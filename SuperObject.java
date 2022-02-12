package objects;
import java.awt.*;
import java.awt.image.BufferedImage;

import main.GamePanel;
public class SuperObject {
 public BufferedImage image;
 public Rectangle orect=new Rectangle(0,0,48,48);
 public int sAdx=0;
 public int sAdy=0;
 public String name;
 public boolean collision=false;
 public int worldX ,worldY;
 public void draw(Graphics2D g2,GamePanel gp) {
	 int scx=worldX-gp.player.worldX+gp.player.screenX;
	    int scy=worldY-gp.player.worldY+gp.player.screenY;
	    		if(worldX+gp.tileSize>gp.player.worldX-gp.player.screenX&&
	    				worldX-gp.tileSize<gp.player.worldX+gp.player.screenX&&
	    				worldY+gp.tileSize>gp.player.worldY-gp.player.screenY&&
	    				worldY-gp.tileSize<gp.player.worldY+gp.player.screenY) {
	    		    g2.drawImage(image,scx,scy,gp.tileSize, gp.tileSize, null);

	    		}
 }
}
