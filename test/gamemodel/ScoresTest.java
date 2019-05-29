//_________________________________________________________________________________________________________________________________________
	package gamemodel;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import model.gamemodel.Score;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to test the Model class "Scores".
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_March-2019
	 */
	class ScoresTest {
		
		private Score scores;
		private Score prev;
		private Score next;
		
		/**
		 *This scenary is created to test the Scores Constructor. 
		 */
		private void setUpScenary1() {
			
		}
		
		private void setUpScenary2() {
			scores = new Score(8);
			next = new Score(12);
			prev = new Score(4);
			scores.setNext(next);
			scores.setPrev(prev);
		}
//_________________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the constructor method of the Model class Score besides its getters and setters
		 *	making sure a Score is right initialized.
		 */
		public void testScores() {
			setUpScenary1();
			Score sc = new Score(5);
			
			assertNotNull(sc, "The recent created scores object is null as not expected");
			assertEquals(5, sc.getScore(), "the score value for this score is not the expected one");
			
			assertNull(sc.getNext(), "The next element of this node is not null");
			assertNull(sc.getPrev(), "The previous element of this node is not null");
			
			sc.setNext(new Score(8));
			sc.setPrev(new Score(3));
			
			assertNotNull(sc.getNext(), "the next element of this node was not set as expected");
			assertNotNull(sc.getPrev(), "the prev element of this node was not set as expected");
			
		}
	//_____________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the override compareTo method of the model class PlayedTime, making sure the comparations between nodes is
		 * being executed in the right way so the order criteria of the tree is not wrong
		 */
		public void testCompareTo() {
			setUpScenary2();
					
			assertEquals(-1, scores.compareTo(next), "the scores node is not smaller than its next one");
			assertEquals(1, scores.compareTo(prev), "the scores node is not bigger that its previous one");
			assertEquals(0, scores.compareTo(scores), "the scores node is not equals to itself");
		}
//_________________________________________________________________________________________________________________________________________
}
