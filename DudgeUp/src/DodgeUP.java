import processing.core.PApplet;
import processing.core.PFont;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class DodgeUP extends PApplet{

    public static PApplet processing;

    public static List<Brick> bricks = new ArrayList<>();
    public static List<Star> stars = new ArrayList<>();

    public static long score = 0;
    public static long highScore = Database.popHighScore();

    public static boolean startOver = false;
    public static boolean retryOver = false;
    public static boolean exitOver = false;
    public static boolean mainMenuOver = false;
    public static boolean startChecker = false;


    public static Color startColor;
    public static Color exitColor;
    public static Color mainMenuColor;

    public static boolean startMenuActivator = true;
    public static boolean endMenuActivator = false;




    public static void main(String[] args) {

        PApplet.main("DodgeUP" ,args);

    }



    @Override
    public void setup() {


        processing = this;
        Brick.speed = 5;

        Brick.makeBlocks();
        Heart.loadHeart();
        BackGround.loadBackgrounds();
        StickMan.loadStickMan();
        Star.loadStar();

    }

    @Override
    public void settings() {
        size(700, 700);


    }

    @Override
    public void draw() {

        startMenu();
        updateCoordinates();

        if (startChecker) {
            BackGround.showBackground1();

            Brick.showBlock();
            Brick.moveBlock();

            Star.showStar();
            Star.moveStar();

            StickMan.showStickMan();

            if (Brick.checkCrash()) {
                Heart.lives--;
            }

            if (Star.checkCrash()) {
                score += 20;
            }


            increaseSpeed();
            showScore();
            Heart.showHeart();
            BackGround.showBackground2();

        }



        gameOver();
        win();

    }





    public void startMenu() {

        image(BackGround.backgroundImage1, 0, 0, 700, 700);
        mouseHover();

        PFont font = createFont("Serif.bold", 30);
        textFont(font);

        fill(startColor);
        text("Start",320, 320);

        fill(exitColor);
        text("Exit",325, 400);

        fill(252, 244, 3);
        textSize(60);
        text("DodgeUP!", 225, 150);

        fill(8, 36, 252);
        font = createFont("Serif.bolditalic", 30);
        textFont(font);
        text("Created By ShadowJavad...", 185, 600);

    }

    public void endMenu() {

        mouseHover();


        PFont font = createFont("Serif.bold", 30);
        textFont(font);

        fill(startColor);
        text("Retry",318, 320);

        fill(mainMenuColor);
        text("Main Menu",280, 410);

        fill(exitColor);
        text("Exit",325, 500);


        fill(252, 244, 3);
        textSize(30);
        text("Your Score : " + score, 255, 215);
        textSize(20);
        text("High Score : " + highScore, 290, 245);



    }


    public void win() {

        if (bricks.size() == 0 ) {
            startChecker = false;
            endMenuActivator = true;

            background(0);

            PFont font = createFont("Serif.bold", 60);
            textFont(font);
            fill(7, 252, 3);
            text("You Won!", 220, 150);

            endMenu();
        }

    }

    public void gameOver() {

        if (Heart.lives == 0) {
            startChecker = false;
            endMenuActivator = true;

            background(0);

            PFont font = createFont("Serif.bold", 60);
            textFont(font);
            fill(252, 3, 3);
            textSize(60);
            text("GameOver!", 200, 150);

            endMenu();

        }

    }



    public void showScore() {
        DodgeUP.processing.noStroke();



        for (int i=0 ; i<bricks.size() ; i++) {
            if (bricks.get(i).getBrickY() >= 600) {
                bricks.remove(bricks.get(i));
                score++;
            }
        }

        if (score > highScore) {
            highScore = score;
            Database.pushHighScore(highScore);
        }

        fill(0);
        PFont font = createFont("Serif.bold", 30);
        textFont(font);
        text("Score : " + score, 0, 30);
        textSize(20);
        text("High Score : " + highScore, 0, 60);
    }


    public void updateCoordinates() {

        if (startMenuActivator) {
            if ( overStart(320, 300, 63, 20) ) {
                startOver = true;
                exitOver = false;
            }

            else if ( overExit(328, 380, 49, 20) ) {
                startOver = false;
                exitOver = true;
            }
            else {
                startOver = exitOver = false;
            }

        }

        else if (endMenuActivator) {
            if (overRetry(321, 300, 68, 20)) {
                exitOver = false;
                retryOver = true;
            }

            else if ( overMainMenu(283, 390, 145, 20) ) {
                exitOver = false;
                retryOver = false;
                mainMenuOver = true;
            }

            else if ( overExit(328, 480, 49, 20) ) {
                exitOver = true;
                retryOver = false;
                mainMenuOver = false;
            }
            else {
                exitOver = retryOver = mainMenuOver = false;
            }
        }


    }



    public void mousePressed() {

        if (startMenuActivator) {
            if (startOver) {
                startChecker = true;
                startMenuActivator = false;
            }
            else if (exitOver) {
                exit();
            }
        }


        else if (endMenuActivator) {
            if (retryOver) {
                startChecker = true;
                endMenuActivator = false;
                restart();
            }

            else if (mainMenuOver) {
                endMenuActivator = false;
                startMenuActivator = true;
                restart();
            }

            else if (exitOver) {
                exit();
            }
        }
    }

    public void mouseHover() {

        if (endMenuActivator) {
            if (retryOver) {
                startColor = new Color(7, 252, 3);
            }
            else {
                startColor = new Color(252, 252, 252);
            }

            if (mainMenuOver) {
                mainMenuColor = new Color(8, 36, 252);
            }
            else {
                mainMenuColor = new Color(252, 252, 252);
            }

            if (exitOver) {
                exitColor = new Color(252, 3, 3);
            }
            else {
                exitColor = new Color(252, 252, 252);
            }
        }

        else if(startMenuActivator){
            if (startOver) {
                startColor = new Color(7, 252, 3);
            }
            else {
                startColor = new Color(0, 0, 0);
            }

            if (exitOver) {
                exitColor = new Color(252, 3, 3);
            }
            else {
                exitColor = new Color(0, 0, 0);
            }
        }




    }


    public boolean overMainMenu(int x, int y,int width, int height) {
        return mouseX >= x && mouseX <= x + width &&
                mouseY >= y && mouseY <= y + height;
    }
    public boolean overRetry(int x, int y,int width, int height) {
        return mouseX >= x && mouseX <= x + width &&
                mouseY >= y && mouseY <= y + height;
    }
    public boolean overExit(int x, int y, int width, int height) {
        return mouseX >= x && mouseX <= x + width &&
                mouseY >= y && mouseY <= y + height;
    }

    public boolean overStart(int x, int y,int width, int height) {
        return mouseX >= x && mouseX <= x + width &&
                mouseY >= y && mouseY <= y + height;
    }

    private void fill(Color color) {
        fill(color.getRGB());
    }

    public void restart() {
        score = 0;

        setup();

    }

    public void increaseSpeed() {

        if (frameCount % 150 == 0) {
            Brick.speed += 2;
        }

    }
}