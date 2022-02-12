package objects;

import javax.imageio.ImageIO;

public class objKey extends SuperObject {
	public objKey() {
name="key";
try {
image=ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));	
//image=ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));	
//image=ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));	
//image=ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));	

}catch(Exception e) {
	
}
	}
}
