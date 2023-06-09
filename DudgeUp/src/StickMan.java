import processing.core.PImage;

public class StickMan {


    private static PImage stickMan;

    public static void loadStickMan() {
        stickMan = DodgeUP.processing.loadImage("images/stickMan.png");
    }
    public static void showStickMan() {
        int directionX = DodgeUP.processing.mouseX - 25;

        DodgeUP.processing.image(stickMan, directionX,530, 50,70);

    }


}
