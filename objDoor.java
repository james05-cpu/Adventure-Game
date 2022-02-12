package objects;

import javax.imageio.ImageIO;

public class objDoor extends SuperObject {
	public objDoor() {
		name="door";
		try {
		image=ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));	
		//image=ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));	
		//image=ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));	
		//image=ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));	

		}catch(Exception e) {
			
		}
		collision=true;
	}
}
