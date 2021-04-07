package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	public static Scene scene;
	public static Parent root;
	public static Stage stage;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        stage = primaryStage;
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene); 
	    
	    
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
