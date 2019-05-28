//_________________________________________________________________________________________________________________________________________
	package gamemodel;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.Assert.assertFalse;
	import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.*;
	import java.time.LocalDate;
	import org.junit.jupiter.api.Test;
	import com.sun.prism.paint.Color;
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
			game.addPlayer(new Player("Juan","backtojuan","backtojuan",Color.BLACK.toString(),LocalDate.of(2002,3,13),Shape.RECTANGLE));
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
			
			game.removePlayer("backtojuan", "backtojuan");
				
			assertTrue("The player was not removed", game.getPlayers().get(game.getPlayers().size()-1).getName()!="Juan");
			assertTrue("The list was not decrease",game.getPlayers().size()!=size);
			
			
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the removePlayer method of the model class Game, making sure that the Game removes a Player correctly
		 */
		public void testSavePlayers() {
			
		}
//_________________________________________________________________________________________________________________________________________
		

}
