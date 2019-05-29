//_________________________________________________________________________________________________________________________________________
	package searching;
	import java.time.LocalDate;
//_________________________________________________________________________________________________________________________________________
	import model.gamemodel.Game;
	import model.gamemodel.Player;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to create methods to search Players with binary methods.
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_MAY-2019
	 */
	public class BinarySearching {
//_________________________________________________________________________________________________________________________________________		
		/**
		 * This method search a player inside the Game by using Binary Searching
		 * @param game the game that contains the player needed
		 * @param birthday the value that is going to be searched associated with the players
		 * @return a boolean that represents if the player was found or not
		 */
		public int searchBirthday(Game game, LocalDate birthday) {
			boolean found = false;
			int pos = 0;
			int low = 0;
			int high = game.getPlayers().size()-1;
			
			while(low<=high && !found) {
				int mid = (low+high)/2;
				if(game.getPlayers().get(mid).getBirthdate().equals(birthday)) {
					found = true;
					pos = mid;
				}
				else if(game.getPlayers().get(mid).getBirthdate().isAfter(birthday)) {
					high = mid - 1;
				}
				else
				{
					low = mid + 1;
				}
			}
			return pos;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method search a player inside the Game by using Binary Searching
		 * @param game the game that contains the player needed
		 * @param name the value that is going to be searched associated with the players
		 * @return a boolean that represents if the player was found or not
		 */
		public int searchName(Game game, String name) {
			boolean found = false;
			int pos = 0;
			int low = 0;
			int high = game.getPlayers().size()-1;
			
			while(low<=high && !found) {
				int mid = (low+high)/2;
				if(game.getPlayers().get(mid).getName().equals(name)) {
					found = true;
					pos = mid;
				}
				else if(game.getPlayers().get(mid).getName().compareTo(name)>0) {
					high = mid - 1;
				}
				else
				{
					low = mid + 1;
				}
			}		
			return pos;
		}
		
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method search a player inside the Game by using Binary Searching
		 * @param game the game that contains the player needed
		 * @param nickname the value that is going to be searched associated with the players
		 * @return a boolean that represents if the player was found or not
		 */
		public int searchNickName(Game game, String nickname) {
			boolean found = false;
			int pos = 0;
			int low = 0;
			int high = game.getPlayers().size()-1;
			
			while(low<=high && !found) {
				int mid = (low+high)/2;
				if(game.getPlayers().get(mid).getName().equals(nickname)) {
					found = true;
					pos = mid;
				}
				else if(game.getPlayers().get(mid).getName().compareTo(nickname)>0) {
					high = mid - 1;
				}
				else
				{
					low = mid + 1;
				}
			}		
			return pos;
		}
//_________________________________________________________________________________________________________________________________________
}