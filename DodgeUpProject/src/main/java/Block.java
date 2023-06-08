import processing.core.PApplet;

public class Block implements Interface{


    private static PApplet pApplet=Main.processing;
    public static int speedY=-80;
    public static int BlockHeight=50;
    public static int BlockWidth=30;
    private int BlockX;
    private int blockX;
    private int BlockY;
    private int BlockColorR;
    private int BlockColorG;
    private int BlockColorB;
    public Block(int blockX,int blockY,int blockColorR,int blockColorG,int blockColorB) {
        BlockX=blockX;
        BlockY=blockY;
        BlockColorR=blockColorR;
        BlockColorG=blockColorG;
        BlockColorB=blockColorB;

    }
    @Override
    public void makeObjects() {
        for (int i=0;i<50;i++)
        {
            Main.blocks.add(new Block(blockX+10,speedY,BlockColorR,BlockColorG,BlockColorB));
            speedY-=30;
            Main.blocks.add(new Block(blockX+90,speedY+80,BlockColorR,BlockColorG,BlockColorB));
            speedY-=40;
            Main.blocks.add(new Block(blockX+180,speedY+40,BlockColorR,BlockColorG,BlockColorB));
            speedY-=90;
            Main.blocks.add(new Block(blockX+260,speedY+80,BlockColorR,BlockColorG,BlockColorB));
            speedY-=10;
            Main.blocks.add(new Block(blockX+320,speedY+150,BlockColorR,BlockColorG,BlockColorB));
            if(i%2==0)
            blockX+=40;
            else blockX-=40;
        }

    }

    public int getBlockY() {
        return BlockY;
    }

    public void setBlockY(int blockY) {
        BlockY = blockY;
    }

    public int getBlockX() {
        return BlockX;
    }

    public void setBlockX(int blockX) {
        BlockX = blockX;
    }

    public int getBlockColorR() {
        return BlockColorR;
    }

    public void setBlockColorR(int blockColorR) {
        BlockColorR = blockColorR;
    }

    public int getBlockColorG() {
        return BlockColorG;
    }

    public void setBlockColorG(int blockColorG) {
        BlockColorG = blockColorG;
    }

    public int getBlockColorB() {
        return BlockColorB;
    }

    public void setBlockColorB(int blockColorB) {
        BlockColorB = blockColorB;
    }



}
