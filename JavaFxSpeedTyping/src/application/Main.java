package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	public static Parent root;
	public static Stage stage;
	public static Scene scene;
	public static TexteGenerator textGenerator;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        scene = new Scene(root, 634, 618);
        primaryStage.setScene(scene);
        stage = primaryStage;
           
	    textGenerator = new TexteGenerator();
	    textGenerator.GenerateText("Salut a tous c fanta et jadore le minecraft");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
