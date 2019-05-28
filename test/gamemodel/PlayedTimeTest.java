//_________________________________________________________________________________________________________________________________________
	package gamemodel;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import model.gamemodel.Game;
	import model.gamemodel.PlayedTime;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to test the Model class "PlayedTime".
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_March-2019
	 */
	class PlayedTimeTest {
		
		private PlayedTime root;
		private PlayedTime right;
		private PlayedTime left;
		/**
		 *This scenary is created to test the PlayedTime Constructor. 
		 */
		private void setUpScenary1() {
			
		}
		
		/**
		 * this scenary is created to test the rest of the methods for this classs
		 */
		private void setUpScenary2() {
			root = new PlayedTime(5);
			left = new PlayedTime(3);
			right = new PlayedTime(8);
		}
//_________________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the constructor method of the Model class PlayedTime, making sure the PlayedTime is right initialized.
		 */
		public void testPlayedTime() {
			setUpScenary1();
			
			PlayedTime playedtime = new PlayedTime(13);
			
			assertNotNull("The playedtime is null as not expected",playedtime);
			assertTrue("The value for this playedtime it's not the expected one",playedtime.getTimeplayed()==13);
			assertNull("The righty node for this element is not null", playedtime.getRight());
			assertNull("The lefty node for this element is not null", playedtime.getLeft());
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the getters and setters method of the model class PlayedTime making sure the relations are return and set
		 * in the right way
		 */
		public void testGettersAndSetters() {
			setUpScenary2();
			
			assertNotNull(root);
			assertNotNull(left);
			assertNotNull(right);
			
			assertNull("The righty node for this element is not null", root.getRight());
			assertNull("The lefty node for this element is not null", root.getLeft());
			
			assertNull("The righty node for this element is not null", left.getRight());
			assertNull("The lefty node for this element is not null", right.getLeft());
			
			assertNull("The righty node for this element is not null", left.getRight());
			assertNull("The lefty node for this element is not null", right.getLeft());
			
			root.setLeft(left);
			root.setRight(right);
			
			assertEquals(left, root.getLeft(),"The lefty node for this element was not set as expected");
			assertEquals(right, root.getRight(), "The righty node for thus element was not set as expected");
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the override compareTo method of the model class PlayedTime, making sure the comparations between nodes is
		 * being executed in the right way so the order criteria of the tree is not wrong
		 */
		public void testCompareTo() {
			setUpScenary2();
			
			root.setLeft(left);
			root.setRight(right);
			
			assertEquals(-1, root.compareTo(root.getRight()), "the root node is not smaller than its righty one");
			assertEquals(1, root.compareTo(root.getLeft()), "the root node is not bigger that its lefty one");
			assertEquals(0, root.compareTo(root), "the root node is not equals to itself");
			
		}
//_________________________________________________________________________________________________________________________________________
}
