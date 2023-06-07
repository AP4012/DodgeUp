import java.util.ArrayList;
import java.util.Random;

public class Brick {


    public static int speed;

    private static final int brickWidth = 60;
    private static final int brickHeight = 30;


    private final int brickX;
    private int brickY;
    private final int brickColorR;
    private final int brickColorG;
    private final int brickColorB;

    public Brick(int brickX, int brickY, int brickColorR, int brickColorG, int brickColorB) {
        this.brickX = brickX;
        this.brickY = brickY;
        this.brickColorR = brickColorR;
        this.brickColorG = brickColorG;
        this.brickColorB = brickColorB;
    }

    public static void makeBlocks() {
        Random random = new Random();
        DodgeUP.bricks = new ArrayList<>();
        int speedY = -100;
        for (int i=0 ; i<10 ; i++) {
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
            DodgeUP.bricks.add(new Brick(random.nextInt(30, 651), speedY, random.nextInt(253), random.nextInt(253), random.nextInt(253)));
            speedY -= 100;
        }
    }

    public static void showBlock() {
        for (Brick b: DodgeUP.bricks) {
            DodgeUP.processing.noStroke();
            DodgeUP.processing.fill(b.brickColorR, b.brickColorG, b.brickColorB);
            DodgeUP.processing.rect(b.brickX, b.brickY, Brick.brickWidth, Brick.brickHeight);
        }
    }

    public static void moveBlock() {

        for (Brick b: DodgeUP.bricks) {
            b.brickY += speed;
        }
    }



    public static boolean checkCrash() {
        for (Brick b: DodgeUP.bricks) {

            if (DodgeUP.processing.mouseX >= b.brickX && DodgeUP.processing.mouseX <= b.brickX + Brick.brickWidth &&
                    565 >= b.brickY && 565 <= b.brickY + Brick.brickWidth) {

                DodgeUP.bricks.remove(b);
                return true;
            }

            else if (DodgeUP.processing.mouseX+25 >= b.brickX && DodgeUP.processing.mouseX+25 <= b.brickX + Brick.brickWidth &&
                    565 >= b.brickY && 565 <= b.brickY + Brick.brickWidth) {

                DodgeUP.bricks.remove(b);
                return true;
            }

            else if (DodgeUP.processing.mouseX-25 >= b.brickX && DodgeUP.processing.mouseX-25 <= b.brickX + Brick.brickWidth &&
                    565 >= b.brickY && 565 <= b.brickY + Brick.brickWidth) {

                DodgeUP.bricks.remove(b);
                return true;
            }

            else if (DodgeUP.processing.mouseX-25 >= b.brickX && DodgeUP.processing.mouseX-25 <= b.brickX + Brick.brickWidth &&
                    590 >= b.brickY && 590 <= b.brickY + Brick.brickWidth) {

                DodgeUP.bricks.remove(b);
                return true;
            }

            else if (DodgeUP.processing.mouseX+25 >= b.brickX && DodgeUP.processing.mouseX+25 <= b.brickX + Brick.brickWidth &&
                    590 >= b.brickY && 590 <= b.brickY + Brick.brickWidth) {

                DodgeUP.bricks.remove(b);
                return true;
            }

            else if (DodgeUP.processing.mouseX >= b.brickX && DodgeUP.processing.mouseX <= b.brickX + Brick.brickWidth &&
                    625 >= b.brickY && 625 <= b.brickY + Brick.brickWidth) {

                DodgeUP.bricks.remove(b);
                return true;
            }

        }

        return false;
    }


    public int getBrickY() {
        return brickY;
    }
}
