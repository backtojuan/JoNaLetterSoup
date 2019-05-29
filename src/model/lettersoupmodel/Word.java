//_________________________________________________________________________________________________________________________________________
	package model.lettersoupmodel;
//_________________________________________________________________________________________________________________________________________
	import java.util.Random;
	import model.lettersoupmodel.Direction;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the nedeed methods and attributes to create Words
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01 May_2019
	 * 
	 */
	public class Word {
		
		private String name;
		private int row;
		private int column;
		private int length;
		private Direction direction;
		
		private Random random;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>Word constructor</b> 
		 * @param name the name of the word
		 * @param row the horizontal position of the word in the matrix
		 * @param column the vertical position of the word in the matrix
		 * @param length the size of the word
		 */
		public Word(String name,int row, int column,int length) {
			this.name = name;
			this.row = row;
			this.column = column;
			this.length = length;
			generateRandomDirection();
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method gives to the word a random Direction value
		 */
		private void generateRandomDirection() {
			random = new Random();
			int indicator = random.nextInt(4);
			switch(indicator) {
			case 0:
				direction = Direction.DOWN;
				break;
			case 1:
				direction = Direction.LEFT;
				break;
			case 2:
				direction = Direction.UP;
				break;
			case 3:
				direction = Direction.RIGHT;
				break;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method returns the name of this word
		 * @return the name of the word
		 */
		public String getName() {
			return name;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method returns the row of this word
		 * @return the row of this word
		 */
		public int getRow() {
			return row;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method returns the column of this word
		 * @return the column of this word
		 */
		public int getColumn() {
			return column;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method returns the size value of this word
		 * @return the size of this word
		 */
		public int getLength() {
			return length;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method returns the Direction value of this word
		 * @return the direction of this word
		 */
		public Direction getDirection() {
			return direction;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method sets the current row for this word with the new value requested
		 * @param row the new value of the row for this word
		 */
		public void setRow(int row) {
			this.row = row;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method sets the current column for this word with the new value requested
		 * @param column the new value of the column for this column
		 */
		public void setColumn(int column) {
			this.column = column;
		}
	//____________________________________________________________________________________________________________________________________
		@Override
		/**
		 * This method returns a current String representation of this word
		 * @return the string representation for this word
		 */
		public String toString() {
			return "Name "+name +" Row "+row +" Column "+column+" Length "+length+" Direction "+direction;
		}
	//_____________________________________________________________________________________________________________________________________
}