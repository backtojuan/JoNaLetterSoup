//___________________________________________PACKAGE OF THIS CLASS_________________________________________________________________________
	package gui.lettersoupgui;
//___________________________________________USED PACKAGES FOR THIS CLASS__________________________________________________________________
	import javafx.fxml.FXML;
	import javafx.scene.control.ComboBox;
	import javafx.event.ActionEvent;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.GridPane;
	import javafx.stage.Stage;	
//___________________________________________ATTRIBUTES____________________________________________________________________________________
	public class LetterSoupController {
		
	    @FXML
	    private BorderPane borderpane;
	    
	    @FXML
	    private ComboBox<?> topicComboBox;

	    @FXML
	    private ComboBox<?> difficultyComboBox;
	    
	    @FXML
	    private GridPane gridpane;
	    
	    private Stage stage;
		
	    
//_________________________________________METHODS FOR THIS CLASS__________________________________________________________________________
		@FXML
		public void initialize() {	
			
		}
	//_____________________________________________________________________________________________________________________________________
	   
		/**
	     * This method allows to set the current stage to the respective controller.
	     * @param stg the stage that this controller is going to manage
	     * @see GUI.Main#start(Stage)
	     */
	    public void setStage(Stage stg) {
	    	stage = stg;
	    }
		
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    void playGame(ActionEvent event) {

	    }
	//_____________________________________________________________________________________________________________________________________
	    
//_________________________________________________________________________________________________________________________________________
}
