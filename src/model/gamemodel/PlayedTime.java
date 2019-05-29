//_________________________________________________________________________________________________________________________________________
	package model.gamemodel;
//_________________________________________________________________________________________________________________________________________
	import java.io.Serializable;
	import java.util.ArrayList;
	import javafx.geometry.Pos;
	import javafx.util.Duration;

//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the necessary attributes and methods to create and Save PlayedTimes
	 *@author Lina Johanna Salinas Delgado
	 *@author Juan José Valencia Jaramillo
	 *@version V_01_MAY_2019
	 */
	public class PlayedTime implements Comparable<PlayedTime>,Serializable{
		
		private int timeplayed;
		
		private PlayedTime left;
		private PlayedTime right;
//________________________________________________________________________________________________________________________________________
		/**
		 * <b>PlayedTime Constructor</b>
		 * @param timeplayed the value of timeplayed for this game
		 */
		public PlayedTime(int timeplayed) {
			this.timeplayed = timeplayed;
		}
		
		/**
		 * This method returns the value of playedtime for the current node
		 * @return the time played specified in seconds that was spend playing the lettersoup
		 */
		public int getTimeplayed() {
			return timeplayed;
		}
		
		/**
		 * This method gets the lefty node of this element
		 * @return the lefty node associated to the current node
		 */
		public PlayedTime getLeft() {
			return left;
		}
		
		/**
		 * this method gets the lefty node of this element
		 * @return the righty node associated to the current node
		 */
		public PlayedTime getRight() {
			return right;
		}
		
		/**
		 * This method sets the lefty node of this element
		 * @param left the value that is going to be insert as smaller for the current node
		 */
		public void setLeft(PlayedTime left) {
			this.left = left;
		}
		
		/**
		 * This method sets the right node of this element
		 * @param right the value that is going to be insert as bigger for the current node
		 */
		public void setRight(PlayedTime right) {
			this.right = right;
		}	
	//_____________________________________________________________________________________________________________________________________
		@Override
		/**
		 * This method compares the value of the PlayedTimes so they can have a right criteria order when creating the binary searching tree
		 * @param playedtime the played time that is going to be compare with this element
		 * @return an Integer that represents is the two compared nodes are equals, one bigger than other, one smaller than other.
		 */
		public int compareTo(PlayedTime playedtime) {
			int comparation = 0;
			if(this.getTimeplayed()<playedtime.getTimeplayed()) {
				comparation = -1;
			}
			else if(this.getTimeplayed()>playedtime.getTimeplayed()) {
				comparation = 1;
			}
			return comparation;
		}
//_________________________________________________________________________________________________________________________________________	
}
