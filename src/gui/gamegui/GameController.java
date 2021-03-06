//_________________________________________________________________________________________________________________________________________
	package gui.gamegui;
//_________________________________________________________________________________________________________________________________________
	import java.io.IOException;
	import org.controlsfx.control.Notifications;
	import customexception.InvalidInformationException;
	import customexception.PlayerDoesNotExistException;
	import gui.lettersoupgui.LetterSoupController;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.geometry.Pos;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.input.MouseEvent;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.Pane;
	import javafx.scene.media.AudioClip;
	import javafx.stage.Modality;
	import javafx.stage.Stage;
	import javafx.util.Duration;
	import model.gamemodel.Game;
	import threads.MusicThread;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and launch the main game gui 
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan Jos� Valencia Jaramillo
	 * @version V_01_MAY-2019
	 */
	public class GameController{
		//:::::::::::::::::::::::::::::::::::::::::::::
	    	@FXML
	    	private Pane pane;
	    	@FXML
	    	private BorderPane borderpane;
		    @FXML
		    private PasswordField passwordField;
		    @FXML
		    private TextField nicknameTextField; 
		    @FXML
		    private ImageView doraemon;
		//:::::::::::::::::::::::::::::::::::::::::::::
		    private Stage stage;
		    private AudioClip audio;
		    private Game game;
		//:::::::::::::::::::::::::::::::::::::::::::::
//_________________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method initializes the GUI once it has been launched making sure the needed objects are ready to work
		     */
		    private void initialize(){
		    		game = new Game(null);
		    		MusicThread mt = new MusicThread(this);
		    		mt.setDaemon(true);
		    		mt.start();
		    }
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * This method plays the background music of the game by calling the audio to be played.
		     */
		    public void playMusic() {
		    	audio = new AudioClip(this.getClass().getResource("backgroundmusic.mp3").toString());
		    	audio.play();
		    } 
	//_____________________________________________________________________________________________________________________________________	
		    /**
		     * This method sets the stage of the window that is going to manage this controller once it has been initialized
		     * @param stage the new stage for this window
		     */
		    public void setStage(Stage stage) {
		    	this.stage = stage;
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method plays a background animated sound of the popular asian character "Doraemon" as a little easter egg :3
		     * @param event the event triggered by the user
		     */
		    private void playDoraemonEasterEgg(MouseEvent event) {
		    	AudioClip audio = new AudioClip(this.getClass().getResource("doraemon.mp3").toString());
		    	if(event.getX()<doraemon.getFitHeight()||event.getX()<doraemon.getFitWidth()) {
		    		audio.play();
		    	}
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method allows to remove a registered player in the game throught the game.
		     * @param event the event triggered by the user
		     */
		    private void removeProfile(ActionEvent event) {
		    	try {
		    		String nickname = nicknameTextField.getText();
		    		String password = passwordField.getText();
		    		if(nickname.equals("")||password.equals("")) {
		    			throw new InvalidInformationException(nickname);
		    		}
		    		if(game.playerExists(nickname)==null) {
		    			throw new PlayerDoesNotExistException(nickname);
		    		}
		    		else {
		    			if(game.isCorrect(nickname, password)) {
		    				game.removePlayer(nickname, password);
		    				game.savePlayers();
			    			Notifications.create()
			    			.title("Annoucement")
			    			.text("You've been succesfully removed. We hope you come back someday!!!")
			    			.graphic(new ImageView(new Image("gui/gamegui/images/success.png")))
			    			.darkStyle()
			    			.hideCloseButton()
			    			.hideAfter(Duration.seconds(8))
			    			.position(Pos.BOTTOM_CENTER)
			    			.show();
		    			}
		    			else {
			    			Notifications.create()
			    			.title("Announcement")
			    			.text("OOPS! your password and your nickname does not match together be careful and try again")
			    			.graphic(new ImageView(new Image("gui/gamegui/images/warning.png")))
			    			.darkStyle()
			    			.position(Pos.TOP_RIGHT)
			    			.hideCloseButton()
			    			.hideAfter(Duration.seconds(8))
			    			.show();
		    			}
		    		}
		    	}
		    	catch (PlayerDoesNotExistException pdne){
		    		Notifications.create()
		    		.title("Announcement")
		    		.text(pdne.getMessage())
		    		.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
		    		.darkStyle()
		    		.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
		    		.show();
		    	}
		    	catch(InvalidInformationException iie) {
		    		Notifications.create()
		    		.title("Announcement")
		    		.text(iie.getMessage())
		    		.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
		    		.darkStyle()
		    		.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
		    		.show();
		    	}

		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method shows a little information about the development of this project
		     * @param event the event triggered by the user
		     */
		    private void showAboutInfo(ActionEvent event) {
		    	Notifications.create()
		    	.title("About")
		    	.text("Developed by Lina Johanna Salinas Delgado & Juan Jose Valencia Jaramillo."
		    			+ "Software engineering students from Icesi University")
		    	.graphic(new ImageView(new Image("gui/gamegui/images/suggestion.png")))
		    	.darkStyle()
		    	.position(Pos.BOTTOM_CENTER)
		    	.hideCloseButton()
    			.hideAfter(Duration.seconds(8))
    			.show();
		    }		    
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method launchs the new window that contains the registered players table of the game
		     * @param event the event triggered by the user
		     */
		    private void showBestScoresMenu(ActionEvent event) {
				try {
			    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RegisteredHall.fxml"));
			    	Parent root1 = (Parent) fxmlLoader.load();
			    	RegisteredHallController shc = new RegisteredHallController();
			    	stage = new Stage();
			    	shc.setStage(stage);
			    	stage.setTitle("Scores Hall");
			    	stage.centerOnScreen();
			    	stage.setResizable(false);
			    	Image image = new Image("gui/gamegui/images/icon.png");
					stage.getIcons().add(image);
					stage.initModality(Modality.APPLICATION_MODAL);
			    	stage.setScene(new Scene(root1));  
			    	stage.show();
				} catch (IOException e) {
					Notifications.create()
					.title("Something went wrong...")
					.text("Cannot launch the new window due to a problem with the files in the project, make sure 'RegisteredHall.fxml' exists")
					.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
					.darkStyle()
					.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
	    			.show();
				}
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method shows a little information about instructions of signing up in the game
		     * @param event the event triggered by the user
		     */
		    private void showSignUpInfo(ActionEvent event) {
		    	Notifications.create()
		    	.title("Help")
		    	.text("If you want to sign up please click the sign up button and fill the required information in order to start playing")
		    	.graphic(new ImageView(new Image("gui/gamegui/images/suggestion.png")))
		    	.darkStyle()
		    	.position(Pos.BOTTOM_CENTER)
		    	.hideCloseButton()
    			.hideAfter(Duration.seconds(8))
		    	.show();
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This methods signs in the player in the game allowing them to be able to play a new lettersoup  
		     * @param event the event triggered by the user
		     */
		    private void signIn(ActionEvent event) {
		    	try {
		    		game.refreshPlayers();
		    		String nickname = nicknameTextField.getText();
		    		String password = passwordField.getText();
		    		if(game.playerExists(nickname)==null) {
		    			throw new PlayerDoesNotExistException(nickname);
		    		}
		    		if(game.isCorrect(nickname, password)) {
		    			
		    			try {
			    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/lettersoupgui/lettersoup.fxml"));
					    	Parent root1 = (Parent) fxmlLoader.load();
					    	stage = new Stage();
					    	LetterSoupController ltc = new LetterSoupController();
					    	ltc.setStage(stage);
					    	stage.setTitle("LetterSoup");
					    	stage.centerOnScreen();
					    	stage.initModality(Modality.APPLICATION_MODAL);
							Image image = new Image("gui/lettersoupgui/images/icon.png");
							stage.getIcons().add(image);
							stage.setResizable(false);
							stage.centerOnScreen();		
					    	stage.setScene(new Scene(root1));  
					    	stage.show();
		    			}
					    catch(IOException e) {
							Notifications.create()
							.title("Something went wrong...")
							.text("Cannot launch the new window due to a problem with the files in the project, make sure 'SignIn.fxml' exists")
							.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
							.darkStyle()
							.position(Pos.TOP_RIGHT)
				    		.hideCloseButton()
			    			.hideAfter(Duration.seconds(8))
			    			.show();;
					    }
		    		}
		    		else {
		    			Notifications.create()
		    			.title("Announcement")
		    			.text("OOPS! your password and your nickname does not match together be careful and try again")
		    			.graphic(new ImageView(new Image("gui/gamegui/images/warning.png")))
		    			.darkStyle()
		    			.position(Pos.TOP_RIGHT)
		    			.hideCloseButton()
		    			.hideAfter(Duration.seconds(8))
		    			.show();
		    		}
		    	}
		    	catch (PlayerDoesNotExistException pdne){
		    		Notifications.create()
		    		.title("Announcement")
		    		.text(pdne.getMessage())
		    		.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
		    		.darkStyle()
		    		.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
		    		.show();
		    	}
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method signs up the user to the game allowing them to register in a new form window. 
		     * @param event The event triggered by the user
		     */
		    private void signUp(ActionEvent event){
				try {
			    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
			    	Parent root1 = (Parent) fxmlLoader.load();
			    	
			    	SignUpController supc = new SignUpController();
			    	stage = new Stage();
			    	supc.setStage(stage);
			    	stage.setTitle("Sign up section");
			    	stage.centerOnScreen();
			    	stage.setResizable(false);
			    	Image image = new Image("gui/gamegui/images/icon.png");
					stage.getIcons().add(image);
					stage.initModality(Modality.APPLICATION_MODAL);
			    	stage.setScene(new Scene(root1));  
			    	stage.show();
				} catch (IOException e) {
					Notifications.create()
					.title("Something went wrong...")
					.text("Cannot launch the new window due to a problem with the files in the project, make sure 'SignUp.fxml' exists")
					.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
					.darkStyle()
					.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
	    			.show();
				}
		    }
//_________________________________________________________________________________________________________________________________________
}
