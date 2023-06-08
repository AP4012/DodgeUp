import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;


public class Main extends PApplet {

    public static PApplet processing;
    public static ArrayList<Block> blocks = new ArrayList<>();
    private PImage charImage;
    private PImage heartImage;
    private PImage brokenHeartImage;
    private PImage mainBackground;
    private PImage gameBackground1;
    private PImage gameBackground2;
    private PImage gameBackground3;
    private  int backgroundNumber = 1;
    private  int easyHP = 4;
    private int difficultHP=3;
    private  int menu = 0;
    private int firstR;
    private int firstG;
    private int firstB;
    private int secondR;
    private int secondG;
    private int secondB;
    private int thirdR;
    private int thirdG;
    private int thirdB;
    private int fourthR;
    private int fourthG;
    private int fourthB;
    private int fifthR;
    private int fifthG;
    private int fifthB;
    private int sixthR;
    private int sixthG;
    private int sixthB;
    private int seventhR;
    private int seventhG;
    private int seventhB;
    private int eighthR;
    private int eighthG;
    private int eighthB;
    private int ninthR;
    private int ninthG;
    private int ninthB;
    private int tenthR;
    private int tenthG;
    private int tenthB;
    private boolean playMusic = true;
    private int score=0;
    private boolean isCrushed=false;
    private int count=0;
    private int difficultyNumber=0;
    private PImage characterCrushed;


    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    @Override
    public void setup() {
        processing = this;
        Block block = new Block(0, 0, 0, 0, 0);
        block.makeObjects();
        charImage = loadImage("character.png");
        heartImage = loadImage("heart.png");
        brokenHeartImage = loadImage("broken-heart.png");
        mainBackground = loadImage("main-background.jpg");
        gameBackground1 = loadImage("game-background1.png");
        gameBackground2 = loadImage("game-background2.jpeg");
        gameBackground3 = loadImage("game-background3.png");
        characterCrushed=loadImage("character-crushed.png");
        for (Block b:blocks) {
            b.setBlockColorR((int)random(255));
            b.setBlockColorG((int)random(255));
            b.setBlockColorB((int)random(255));
        }

    }

    @Override
    public void settings() {
        size(400, 700);

    }

    @Override
    public void draw() {
        if (menu == 0) {
            background(mainBackground);
            fill(firstR, firstG, firstB);
            text("Start Game", 100, 250);
            fill(secondR, secondG, secondB);
            text("Setting", 130, 350);
            fill(thirdR, thirdG, thirdB);
            text("Exit Game", 110, 450);
            if ((mouseX > 100) && (mouseX < 300) && (mouseY > 200) && (mouseY < 250)) {
                firstR = 158;
                firstG = 5;
                firstB = 247;
                if (mousePressed) {
                    easyHP = 4;
                    difficultHP=3;
                    score=0;
                    menu = 1;
                }
            } else {
                firstR = 255;
                firstG = 255;
                firstB = 255;
            }
            if ((mouseX > 105) && (mouseX < 305) && (mouseY > 300) && (mouseY < 350)) {
                secondR = 158;
                secondG = 5;
                secondB = 247;
                if (mousePressed) menu = 2;
            } else {
                secondR = 255;
                secondG = 255;
                secondB = 255;
            }
            if ((mouseX > 105) && (mouseX < 305) && (mouseY > 400) && (mouseY < 450)) {
                thirdR = 158;
                thirdG = 5;
                thirdB = 247;
                if (mousePressed) {
                    exit();
                }
            } else {
                thirdR = 255;
                thirdG = 255;
                thirdB = 255;
            }

            textSize(40);
        } else if (menu == 1) {
            if(blocks.size()==0) winningGame();
            else if((easyHP==0)||(difficultHP==0)) gameOver();
            else {
                    setBackground(backgroundNumber);
                    fill(84, 170, 232);
                    rect(0, 620, 400, 180);
                    fill(99, 5, 153);
                    textSize(30);
                    text("Score:"+score,250,665);
                    if(difficultyNumber==0) {
                        if (easyHP == 4) showFullHPForEasy();
                        if (easyHP == 3) showOneLessHPForEasy();
                        if (easyHP == 2) showTwoLessHPForEasy();
                        if (easyHP == 1) showThreeLessHPForEasy();
                    } else if (difficultyNumber==1) {
                        if (difficultHP == 3) showFullHPForDifficult();
                        if (difficultHP == 2) showOneLessHPForDifficult();
                        if (difficultHP == 1) showTwoLessHPForDifficult();
                    }
                if(!isCrushed){
                        image(charImage, mouseX, 550);
                        checkCrushed();
                    }
                    else {
                        image(characterCrushed, mouseX, 550);
                        count++;
                        if(count==70)
                        {
                            isCrushed=false;
                            count=0;
                        }
                    }
                for (Block b : blocks) {
                        showBlocks(b.getBlockX(), b.getBlockY(), b.getBlockColorR(), b.getBlockColorG(), b.getBlockColorB());
                    }
                if(difficultyNumber==0)
                    moveBlocks();
                else if(difficultyNumber==1)
                    moveBlocksFast();
                    if (blocks.size() > 0 && blocks.get(0).getBlockY() >= 540) {
                        blocks.remove(0);
                        score++;
                    }
                }

            }
         else if (menu == 2) {
            gameSetting();
        }
    }

