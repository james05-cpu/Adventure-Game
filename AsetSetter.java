package main;

import objects.objKey;
import objects.objChest;
import objects.objDoor;
public class AsetSetter {
GamePanel gp;

public AsetSetter(GamePanel gp) {
	this.gp = gp;
}
public void setObject() {
	gp.obj[0]=new objKey();
	gp.obj[0].worldX=23*gp.tileSize;
	gp.obj[0].worldY=7*gp.tileSize;

	
	gp.obj[1]=new objKey();
	gp.obj[1].worldX=23*gp.tileSize;
	gp.obj[1].worldY=40*gp.tileSize;
	
	gp.obj[2]=new objKey();
	gp.obj[2].worldX=38*gp.tileSize;
	gp.obj[2].worldY=8*gp.tileSize;
	
	gp.obj[3]=new objDoor();
	gp.obj[3].worldX=10*gp.tileSize;
	gp.obj[3].worldY=11*gp.tileSize;
	
	gp.obj[4]=new objDoor();
	gp.obj[4].worldX=8*gp.tileSize;
	gp.obj[4].worldY=20*gp.tileSize;

	gp.obj[5]=new objDoor();
	gp.obj[5].worldX=12*gp.tileSize;
	gp.obj[5].worldY=22*gp.tileSize;

	gp.obj[6]=new objChest();
	gp.obj[6].worldX=10*gp.tileSize;
	gp.obj[6].worldY=7*gp.tileSize;
	
	
}

}
