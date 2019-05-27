//_________________________________________________________________________________________________________________________________________
		package gui.lettersoupgui;
//_________________________________________________________________________________________________________________________________________	
		import org.controlsfx.control.Notifications;
		
		import javafx.application.Platform;
		import javafx.collections.FXCollections;
		import javafx.event.ActionEvent;
		import javafx.fxml.FXML;
		import javafx.geometry.Pos;
		import javafx.scene.control.Button;
		import javafx.scene.control.ComboBox;
		import javafx.scene.control.Label;
		import javafx.scene.control.ProgressBar;
		import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
		import javafx.scene.image.Image;
		import javafx.scene.image.ImageView;
		import javafx.scene.layout.BorderPane;
		import javafx.scene.layout.GridPane;
		import javafx.stage.Stage;
		import javafx.util.Duration;
		import javafx.concurrent.Task;
		import javafx.concurrent.Service;
		import model.gamemodel.Difficulty;
		import model.gamemodel.Game;
		import model.lettersoupmodel.LettersSoup;
		import model.lettersoupmodel.Topic;
		import threads.GUIUpdateTimeThread;
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
		    @FXML
		    private ProgressBar progressbar;
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
		    private Integer minutes;
		    private Integer seconds;
		  //::::::::::::::::::::::::::::::::::::::::::::::::::::
		    private TimeThread timethread;
		    private GUIUpdateTimeThread guiupdate;
