//_________________________________________________________________________________________________________________________________________
	package lettersoupmodel;
//_________________________________________________________________________________________________________________________________________
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertTrue;
	import static org.junit.jupiter.api.Assertions.*;

	import org.junit.jupiter.api.Test;
	import model.lettersoupmodel.*;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to test the Model class "Word".
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_March-2019
	 */
	class WordTest {
		
		/**
		 *This scenary is created to test the Word Constructor. 
		 */
		private void setUpScenary1() {
			
		}
//_________________________________________________________________________________________________________________________________________
		@Test
		/**
		 * This method test the constructor method of the Model class Word besides 
		 * its getters and setters, making sure a word can be created, initialized andd be modified with expected values
		 */
		public void testPlayer() {
			setUpScenary1();
			
			String name = "HORSE";
			Word word = new Word(name,0,0,name.length());
			
			assertNotNull("The word is null as not expected",word);
			assertEquals(name, word.getName(), "The expected assignated name for this word is wrong");
			assertEquals(0, word.getRow(), "The row value for this word is not the expected one");
			assertEquals(0, word.getColumn(), "The	column value for this word is not the expected one");
			assertEquals(name.length(), word.getLength(), "");
			assertNotNull("The direction value for this word was not assignated as expected",word.getDirection());
			
			String toString = "Name "+word.getName()+" Row "+word.getRow()+" Column "+word.getColumn()
			+" Length "+word.getLength()+" Direction "+word.getDirection();
			
			assertEquals(word.toString(),toString,"The toString convertion for this word was not the expected one");
			
			word.setRow(5);
			word.setColumn(7);
			
			assertEquals(5, word.getRow(), "The row value for this word was not set as expected");
			assertEquals(7, word.getColumn(), "The column value for this word was not set as expected");
		}		
//_________________________________________________________________________________________________________________________________________
}
