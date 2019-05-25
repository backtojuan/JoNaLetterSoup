//_________________________________________________________________________________________________________________________________________
	package gui.gamegui;
//_________________________________________________________________________________________________________________________________________
	import javafx.fxml.FXML;
	import javafx.scene.control.ColorPicker;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.DatePicker;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.stage.Stage;
	import javafx.event.ActionEvent;
//_________________________________________________________________________________________________________________________________________
	public class SignUpController {
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		    @FXML
		    private DatePicker birthdayField;
		    @FXML
		    private TextField nameField;
		    @FXML
		    private TextField nickNameField;
		    @FXML
		    private ColorPicker colorField;
		    @FXML
		    private ComboBox<String> avatarComboBox;
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
		    void signUp(ActionEvent event) {
		    	
		    	
		    	
		    	
		    }		    
//_________________________________________________________________________________________________________________________________________
}