    public void setBackground(int i) {
        if (i == 1)
            background(gameBackground1);
        if (i == 2)
            background(gameBackground2);
        if (i == 3)
            background(gameBackground3);
    }

    public void checkCrushed() {

        for (Block b : blocks) {
            if ((b.getBlockY() + Block.BlockHeight >= 540) && (b.getBlockY() <= 590) && (b.getBlockX() + Block.BlockWidth >= mouseX) && (b.getBlockX() <= mouseX)) {
                if(difficultyNumber==0){
                easyHP -= 1;}
                else difficultHP-=1;
                isCrushed=true;
            }
        }
    }

    public void gameOver() {

        background(mainBackground);
        textSize(50);
        fill(255);
        text("Game Over!", 75, 250);
        textSize(40);
        fill(firstR, firstG, firstB);
        text("Main Menu", 105, 400);
        fill(secondR, secondG, secondB);
        text("Exit Game", 110, 500);
        fill(255);
        textSize(30);
        text("Your Final Score:"+score, 80, 300);

        if ((mouseX > 105) && (mouseX < 305) && (mouseY > 350) && (mouseY < 400)) {
            firstR = 158;
            firstG = 5;
            firstB = 247;
            if (mousePressed) menu = 0;
        } else {
            firstR = 255;
            firstG = 255;
            firstB = 255;
        }
        if ((mouseX > 110) && (mouseX < 310) && (mouseY > 450) && (mouseY < 500)) {
            secondR = 158;
            secondG = 5;
            secondB = 247;
            if (mousePressed) exit();
        } else {
            secondR = 255;
            secondG = 255;
            secondB = 255;
        }


    }

    public void moveBlocks() {
        for (Block b : blocks) {
            b.setBlockY(b.getBlockY() + 2);
        }
    }
    public void moveBlocksFast() {
        for (Block b : blocks) {
            b.setBlockY(b.getBlockY() + 3);
        }
    }


    public void showBlocks(int x, int y, int r, int g, int b) {
        fill(r, g, b);
        noStroke();
        rect(x, y, Block.BlockWidth, Block.BlockHeight);
    }

    public void showFullHPForEasy() {

        image(heartImage, 10, 650);
        image(heartImage, 40, 650);
        image(heartImage, 70, 650);
        image(heartImage, 100, 650);


    }
    public void showFullHPForDifficult() {

        image(heartImage, 10, 650);
        image(heartImage, 40, 650);
        image(heartImage, 70, 650);
    }
    public void showOneLessHPForDifficult() {

        image(heartImage, 10, 650);
        image(heartImage, 40, 650);
        image(brokenHeartImage, 70, 650);
    }
    public void showTwoLessHPForDifficult() {

        image(heartImage, 10, 650);
        image(brokenHeartImage, 40, 650);
        image(brokenHeartImage, 70, 650);
    }

    public void showOneLessHPForEasy() {
        image(heartImage, 10, 650);
        image(heartImage, 40, 650);
        image(heartImage, 70, 650);
        image(brokenHeartImage, 100, 650);

    }

    public void showTwoLessHPForEasy() {
        image(heartImage, 10, 650);
        image(heartImage, 40, 650);
        image(brokenHeartImage, 70, 650);
        image(brokenHeartImage, 100, 650);

    }

    public void showThreeLessHPForEasy() {
        image(heartImage, 10, 650);
        image(brokenHeartImage, 40, 650);
        image(brokenHeartImage, 70, 650);
        image(brokenHeartImage, 100, 650);
    }


