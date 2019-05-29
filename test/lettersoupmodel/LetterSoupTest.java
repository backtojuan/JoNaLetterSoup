//_________________________________________________________________________________________________________________________________________
	package lettersoupmodel;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;

	import model.gamemodel.Difficulty;
	import model.lettersoupmodel.*;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to test the Model class "LetterSoup".
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_March-2019
	 */
	class LetterSoupTest {
		
		private LettersSoup lettersoup;
		/**
		 *This scenary is created to test the LetterSoup Constructor. 
		 */
		private void setUpScenary1() {
			
		}		
		/**
		 * This scenary is created to test the generation of the LetterSoup
		 */
		private void setUpScenary2() {
			lettersoup = new LettersSoup(Topic.ANIMALS,Difficulty.BASIC);
		}
		
//_________________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the constructor method of the Model class LetterSoup besides 
		 * its getters and setters, making sure a lettersoup can be generated, initialized and filled with the right words and content.
		 */
		public void testLetterSoup() {
			setUpScenary1();
			
			LettersSoup lettersoup = new LettersSoup(Topic.CITIES, Difficulty.BASIC);
			
			assertNotNull("The recent lettersoup is null as not expected",lettersoup);
			assertEquals(Topic.CITIES, lettersoup.getTopic(), "The topic value for this lettersoup is not the expected one");
			assertEquals(Difficulty.BASIC, lettersoup.getDifficultylevel(), "the difficulty value for this lettersoup is not the expected one");
				
			assertEquals(10,lettersoup.getLetterSoup().length,"The size of the matrix assignated for this lettersoup is not the expected one");
			assertEquals(3, lettersoup.getSolution().length,"The size of the solution array assignated for this lettersoup is not the expected one");
			
			LettersSoup letterssoup = new LettersSoup(Topic.NUMBERS, Difficulty.INTERMEDIUM);
			
			assertNotNull("The recent lettersoup is null as not expected",lettersoup);
			assertEquals(Topic.NUMBERS, letterssoup.getTopic(), "The topic value for this lettersoup is not the expected one");
			assertEquals(Difficulty.INTERMEDIUM, letterssoup.getDifficultylevel(), "the difficulty value for this lettersoup is not the expected one");
				
			assertEquals(15,letterssoup.getLetterSoup().length,"The size of the matrix assignated for this lettersoup is not the expected one");
			assertEquals(6, letterssoup.getSolution().length,"The size of the solution array assignated for this lettersoup is not the expected one");
			
		}
//______________________________________________________________________________________________________________________________________________________
}
