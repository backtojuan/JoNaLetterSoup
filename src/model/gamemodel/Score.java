//_________________________________________________________________________________________________________________________________________
	package model.gamemodel;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the necessary attributes and methods to create a Game and its all components
	 *@author Lina Johanna Salinas Delgado
	 *@author Juan José Valencia Jaramillo
	 *@version V_01_MAY_2019
	 */
	public class Score implements Comparable<Score> {
		
		private int score;
		private Score next;
		private Score prev;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>Scores Constructor</b> 
		 * @param score the score value for this score
		 */
		public Score(int score) {
			this.score = score;
		}

		/**
		 * This method returns the score value associated to this node
		 * @return the score value
		 */
		public int getScore() {
			return score;
		}
		
		/**
		 * This method returns the next node of the current element
		 * @return the next node
		 */
		public Score getNext() {
			return next;
		}
		
		/**
		 * This method sets the next node of the current element
		 * @param next the new node to be set
		 */
		public void setNext(Score next) {
			this.next = next;
		}
		
		/**
		 * This method returns the previous node of the current element
		 * @return prev the prev node 
		 */
		public Score getPrev() {
			return next;
		}
		
		/**
		 * This method sets the prev node of the current element
		 * @param prev the new node to be set
		 */
		public void setPrev(Score prev) {
			this.prev = prev;
		}
	//___________________________________________________________________________________________________________________________________
		@Override
		/**
		 * This method compares the node with each other making sure that when adding a new node this mantains the order and balance
		 * in the linked list
		 */
		public int compareTo(Score score) {
			int comparation = 0;
			if(this.getScore()<score.getScore()) {
				comparation = -1;
			}
			else if(this.getScore()>score.getScore()) {
				comparation = 1;
			}
			return comparation;
		}
//_________________________________________________________________________________________________________________________________________


}
