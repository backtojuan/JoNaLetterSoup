//_________________________________________________________________________________________________________________________________________
	package model.gamemodel;
//_________________________________________________________________________________________________________________________________________	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
//_________________________________________________________________________________________________________________________________________
	public class Game{
		
		private Difficulty difficultylevel;
		private ArrayList<Player> players;
		private ArrayList<Integer> scores;
		
		private PlayedTime root;
//_________________________________________________________________________________________________________________________________________
		public Game(Difficulty difficultylevel) throws IOException, ClassNotFoundException {
			this.difficultylevel = difficultylevel;
			players = new ArrayList<Player>();
			loadScores();
		}
	//_____________________________________________________________________________________________________________________________________
		public ArrayList<Player> getPlayers(){
			return players;
		}
	//_____________________________________________________________________________________________________________________________________
		public ArrayList<Integer> getScores(){
			return scores;
		}
	//_____________________________________________________________________________________________________________________________________
		public PlayedTime getRoot() {
			return root;
		}
	//_____________________________________________________________________________________________________________________________________
		public Difficulty getDifficultylevel(){
			return difficultylevel;
		}
	//_____________________________________________________________________________________________________________________________________
		public void setDifficultyLevel(Difficulty difficultylevel) {
			this.difficultylevel = difficultylevel;
		}
	//_____________________________________________________________________________________________________________________________________
		public void addPlayer(Player player) {
			players.add(player);
		}
	//_____________________________________________________________________________________________________________________________________
		public void addScore(int score) {
			scores.add(score);
		}
	//_____________________________________________________________________________________________________________________________________
		public void addPlayedTime(String nickname, int playedtime) {
			PlayedTime pt = new PlayedTime(nickname,playedtime);
			if(root==null) {
				root = pt;
			}
			else {
				addPlayedTime(root, pt);
			}
		}
	//_____________________________________________________________________________________________________________________________________
		private void addPlayedTime(PlayedTime current, PlayedTime playedtime) {
			if(current.compareTo(playedtime)>0) {
				if(current.getLeft()==null) {
					current.setLeft(playedtime);
				}
				else {
					addPlayedTime(current.getLeft(), playedtime);
				}
			}
			else if(current.compareTo(playedtime)<0) {
				if(current.getRight()==null) {
					current.setRight(playedtime);
				}
				else {
					addPlayedTime(current.getRight(), playedtime);
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		public PlayedTime searchPlayedTime(String nickname,int playedtime) {
			PlayedTime searched = new PlayedTime(nickname,playedtime);
			if(root.getNickname().equals(nickname)) {
				return root;
			}
			else {
				return searchPlayedTime(root, searched);
			}
		}
	//_____________________________________________________________________________________________________________________________________
		private PlayedTime searchPlayedTime(PlayedTime current, PlayedTime searched) {
			if(current!=null) {
				if(current.compareTo(searched)<0) {
					if(current.getRight()!=null) {
						if(current.getRight().getNickname().equals(searched.getNickname())) {
							return current.getRight();
						}
						else {
							return searchPlayedTime(current.getRight(), searched);
						}
					}
				}
				else if(current.compareTo(searched)>0) {
					if(current.getLeft()!=null) {
						if(current.getLeft().getNickname().equals(searched.getNickname())) {
							return current.getLeft();
						}
						else {
							return searchPlayedTime(current.getLeft(), searched);
						}
					}
				}
			}
			return current;
		}
	//_____________________________________________________________________________________________________________________________________
		private void removePlayedTime(String nickname,int playedtime) {
			if(searchPlayedTime(nickname, playedtime).isLeaf()) {
				
			}
		}
	//_____________________________________________________________________________________________________________________________________
		public void removePlayer(String nickname, String password) {
			for(int i=0;i<players.size();i++) {
				if(players.get(i).getNickname().equals(nickname)) {
					if(players.get(i).getPassword().equals(password)) {
						players.remove(i);
					}
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		private void saveScores() throws IOException {
			File f = new File("data/scores");
			ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(f));
			oops.writeObject(scores);
			oops.close();
		}
	//_____________________________________________________________________________________________________________________________________
		@SuppressWarnings("unchecked")
		private void loadScores() throws IOException, ClassNotFoundException {
			File f = new File("data/scores");
			if(f.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				scores = (ArrayList<Integer>) ois.readObject();
				ois.close();
			}
			else {
				scores = new ArrayList<Integer>();
			}
		}
	//_____________________________________________________________________________________________________________________________________
		public void savePlayers() throws FileNotFoundException {
			PrintWriter pw = new PrintWriter("data/players.txt");
			pw.print(playersReport());
			pw.close();
		}
	//_____________________________________________________________________________________________________________________________________
		private String playersReport() {
			String report = "";
				for(int i=0;i<players.size();i++) {
					report += players.get(i).getName()+","+players.get(i).getNickname()
							+","+players.get(i).getPassword()+","+players.get(i).getFavColor()
							+","+players.get(i).getBirthday()+","+players.get(i).getAvatar();
					report += "\n";
				}
			return report;
		} 
	//_____________________________________________________________________________________________________________________________________
		public Player playerExists(String nickname){
			Player player = null;
			for(int i=0;i<players.size()&&player==null;i++) {
				if(players.get(i).getNickname().equals(nickname)){
					player = players.get(i);
				}
			}
			return player;
		}
	//_____________________________________________________________________________________________________________________________________
		public boolean isCorrect(String nickname,String password){

			boolean correct = false;
			if(playerExists(nickname)!=null) {
				if(playerExists(nickname).getPassword().equals(password)) {
					correct = true;
				}
			}
			return correct;
		}
	//_____________________________________________________________________________________________________________________________________
//_________________________________________________________________________________________________________________________________________
}
