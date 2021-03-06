//_________________________________________________________________________________________________________________________________________
	package gui.gamegui;
//_________________________________________________________________________________________________________________________________________
	import java.time.LocalDate;
	import org.controlsfx.control.Notifications;

import customexception.InvalidInformationException;
import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
	import javafx.scene.control.Label;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
	import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
	import model.gamemodel.Game;
	import model.gamemodel.Player;
	import model.gamemodel.Shape;
	import searching.BinarySearching;
	import sorting.Bubble;
	import sorting.Insertion;
	import sorting.Selection;
	import javafx.stage.Stage;
import javafx.util.Duration;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and launch the scores hall gui 
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan Jos� Valencia Jaramillo
	 * @version V_01_MAY-2019
	 */
	public class RegisteredHallController {	
		//:::::::::::::::::::::::::::::::::::::::::
		    @FXML
		    private BorderPane borderpane;
		    @FXML
		    private Label lblMessage;
		    @FXML
		    private TextField searchTextField;
		    @FXML
		    private DatePicker birthdayPicker;
		    @FXML
		    private TableView<Player> table;
		    @FXML
		    private ObservableList<Player> players;
		//:::::::::::::::::::::::::::::::::::::::::  
		    private Game game;
		    private Stage stage;
		//:::::::::::::::::::::::::::::::::::::::::
		    private Bubble bubble;
		    private Selection selection;
		    private Insertion insertion;
		    private BinarySearching binary;
//_________________________________________________________________________________________________________________________________________
			@FXML
			/**
			 * This method initializes the GUI once it has been launched creating the necessary objects and components that are going 
			 * to be used for this window
			 */
			private void initialize() {
				game = new Game(null);
				selection = new Selection();
		    	bubble = new Bubble();
		    	insertion = new Insertion();
		    	binary = new BinarySearching();
				initializeTV();
			}
	//_____________________________________________________________________________________________________________________________________
			/**
			 * This method sets the new stage of the window that this controller is going to manage
			 * @param stage the new stage for this window
			 */
			public void setStage(Stage stage) {
				this.stage = stage;
			}
	//_____________________________________________________________________________________________________________________________________
			@SuppressWarnings("unchecked")
			@FXML
			/**
			 * This method initialize the tableview control element so the players can be displayed in the GUI 
			 * @return a TableView of type Player that containts the random players generated once the program starts
			 */
			private void initializeTV() {
				
				//Creates the table of flights
				//Name Column
				TableColumn<Player, String> nameColumn = new TableColumn<>("Name");
				nameColumn.setMinWidth(150);
				nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
				
				//NickName Column
				TableColumn<Player, String> nicknameColumn = new TableColumn<>("Nickname");
				nicknameColumn.setMinWidth(100);
				nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
				
				//Avatar Column
				TableColumn<Player, Shape> passwordColumn = new TableColumn<>("Password");
				passwordColumn.setMinWidth(100);
				passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
				
				//Color Column
				TableColumn<Player, String> colorColumn = new TableColumn<>("FavColor");
				colorColumn.setMinWidth(75);
				colorColumn.setCellValueFactory(new PropertyValueFactory<>("favColor"));
				
				//Birthday Column
				TableColumn<Player, LocalDate> birthdayColumn = new TableColumn<>("Birthday");
				birthdayColumn.setMinWidth(75);
				birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));
				
				//Avatar Column
				TableColumn<Player, Shape> avatarColumn = new TableColumn<>("Avatar");
				avatarColumn.setMinWidth(75);
				avatarColumn.setCellValueFactory(new PropertyValueFactory<>("avatar"));

		
				//Creates the table of flights
				table = new TableView<>();
				table.setItems(getPlayers());
				table.getColumns().addAll(nameColumn,nicknameColumn,passwordColumn,colorColumn,birthdayColumn,avatarColumn);
				table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				borderpane.setCenter(table);	
			}
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method searchs a birthday in the registeredtable of players by using binary searching
		     * @param event the event triggered by the user
		     */
		    private void searchBirthday(ActionEvent event) {
		    	try {
			    	if(birthdayPicker.getValue()==null) {
			    		throw new InvalidInformationException(null);
			    	}
			    	else {
			    		int pos = binary.searchBirthday(game, birthdayPicker.getValue());
			    		System.out.println(pos);
			    		if(pos==0) {
			    			lblMessage.setText("We could not find your request, sorry try again :(");
			    		}
			    		else {
			    			game.getPlayers().set(0, game.getPlayers().get(pos));
			    			updateGUI();
			    			lblMessage.setText("We find your request!! now is being displayed as first");
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
		    @FXML
		    /**
		     * This method searchs a name in the registeredplayers table by binary searching
		     * @param event the event triggered by the user
		     */
		    private void searchName(ActionEvent event) {
		    	try {
			    	if(searchTextField.getText().equals("")) {
			    		throw new InvalidInformationException("");
			    	}
			    	else {
			    		int pos = binary.searchName(game, searchTextField.getText());
			    		if(pos==0) {
			    			lblMessage.setText("We could not find your request, sorry try again :(");
			    		}
			    		else {
			    			game.getPlayers().set(0, game.getPlayers().get(pos));
			    			updateGUI();
			    			lblMessage.setText("We find your request!! now is being displayed as first");
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
		    @FXML
		    /**
		     * This method searchs a nickname in the registeredplayers table by using binary searching
		     * @param event the event triggered by the user
		     */
		    private void searchNickName(ActionEvent event) {
		    	try {
			    	if(searchTextField.getText().equals("")) {
			    		throw new InvalidInformationException("");
			    	}
			    	else {
			    		int pos = binary.searchNickName(game, searchTextField.getText());
			    		if(pos==0) {
			    			lblMessage.setText("We could not find your request, sorry try again :(");
			    		}
			    		else {
			    			game.getPlayers().set(0, game.getPlayers().get(pos));
			    			updateGUI();
			    			lblMessage.setText("We find your request!! now is being displayed as first");
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
		    @FXML
		    /**
		     * This method sorts the registeredplayers table by avatar using selection sorting		   
		     * @param event the event triggered by the user
		     */
		    private void sortByAvatar(ActionEvent event) {
		    	selection.sortByAvatar(game);
		    	updateGUI();
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method sorts the registeredplayers table by birthday using selection sorting
		     * @param event the event triggered by the user
		     */
		    private void sortByBirthday(ActionEvent event) {
		    	selection.sortByBirthday(game);
		    	updateGUI();
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method sorts the registeredplayers table by color using bubble sorting
		     * @param event the event triggered by the user
		     */
		    private void sortByColor(ActionEvent event) {
		    	bubble.sortByColor(game);
		    	updateGUI();
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method sorts the registeredplayers table by name using bubble sorting
		     * @param event the event triggered by the user
		     */
		    private void sortByName(ActionEvent event) {
		    	bubble.sortByName(game);
		    	updateGUI();
		    }
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * This method sorts the registeredplayers table by nickname using insertion sorting
		     * @param event the event triggered by the user
		     */
		    @FXML
		    private void sortByNickname(ActionEvent event) {
		    	insertion.sortByNickName(game);
		    	updateGUI();
		    }
	//_____________________________________________________________________________________________________________________________________
		    @FXML
		    /**
		     * This method sorts the registeredplayers table by password using insertion sorting
		     * @param event the event triggered by the user
		     */
		    private void sortByPassword(ActionEvent event) {
		    	insertion.sortByPassword(game);
		    	updateGUI();
		    }
	    
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * This method returns a list that contains the players registered on the game
		     * @return An observablelist of type Player
		     */
		    public ObservableList<Player> getPlayers(){
		    	players = FXCollections.observableArrayList();
		    	for(int i=0;i<game.getPlayers().size();i++) {
		    		players.add(game.getPlayers().get(i));
		    	}
		    	return players;
		    }
	    
	//_____________________________________________________________________________________________________________________________________
		    /**
		     * This method refresh the tableView of the GUI everytime new players are registered to the game
		     * <b>Pos:</b> the tableView of the GUI shows the new players registered
		     */
		    public void updateGUI() {
		    	for(int i=0;i<this.getPlayers().size();i++) {
		    		players.add(game.getPlayers().get(i));
		    	}
		    	table.setItems(players);	
		    }
//_________________________________________________________________________________________________________________________________________
}
