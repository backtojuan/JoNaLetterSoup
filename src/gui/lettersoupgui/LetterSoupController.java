//_________________________________________________________________________________________________________________________________________
		package gui.lettersoupgui;
//_________________________________________________________________________________________________________________________________________	
		import org.controlsfx.control.Notifications;

		import customexception.InvalidInformationException;
		import gui.gamegui.GameController;
		import javafx.application.Platform;
		import javafx.collections.FXCollections;
		import javafx.event.ActionEvent;
		import javafx.event.EventHandler;
		import javafx.fxml.FXML;
		import javafx.geometry.Pos;
		import javafx.scene.control.Button;
		import javafx.scene.control.ComboBox;
		import javafx.scene.control.Label;
		import javafx.scene.control.ScrollPane;
		import javafx.scene.control.ScrollPane.ScrollBarPolicy;
		import javafx.scene.control.TextArea;
		import javafx.scene.control.TextField;
		import javafx.scene.image.Image;
		import javafx.scene.image.ImageView;
		import javafx.scene.input.MouseEvent;
		import javafx.scene.layout.BorderPane;
		import javafx.scene.layout.GridPane;
		import javafx.scene.layout.Pane;
		import javafx.scene.media.AudioClip;
		import javafx.scene.paint.Color;
		import javafx.scene.shape.Circle;
		import javafx.stage.Stage;
		import javafx.util.Duration;
		import model.gamemodel.Difficulty;
		import model.gamemodel.Game;
		import model.gamemodel.PlayedTime;
		import model.lettersoupmodel.Direction;
		import model.lettersoupmodel.LettersSoup;
		import model.lettersoupmodel.Topic;
		import model.lettersoupmodel.Word;
		import threads.GUIUpdateTimeThread;
		import threads.LoadingThread;
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
		    private Button checkButton;
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
		    private int score;
		    private LettersSoup letterssoup;
		    private boolean found;
		    private Game game;
		    private String foundlist;
		    //::::::::::::::::::::::::::::::::::::::::::::::::::::
		    private TimeThread timethread;
		    private GUIUpdateTimeThread guiupdate;
		    private Integer minutes;
		    private Integer seconds;
		    private LoadingThread loadingthread;
		  //::::::::::::::::::::::::::::::::::::::::::::::::::::
		    private Circle circle1;
		    private Circle circle2;
		    private Circle circle3;
		  //::::::::::::::::::::::::::::::::::::::::::::::::::::
		    @FXML
		    private TextField checkRow;
		    @FXML
		    private ComboBox<Direction> directionComboBox;
		    @FXML
		    private TextField checkColumn;
