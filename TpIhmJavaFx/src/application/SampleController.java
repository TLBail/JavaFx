package application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class SampleController {

	@FXML
	ListView<String> listPolice;
   
	@FXML
	ListView<String> listStylePolice;
	
	@FXML
	ListView<String> listTaille;
	
	
	@FXML
	TextField textFieldStylePolice;
	@FXML
	TextField textFieldPolice;
	@FXML
	TextField textFieldTaille;
	
	@FXML
	Canvas canvaText;
	
	private String police = "Calibri", Style;
	private Double taille = 10d;
	private boolean bold = false;
	
   public SampleController() {
	   
   }
   
   
   @FXML
   void OnPlayClick(ActionEvent event) {

	}

   @FXML
    void OnSelectionOfPolice(MouseEvent event) {
	   police = listPolice.getFocusModel().getFocusedItem();
	   textFieldPolice.setText(police);
   }
    
   @FXML
   void OnSelectionOfStylePolice(MouseEvent event) {
	   Style = listStylePolice.getFocusModel().getFocusedItem();
	   textFieldStylePolice.setText(Style);
	   if(Style.contains("Gras")){
		   bold = true;
	   }else{
		   bold = false;
	   }
  }
   
   @FXML
   void OnSelectionOfTaille(MouseEvent event){
	   String focused = listTaille.getFocusModel().getFocusedItem();
	   textFieldTaille.setText(focused);
	   taille = Double.parseDouble(focused);
   }
    
   @FXML
   void OnAnnulerCliked(ActionEvent event){
	  Main.stage.close();
   }
   
   @FXML
   void OnApplyButton(){
	   
	 GraphicsContext gc = canvaText.getGraphicsContext2D();
	 gc.clearRect(0, 0, canvaText.getWidth(), canvaText.getHeight());
	 
	 if(bold){
		 
		 gc.setFont(Font.font(police, FontWeight.BOLD, taille));
	 }else{
		 gc.setFont(Font.font(police, taille));
		 
	 }
	 
	 gc.fillText("IUT de laval", canvaText.getWidth()/2, canvaText.getHeight()/2);
	 gc.strokeLine(0, canvaText.getHeight()/2, canvaText.getWidth()/4, canvaText.getHeight()/2);
	 gc.strokeLine(canvaText.getWidth() / 2 + canvaText.getWidth() / 4, canvaText.getHeight()/2, canvaText.getWidth(), canvaText.getHeight()/2);
	 
   }
   
   /* 
   @FXML
   void OnTextFielChange(ActionEvent event){
	   TextField textfield =  (TextField) event.getSource();
	   if(textfield != null){
		   String textInput  = textfield.getText();
		   if(textfield == textFieldPolice){
			   
		   }
		   if(textfield == textFieldStylePolice){
			   
		   }
		   if(textfield = textFieldTaille){
			   
		   }
	   }
   }
   */
    
}