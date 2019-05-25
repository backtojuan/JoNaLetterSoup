//_________________________________________________________________________________________________________________________________________
		package gui.lettersoupgui;
//_________________________________________________________________________________________________________________________________________
		import javafx.fxml.FXML;
		import javafx.geometry.Pos;
		import javafx.scene.control.ComboBox;
		import javafx.scene.control.Label;
		import javafx.scene.control.TextArea;
		import javafx.scene.control.Button;
		import java.io.IOException;
		import javafx.collections.FXCollections;
		import javafx.event.ActionEvent;
		import javafx.scene.layout.BorderPane;
		import javafx.scene.layout.GridPane;
		import javafx.scene.control.ScrollPane;
		import javafx.stage.Stage;
		import model.gamemodel.Difficulty;
		import model.lettersoupmodel.LettersSoup;
		import model.lettersoupmodel.Topic;
//_________________________________________________________________________________________________________________________________________
		public class LetterSoupController {
			
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::
		    @FXML
		    private BorderPane borderpane;
		    @FXML
		    private Button playButton;
		    @FXML
		    private ComboBox<Topic> topicComboBox;
		    @FXML
		    private ComboBox<Difficulty> difficultyComboBox;		    
		    @FXML
		    private TextArea solutionList;
		    @FXML
		    private TextArea foundList;
		    @FXML
		    private ScrollPane scrollpane;
		    @FXML
		    private GridPane gridpane;
		  //::::::::::::::::::::::::::::::::::::::::::::::::::::
		    private Stage stage;
		    private Button lettersoup[][];
		    private LettersSoup letterssoup;
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * 
		     */
		    @FXML
		    private void initialize() {
		    	topicComboBox.setItems(FXCollections.observableArrayList(Topic.ANIMALS,Topic.CITIES,Topic.NUMBERS));
		    	difficultyComboBox.setItems(FXCollections.observableArrayList(Difficulty.BASIC,Difficulty.INTERMEDIUM,Difficulty.HARD));
		    	gridpane = new GridPane();
		    	scrollpane = new ScrollPane();
		    	borderpane.setCenter(scrollpane);
		    	solutionList.setEditable(false);
		    	foundList.setEditable(false);
		    }
		//_________________________________________________________________________________________________________________________________
			/**
		     * This method allows to set the current stage to the respective controller.
		     * @param stg the stage that this controller is going to manage
		     * @see GUI.Main#start(Stage)
		     */
		    public void setStage(Stage stg) {
		    	stage = stg;
		    }
		//_________________________________________________________________________________________________________________________________
			@FXML
		    private void playGame(ActionEvent event) {
		    	if(topicComboBox.getValue().equals(Topic.ANIMALS) && difficultyComboBox.getValue().equals(Difficulty.BASIC)) {
		    		try {
						letterssoup = new LettersSoup(Topic.ANIMALS, Difficulty.BASIC);
						showBasicLetterSoup();
						showListOfWords();
						playButton.setDisable(true);
						prueba();
					} catch (IOException ioe) {
					
					}
		    	}
		    }
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * 
		     */
			private void showBasicLetterSoup() {
		    lettersoup = new Button[15][15];
				for (int i = 0; i < lettersoup.length; i++) {
					for (int j = 0; j < lettersoup[i].length; j++) {
					if(letterssoup.getLetterSoup()[i][j]!=null) {
						lettersoup[i][j] = new Button(String.valueOf(letterssoup.getLetterSoup()[i][j]));
						lettersoup[i][j].setMaxSize(30.0, 30.0);
					}
					else {
						lettersoup[i][j] = new Button(" ");
						lettersoup[i][j].setMaxSize(30.0, 30.0);
					}
						gridpane.setAlignment(Pos.CENTER);
						gridpane.setVgap(0);
						gridpane.setHgap(0);
						gridpane.add(lettersoup[i][j], j, i);
						scrollpane.setContent(gridpane);
					}
				}
		    }
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * 
		     */
			private void showIntermediumLetterSoup() {
			lettersoup = new Button[20][20];
				for (int i = 0; i < lettersoup.length; i++) {
					for (int j = 0; j < lettersoup[i].length; j++) {
					if(letterssoup.getLetterSoup()[i][j]!=null) {
							lettersoup[i][j] = new Button(String.valueOf(letterssoup.getLetterSoup()[i][j]));
					}
					else {
						lettersoup[i][j] = new Button(" ");
					}
						gridpane.setAlignment(Pos.CENTER);
						gridpane.setVgap(5);
						gridpane.setHgap(5);
						gridpane.add(lettersoup[i][j], j, i);
						scrollpane.setContent(gridpane);
					}
				}
		    } 
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * 
		     */
			private void showHardLetterSoup() {
			lettersoup = new Button[30][30];
				for (int i = 0; i < lettersoup.length; i++) {
					for (int j = 0; j < lettersoup[i].length; j++) {
					if(letterssoup.getLetterSoup()[i][j]!=null) {
						lettersoup[i][j] = new Button(String.valueOf(letterssoup.getLetterSoup()[i][j]));
					}
					else {
						lettersoup[i][j] = new Button(" ");
					}
						gridpane.setAlignment(Pos.CENTER);
						gridpane.setVgap(5);
						gridpane.setHgap(5);
						gridpane.add(lettersoup[i][j], j, i);
						scrollpane.setContent(gridpane);
					}
				}
		    } 
	//_____________________________________________________________________________________________________________________________________
			
			private void showListOfWords() {
				String list = "";
				for(int i=0;i<letterssoup.getSolution().length;i++) {
					list += " " + letterssoup.getSolution()[i].getName();
					list += "\n";
				}
				solutionList.setText(list);
			}
	//_____________________________________________________________________________________________________________________________________
		    private void prueba() {
			String mssg = "";
			for(int i=0;i<letterssoup.getLetterSoup().length;i++) {
				for(int j=0;j<letterssoup.getLetterSoup()[i].length;j++) {
					if(letterssoup.getLetterSoup()[i][j] == null) {
						mssg += " ";
					}
					else {
						mssg += letterssoup.getLetterSoup()[i][j] +" ";
					}
					if(j==letterssoup.getLetterSoup().length-1) {
						mssg += "\n";
					}
				}
			}
			System.out.println(mssg);
		    }  
//_________________________________________________________________________________________________________________________________________
}