    public void winningGame(){
        background(mainBackground);
        textSize(50);
        fill(255);
        text("You Won!", 100, 250);
        textSize(40);
        fill(firstR, firstG, firstB);
        text("Main Menu", 105, 400);
        fill(secondR, secondG, secondB);
        text("Exit Game", 110, 500);
        fill(255);
        textSize(30);
        text("Your Final Score:"+score, 80, 300);

        if ((mouseX > 105) && (mouseX < 305) && (mouseY > 350) && (mouseY < 400)) {
            firstR = 158;
            firstG = 5;
            firstB = 247;
            if (mousePressed) menu = 0;
        } else {
            firstR = 255;
            firstG = 255;
            firstB = 255;
        }
        if ((mouseX > 110) && (mouseX < 310) && (mouseY > 450) && (mouseY < 500)) {
            secondR = 158;
            secondG = 5;
            secondB = 247;
            if (mousePressed) exit();
        } else {
            secondR = 255;
            secondG = 255;
            secondB = 255;
        }

    }
    public void gameSetting(){
        background(mainBackground);
        blockColor();
        difficulty();
        textSize(30);
        fill(255);
        text("Game Background:", 80, 100);
        textSize(20);
        fill(firstR, firstG, firstB);
        text("Option 1", 65, 175);
        fill(secondR, secondG, secondB);
        text("Option 2", 165, 175);
        fill(thirdR, thirdG, thirdB);
        text("Option 3", 265, 175);
        textSize(40);
        fill(fourthR, fourthG, fourthB);
        text("Exit", 160, 600);
        if ((mouseX > 160) && (mouseX < 220) && (mouseY > 575) && (mouseY < 600)) {
            fourthR = 158;
            fourthG = 5;
            fourthB = 247;
            if (mousePressed) menu = 0;
        } else {
            fourthR = 255;
            fourthG = 255;
            fourthB = 255;
        }
        if ((mouseX > 65) && (mouseX < 145) && (mouseY > 150) && (mouseY < 175)) {
            firstR = 158;
            firstG = 5;
            firstB = 247;
            if (mousePressed) backgroundNumber = 1;
        } else {
            firstR = 255;
            firstG = 255;
            firstB = 255;
        }
        if ((mouseX > 165) && (mouseX < 245) && (mouseY > 150) && (mouseY < 175)) {
            secondR = 158;
            secondG = 5;
            secondB = 247;
            if (mousePressed) backgroundNumber = 2;
        } else {
            secondR = 255;
            secondG = 255;
            secondB = 255;
        }
        if ((mouseX > 265) && (mouseX < 345) && (mouseY > 150) && (mouseY < 175)) {
            thirdR = 158;
            thirdG = 5;
            thirdB = 247;
            if (mousePressed) backgroundNumber = 3;
        } else {
            thirdR = 255;
            thirdG = 255;
            thirdB = 255;
        }
    }
    public void blockColor()
    {
        textSize(30);
        fill(255);
        text("Blocks Color:", 115, 250);
        textSize(20);
        fill(fifthR, fifthG, fifthB);
        text("Colorful", 65, 300);
        fill(sixthR, sixthG, sixthB);
        text("Purple", 265, 300);
        fill(seventhR, seventhG, seventhB);
        text("Yellow", 65, 350);
        fill(eighthR,eighthG,eighthB);
        text("Red",265,350);
        if ((mouseX > 265) && (mouseX < 345) && (mouseY > 325) && (mouseY < 350)) {
            eighthR = 158;
            eighthG = 5;
            eighthB = 247;
            if (mousePressed) {
                for (Block b:blocks) {
                    b.setBlockColorR(191);
                    b.setBlockColorG(19);
                    b.setBlockColorB(39);
                }
            }
        } else {
            eighthR = 255;
            eighthG = 255;
            eighthB = 255;
        }
        if ((mouseX > 65) && (mouseX < 145) && (mouseY > 275) && (mouseY < 300)) {
            fifthR = 158;
            fifthG = 5;
            fifthB = 247;
            if (mousePressed) {
                for (Block b:blocks) {
                    b.setBlockColorR((int)random(255));
                    b.setBlockColorG((int)random(255));
                    b.setBlockColorB((int)random(255));
                }
            }
        } else {
            fifthR = 255;
            fifthG = 255;
            fifthB = 255;
        }
        if ((mouseX > 265) && (mouseX < 345) && (mouseY > 275) && (mouseY < 300)) {
            sixthR = 158;
            sixthG = 5;
            sixthB = 247;
            if (mousePressed) {
                for (Block b:blocks) {
                    b.setBlockColorR(103);
                    b.setBlockColorG(2);
                    b.setBlockColorB(204);
                }
            }
        } else {
            sixthR = 255;
            sixthG = 255;
            sixthB = 255;
        }
        if ((mouseX > 65) && (mouseX < 145) && (mouseY > 325) && (mouseY < 350)) {
            seventhR = 158;
            seventhG = 5;
            seventhB = 247;
            if (mousePressed) {
                for (Block b:blocks) {
                    b.setBlockColorR(222);
                    b.setBlockColorG(204);
                    b.setBlockColorB(4);
                }
            }
        } else {
            seventhR = 255;
            seventhG = 255;
            seventhB = 255;
        }
    }
    public void difficulty(){
        textSize(30);
        fill(255);
        text("Difficulty:", 135, 400);
        textSize(20);
        fill(ninthR, ninthG, ninthB);
        text("Standard", 65, 450);
        fill(tenthR, tenthG, tenthB);
        text("Difficult", 265, 450);
        if ((mouseX > 65) && (mouseX < 145) && (mouseY > 425) && (mouseY < 450)) {
            ninthR = 158;
            ninthG = 5;
            ninthB = 247;
            if (mousePressed) {
                difficultyNumber=0;
            }
        } else {
            ninthR = 255;
            ninthG = 255;
            ninthB = 255;
        }
        if ((mouseX > 265) && (mouseX < 345) && (mouseY > 425) && (mouseY < 450)) {
            tenthR = 158;
            tenthG = 5;
            tenthB = 247;
            if (mousePressed) {
               difficultyNumber=1;
            }
        } else {
            tenthR = 255;
            tenthG = 255;
            tenthB = 255;
        }

    }
}



