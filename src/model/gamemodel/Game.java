//_________________________________________________________________________________________________________________________________________
	package model.gamemodel;
//_________________________________________________________________________________________________________________________________________	
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.PrintWriter;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.ArrayList;
	import org.controlsfx.control.Notifications;
	import javafx.geometry.Pos;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.util.Duration;
//_________________________________________________________________________________________________________________________________________
		/**
		 * This class manages the necessary attributes and methods to create a Game and its all components
		 *@author Lina Johanna Salinas Delgado
		 *@author Juan José Valencia Jaramillo
		 *@version V_01_MAY_2019
		 */
		public class Game{
			
			private Difficulty difficultylevel;
			private ArrayList<Player> players;
			private ArrayList<Integer> scores;
			
			private PlayedTime root;
//_________________________________________________________________________________________________________________________________________
			/**
			 * <b>Game Constructor</b><br>
			 * This method allows to construct a general game with it's all specified components such as players, scores and playedtimes<br>
			 * @param difficultylevel the level of difficult that the user wants this game to be
			 */
			public Game(Difficulty difficultylevel){
				this.difficultylevel = difficultylevel;
				players = new ArrayList<Player>();
				loadScores();
				loadPlayers();
				loadTimes();
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * This method returns the players of the game<br>
			 * <b>Pre:</b> the Game exists<br>
			 * @return the list that contains all the players registered in the game
			 */
			public ArrayList<Player> getPlayers(){
				return players;
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * This method returns the scores of the game<br>
			 * <b>Pre:</b> the Game exists<br>
			 * @return the list that contains all the scores that belongs to some players
			 */
			public ArrayList<Integer> getScores(){
				return scores;
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * This method returns the root node of the binary searching tree of playedtimes<br>
			 * <b>Pre:</b> the Game exists<br>
			 * @return the root node 
			 */
			public PlayedTime getRoot() {
				return root;
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * This method returns the difficultylevel asocciated to this game<br>
			 * <b>Pre:</b> the Game exists<br>
			 * @return the difficulty level which determinates the hardeness of this game
			 */
			public Difficulty getDifficultylevel(){
				return difficultylevel;
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * This method sets the difficultylevel associated to this game in the case that the user had choosen one<br>
			 * <b>Pre:</b> the Game exists<br>
			 * <b>Pos:</b> the requested level was succesfully set to this game<br>
			 * @param difficultylevel the difficulty level which determinates the hardeness of this game
			 */
			public void setDifficultyLevel(Difficulty difficultylevel) {
				this.difficultylevel = difficultylevel;
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * This method adds a player to the general list of players in the game
			 * <b>Pre:</b> the Game exists<br>
			 * <b>Pos:</b> the requested player was added to the list of players<br>
			 * @param player the player that it's going to be added
			 */
			public void addPlayer(Player player) {
				players.add(player);
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * This method adds a score to the general list of scores in the game<br>
			 * <b>Pre:</b> the Game exists<br>
			 * <b>Pos:</b> the requested score was added to the list of scores<br>
			 * @param player the player that it's going to be added
			 */
			public void addScore(int score) {
				scores.add(score);
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * This method adds a playedtime to the binary searching tree of playedtimes<br>
			 * <b>Pre:</b> the Game exists<br>
			 * <b>Pos:</b> the requested playedtime was added to the binary searching tree without any incovenient<br>
			 * @param playedtime the playedtime that it's going to be added
			 */
			public void addPlayedTime(int playedtime) {
				PlayedTime pt = new PlayedTime(playedtime);
				if(root==null) {
					root = pt;
				}
				else {
					addPlayedTime(root, pt);
				}
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * 
			 * @param current
			 * @param playedtime
			 */
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
			/**
			 * 
			 * @param playedtime
			 * @return
			 */
			public PlayedTime searchPlayedTime(int playedtime) {
				PlayedTime searched = new PlayedTime(playedtime);
				if(root.compareTo(searched)==0){
					return root;
				}
				else {
					return searchPlayedTime(root, searched);
				}
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * 
			 * @param current
			 * @param searched
			 * @return
			 */
			private PlayedTime searchPlayedTime(PlayedTime current, PlayedTime searched) {
				if(current!=null) {
					if(current.compareTo(searched)<0) {
						if(current.getRight()!=null) {
							if(current.getRight().compareTo(searched)==0) {
								return current.getRight();
							}
							else {
								return searchPlayedTime(current.getRight(), searched);
							}
						}
					}
					else if(current.compareTo(searched)>0) {
						if(current.getLeft()!=null) {
							if(current.getLeft().compareTo(searched)==0) {
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
			/**
			 * 
			 * @param nickname
			 * @param password
			 */
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
			/**
			 * 
			 */
			private void saveScores(){
				try {
					File f = new File("data/scores");
					ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(f));
					oops.writeObject(scores);
					oops.close();
				}
		    	catch(IOException e) {
		    		Notifications.create()
		    		.title("Announcement")
		    		.text("The file that contained the scores of the game was deleted check for the data folder")
		    		.darkStyle()
		    		.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
		    		.showError();
		    	}
			}
		//_____________________________________________________________________________________________________________________________________
			@SuppressWarnings("unchecked")
			/**
			 * 
			 */
			private void loadScores(){
				try {
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
		    	catch(IOException|ClassNotFoundException e) {
		    		Notifications.create()
		    		.title("Announcement")
		    		.text("The file that contained the scores of the game was deleted check for the data folder")
		    		.darkStyle()
		    		.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
		    		.showError();
		    	}
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * 
			 */
			public void savePlayers(){
				try {
					PrintWriter pw = new PrintWriter("data/players.txt");
					pw.print(playersReport());
					pw.close();
				}
		    	catch(FileNotFoundException fnfe) {
		    		Notifications.create()
		    		.title("Announcement")
		    		.text("The Path to save the players does not exists, please make sure the folder is created inside the project")
		    		.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
		    		.darkStyle()
		    		.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
		    		.show();
		    	}
			}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * 
			 */
			private void loadPlayers(){
				try {
					BufferedReader br=new BufferedReader(new FileReader("data/players.txt"));
					String line=br.readLine();
					while(line!=null) {
						String[] parts=line.split(",");
						String name = parts[0];
						String nickname=parts[1];
						String password=parts[2];
						String favColor=parts[3];
						
						String birthday = parts[4];
						DateTimeFormatter formatter=parts[4].substring(3,5).contains("/")?DateTimeFormatter.ofPattern("dd/M/yyyy"):DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate birthdate=LocalDate.parse(birthday, formatter);
						
						Shape avatar=parts[4].equals("CIRCLE")?Shape.CIRCLE:Shape.RECTANGLE;
						
						Player player=new Player(name,nickname,password,favColor,birthdate,avatar);
						
						players.add(player);
						line=br.readLine();
				    }
					br.close();
				}
			    catch(IOException e) {
					Notifications.create()
					.title("Something went wrong...")
					.text("Cannot load the players due to a problem finding the text with the information, make sure the players.txt file"
							+ "is created in the data folder of the project")
					.darkStyle()
					.position(Pos.TOP_RIGHT)
		    		.hideCloseButton()
	    			.hideAfter(Duration.seconds(8))
	    			.show();
			}
		}
			
		//_____________________________________________________________________________________________________________________________________
			/**
			 * 
			 */
			private void saveTimes(){
				try {
					File f = new File("data/scores");
					ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(f));
					oops.writeObject(root);
					oops.close();
				}
				catch(IOException e) {
				    Notifications.create()
				    .title("Announcement")
				    .text("The file that contained the playedtimes of the game was deleted check for the data folder")
				    .darkStyle()
				    .position(Pos.TOP_RIGHT)
				    .hideCloseButton()
			    	.hideAfter(Duration.seconds(8))
			    	.showError();
				    }
				}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * 
			 */
			private void loadTimes(){
				try {
					File f = new File("data/scores");
					if(f.exists()) {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
					root = (PlayedTime) ois.readObject();
					ois.close();
					}
				else {
					root = null;
					}
				}
				catch(IOException|ClassNotFoundException e) {
				    Notifications.create()
				    .title("Announcement")
				    .text("The file that contained the playedtimes of the game was deleted check for the data folder")
				    .darkStyle()
				    .position(Pos.TOP_RIGHT)
				    .hideCloseButton()
			    	.hideAfter(Duration.seconds(8))
				    .showError();
				    }
				}
		//_____________________________________________________________________________________________________________________________________
			/**
			 * 
			 * @return
			 */
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
			/**
			 * 
			 * @param nickname
			 * @return
			 */
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
			/**
			 * 
			 * @param nickname
			 * @param password
			 * @return
			 */
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
			/**
			 * 
			 */
			public void refreshPlayers() {
				loadPlayers();
			}
//_____________________________________________________________________________________________________________________________________________
}