//_________________________________________________________________________________________________________________________________________
		    /**
		     * 
		     */
		    @FXML
		    private void initialize() {
		    	topicComboBox.setItems(FXCollections.observableArrayList(Topic.ANIMALS,Topic.CITIES,Topic.NUMBERS));
		    	difficultyComboBox.setItems(FXCollections.observableArrayList(Difficulty.BASIC,Difficulty.INTERMEDIUM,Difficulty.HARD));
		    	gridpane = new GridPane();
		    	scrollpane = new ScrollPane();
		    	scrollpane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		    	scrollpane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		    	borderpane.setCenter(scrollpane);
		    	solutionList.setEditable(false);
		    	foundList.setEditable(false);
		    	progressbar = new ProgressBar();
				game = new Game(null);
				Platform.setImplicitExit(true);
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
		    		seconds-=1;
		    		if(seconds==0) {
		    			seconds=59;
		    			minutes-=1;
		    		}
		    }
	//_________________________________________________________________________________________________________________________________
		    public void setTime() {
	    		minutesLabel.setText("0"+minutes);
	    		if(seconds>10) {
	    			secondsLabel.setText(""+seconds);
	    		}
	    		else {
	    			secondsLabel.setText("0"+seconds);
	    		}
		    } 
	//_________________________________________________________________________________________________________________________________
			@FXML
		    private void playGame(ActionEvent event) {
				try {
					if(topicComboBox.getValue().equals(Topic.ANIMALS)) {
						playAnimalsGame();
					}
					else if(topicComboBox.getValue().equals(Topic.CITIES)) {
						playCitiesGame();
					}
					else {
						playNumbersGame();
					}
				}
				catch(NullPointerException npe) {
					Notifications.create()
					.title("Announcement")
					.text("Please select a topic and a difficulty in order to start playing")
					.graphic(new ImageView(new Image("gui/gamegui/images/warning.png")))
					.position(Pos.TOP_RIGHT)
	    			.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
					.darkStyle()
					.show();
				}
		    }
	//_____________________________________________________________________________________________________________________________________
			private void playAnimalsGame() {
					Difficulty difficulty = null;
	    			if(difficultyComboBox.getValue().equals(Difficulty.BASIC)) {
	    				letterssoup = new LettersSoup(Topic.ANIMALS, Difficulty.BASIC);
	    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
	    				minutes = 5;
	    				seconds = 59;
	    				showLoading();
	    				showBasicLetterSoup();
	    			}
	    			else if(difficultyComboBox.getValue().equals(Difficulty.INTERMEDIUM)) {
	    				letterssoup = new LettersSoup(Topic.ANIMALS, Difficulty.INTERMEDIUM);
	    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
	    				minutes = 11;
	    				seconds = 59;
	    				showIntermediumLetterSoup();

	    			}
	    			else {
	    				letterssoup = new LettersSoup(Topic.ANIMALS, Difficulty.HARD);
	    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
	    				minutes = 14;
	    				seconds = 59;
	    				showHardLetterSoup();
	    			}
					showListOfWords();
					playButton.setDisable(true);
					
					Platform.setImplicitExit(true);
					
					guiupdate = new GUIUpdateTimeThread(this);
					guiupdate.setDaemon(true);
					guiupdate.start();
					
					timethread = new TimeThread(this, false);
					timethread.setDaemon(true);
					timethread.start();
			}
	//_____________________________________________________________________________________________________________________________________
			private void playCitiesGame() {
				Difficulty difficulty = null;
				Topic topic = Topic.CITIES;
				if(difficultyComboBox.getValue().equals(Difficulty.BASIC)) {
					difficulty = Difficulty.BASIC;
    				letterssoup = new LettersSoup(topic, difficulty);
    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
    				minutes = 5;
    				seconds = 59;
    				showBasicLetterSoup();
    			}
    			else if(difficultyComboBox.getValue().equals(Difficulty.INTERMEDIUM)) {
    				difficulty = Difficulty.INTERMEDIUM;
    				letterssoup = new LettersSoup(topic,difficulty);
    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
    				minutes = 11;
    				seconds = 59;
    				showIntermediumLetterSoup();
    			}
    			else {
    				difficulty = Difficulty.HARD;
    				letterssoup = new LettersSoup(topic, difficulty);
    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
    				minutes = 14;
    				seconds = 59;
    				showHardLetterSoup();
    			}
				showListOfWords();
				playButton.setDisable(true);
				guiupdate = new GUIUpdateTimeThread(this);
				guiupdate.setDaemon(true);
				guiupdate.start();
				
				timethread = new TimeThread(this, false);
				timethread.setDaemon(true);
				timethread.start();
			}
	//_____________________________________________________________________________________________________________________________________
			private void playNumbersGame() {
				Difficulty difficulty = null;
				Topic topic = Topic.NUMBERS;
				if(difficultyComboBox.getValue().equals(Difficulty.BASIC)) {
					difficulty = Difficulty.BASIC;
    				letterssoup = new LettersSoup(topic, difficulty);
    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
    				minutes = 5;
    				seconds = 59;
    				showBasicLetterSoup();
    			}
    			else if(difficultyComboBox.getValue().equals(Difficulty.INTERMEDIUM)) {
    				difficulty = Difficulty.INTERMEDIUM;
    				letterssoup = new LettersSoup(topic,difficulty);
    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
    				minutes = 11;
    				seconds = 59;
    				showIntermediumLetterSoup();
    			}
    			else {
    				difficulty = Difficulty.HARD;
    				letterssoup = new LettersSoup(topic, difficulty);
    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
    				minutes = 14;
    				seconds = 59;
    				showHardLetterSoup();
    			}
				showListOfWords();
				playButton.setDisable(true);
				guiupdate = new GUIUpdateTimeThread(this);
				guiupdate.setDaemon(true);
				guiupdate.start();
				
				timethread = new TimeThread(this, false);
				timethread.setDaemon(true);
				timethread.start();
			}
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * 
		     */
			private void showBasicLetterSoup() {
		    lettersoup = new Button[15][15];
				for (int i = 0; i < lettersoup.length; i++) {
					for (int j = 0; j < lettersoup[i].length; j++) {
						lettersoup[i][j] = new Button(String.valueOf(letterssoup.getLetterSoup()[i][j]));
						lettersoup[i][j].setMaxSize(30.0, 30.0);
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
			private void showIntermediumLetterSoup() {
			lettersoup = new Button[20][20];
				for (int i = 0; i < lettersoup.length; i++) {
					for (int j = 0; j < lettersoup[i].length; j++) {
						lettersoup[i][j] = new Button(String.valueOf(letterssoup.getLetterSoup()[i][j]));
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
						lettersoup[i][j] = new Button(String.valueOf(letterssoup.getLetterSoup()[i][j]));
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
	//____________________________________________________________________________________________________________________________________
			private void showLoading() {
				final Service<Integer> thread = new Service<Integer>() {
					@Override
					public Task<Integer> createTask() {
						return new Task<Integer>() {
							@Override
							public Integer call() throws InterruptedException{
								int i;
								for(i=0;i<1000;i++) {
									updateProgress(i,1000);
									Thread.sleep(10);
								}
								return i;
							} 
						};
					}	
				};
				progressbar.progressProperty().bind(thread.progressProperty());
			}
//_________________________________________________________________________________________________________________________________________
}
