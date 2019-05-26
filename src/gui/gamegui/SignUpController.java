//_________________________________________________________________________________________________________________________________________
	package gui.gamegui;
//_________________________________________________________________________________________________________________________________________
	import java.time.LocalDate;

	import org.controlsfx.control.Notifications;
	import customexception.InvalidInformationException;
	import customexception.InvalidPasswordException;
	import javafx.fxml.FXML;
	import javafx.geometry.Pos;
	import javafx.scene.control.ColorPicker;
	import javafx.scene.control.DatePicker;
	import javafx.scene.control.MenuButton;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.Pane;
	import javafx.scene.paint.Color;
	import javafx.stage.Stage;
	import model.gamemodel.Player;
	import model.gamemodel.Shape;
	import javafx.collections.FXCollections;
	import javafx.event.ActionEvent;
	import javafx.scene.shape.Circle;
	import javafx.scene.shape.Rectangle;
	import javafx.scene.shape.Polygon;
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
//_________________________________________________________________________________________________________________________________________
		    public void setStage(Stage stage) {
		    	this.stage = stage;
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
		    			Notifications.create()
		    			.title("Annoucement")
		    			.text("You've been succesfully registered. Welcome!!!")
		    			.darkStyle()
		    			.position(Pos.CENTER)
		    			.showInformation()
		    			;
		    		}
		    	}
		    	catch(InvalidInformationException iie) {
		    		Notifications.create()
		    			.title("Something went wrong....")
		    			.text(iie.getMessage())
		    			.darkStyle()
		    			.position(Pos.CENTER)
		    			.showError();
		    	}
		    	catch(InvalidPasswordException ipe){
		    		Notifications.create()
	    			.title("Something went wrong....")
	    			.text(ipe.getMessage())
	    			.darkStyle()
	    			.position(Pos.CENTER)
	    			.showWarning();
		    	}
		    }
	//_____________________________________________________________________________________________________________________________________
			@FXML
		    private void createCircleAvatar(ActionEvent event) { 
				Circle circle = new Circle(350.0,290.0,50,colorField.getValue());
		   		paneSurface.getChildren().add(circle);
		    }
	//_____________________________________________________________________________________________________________________________________
			@FXML
			private void createSquareAvatar(ActionEvent event) {
				Rectangle square = new Rectangle(300.0,240.0,75,75);
				square.setFill(colorField.getValue());
				paneSurface.getChildren().add(square);
			}
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    void returnToMainStage(ActionEvent event) {
		    	
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
