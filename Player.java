package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
public int screenX;
public int screenY;
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        screenX=gp.width/2-(gp.tileSize/2);
        screenY= gp.height/2-(gp.tileSize/2);
        rect=new Rectangle();
        rect.x=8;
        rect.y=16;
        sAdx=rect.x;
        sAdy=rect.y;
        rect.height=32;
        rect.width=32;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        worldX= gp.tileSize*23;
        worldY= gp.tileSize*21;
        speed=4;
         direction="down";
    }
    public void getPlayerImage(){
        try {
            up1= ImageIO.read(getClass().getResource("/player/bu1.png"));
           up2= ImageIO.read(getClass().getResource("/player/bu2.png"));
            down1= ImageIO.read(getClass().getResource("/player/bd1.png"));
            down2= ImageIO.read(getClass().getResource("/player/bd2.png"));
            left1= ImageIO.read(getClass().getResource("/player/bl1.png"));
            left2= ImageIO.read(getClass().getResource("/player/bl2.png"));
            right1= ImageIO.read(getClass().getResource("/player/br1.png"));
            right2= ImageIO.read(getClass().getResource("/player/br2.png"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hello");

        }
    }
    public void update(){
        if (keyH.upPressed==true){
            direction="up";
           // worldY-=speed;
        }
        else if (keyH.downPressed==true){
            direction="down";
           // worldY+=speed;
            

        }
        else if (keyH.rightPressed==true){
            direction="right";
     	   //worldX+=speed;

        }
        else if (keyH.leftPressed==true){
            direction="left";
     	  // worldX-=speed;

        }
        collision=false;
       gp.chk.checkItem(this);
      int index= gp.chk.checOBj(this, true);
      pickObj(index);
        if(collision==false) {
        	switch(direction) {
        	   case "up":
        		   worldY-=speed;
                   break;
               case "down":
            	   worldY+=speed;
                   break;
               case "right":
            	   worldX+=speed;
                   break;
               case "left":
            	   worldX-=speed;
                   break;
        	}
        
        }
        spriteCounter++;
        if(spriteCounter>12) {
        	if(spriteNum==1) {
        		spriteNum=2;
        	}
        	else if(spriteNum==2) {
        		spriteNum=1;
        	}
        	spriteCounter=1;
        }
    }
    public void pickObj(int i) {
    	if(i!=999) {
String name=gp.obj[i].name;
switch(name) {
case "key":
	hasKey++;
	gp.obj[i]=null;
	break;
case "door":
	if(hasKey>0) {
		hasKey--;
		gp.obj[i]=null;

		break;
	}
}
    	}
    }
    public void draw(Graphics2D g){
        //g.setColor(Color.BLUE);
       // g.fillRect(x,y,gp.tileSize, gp.tileSize);
    	BufferedImage image=null;
        switch (direction){
            case "up":
            	if(spriteNum==1) {
                image=up1;
            	}
            	if(spriteNum==2) {
            		image=up2;
            	}
                break;
            case "down":
            	
            	if(spriteNum==1) {
                    image=down1;
                	}
                	if(spriteNum==2) {
                		image=down2;
                	}
                break;
            case "right":
            	if(spriteNum==1) {
                    image=right1;
                	}
                	if(spriteNum==2) {
                		image=right2;
                	}
            	break;
            case "left":
            	if(spriteNum==1) {
                    image=left1;
                	}
                	if(spriteNum==2) {
                		image=left2;
                	}
            	break;
        }
        g.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);
    }
}
