package application;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class sampleController {

	
	
	
	@FXML
	Pane paneText;
	
	@FXML
	TextField textField;
	
	@FXML
	void OnNewCharacter(KeyEvent event) {
		Main.textGenerator.newWord(textField);
	}
	
	
}
