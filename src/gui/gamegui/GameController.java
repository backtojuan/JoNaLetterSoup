	
	package gui.gamegui;
	
	import javafx.fxml.FXML;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.TextField;
	import javafx.stage.Stage;
	import javafx.event.ActionEvent;
	
	public class GameController {
	
	    @FXML
	    private TextField nicknameTextField;
	
	    @FXML
	    private TextField passwordTextField;
	
	    @FXML
	    private ComboBox<?> selectComboBox;
	    
	    private Stage stage;
	    
	    
	    public void setStage(Stage stg) {
	    	stage = stg;
	    }
	    
	    @FXML
	    void signIn(ActionEvent event) {
	
	    }

}
