//_________________________________________________________________________________________________________________________________________
	package model.gamemodel;
//_________________________________________________________________________________________________________________________________________
	public class PlayedTime implements Comparable<PlayedTime>{
		
		private String nickname;
		private int timeplayed;
		
		private PlayedTime left;
		private PlayedTime right;
//________________________________________________________________________________________________________________________________________
		
		public PlayedTime(String nickname, int timeplayed) {
			this.nickname = nickname;
			this.timeplayed = timeplayed;
		}
	
		public String getNickname() {
			return nickname;
		}
	
		public int getTimeplayed() {
			return timeplayed;
		}
	
		public PlayedTime getLeft() {
			return left;
		}
	
		public PlayedTime getRight() {
			return right;
		}
	
		public void setLeft(PlayedTime left) {
			this.left = left;
		}
	
		public void setRight(PlayedTime right) {
			this.right = right;
		}	
	//_____________________________________________________________________________________________________________________________________
		public boolean isLeaf() {
			return left==null && right==null;
		}
	//_____________________________________________________________________________________________________________________________________
		@Override
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
