//_________________________________________________________________________________________________________________________________________
	package gui.gamegui;
//_________________________________________________________________________________________________________________________________________
	import java.io.IOException;
	import java.time.LocalDate;
	import org.controlsfx.control.Notifications;
	import customexception.InvalidInformationException;
	import customexception.InvalidPasswordException;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.geometry.Pos;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
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
	    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		    private Stage stage;
		    private Game game;
//_________________________________________________________________________________________________________________________________________
		    @FXML
		    private void Initialize() {
		    	GameController gc = new GameController();
		    	game = gc.giveGame();
		    }
	//_____________________________________________________________________________________________________________________________________
		    public void setStage(Stage stage) {
		    	this.stage = stage;
		    }
	//_____________________________________________________________________________________________________________________________________
		    public void initGame(Game game) {
		    	this.game = game;
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    private void signUp(ActionEvent event) {
		    	try {
		    		LocalDate birthday = birthdayField.getValue();
		    		String name = nameField.getText();
		    		String nickname = nickNameField.getText();
		    		String favcolor = colorField.getValue().toString();	
		    		String avatars = avatarMenu.getText();
		    		String password = passwordField.getText();
		    		String confirmPassword = confirmPasswordField.getText();
		    		Shape avatar = null;
		    		if(avatars.equals("CIRCLE")) {
		    			avatar = Shape.CIRCLE;
		    		}
		    		else{
		    			avatar = Shape.RECTANGLE;
		    		}
		    		if(birthday == null||name == null||nickname == null||
		    		favcolor == null||avatar == null||password == null) {
		    			throw new InvalidInformationException(null);
		    		}
		    		else if(password == password.toUpperCase()||password.length()!=confirmPassword.length()||
		    				password.length()<8 || confirmPassword(password,confirmPassword)==false) {
		    			throw new InvalidPasswordException(password,confirmPassword);
		    		}
		    		else{
		    			Player player = new Player(name,nickname,password,favcolor,birthday,avatar);
		    			game.addPlayer(player);
		    			Notifications.create()
		    			.title("Annoucement")
		    			.text("You've been succesfully registered. Welcome!!!")
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
		    }
	//_____________________________________________________________________________________________________________________________________
			@FXML
		    private void createCircleAvatar(ActionEvent event) { 
				Circle circle = new Circle(400.0,290.0,50,colorField.getValue());
		   		paneSurface.getChildren().add(circle);
		    }
	//_____________________________________________________________________________________________________________________________________
			@FXML
			private void createSquareAvatar(ActionEvent event) {
				Rectangle square = new Rectangle(250.0,2500,75,75);
				square.setFill(colorField.getValue());
				paneSurface.getChildren().add(square);
			}
	//_____________________________________________________________________________________________________________________________________
		    private boolean confirmPassword(String password, String confirmPassword) {
		    	if(password.equals(confirmPassword)) {
		    		return true;
		    	}
		    	return false;
		    }
//_________________________________________________________________________________________________________________________________________
}
