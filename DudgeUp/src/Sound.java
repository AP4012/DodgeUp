import processing.sound.SoundFile;

public class Sound {
    private static SoundFile mainSound;
    private static SoundFile clickSound;
    private static SoundFile hoverSound;
    private static SoundFile hitSound;
    private static SoundFile scoreSound;
    private static SoundFile winSound;
    private static SoundFile loseSound;


    public static void loadSounds() {
        mainSound = new SoundFile(DodgeUP.processing, "sounds/bitQuest.wav");
        clickSound = new SoundFile(DodgeUP.processing, "sounds/click.wav");
        hoverSound = new SoundFile(DodgeUP.processing, "sounds/hover.wav");
        hitSound = new SoundFile(DodgeUP.processing, "sounds/getHit.wav");
        scoreSound = new SoundFile(DodgeUP.processing, "sounds/score.wav");
        winSound = new SoundFile(DodgeUP.processing, "sounds/win.wav");
        loseSound = new SoundFile(DodgeUP.processing, "sounds/gameOver.wav");
    }

    public static void startMainSound() {
        mainSound.play();
        mainSound.loop();
    }
    public static void startClickSound() {
        clickSound.play();
    }
    public static void startHoverSound() {
        hoverSound.play();
    }
    public static void startHitSound() {
        hitSound.play();
    }
    public static void startScoreSound() {
        scoreSound.play();
    }
    public static void startWinSound() {
        if (!winSound.isPlaying()) {
            winSound.play();
        }
    }
    public static void startLoseSound() {
        if (!loseSound.isPlaying()) {
            loseSound.play();
        }
    }



    public static void stopMainSound() {
        if (mainSound.isPlaying()) {
            mainSound.stop();
        }
    }
    public static void stopLoseSound() {
        if (loseSound.isPlaying()) {
            loseSound.stop();
        }
    }
    public static void stopWinSound() {
        if (winSound.isPlaying()) {
            winSound.stop();
        }
    }

}
