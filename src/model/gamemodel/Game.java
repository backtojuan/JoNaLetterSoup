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
	import java.util.ArrayList;
//_________________________________________________________________________________________________________________________________________
	public class Game{
		
		private Difficulty difficultylevel;
		private ArrayList<Player> players;
		private ArrayList<Integer> scores;
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
		public void saveScores() throws IOException {
			File f = new File("data/scores");
			ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(f));
			oops.writeObject(scores);
			oops.close();
		}
	//_____________________________________________________________________________________________________________________________________
		@SuppressWarnings("unchecked")
		public void loadScores() throws IOException, ClassNotFoundException {
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
//_________________________________________________________________________________________________________________________________________
}
