//___________________________________________PACKAGE OF THIS CLASS_________________________________________________________________________
	package gui.lettersoupgui;
//___________________________________________USED PACKAGES FOR THIS CLASS__________________________________________________________________
	import javafx.fxml.FXML;
	import javafx.scene.control.ComboBox;

import java.io.IOException;

import javafx.event.ActionEvent;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.GridPane;
	import javafx.stage.Stage;
import model.gamemodel.Difficulty;
import model.lettersoupmodel.LettersSoup;
import model.lettersoupmodel.Topic;
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
	    
	    private LettersSoup letterssoup;
		
//_________________________________________METHODS FOR THIS CLASS__________________________________________________________________________
		@FXML
		public void initialize() {	
			try {
				letterssoup = new LettersSoup(Topic.CITIES, Difficulty.HARD);
				letterssoup.generateBasicLetterSoup(Topic.CITIES);
				prueba();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	    
	    public void prueba() {
	    	String mssg = "";
	    	for(int i=0;i<letterssoup.getLetterSoup().length;i++) {
	    		for(int j=0;j<letterssoup.getLetterSoup()[i].length;j++) {
	    			mssg += letterssoup.getLetterSoup()[i][j] +" ";
	    			if(j==letterssoup.getLetterSoup().length-1) {
	    				mssg += "\n";
	    			}
	    		}
	    	}
	    	System.out.println(mssg);
	    }  
//_________________________________________________________________________________________________________________________________________
}
