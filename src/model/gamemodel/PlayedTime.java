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
		 * 
		 * @param timeplayed
		 */
		public PlayedTime(int timeplayed) {
			this.timeplayed = timeplayed;
		}
		
		/**
		 * 
		 * @return
		 */
		public int getTimeplayed() {
			return timeplayed;
		}
		
		/**
		 * 
		 * @return
		 */
		public PlayedTime getLeft() {
			return left;
		}
		
		/**
		 * 
		 * @return
		 */
		public PlayedTime getRight() {
			return right;
		}
		
		/**
		 * 
		 * @param left
		 */
		public void setLeft(PlayedTime left) {
			this.left = left;
		}
		
		/**
		 * 
		 * @param right
		 */
		public void setRight(PlayedTime right) {
			this.right = right;
		}	
	//_____________________________________________________________________________________________________________________________________
		@Override
		/**
		 * @param playedtime
		 * @return
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
