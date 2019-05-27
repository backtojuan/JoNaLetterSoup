//_________________________________________________________________________________________________________________________________________
		package gui.lettersoupgui;
//_________________________________________________________________________________________________________________________________________
		import java.io.IOException;
		import java.sql.Time;
		import org.controlsfx.control.Notifications;
		import javafx.collections.FXCollections;
		import javafx.event.ActionEvent;
		import javafx.fxml.FXML;
		import javafx.geometry.Pos;
		import javafx.scene.control.Button;
		import javafx.scene.control.ComboBox;
		import javafx.scene.control.Label;
		import javafx.scene.control.ScrollPane;
		import javafx.scene.control.TextArea;
		import javafx.scene.image.Image;
		import javafx.scene.image.ImageView;
		import javafx.scene.layout.BorderPane;
		import javafx.scene.layout.GridPane;
		import javafx.stage.Stage;
		import javafx.util.Duration;
		import model.gamemodel.Difficulty;
		import model.gamemodel.Game;
		import model.lettersoupmodel.LettersSoup;
		import model.lettersoupmodel.Topic;
		import threads.TimeThread;
//_________________________________________________________________________________________________________________________________________
		public class LetterSoupController {
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::
		    @FXML
		    private BorderPane borderpane;
		    @FXML
		    private ScrollPane scrollpane;
		    @FXML
		    private GridPane gridpane;
		  //::::::::::::::::::::::::::::::::::::::::::::::::::::
		    @FXML
		    private Button playButton;
		    @FXML
		    private ComboBox<Topic> topicComboBox;
		    @FXML
		    private ComboBox<Difficulty> difficultyComboBox;		    
		  //::::::::::::::::::::::::::::::::::::::::::::::::::::
		    @FXML
		    private TextArea solutionList;
		    @FXML
		    private TextArea foundList;
		    @FXML
		    private Label minutesLabel;
		    @FXML
		    private Label secondsLabel;
		    @FXML
		    private Label scoreLabel;  
		  //::::::::::::::::::::::::::::::::::::::::::::::::::::
		    private Stage stage;
		    private Button lettersoup[][];
		    private LettersSoup letterssoup;
		    private Game game;
		  //::::::::::::::::::::::::::::::::::::::::::::::::::::
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
			    try {
					game = new Game(null);
			    } catch (ClassNotFoundException | IOException e) {
			    	Notifications.create()
			    	.title("Announcement")
			    	.text("The file that contained the scores of the game was deleted check for the data folder")
		    		.darkStyle()
		    		.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
		    		.hideAfter(Duration.seconds(8))
			   		.showError();
			   		;
				}
			    
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
		    public void runTime() {
		    	if(letterssoup.getDifficultylevel()==Difficulty.BASIC) {
		    		int minutes = 7;
		    		int seconds = 59;
		    		minutesLabel.setText(""+minutes);
		    		secondsLabel.setText(""+seconds);
		    		seconds-=1;
		    		if(seconds==0) {
		    			seconds=59;
		    			minutes-=1;
		    		}
		    	}
		    	else if(letterssoup.getDifficultylevel()==Difficulty.INTERMEDIUM) {
		    		int minutes = 14;
		    		int seconds = 59;
		    		minutesLabel.setText(""+minutes);
		    		secondsLabel.setText(""+seconds);
		    		seconds-=1;
		    		if(seconds==0) {
		    			seconds=59;
		    			minutes-=1;
		    		}
		    	}
		    	else {
		    		int minutes = 19;
		    		int seconds = 59;
		    		minutesLabel.setText(""+minutes);
		    		secondsLabel.setText(""+seconds);
		    		seconds-=1;
		    		if(seconds==0) {
		    			seconds=59;
		    			minutes-=1;
		    		}
		    	}
		    }
		//_________________________________________________________________________________________________________________________________
			@FXML
		    private void playGame(ActionEvent event) {
				if(topicComboBox.getValue().equals(Topic.ANIMALS)) {
					playAnimalsGame();
				}
		    }
	//_____________________________________________________________________________________________________________________________________
			private void playAnimalsGame() {
	    		try {
	    			Difficulty difficulty = null;
	    			if(difficultyComboBox.getValue().equals(Difficulty.BASIC)) {
	    				letterssoup = new LettersSoup(Topic.ANIMALS, Difficulty.BASIC);
	    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
	    				showBasicLetterSoup();
	    			}
	    			else if(difficultyComboBox.getValue().equals(Difficulty.INTERMEDIUM)) {
	    				letterssoup = new LettersSoup(Topic.ANIMALS, Difficulty.INTERMEDIUM);
	    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
	    				showIntermediumLetterSoup();
	    			}
	    			else {
	    				letterssoup = new LettersSoup(Topic.ANIMALS, Difficulty.HARD);
	    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
	    				showHardLetterSoup();
	    			}
					showListOfWords();
					playButton.setDisable(true);	
					TimeThread tt = new TimeThread(this, false);
					tt.start();
					prueba();
				} catch (IOException|ClassNotFoundException e) {
					Notifications.create()
					.title("Announcement")
					.text("The scores cannot be recovered because the file does not exist check for the folder data")
					.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
					.darkStyle()
					.position(Pos.TOP_RIGHT)
					.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
	    			.show();	
				}
			}
	//_____________________________________________________________________________________________________________________________________
			private void playCitiesGame() {
				
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
