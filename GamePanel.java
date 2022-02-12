package main;

import entity.Player;
import objects.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize=16;
    int scale=3;
   public int tileSize=originalTileSize*scale;
    public int maxCol=16;
    public int maxRow=12;
  public   int width=tileSize*maxCol;
    public int height=tileSize*maxRow;
    public int maxWoC=50;
    public int maxWoR=50;
    public int ww=tileSize*maxCol;
    public int wh=tileSize*maxWoR;
    int playerX;
    int playerY;
    int playerSpeed=4;
    int FTF=60;
    AsetSetter aset=new AsetSetter(this);
    public SuperObject []obj=new SuperObject[10];
    public collisionChecker chk=new collisionChecker(this);
    TileManager tm=new TileManager(this);
Thread gameThread;
KeyHandler handler=new KeyHandler();
public Player player=new Player(this,this.handler);
    public GamePanel() {
setPreferredSize(new Dimension(width,height));
setBackground(Color.black);
setDoubleBuffered(true);
addKeyListener(handler);
setFocusable(true);
    }
    public void setOs() {
    	aset.setObject();
    }
public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
}
    @Override
    public void run() {
        double drawInterval=1000000000/FTF;
         double delta=0;
         long lastTime=System.nanoTime();
         long currentTime;
        while (gameThread!=null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       Graphics2D g2=(Graphics2D) g;
       
       tm.draw(g2);
       for(int i=0; i<obj.length; i++) {
    	   if(obj[i]!=null) {
    		   obj[i].draw(g2, this);
    	   }
       }
       player.draw(g2);
       g2.dispose();
    }
}
