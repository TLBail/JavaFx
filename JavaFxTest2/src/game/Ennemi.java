package game;

import application.Main;
import javafx.scene.image.Image;

public class Ennemi {
	
	private static final double speed = 5, rotateSpeed = 20, nbAnim = 20;
	public double angle = 0, enemiX = 0, enemiY = 0, actualNbAnim = 0, directionX, directionY;
	private Image img;
	private boolean isAlive = true;
	
	
	public Ennemi(Image img, double enemiX, double enemiY) {
		if(img == null) System.err.println("err");
		this.img = img;
		this.enemiX = enemiX;
		this.enemiY = enemiY;
		if(enemiX > Main.canvas.getWidth() / 2) {
			directionX = -speed;
		}else {
			directionX = speed;
		}
		if(enemiY > Main.canvas.getHeight() / 2) {
			directionY = -speed;
		}else {
			directionY = speed;
		}
	}
	
	
	
	
	public void move() {
		if(isAlive) {

			if(enemiX < 0 || enemiX + 100 > Main.canvas.getWidth()) directionX = -directionX;
			if(enemiY < 0 || enemiY + 100> Main.canvas.getHeight()) directionY = -directionY;
			enemiX += directionX;
			enemiY += directionY;
			
		}
	}
	
	public void render() {
		
		if(isAlive)
			Tools.drawRotatedImage(Main.gc, img, angle, enemiX, enemiY);
	}
	
	public void kill() {
		isAlive = false;
	}

}
