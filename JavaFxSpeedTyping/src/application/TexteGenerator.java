package application;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class TexteGenerator {
	
	private Pane paneText;
	private Label listeText[];
	
	
	public TexteGenerator() {
		paneText = (Pane) Main.scene.lookup("#paneText");
		
		
	}
	
	public void GenerateText(String textToGenerate) {
		int nbWord = nbWord(textToGenerate);
		System.out.println(nbWord);
		listeText = new Label[nbWord];
		
		for (int i = 0; i < listeText.length; i++) {
			listeText[i] = new javafx.scene.control.Label(wordtaker(textToGenerate, i));
			listeText[i].setTextFill(Color.YELLOW);
			listeText[i].setLayoutX(i * textToGenerate.length());
			paneText.getChildren().add(listeText[i]);
			
		}
		for (Label label : listeText) {
			System.out.println(label.getText());
		}
		
	}
	
	
	public void newWord(TextField textField) {
		
		for (Label label : listeText) {
			if(label.getText().equals(textField.getText().replaceAll(" ", ""))) {
				label.setText("");
				textField.setText("");
			}else {
				
			}
		}
	}
	
	
	private int nbWord(String stringToCalculate) {
		int count=0;  
	      
        char ch[]= new char[stringToCalculate.length()];     
        for(int i=0;i<stringToCalculate.length();i++)  
        {  
            ch[i]= stringToCalculate.charAt(i);  
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                count++;  
        }  
        return count;  
	}
	
	
	private String wordtaker(String string, int indice) {
		String listString[] = string.split(" ");
		
        return listString[indice];
	}

	
}
