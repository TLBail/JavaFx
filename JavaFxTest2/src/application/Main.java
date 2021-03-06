package application;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import game.Ennemi;
import game.Player;
import game.Tools;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

	public static void main(String[] args) throws Exception {
		launch(args);

	}

	private void initGameLoop(Scene scene) {
		// on récupere les élement
		canvas = (Canvas) scene.lookup("#canvas");
		if (canvas == null)
			System.err.println(" ett le bug lla");
		gc = canvas.getGraphicsContext2D();

		Timeline gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);

		timeStart = System.currentTimeMillis();

		awake();
		
		KeyFrame kf = new KeyFrame(Duration.seconds(0.017), // 60 FPS
				new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						deltaTime = (System.currentTimeMillis() - timeStart) / 1000.0;

						// Clear the canvas
						gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

						update();

					}
				});

		gameLoop.getKeyFrames().add(kf);
		gameLoop.play();

		// drawShapes();
	}

	private static void prepareActionHandlers() {
		// use a set so duplicates are not possible
		currentlyActiveKeys = new HashSet<KeyCode>();
		mainScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				currentlyActiveKeys.add(event.getCode());
			}
		});
		mainScene.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				currentlyActiveKeys.remove(event.getCode());
			}
		});
	}

	// appelé qu'une seul fois
	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		primaryStage.setTitle("Hello World");
		mainScene = new Scene(root);
		primaryStage.setScene(mainScene);

		// icon
		InputStream iconStream = getClass().getResourceAsStream("..\\data\\duck.jpg");
		if (iconStream == null)
			System.out.println("pas trouvé");
		Image img = new Image(iconStream);
		primaryStage.getIcons().add(img);

		// event
		prepareActionHandlers();
		
		initGameLoop(mainScene);
		primaryStage.show();

		

	}
	
	
	public static Canvas canvas;
	public static GraphicsContext gc;
	private static Scene mainScene;
	private Image img;
	private Player player;
	private double deltaTime, timeStart;
	public static HashSet<KeyCode> currentlyActiveKeys;
	private ArrayList<Ennemi>  ennemis = new ArrayList<>();
	

	//first frame before update
	private void awake() {

		InputStream oubahStreamImg = getClass().getResourceAsStream("..\\data\\loubahssi.png");
		if (oubahStreamImg == null)
			System.out.println("pas trouvé");
		player = new Player(new Image(oubahStreamImg, 180, 200, false , false));
		
		//genere les méchant
		InputStream ennemiStream = getClass().getResourceAsStream("..\\data\\mechant.png");
		if (ennemiStream == null)
			System.out.println("pas trouvé");
		img = new  Image(ennemiStream, 100, 100, false,false);
	
		for (int i = 0; i < 5; i++) {
			ennemis.add(new Ennemi(img, Math.random() * (canvas.getWidth() - 100), Math.random() * (canvas.getHeight() - 100)));
		}


	}

	// appelé a chaque frame
	private void update() {

		/*
		 * //bacground gc.setFill(Color.WHITE); gc.fillRect(0, 0, canvas.getWidth(),
		 * canvas.getHeight());
		 */
		//on gere la réaparition
		fete();
		if(deltaTime >= 10) {
			for (int i = 0; i < 5; i++) {
				ennemis.add(new Ennemi(img, Math.random() * (canvas.getWidth() - 100), Math.random() * (canvas.getHeight() - 100)));
			}
			timeStart = System.currentTimeMillis();
		}
		
		
		if(Main.currentlyActiveKeys.contains(KeyCode.SPACE)) {
			
			//le joueur Attaque
			player.attaque();
			
			//on regarde si il tue du virus
			for (Ennemi ennemi : ennemis) {
				if(Tools.colid(new Rectangle(ennemi.enemiX, ennemi.enemiY , 100, 100), new Rectangle(player.getOubahX(), player.getOubahY() , 180, 200))) {
					ennemi.kill();
				}
			}
			
			
		}
		
		for (Ennemi ennemi : ennemis) {
			ennemi.move();
			ennemi.render();
		}
		
		player.movePlayer();
		player.render();

	}
	
	public void fete() {
		if(Main.currentlyActiveKeys.contains(KeyCode.ENTER)) {
			
			for (int i = 0; i < 5; i++) {
				ennemis.add(new Ennemi(img, Math.random() * (canvas.getWidth() - 100), Math.random() * (canvas.getHeight() - 100)));
			}
			
			
		}
	}

}



