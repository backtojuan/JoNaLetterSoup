//_________________________________________________________________________________________________________________________________________
	package gui.gamegui;
//_________________________________________________________________________________________________________________________________________
	import java.io.IOException;
	import java.time.LocalDate;
	import org.controlsfx.control.Notifications;
	import customexception.InvalidInformationException;
	import customexception.InvalidPasswordException;
	import customexception.RepitedPlayerException;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.geometry.Pos;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Label;
	import javafx.scene.control.ColorPicker;
	import javafx.scene.control.DatePicker;
	import javafx.scene.control.MenuButton;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.layout.Pane;
	import javafx.scene.shape.Circle;
	import javafx.scene.shape.Rectangle;
	import javafx.stage.Stage;
	import javafx.util.Duration;
	import model.gamemodel.Game;
	import model.gamemodel.Player;
	import model.gamemodel.Shape;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and launch the sign up gui 
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_MAY-2019
	 */
	public class SignUpController {
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	    	@FXML
	    	private Pane paneSurface;
		    @FXML
		    private DatePicker birthdayField;
		    @FXML
		    private TextField nameField;
		    @FXML
		    private TextField nickNameField;
		    @FXML
		    private ColorPicker colorField;
		    @FXML
		    private MenuButton avatarMenu;
		    @FXML
		    private PasswordField passwordField;
		    @FXML
		    private PasswordField confirmPasswordField;
		    @FXML
		    private Label avatarLabel;
	    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		    private Stage stage;
		    private Game game;
//_________________________________________________________________________________________________________________________________________
			@FXML
			/**
			 * This method initializes the GUI once it has been launched creating the necessary objects and components that are going 
			 * to be used for this window
			 */
		    public void initialize() {
				game = new Game(null);
		    }
	//_____________________________________________________________________________________________________________________________________
			/**
			 * This method sets the new stage of the window that this controller is going to manage
			 * @param stage the new stage for this window
			 */
			public void setStage(Stage stage) {
		    	this.stage = stage;
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method signs up the user as a new Player contained for this game. 
		     * @param event the event triggered by the user
		     */
		    private void signUp(ActionEvent event) {
		    	try {
		    		LocalDate birthday = birthdayField.getValue();
		    		String name = nameField.getText();
		    		String nickname = nickNameField.getText();
		    		String favcolor = colorField.getValue().toString();	
		    		String avatars = avatarLabel.getText();
		    		String password = passwordField.getText();
		    		String confirmPassword = confirmPasswordField.getText();
		    		Shape avatar = avatars.equals("CIRCLE")?Shape.CIRCLE:Shape.RECTANGLE;   
		    		if(birthday == null) {
		    			throw new InvalidInformationException(null);
		    		}
		    		if(name.equals("")||nickname.equals("")||avatars.equals("")){
		    			throw new InvalidInformationException("");
		    		}	
		    		if(password == password.toUpperCase()||password.length()!=confirmPassword.length()||confirmPassword(password,confirmPassword)==false) {
		    			throw new InvalidPasswordException(password,confirmPassword);
		    		}
		    		else if(password.length()<8) {
		    			throw new InvalidPasswordException(password,confirmPassword);
		    		}
		    		if(game.playerExists(nickname)!=null) {
		    			throw new RepitedPlayerException(game.playerExists(nickname).getNickname(), nickname);
		    		}
		    		else{
		    			Player player = new Player(name,nickname,password,favcolor,birthday,avatar);
		    			game.addPlayer(player);
		    			game.savePlayers();
		    			Notifications.create()
		    			.title("Annoucement")
		    			.text("You've been succesfully registered. Welcome!!!"
		    					+ "\nThe default avatar is: Rectangle"
		    					+ ",The default color is white"
		    					+ "(In the case that you haven't choose an specific one)")
		    			.graphic(new ImageView(new Image("gui/gamegui/images/success.png")))
		    			.darkStyle()
		    			.hideCloseButton()
		    			.hideAfter(Duration.seconds(8))
		    			.position(Pos.BOTTOM_CENTER)
		    			.show()
		    			;
		    		}
		    	}
		    	catch(InvalidInformationException iie) {
		    		Notifications.create()
		    			.title("Something went wrong....")
		    			.text(iie.getMessage())
		    			.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
		    			.darkStyle()
		    			.position(Pos.TOP_CENTER)
		    			.hideCloseButton()
		    			.hideAfter(Duration.seconds(8))
		    			.show();
		    	}
		    	catch(InvalidPasswordException ipe){
		    		Notifications.create()
	    			.title("Something went wrong....")
	    			.text(ipe.getMessage())
	    			.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
	    			.darkStyle()
	    			.position(Pos.TOP_CENTER)
	    			.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
	    			.show();
		    	}
		    	catch(RepitedPlayerException rpe) {
		    		Notifications.create()
	    			.title("Something went wrong....")
	    			.text(rpe.getMessage())
	    			.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
	    			.darkStyle()
	    			.position(Pos.TOP_CENTER)
	    			.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
	    			.show();
		    	}
		    }
	//_____________________________________________________________________________________________________________________________________
			@FXML
			/**
			 * This method displays the avatar that the user wants to be identify as
			 * @param event the event triggered by the user
			 */
		    private void createCircleAvatar(ActionEvent event) { 
				Circle circle = new Circle(400.0,290.0,50,colorField.getValue());
		   		paneSurface.getChildren().add(circle);
		   		avatarLabel.setText(""+Shape.CIRCLE);
		    }
	//_____________________________________________________________________________________________________________________________________
			@FXML
			/**
			 * This method displays the avatar that the user wants to be identify as
			 * @param event the event triggere by the user
			 */
			private void createSquareAvatar(ActionEvent event) {
				Rectangle square = new Rectangle(250.0,250,75,75);
				square.setFill(colorField.getValue());
				paneSurface.getChildren().add(square);
				avatarLabel.setText(""+Shape.RECTANGLE);
			}
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * This method verifies if the user typed well their password and they match together
		     * @param password the first attemp of the password typed
		     * @param confirmPassword the second attemp of the password typed
		     * @return a boolean condition that confirms if these passwords match or not
		     */
			private boolean confirmPassword(String password, String confirmPassword) {
		    	if(password.equals(confirmPassword)) {
		    		return true;
		    	}
		    	return false;
		    }
//_________________________________________________________________________________________________________________________________________
}
