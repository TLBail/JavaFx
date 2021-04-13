package application;
	
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	
	public static Scene scene;
	public static Parent root;
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Texte form app");
        scene = new Scene(root, 470, 618);
        primaryStage.setScene(scene);
        stage = primaryStage;
        
        //icon
        InputStream iconStream = getClass().getResourceAsStream("icon.jpg");
        if(iconStream == null) {
        	System.out.println("pas trouvé");
        }else {
        	Image img = new Image(iconStream);
            primaryStage.getIcons().add(img);
            
        }
        
        
        ListView<String> listPolice = (ListView<String>) scene.lookup("#listPolice");
        
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ObservableList<String> itemsPolice =FXCollections.observableArrayList(
				graphicsEnvironment.getAvailableFontFamilyNames()
				);
			listPolice.setItems(itemsPolice);
        
			
		ListView<String> listStylePolice = (ListView<String>) scene.lookup("#listStylePolice");
	        
		ObservableList<String> itemsStylePolice =FXCollections.observableArrayList (
				    "Normal", "Italique", "Gras", "Gras Italique");
	   
		listStylePolice.setItems(itemsStylePolice);
	        
	    ListView<String> listTaille = (ListView<String>) scene.lookup("#listTaille");
        
	    ObservableList<String> itemslistTaille =FXCollections.observableArrayList ();
	    for (int i = 0; i < 100; i++) {
	    	
	    	itemslistTaille.add(String.valueOf(i));
		    
		}
	    listTaille.setItems(itemslistTaille);
	   
	    ColorPicker colorPicker = (ColorPicker) scene.lookup("#colorPicker");
	    colorPicker.setValue(Color.WHITE);
	    
	    
	    ChoiceBox<String> soulignementChoiceBox = (ChoiceBox) scene.lookup("#soulignementChoiceBox");
	    ObservableList<String> itemsSoulignement =FXCollections.observableArrayList (
			    "(aucun)", "souligne");
	    soulignementChoiceBox.setItems(itemsSoulignement);
    
	    
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
