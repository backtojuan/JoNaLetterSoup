	package gui.gamegui;
	
	import javafx.fxml.FXML;
	import javafx.event.ActionEvent;
	import javafx.stage.Stage;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.Pane;
	
	public class GameController {
	
		@FXML    
		private Pane pane;
		
	    @FXML
	    private PasswordField passwordField;
	
	    @FXML
	    private TextField nicknameTextField;
	    
	    private Stage stage;
	
	    
	    @FXML
	    public void initialize() {
	    	
	    }
	    
	    public void setStage(Stage stage) {
	    	this.stage = stage;
	    }
	    
	    @FXML
	    void removeProfile(ActionEvent event) {
	
	    }
	
	    @FXML
	    void showAboutMenu(ActionEvent event) {
	
	    }
	
	    @FXML
	    void showBestScoresMenu(ActionEvent event) {
	
	    }
	
	    @FXML
	    void showSignUpInfoMenu(ActionEvent event) {
	
	    }
	
	    @FXML
	    void signIn(ActionEvent event) {
	
	    }
	
	    @FXML
	    void signUp(ActionEvent event) {
	
	    }
	
	}
