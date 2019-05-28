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
		 * 
		 * @param name
		 * @param row
		 * @param column
		 * @param length
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
		 * 
		 */
		private void generateRandomDirection() {
			random = new Random();
			int indicator = random.nextInt(8);
			switch(indicator) {
			case 0:
				direction = Direction.DOWN;
				break;
			case 1:
				direction = Direction.LEFT;
				break;
			case 2:
				direction = Direction.NORTHEAST;
				break;
			case 3:
				direction = Direction.NORTHWEST;
				break;
			case 4:
				direction = Direction.SOUTHWEST;
				break;
			case 5:
				direction = Direction.SOUTHEAST;
				break;
			case 6:
				direction = Direction.UP;
				break;
			case 7:
				direction = Direction.RIGHT;
				break;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @return
		 */
		public String getName() {
			return name;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @return
		 */
		public int getRow() {
			return row;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @return
		 */
		public int getColumn() {
			return column;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @return
		 */
		public int getLength() {
			return length;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @return
		 */
		public Direction getDirection() {
			return direction;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @param row
		 */
		public void setRow(int row) {
			this.row = row;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @param column
		 */
		public void setColumn(int column) {
			this.column = column;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @param direction
		 */
		public void setDirection(Direction direction) {
			this.direction = direction;
		}
	//____________________________________________________________________________________________________________________________________
		@Override
		/**
		 * @return 
		 */
		public String toString() {
			return "Name "+name +" Row "+row +" Column "+column+" Length "+length+" Direction "+direction;
		}
	//_____________________________________________________________________________________________________________________________________
}