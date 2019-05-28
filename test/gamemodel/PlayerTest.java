//_________________________________________________________________________________________________________________________________________
	package gamemodel;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.*;
	import java.time.LocalDate;
	import org.junit.jupiter.api.Test;
	import javafx.scene.paint.Color;
	import model.gamemodel.Game;
	import model.gamemodel.Player;
	import model.gamemodel.Shape;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to test the Model class "Player".
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_March-2019
	 */
	class PlayerTest {
		
		private Player player;
		/**
		 *This scenary is created to test the Player Constructor. 
		 */
		private void setUpScenary1() {
			
		}
//_________________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the constructor method of the Model class Player, making sure a Player is right initialized.
		 */
		public void testPlayer() {
			setUpScenary1();
			Player player = new Player("Juan", "backtojuan", "backtojuan", Color.BLACK.toString(),LocalDate.of(2002,3,13),Shape.CIRCLE);
			assertNotNull(player, "The recent created player is null");
			assertTrue("The name of the player is not the correct one", player.getName().equals("Juan"));
			assertTrue("The nickname of the player is not the correct one", player.getNickname().equals("backtojuan"));
			assertTrue("The password of the player is not the correct one", player.getPassword().equals("backtojuan"));
			assertTrue("The color of the player is not the correct one", player.getFavColor().equals(Color.BLACK.toString()));
			assertTrue("The birthdate of the player is not the correct one", player.getBirthdate().equals(LocalDate.of(2002,3,13)));
			assertTrue("The avatar of the player is not the correct one", player.getAvatar().equals(Shape.CIRCLE));
		}		
//_________________________________________________________________________________________________________________________________________
}
