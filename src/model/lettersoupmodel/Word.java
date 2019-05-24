//___________________________________________PACKAGE OF THIS CLASS_________________________________________________________________________
	package model.lettersoupmodel;
//___________________________________________USED PACKAGES FOR THIS CLASS__________________________________________________________________
	import java.util.Random;
	import model.lettersoupmodel.Direction;
//___________________________________________ATTRIBUTES____________________________________________________________________________________
	
	public class Word {
		
		private String name;
		private int row;
		private int column;
		private int length;
		private Direction direction;
		
		private Random random;
//_________________________________________METHODS FOR THIS CLASS__________________________________________________________________________
	
		public Word(String name,int row, int column,int length) {
			this.name = name;
			this.row = row;
			this.column = column;
			this.length = length;
			generateRandomDirection();
		}
	//_____________________________________________________________________________________________________________________________________
		
		public void generateRandomDirection() {
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
		public String getName() {
			return name;
		}
	//_____________________________________________________________________________________________________________________________________
		public int getRow() {
			return row;
		}
	//_____________________________________________________________________________________________________________________________________
		public int getColumn() {
			return column;
		}
	//_____________________________________________________________________________________________________________________________________
		public int getLength() {
			return length;
		}
	//_____________________________________________________________________________________________________________________________________
		public Direction getDirection() {
			return direction;
		}
	//_____________________________________________________________________________________________________________________________________
		public void setName(String name) {
			this.name = name;
		}
	//_____________________________________________________________________________________________________________________________________
		public void setRow(int row) {
			this.row = row;
		}
	//_____________________________________________________________________________________________________________________________________
		public void setColumn(int column) {
			this.column = column;
		}
	//_____________________________________________________________________________________________________________________________________
		public void setDirection(Direction direction) {
			this.direction = direction;
		}
	//____________________________________________________________________________________________________________________________________
		@Override
		public String toString() {
			return "Name "+name +" Row "+row +" Column "+column+" Length "+length+" Direction "+direction;
		}
	//_____________________________________________________________________________________________________________________________________
}