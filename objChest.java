package objects;

import javax.imageio.ImageIO;

public class objChest extends SuperObject {
	public objChest() {
		name="Chest";
		try {
		image=ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));	
		//image=ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));	
		//image=ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));	
		//image=ImageIO.read(getClass().getResourceAsStream("/objects/boot.png"));	

		}catch(Exception e) {
			
		}
			}
}
