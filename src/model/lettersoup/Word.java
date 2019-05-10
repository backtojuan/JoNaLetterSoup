	
	package model.lettersoup;
	
	import java.util.Random;

import com.sun.javafx.scene.traversal.Direction;

import model.lettersoup.Directions;
	
	
	
	public class Word {
		
		private int row;
		private int column;
		private int length;
		private Directions direction;
		
		private Random random;
		
		public Word(int r, int c,int l) {
			row = r;
			column = c;
			length = l;
		}
		
		public void generateRandomDirection() {
			random = new Random();
			int indicator = random.nextInt(8);
			switch(indicator) {
			case 0:
				direction = Directions.DOWN;
				break;
			case 1:
				direction = Directions.LEFT;
				break;
			case 2:
				direction = Directions.SOUTHEAST;
				break;
			case 3:
				direction = Directions.SOUTHEAST;
				break;
			case 4:
				direction = Directions.SOUTHEAST;
				break;
			case 5:
				direction = Directions.SOUTHEAST;
				break;
			
			}
		}
		
		
		
	}
