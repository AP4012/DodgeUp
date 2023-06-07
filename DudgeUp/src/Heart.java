import processing.core.PImage;

public class Heart {

    private static PImage heart;
    public static int lives = 3;

    public static void loadHeart() {
        lives = 3;
        heart = DodgeUP.processing.loadImage("images/heart.png");
    }
    public static void showHeart() {
        DodgeUP.processing.noStroke();

        if (lives == 3) {
            DodgeUP.processing.image(heart, 645,10, 50,50);
            DodgeUP.processing.image(heart, 590,10, 50,50);
            DodgeUP.processing.image(heart, 535,10, 50,50);
        }
        else if (lives == 2) {
            DodgeUP.processing.image(heart, 645,10, 50,50);
            DodgeUP.processing.image(heart, 590,10, 50,50);
        }
        else {
            DodgeUP.processing.image(heart, 645,10, 50,50);
        }

    }
}
