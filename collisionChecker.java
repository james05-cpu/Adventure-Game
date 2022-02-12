package main;

import entity.Entity;

public class collisionChecker {
	GamePanel pan;
public collisionChecker(GamePanel pan) {
	this.pan=pan;
}
public int checOBj(Entity ent,boolean player) {
	int index=999;
	for(int i=0; i<pan.obj.length; i++) {
		if(pan.obj[i]!=null) {
			ent.rect.x=ent.worldX+ent.rect.x;
			ent.rect.y=ent.worldY+ent.sAdy;
			pan.obj[i].orect.x=pan.obj[i].worldX+pan.obj[i].orect.x;
			pan.obj[i].orect.y=pan.obj[i].worldY+pan.obj[i].orect.y;
			switch(ent.direction) {
			   case "up":
				   ent.rect.y-=ent.speed;
				   if(ent.rect.intersects(pan.obj[i].orect)) {
if(pan.obj[i].collision==true) {
	ent.collision=true;
}
if(player==true) {
	index=1;
}
				   }
	                break;
	            case "down":
	            	ent.rect.y+=ent.speed;
	            	  if(ent.rect.intersects(pan.obj[i].orect)) {
	            		  if(pan.obj[i].collision==true) {
	            				ent.collision=true;
	            			}
	            			if(player==true) {
	            				index=1;
	            			}
					   }
	                break;
	            case "right":
	            	ent.rect.x-=ent.speed;
	            	  if(ent.rect.intersects(pan.obj[i].orect)) {
	            		  if(pan.obj[i].collision==true) {
	            				ent.collision=true;
	            			}
	            			if(player==true) {
	            				index=1;
	            			}
					   }
	                break;
	            case "left":
	            	ent.rect.x+=ent.speed;
	            	  if(ent.rect.intersects(pan.obj[i].orect)) {
	            		  if(pan.obj[i].collision==true) {
	            				ent.collision=true;
	            			}
	            			if(player==true) {
	            				index=1;
	            			}
					   }
	                break;
			}

		ent.rect.x=ent.sAdx;
		ent.rect.y=ent.sAdy;
		pan.obj[i].orect.x=pan.obj[i].sAdx;
		pan.obj[i].orect.y=pan.obj[i].sAdy;
		}
	}
	return index;
}
public void checkItem(Entity ent) {
	int entityLeftWorldX=ent.worldX+ent.rect.x;
	int entityRightWorldX=ent.worldX+ent.rect.x+ent.rect.width;
	int entityTopWorldY=ent.worldY+ent.rect.y;
	int entityBottomWorldY=ent.worldY+ent.rect.y+ent.rect.height;
	int leftCol=entityLeftWorldX/pan.tileSize;
	int rightCol=entityRightWorldX/pan.tileSize;
	int topRow=entityTopWorldY/pan.tileSize;
	int botRow=entityBottomWorldY/pan.tileSize;
	int tl1,tl2;
	switch(ent.direction) {
	   case "up":
           topRow=(entityTopWorldY-ent.speed)/pan.tileSize;
           tl1=pan.tm.mapTileNumber[leftCol][topRow];
           tl2=pan.tm.mapTileNumber[rightCol][topRow];
           if(pan.tm.tile[tl1].collision==true||pan.tm.tile[tl2].collision==true) {
        	   ent.collision=true;
           }
           break;
       case "down":
    	   botRow=(entityBottomWorldY-ent.speed)/pan.tileSize;
           tl1=pan.tm.mapTileNumber[leftCol][botRow];
           tl2=pan.tm.mapTileNumber[rightCol][botRow];
           if(pan.tm.tile[tl1].collision==true||pan.tm.tile[tl2].collision==true) {
        	   ent.collision=true;
           }
           break;
       case "right":
    	   rightCol=(entityRightWorldX-ent.speed)/pan.tileSize;
           tl1=pan.tm.mapTileNumber[rightCol][topRow];
           tl2=pan.tm.mapTileNumber[rightCol][botRow];
           if(pan.tm.tile[tl1].collision==true||pan.tm.tile[tl2].collision==true) {
        	   ent.collision=true;
           }
           break;
       case "left":
    	   leftCol=(entityLeftWorldX-ent.speed)/pan.tileSize;
           tl1=pan.tm.mapTileNumber[leftCol][topRow];
           tl2=pan.tm.mapTileNumber[leftCol][botRow];
           if(pan.tm.tile[tl1].collision==true||pan.tm.tile[tl2].collision==true) {
        	   ent.collision=true;
           }
           break;
	}
}
}
