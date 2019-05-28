//_________________________________________________________________________________________________________________________________________
	package gamemodel;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.Assert.assertFalse;
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertNull;
	import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.*;

	import java.io.File;
	import java.io.IOException;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;

	import org.junit.jupiter.api.Test;
	import javafx.scene.paint.Color;
	import model.gamemodel.Difficulty;
	import model.gamemodel.Game;
	import model.gamemodel.Player;
	import model.gamemodel.Shape;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to test the Model class "Game".
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_March-2019
	 */
	class GameTest {

		private Game game;
		/**
		 *This scenary is created to test the Game Constructor. 
		 */
		private void setUpScenary1() {
			
		}
		/**
		 *This scenary is created to test 
		 */
		private void setUpScenary2(){
			game = new Game(Difficulty.INTERMEDIUM);
			game.addPlayer(new Player("Juan","backtojuan","backtojuan",Color.BLACK.toString(),
			LocalDate.of(2002, 3, 13),Shape.RECTANGLE));
			game.addPlayedTime(5);
		}
//_________________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the constructor method of the Model class Game, making sure the Game is right initialized.
		 */
		public void testGame() {
			setUpScenary1();
			game = new Game(null);
			
			assertNotNull("The game is null and it was not created", game);
			assertEquals(null, game.getDifficultylevel(), "The difficulty level is not null as it should be");
			assertNotNull(game.getPlayers(),"The players does not exists");
			assertNull(game.getRoot(),"The Played Time already has a value as not expected");
			
			game.setDifficultyLevel(Difficulty.BASIC);
			assertEquals(Difficulty.BASIC, game.getDifficultylevel(), "the difficulty level was not set as expected");
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the add method of the Model class Game, making sure that the players are correctly added 
		 * and register in the game
		 */
		public void testAddPlayer(){
			setUpScenary2();
			assertFalse("The list is empty", game.getPlayers().isEmpty());
			assertNotNull(game.getPlayers().get(game.getPlayers().size()-1),"There are not players inside the list");
			assertTrue("The Name of the player is not correct", game.getPlayers().get(game.getPlayers().size()-1).getName().equals("Juan"));
			assertTrue("The Nickname of the player is not correct", game.getPlayers().get(game.getPlayers().size()-1).getNickname().equals("backtojuan"));
			assertTrue("The Password of the player is not correct", game.getPlayers().get(game.getPlayers().size()-1).getPassword().equals("backtojuan"));
			assertTrue("The Color of the player is not correct", game.getPlayers().get(game.getPlayers().size()-1).getFavColor().equals(Color.BLACK.toString()));
			assertTrue("The Birthday of the player is not correct", game.getPlayers().get(game.getPlayers().size()-1).getBirthdate().equals(LocalDate.of(2002,3,13)));
			assertTrue("The Avatar of the player is not correct", game.getPlayers().get(game.getPlayers().size()-1).getAvatar().equals(Shape.RECTANGLE));
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the addPlayedTime method of the model class Game, making sure that the Game adds a new PlayedTime to its binary 
		 * searching tree with the right criteria order
		 */
		public void testAddPlayedTime() {
			setUpScenary2();
			
			assertNotNull("The root node is null",game.getRoot());
			assertTrue("The played time does not have the right expected value",game.searchPlayedTime(5).getTimeplayed()==5);
			assertNull("The lefty node of the root is not null as expected", game.searchPlayedTime(5).getLeft());
			assertNull("The right node of the root is not null as expected", game.searchPlayedTime(5).getRight());
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the removePlayer method of the model class Game, making sure that the Game removes a Player correctly
		 */
		public void testRemovePlayer() {
			setUpScenary2();
			
			int size = game.getPlayers().size();
			
			game.getPlayers().remove(game.getPlayers().size()-1);
			game.removePlayer("backtojuan", "backtojuan");
				
			assertTrue("The player was not removed", game.getPlayers().get(game.getPlayers().size()-1).getName()!="Juan");
			assertTrue("The list was not decrease",game.getPlayers().size()!=size);
			
			
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the savePlayers method of the model class Game, making sure that the Game savesPlayer to the textfile assignated
		 * in order to recover them any time.
		 */
		public void testSavePlayers() {
			setUpScenary2();
			
			File savedPlayers = new File("data/players.txt");
			
			assertNotNull("The players file can not be created", savedPlayers);
			assertTrue("The players file does not exists",savedPlayers.exists());
			try {
				assertTrue("The path of the players file is not the right one", 
				savedPlayers.getCanonicalPath().equals("C:\\Users\\Usuario\\Documents\\eclipse-workspace\\JoNaLetterSoup\\data\\players.txt"));
			} catch (IOException e) {
				fail("The file does not exist");
			}
			
		}
	//___________________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the PlayerExists method of the model class Game, making sure that the Game verifies if a player does exists or not
		 */
		public void testPlayerExists() {
			setUpScenary2();
			
			assertTrue("The player requested does not exists",game.playerExists("backtojuan")!=null);
			assertFalse("The player requeste does exists",game.playerExists("NIKOCHAN")!=null);
		}
	//_______________________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the isCorrect method of the model class Game, making sure that the Game verifies if a user match with its password in 
		 * order to signin or remove the user
		 */
		public void testIsCorrect() {
			setUpScenary2();
			assertTrue("The nickname of this player does not match with its password", game.isCorrect("backtojuan", "backtojuan"));
			assertFalse("The nickname of this player does it match with its password", game.isCorrect("niko", "test"));
		}
//___________________________________________________________________________________________________________________________________________________
		

}