//_________________________________________________________________________________________________________________________________________
		    /**
		     * 
		     */
		    @FXML
		    private void initialize() {
		    	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		    	//Initialize the visual components of this fxml
			    	topicComboBox.setItems(FXCollections.observableArrayList(Topic.ANIMALS,Topic.CITIES,Topic.NUMBERS));
			    	difficultyComboBox.setItems(FXCollections.observableArrayList(Difficulty.BASIC,Difficulty.INTERMEDIUM));
			    	directionComboBox.setItems(FXCollections.observableArrayList(Direction.UP,Direction.DOWN,Direction.LEFT,Direction.RIGHT));
					gridpane = new GridPane();
				    scrollpane = new ScrollPane();
			    	solutionList.setEditable(false);
			    	foundList.setEditable(false);
			    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
			    //Initialize the model and the needed threads
			    	game = new Game(null);
					showLoading();
					guiupdate = new GUIUpdateTimeThread(this);
					guiupdate.setDaemon(true);
					loadingthread = new LoadingThread(this);
					loadingthread.setDaemon(true);
					loadingthread.start();
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
	    				showBasicLetterSoup();
	    			}
	    			else{
	    				letterssoup = new LettersSoup(Topic.ANIMALS, Difficulty.INTERMEDIUM);
	    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
	    				minutes = 11;
	    				seconds = 59;
	    				showIntermediumLetterSoup();

	    			}
	    			timethread = new TimeThread(this, false,minutes);
					timethread.setDaemon(true);
					showListOfWords();
					playButton.setDisable(true);
					guiupdate.start();
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
    			else{
    				difficulty = Difficulty.INTERMEDIUM;
    				letterssoup = new LettersSoup(topic,difficulty);
    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
    				minutes = 11;
    				seconds = 59;
    				showIntermediumLetterSoup();
    			}
    			timethread = new TimeThread(this, false,minutes);
				timethread.setDaemon(true);
				showListOfWords();
				playButton.setDisable(true);
				guiupdate.start();
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
    			else{
    				difficulty = Difficulty.INTERMEDIUM;
    				letterssoup = new LettersSoup(topic,difficulty);
    				game.setDifficultyLevel(letterssoup.getDifficultylevel());
    				minutes = 11;
    				seconds = 59;
    				showIntermediumLetterSoup();
    			}
    			timethread = new TimeThread(this, false,minutes);
				timethread.setDaemon(true);
				showListOfWords();
				playButton.setDisable(true);
				guiupdate.start();
				timethread.start();
			}
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * 
		     */
			private void showBasicLetterSoup() {
		    borderpane.setCenter(scrollpane);
		    lettersoup = new Button[10][10];
				for (int i = 0; i < lettersoup.length; i++) {
					for (int j = 0; j < lettersoup[i].length; j++) {
						lettersoup[i][j] = new Button(String.valueOf(letterssoup.getLetterSoup()[i][j]));
						lettersoup[i][j].setMaxSize(30.0, 30.0);
						lettersoup[i][j].setStyle("-fx-background-color : SLATEGRAY");
						gridpane.setAlignment(Pos.CENTER);
						gridpane.setVgap(5);
						gridpane.setHgap(5);
						gridpane.add(lettersoup[i][j], j, i);		
					}
				}
				scrollpane.setContent(gridpane);
		    }
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * 
		     */
			private void showIntermediumLetterSoup() {
			borderpane.setCenter(scrollpane);
			lettersoup = new Button[15][15];
				for (int i = 0; i < lettersoup.length; i++) {
					for (int j = 0; j < lettersoup[i].length; j++) {
						lettersoup[i][j] = new Button(String.valueOf(letterssoup.getLetterSoup()[i][j]));
						lettersoup[i][j].setMaxSize(30.0, 30.0);
						lettersoup[i][j].setStyle("-fx-background-color : SLATEGRAY");
						gridpane.setAlignment(Pos.CENTER);
						gridpane.setVgap(5);
						gridpane.setHgap(5);
						gridpane.add(lettersoup[i][j], j, i);
					}
				}
				scrollpane.setContent(gridpane);
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
			private void showLoading() {
				circle1 = new Circle(170.0,265.0,25,Color.BLACK);
				circle2 = new Circle(235.0,265.0,25,Color.BLACK);
				circle3 = new Circle(300.0,265.0,25,Color.BLACK);
				Pane pane = new Pane();
				pane.getChildren().add(circle1);
				pane.getChildren().add(circle2);
				pane.getChildren().add(circle3);
				borderpane.setCenter(pane);
				Label label = new Label("Wait while we prepare everything for you");
				label.setLayoutX(125);
				label.setLayoutY(200);
				pane.getChildren().add(label);
			}
	//_____________________________________________________________________________________________________________________________________
			public void setFill(int indicator) {
				if(indicator==1) {
					circle1.setFill(Color.RED);
				}
				else if(indicator==2) {
					circle2.setFill(Color.ORANGE);
				}
				else if(indicator==3) {
					circle3.setFill(Color.YELLOW);
				}
				else if(indicator==4) {
					circle1.setFill(Color.GREEN);
					circle2.setFill(Color.GREEN);
					circle3.setFill(Color.GREEN);
				}
			}
	//_____________________________________________________________________________________________________________________________________
			public void disableButton(boolean b) {
					playButton.setDisable(b);
					checkButton.setDisable(b);
			}
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    private void checkSolution(ActionEvent event) {
		    	try {
		    		Direction direction = directionComboBox.getValue();
		    		if(checkRow.getText().equals("")||checkColumn.getText().equals("")) {
		    			throw new InvalidInformationException(checkRow.getText());
		    		}
		    		if(directionComboBox.getValue().equals(null)) {
		    			throw new InvalidInformationException(null);
		    		}
		    		int row = Integer.parseInt(checkRow.getText())-1;
		    		int column = Integer.parseInt(checkColumn.getText())-1;
		    		if(checkSolution(row, column, direction)) {
		    			this.score+=1;
		    			String score = this.score<10?"0"+this.score:""+this.score;
		    			scoreLabel.setText(score);
		    			if(this.score==letterssoup.getSolution().length) {
		    				
		    				guiupdate.isFinished();
		    				timethread.finished();
		    				letterssoup.addScore(this.score);
		    				
		    				int seconds1 = Integer.parseInt(minutesLabel.getText())*60;
		    				int seconds = Integer.parseInt(secondsLabel.getText());
		    				int playedtime = seconds1 + seconds;
		    				PlayedTime playedTime = new PlayedTime(playedtime);
		    			}
		    		}
		    	}
		    	catch(InvalidInformationException iie) {
		    		Notifications.create()
		    		.title("Announcement")
		    		.text(iie.getMessage())
		    		.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
		    		.darkStyle()
		    		.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
		    		.show();
		    	}
		    }
	//_____________________________________________________________________________________________________________________________________
		    private boolean checkSolution(int row,int column,Direction dir) {
		    	int row1 = row;
		    	int column1 = column;
		    	boolean correct = false;
		    	String name = " ";
				int length = letterssoup.getLengthFromAPosition(row);
				for(int k=0;k<=length;k++) {
						name += lettersoup[row][column].getText();
						if(dir.equals(Direction.UP)) {
							row--;
						}
						if(dir.equals(Direction.DOWN)) {
							row++;
						}
						if(dir.equals(Direction.RIGHT)) {
							column++;
						}
						if(dir.equals(Direction.LEFT)) {
							column--;
					}
				}
				if(letterssoup.checkSolution(new Word(name,row1,column1,length))) {
					correct = true;
					setAllCorrectButtons(row1, column1, dir);
					foundlist+=name+"\n";
					foundList.setText(foundlist);
				}
		    	return correct;
		    }
		//_____________________________________________________________________________________________________________________________________
			private void setAllCorrectButtons(int row,int column,Direction dir) {
				int length = letterssoup.getLengthFromAPosition(row);
				for(int k=0;k<=length;k++) {
						lettersoup[row][column].setStyle("-fx-background-color : GREEN");
						if(dir.equals(Direction.UP)) {
							row--;
						}
						if(dir.equals(Direction.DOWN)) {
							row++;
						}
						if(dir.equals(Direction.RIGHT)) {
							column++;
						}
						if(dir.equals(Direction.LEFT)) {
							column--;
						}
					}
				}
//_________________________________________________________________________________________________________________________________________
}
