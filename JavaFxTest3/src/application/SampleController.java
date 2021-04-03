package application;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class SampleController {

	MediaPlayer player;
	
	
	@FXML
   MediaView mediaView;
   
	@FXML
	ImageView playButtonImgView;
	
	@FXML
	Button buttonPlay;
	
   @FXML
   public Slider timeSlider;
   
   public Image playImage, pauseImage;
   
   @FXML
   WebView webView;
   
   
   public SampleController() {
	   InputStream imgStream = getClass().getResourceAsStream("..\\ressources\\play.png");
	   playImage = new Image(imgStream);
	   imgStream = getClass().getResourceAsStream("..\\ressources\\pause.png");
	   pauseImage = new Image(imgStream);

	   
   }
   
   
   @FXML
   void OnPlayClick(ActionEvent event) {
	   
	   
	   if(player != null) {
		   if(player.getStatus() == MediaPlayer.Status.PLAYING) {
			   player.pause();
			   playButtonImgView.setImage(playImage);
			   buttonPlay.setText("Play");
		   }else {
			   player.play();
			   playButtonImgView.setImage(pauseImage);
			   buttonPlay.setText("Pause");
		   }
		   
	   }
	}
   
   @FXML
   void OnOpenFileClick(ActionEvent event) {
	   VideoPlayer videoPlayer = new VideoPlayer(this, VideoPlayer.VIDEOFROMFILE);
	   
	   
   }
   
   @FXML
   void OnOpenUrlClick(ActionEvent event) {
	   VideoPlayer videoPlayer = new VideoPlayer(this, VideoPlayer.VIDEOFROMURL);
   }
   
   
   
   
   @FXML
   void OnStopClick(ActionEvent e) {
	   if(player != null) {
		   player.stop();
		   playButtonImgView.setImage(playImage);
		   buttonPlay.setText("Play");
	   
	   }
	}
    
    
    
    
    
    
    
    
}