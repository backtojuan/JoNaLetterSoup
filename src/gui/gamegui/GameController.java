//_________________________________________________________________________________________________________________________________________
	package gui.gamegui;
//_________________________________________________________________________________________________________________________________________
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Modality;
	import javafx.stage.Stage;
import threads.BackgroundThread;
import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.media.AudioClip;
	import javafx.scene.media.MediaPlayer;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Random;
	import org.controlsfx.control.Notifications;
	import javafx.event.ActionEvent;
//_________________________________________________________________________________________________________________________________________
	public class GameController {
		//:::::::::::::::::::::::::::::::::::::::::::::
	    	@FXML
	    	private BorderPane borderpane;
		    @FXML
		    private PasswordField passwordField;
		    @FXML
		    private TextField nicknameTextField; 
		//:::::::::::::::::::::::::::::::::::::::::::::
		    private Stage stage;
		    private ArrayList<Image> images;
		//:::::::::::::::::::::::::::::::::::::::::::::
//_________________________________________________________________________________________________________________________________________
		    @FXML
		    private void initialize() {
		    	playMusic();
		    	initImages();
		    	BackgroundThread bt = new BackgroundThread(this);
		    	bt.start();
		    	try {
					bt.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    }
	//_____________________________________________________________________________________________________________________________________
		    private void initImages() {
		    	images.add(new Image("gui/gamegui/images/D.png"));
		    	images.add(new Image("gui/gamegui/images/I.png"));
		    	images.add(new Image("gui/gamegui/images/K.png"));
		    	images.add(new Image("gui/gamegui/images/M.png"));
		    	images.add(new Image("gui/gamegui/images/P.png"));
		    }
	//_____________________________________________________________________________________________________________________________________
		    public void playMusic() {
		    	AudioClip audio = new AudioClip(this.getClass().getResource("backgroundmusic.mp3").toString());
		    	audio.play();
		    }
	//_____________________________________________________________________________________________________________________________________
		    public void animateBackground() {
		    	Random random = new Random();
		    	ImageView r = new ImageView();
		    	Image randompick = images.get(random.nextInt(images.size()));
		    	r.setImage(randompick);
		    	borderpane.getChildren().add(r);
		    }
	//_____________________________________________________________________________________________________________________________________	    
		    public void setStage(Stage stage) {
		    	this.stage = stage;
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    private void removeProfile(ActionEvent event) {
		
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    private void showAboutMenu(ActionEvent event) {
		
		    }		    
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    private void showBestScoresMenu(ActionEvent event) {
		
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    private void showSignUpInfoMenu(ActionEvent event) {
		
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    private void signIn(ActionEvent event) {
		
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    void signUp(ActionEvent event) throws IOException {
		    	
		    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
		    	Parent root1 = (Parent) fxmlLoader.load();
		    	Stage stage = new Stage();
		    	
		    	SignUpController supc = new SignUpController();
		    	supc.setStage(stage);
		    	
		    	stage.setTitle("Sign up section");
		    	stage.centerOnScreen();
		    	stage.setResizable(false);
		    	
				Image image = new Image("gui/gamegui/images/icon.png");
				stage.getIcons().add(image);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setResizable(false);
				stage.centerOnScreen();
				
		    	stage.setScene(new Scene(root1));  
		    	stage.show();
		    }
//_________________________________________________________________________________________________________________________________________
}
