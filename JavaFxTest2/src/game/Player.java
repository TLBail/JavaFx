package game;

import application.Main;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Player {
	
	private static final double speed = 5, rotateSpeed = 20, nbAnim = 20;
	private double angle = 0, oubahX = 0, oubahY = 0, actualNbAnim = 0;
	private Image img;
	
	
	public double getOubahX() {
		return oubahX;
	}
	
	public double getOubahY() {
		return oubahY;
	}
	
	public Player(Image img) {
		this.img = img;
		
		oubahX = Main.canvas.getWidth() / 2;
		oubahY = Main.canvas.getHeight() / 2;
		
	}
	
	public void movePlayer() {
		

		if (Main.currentlyActiveKeys.contains(KeyCode.LEFT)) {
			oubahX -= speed;
		}

		if (Main.currentlyActiveKeys.contains(KeyCode.RIGHT)) {
			oubahX += speed;
		}

		if (Main.currentlyActiveKeys.contains(KeyCode.UP)) {
			oubahY -= speed;
		}

		if (Main.currentlyActiveKeys.contains(KeyCode.DOWN)) {
			oubahY += speed;
		}

		if (actualNbAnim > 0) {
			actualNbAnim--;
			angle += rotateSpeed;
		} else {
			angle = 0;
		}

		
	}
	
	public void attaque() {
		actualNbAnim = nbAnim;
	}
	
	public void render() {
		Tools.drawRotatedImage(Main.gc, img, angle, oubahX, oubahY);
	}

}
