package entity;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
	public int spriteCounter=0;
	public int spriteNum=1;
    public int worldX,worldY;
    public int speed;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction;
    public int sAdx,sAdy;
    public Rectangle rect;
    public boolean collision=false;
    public int hasKey=0;
}
