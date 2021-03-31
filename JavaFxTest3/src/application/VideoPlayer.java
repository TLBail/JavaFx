package application;

import java.io.File;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextInputDialog;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class VideoPlayer {
	
	public static final String VIDEOFROMFILE = "videoFromFile", VIDEOFROMURL = "videoFromUrl";
	
	
	private String videoUrlString;
		
	
	public VideoPlayer(SampleController sampleController, String choice) {
		if(choice == VIDEOFROMFILE)
			tryToLoadFile(sampleController);
		if(choice == VIDEOFROMURL)
			tryToLoadUrl(sampleController);
	}
	
	
	private void tryToLoadUrl(SampleController sampleController) {
		// TODO Auto-generated constructor stub
		
		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter your name:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(name -> name = videoUrlString);
	
		
		sampleController.webView.setVisible(true);
	}
	
	private void tryToLoadFile(SampleController sampleController) {
		
		try {
			
			sampleController.mediaView.setVisible(true);
			   System.out.println("try to open the video");
			   FileChooser chooser = new FileChooser();
			   File file = chooser.showOpenDialog(null);
			   
			   
			   Media nwMedia = new Media(file.toURI().toURL().toString());
			   
			   
			   
			   
			   sampleController.player = new MediaPlayer(nwMedia);
			   
			   sampleController.mediaView.setMediaPlayer(sampleController.player);

			   
			   //time slider...
			   
			   sampleController.player.setOnReady(()->{
				   //quand le player est prêt
				   
				   sampleController.timeSlider.setMin(0);
				   sampleController.timeSlider.setMax(sampleController.player.getMedia().getDuration().toSeconds());
				   sampleController.timeSlider.setValue(0);
				   
			   });
			   
			   //listener on player...
			   
			   sampleController.player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
				   
				   @Override
				public void changed(ObservableValue<? extends Duration> arg0, Duration arg1, Duration arg2) {
					Duration duration = sampleController.player.getCurrentTime();
					sampleController.timeSlider.setValue(duration.toSeconds());
					
					
				}
				   
			   });
			   
			   
			   //listener on slider
			   
			   sampleController.timeSlider.valueProperty().addListener(new ChangeListener<Number>() {
				   	
				   @Override
				public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
					// TODO Auto-generated method stub
					if(sampleController.timeSlider.isPressed())  
						sampleController.player.seek(new Duration(sampleController.timeSlider.getValue() * 1000));
				}
				   
			   });
			   
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	

}
