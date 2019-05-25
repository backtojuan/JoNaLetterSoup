//_________________________________________________________________________________________________________________________________________
	package gui.gamegui;
//_________________________________________________________________________________________________________________________________________
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.image.Image;
	import javafx.scene.layout.Pane;
	import javafx.scene.media.AudioClip;
	import javafx.scene.media.MediaPlayer;
	import java.io.IOException;
	import javafx.event.ActionEvent;
//_________________________________________________________________________________________________________________________________________
	public class GameController {
		//:::::::::::::::::::::::::::::::::::::::::::::
			@FXML    
			private Pane pane;
		    @FXML
		    private PasswordField passwordField;
		    @FXML
		    private TextField nicknameTextField;
		//:::::::::::::::::::::::::::::::::::::::::::::
		    private Stage stage;
		//:::::::::::::::::::::::::::::::::::::::::::::
//_________________________________________________________________________________________________________________________________________
	    
		    @FXML
		    public void initialize() {
		    	
		    }
	//_____________________________________________________________________________________________________________________________________
		    
		    public void playMusic() {
		    	AudioClip audio = new AudioClip(this.getClass().getResource("backgroundmusic.mp3").toString());
		    	audio.play();
		    }
		    
	//_____________________________________________________________________________________________________________________________________	    
		    public void setStage(Stage stage) {
		    	this.stage = stage;
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    void removeProfile(ActionEvent event) {
		
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    void showAboutMenu(ActionEvent event) {
		
		    }		    
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    void showBestScoresMenu(ActionEvent event) {
		
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    void showSignUpInfoMenu(ActionEvent event) {
		
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    void signIn(ActionEvent event) {
		
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    void signUp(ActionEvent event) throws IOException {
		    	
		    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
		    	Parent root1 = (Parent) fxmlLoader.load();
		    	Stage stage = new Stage();
		    	
		    	stage.setTitle("Warning Suggestions");
		    	stage.centerOnScreen();
		    	stage.setResizable(false);
		    	
				Image image = new Image("gui/gamegui/images/icon.png");
				stage.getIcons().add(image);
				stage.initModality(Modality.APPLICATION_MODAL);
				
		    	stage.setScene(new Scene(root1));  
		    	stage.show();
		    }
//_________________________________________________________________________________________________________________________________________
}
