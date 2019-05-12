//___________________________________________PACKAGE OF THIS CLASS_________________________________________________________________________
	package gui.lettersoupgui;
//___________________________________________USED PACKAGES FOR THIS CLASS__________________________________________________________________
	import javafx.fxml.FXML;
	import javafx.scene.control.ComboBox;
	import javafx.event.ActionEvent;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.GridPane;	
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
		
	    
//_________________________________________METHODS FOR THIS CLASS__________________________________________________________________________
		@FXML
		public void initialize() {	
			gridpane = new GridPane();
		}
	//_____________________________________________________________________________________________________________________________________
	    @FXML
	    void playGame(ActionEvent event) {

	    }
	//_____________________________________________________________________________________________________________________________________
//_________________________________________________________________________________________________________________________________________
}
