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
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
	
	@FXML
	ColorPicker colorPicker, soulignementcolorPicker;
	
	
	@FXML
	Text textToDisplay;
	
	
	@FXML
	CheckBox barreCheckBox;
	
	@FXML
	ChoiceBox<String> soulignementChoiceBox;
	
	private String police = POLICEDF, style = STYLEDF;
	private Double taille = TAILLEDF;
	private boolean bold = BOLDDF, italique = ITALIQUEDF, souligner = SOULIGNERDF;
	
	private static final String POLICEDF = "Calibri", STYLEDF = "normal";
	private static final Boolean BOLDDF = false, ITALIQUEDF = false, SOULIGNERDF = false;
	private static final double TAILLEDF = 10d;
	


   @FXML
    void OnSelectionOfPolice(MouseEvent event) {
	   police = listPolice.getFocusModel().getFocusedItem();
	   textFieldPolice.setText(police);
	   renderText();
   }
    
   @FXML
   void OnSelectionOfStylePolice(MouseEvent event) {
	   style = listStylePolice.getFocusModel().getFocusedItem();
	   textFieldStylePolice.setText(style);
	   bold = style.contains("Gras");
	   System.out.println(bold);
	   italique = style.contains("Italique");
	   renderText();
  }
   
   @FXML
   void OnSelectionOfTaille(MouseEvent event){
	   String focused = listTaille.getFocusModel().getFocusedItem();
	   textFieldTaille.setText(focused);
	   taille = Double.parseDouble(focused);
	   renderText();
   }
    
   @FXML
   void OnAnnulerCliked(ActionEvent event){
	  Main.stage.close();
   }
   
   @FXML
   void OnApplyButton(){
	
	   if(listTaille.getFocusModel().getFocusedItem() != null)  taille = Double.parseDouble(listTaille.getFocusModel().getFocusedItem());
	   if(listStylePolice.getFocusModel().getFocusedItem() != null) style = listStylePolice.getFocusModel().getFocusedItem();
	   if(listPolice.getFocusModel().getFocusedItem() != null) police = listPolice.getFocusModel().getFocusedItem();
	   
	   renderText();
	 
	}
   
   private void renderText() {
	   
		 GraphicsContext gc = canvaText.getGraphicsContext2D();
		 gc.clearRect(0, 0, canvaText.getWidth(), canvaText.getHeight());
		
	   
	   textToDisplay.setText("IUT de laval");
	   textToDisplay.setFill(colorPicker.getValue());
	   
	   if(bold){
			 if(italique) {
				 textToDisplay.setFont(Font.font(police, FontWeight.BOLD, FontPosture.ITALIC, taille));
			 }else {
				 textToDisplay.setFont(Font.font(police, FontWeight.BOLD, taille));
			 }
		}else{
			if(italique) {
				textToDisplay.setFont(Font.font(police, FontPosture.ITALIC, taille));
			}else {
				textToDisplay.setFont(Font.font(police, taille));
				 	
			}
		 }
	   textToDisplay.setStrikethrough(barreCheckBox.isSelected());
	   
	   //if(soulignementChoiceBox.getValue() != null) textToDisplay.setUnderline(soulignementChoiceBox.getValue().contains("souligne"));
	   if(soulignementChoiceBox.getValue() != null && soulignementChoiceBox.getValue().contains("souligne")) {
		   double widthText = textToDisplay.getLayoutBounds().getWidth() / 2;
		   double heightText = textToDisplay.getLayoutBounds().getHeight() / 2.5;
		   System.out.println(widthText);
		   gc.setStroke(soulignementcolorPicker.getValue());
		   gc.setLineWidth(heightText / 10);
		   gc.strokeLine(canvaText.getWidth() / 2 - widthText,
				   canvaText.getHeight() / 2 + heightText,
				   canvaText.getWidth() / 2 + widthText,
				   canvaText.getHeight() / 2 + heightText
				  );
		   
		   
	   }
	   
	   
	  
	   
	
	 gc.setLineWidth(1);
	 gc.setStroke(Color.BLACK);
	 gc.strokeLine(0, canvaText.getHeight()/2, canvaText.getWidth()/4, canvaText.getHeight()/2);
	 gc.strokeLine(canvaText.getWidth() / 2 + canvaText.getWidth() / 4, canvaText.getHeight()/2, canvaText.getWidth(), canvaText.getHeight()/2);
	 gc.setLineWidth(2);
	 gc.strokeRect(0, 0, canvaText.getWidth(), canvaText.getHeight());
	
   }
   
   
   @FXML
   void OnColorPickerChange(ActionEvent event) {
	   renderText();
   }
   
   @FXML
   void OnChangeRenderText() {
	   renderText();
   }
   
   
   @FXML
   void OnTextFielChange(ActionEvent event){
	   TextField textfield =  (TextField) event.getSource();
	   if(textfield != null){
		   String textInput  = textfield.getText();
		   if(textfield == textFieldPolice){
			   
			   for (int i = 0; i < listPolice.getItems().size(); i++) {
				   if(listPolice.getItems().get(i).equals(textInput)) {
					   listPolice.scrollTo(i);
					   listPolice.getSelectionModel().select(i);
					   listPolice.getFocusModel().focus(i);
				   }
			   }
			}
		   if(textfield == textFieldStylePolice){
			   for (int i = 0; i < listStylePolice.getItems().size(); i++) {
				   if(listStylePolice.getItems().get(i).equals(textInput)) {
					   listStylePolice.scrollTo(i);
					   listStylePolice.getSelectionModel().select(i);
					   listStylePolice.getFocusModel().focus(i);
				   }
			   }
		   }
		   if(textfield == textFieldTaille){
			   for (int i = 0; i < listTaille.getItems().size(); i++) {
				   if(listTaille.getItems().get(i).equals(textInput)) {
					   listTaille.scrollTo(i);
					   listTaille.getSelectionModel().select(i);
					   listTaille.getFocusModel().focus(i);
				   }
			   }
		   		   
		   }
	   }
	   renderText();
   }
   
   
   @FXML
   void OnDefaultButton(ActionEvent event) {
	  police = POLICEDF;
	  style = STYLEDF;
	  taille = TAILLEDF;
	  bold = BOLDDF;
	  italique = ITALIQUEDF;
	  souligner = SOULIGNERDF;
	  listTaille.getFocusModel().focus(20);
	  listTaille.getSelectionModel().select(20);
	  listPolice.getFocusModel().focus(0);
	  listPolice.getSelectionModel().select(0);
	  listStylePolice.getFocusModel().focus(0);
	  listStylePolice.getSelectionModel().select(0);
	  barreCheckBox.setSelected(false);
	  soulignementChoiceBox.setValue("(aucun)");
	  colorPicker.setValue(Color.BLACK);
	  
	  renderText();
   }
   
    
}