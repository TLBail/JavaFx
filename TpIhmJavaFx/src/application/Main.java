package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	public static Scene scene;
	public static Parent root;
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        stage = primaryStage;
        ListView<String> listPolice = (ListView<String>) scene.lookup("#listPolice");
        
        ObservableList<String> itemsPolice =FXCollections.observableArrayList (
			    "Calibri", "Cambria", "Corbel", "Ebrima");
			listPolice.setItems(itemsPolice);
        
			
		ListView<String> listStylePolice = (ListView<String>) scene.lookup("#listStylePolice");
	        
	    ObservableList<String> itemsStylePolice =FXCollections.observableArrayList (
				    "Normal", "Italique", "Gras", "Gras Italique");
	    listStylePolice.setItems(itemsStylePolice);
	        
	    ListView<String> listTaille = (ListView<String>) scene.lookup("#listTaille");
        
	    ObservableList<String> itemslistTaille =FXCollections.observableArrayList ();
	    for (int i = 0; i < 30; i++) {
	    	
	    	itemslistTaille.add(String.valueOf(i));
		    
		}
	    listTaille.setItems(itemslistTaille);
	    
	    
	    
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
