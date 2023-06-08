import processing.core.PImage;

import java.util.Random;

public class BackGround {

    public static PImage backgroundImage1;
    private static PImage backgroundImage2;



    public static void loadBackgrounds () {
        Random random = new Random();
        int index1 = random.nextInt(1,4);
        int index2 = random.nextInt(1,4);


        if (index1 == 1) {
            backgroundImage1 = DodgeUP.processing.loadImage("images/background1.jpg");
        }
        else if (index1 == 2) {
            backgroundImage1 = DodgeUP.processing.loadImage("images/background2.jpg");
        }
        else if (index1 == 3) {
            backgroundImage1 = DodgeUP.processing.loadImage("images/background3.jpg");
        }


        if (index2 == 1) {
            backgroundImage2 = DodgeUP.processing.loadImage("images/brick-wall1.jpg");
        }
        else if (index2 == 2) {
            backgroundImage2 = DodgeUP.processing.loadImage("images/brick-wall2.jpg");
        }
        else if (index2 == 3) {
            backgroundImage2 = DodgeUP.processing.loadImage("images/brick-wall3.jpg");
        }




    }


    public static void showBackground1() {
        DodgeUP.processing.image(backgroundImage1, 0, 0, 700, 600);
    }

    public static void showBackground2() {
        DodgeUP.processing.image(backgroundImage2, 0, 600, 700, 450);
    }
}
