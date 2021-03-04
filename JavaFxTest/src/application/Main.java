package application;
	
import java.io.Console;
import java.io.InputStream;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        
        
        ImageView imgOubah = (ImageView) scene.lookup("#imgOubah");
        
        System.out.println((imgOubah != null)?"oui":"nul");
        
        TranslateTransition transition = new TranslateTransition();
        
        transition.setDuration(Duration.seconds(1));
        transition.setAutoReverse(true);
        transition.setNode(imgOubah);
        transition.setToY(100);
        transition.setCycleCount(Animation.INDEFINITE);
        transition.play();
        
        //icon
        InputStream iconStream = getClass().getResourceAsStream("..\\data\\duck.jpg");
        if(iconStream == null) System.out.println("pas trouvé");
        
        Image img = new Image(iconStream);
        primaryStage.getIcons().add(img);
        
        
        primaryStage.show();
        
        
    }
	
	
	public static void main(String[] args) throws Exception {
		launch(args);
	
		
	}
}
