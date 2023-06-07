import processing.core.PImage;

import java.util.Random;

public class Star {

    private static PImage star;
    public static int width = 40;
    public static int height = 40;

    private final int starX;
    private int starY;


    public Star(int starX, int starY) {
        this.starX = starX;
        this.starY = starY;
    }

    public static void loadStar() {

        star = DodgeUP.processing.loadImage("images/star.png");
        Random random = new Random();

        for (int i=0 ; i<30 ; i++) {
            DodgeUP.stars.add(new Star(random.nextInt(10, 650), random.nextInt(-10000, -100 )));
        }
    }
    public static void showStar() {

        for (Star s:DodgeUP.stars) {
            DodgeUP.processing.image(star, s.starX, s.starY, Star.width, Star.height);
        }

    }

    public static void moveStar() {
        for (Star s:DodgeUP.stars) {
            s.starY += 5;
        }
    }

    public static boolean checkCrash() {
        for (Star s: DodgeUP.stars) {

            if (DodgeUP.processing.mouseX >= s.starX && DodgeUP.processing.mouseX <= s.starX + Star.width &&
                    540 >= s.starY && 540 <= s.starY + Star.height) {

                DodgeUP.stars.remove(s);
                return true;
            }
            else if (DodgeUP.processing.mouseX+25 >= s.starX && DodgeUP.processing.mouseX+25 <= s.starX + Star.width &&
                    540 >= s.starY && 540 <= s.starY + Star.height) {

                DodgeUP.stars.remove(s);
                return true;
            }
            else if (DodgeUP.processing.mouseX-25 >= s.starX && DodgeUP.processing.mouseX-25 <= s.starX + Star.width &&
                    540 >= s.starY && 540 <= s.starY + Star.height) {

                DodgeUP.stars.remove(s);
                return true;
            }

            else if (DodgeUP.processing.mouseX-25 >= s.starX && DodgeUP.processing.mouseX-25 <= s.starX + Star.width &&
                    575 >= s.starY && 575 <= s.starY + Star.height) {

                DodgeUP.stars.remove(s);
                return true;
            }

            else if (DodgeUP.processing.mouseX+25 >= s.starX && DodgeUP.processing.mouseX+25 <= s.starX + Star.width &&
                    575 >= s.starY && 575 <= s.starY + Star.height) {

                DodgeUP.stars.remove(s);
                return true;
            }

            else if (DodgeUP.processing.mouseX >= s.starX && DodgeUP.processing.mouseX <= s.starX + Star.width &&
                    600 >= s.starY && 600 <= s.starY + Star.height) {

                DodgeUP.stars.remove(s);
                return true;
            }

        }

        return false;
    }



}
