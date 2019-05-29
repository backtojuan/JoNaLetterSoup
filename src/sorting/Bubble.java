//_________________________________________________________________________________________________________________________________________
	package sorting;
//_________________________________________________________________________________________________________________________________________
	import model.gamemodel.Game;
	import model.gamemodel.Player;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and sort players by the Bubble method.
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_MAY-2019
	 */
	public class Bubble {
//_________________________________________________________________________________________________________________________________________		
		/**
		 * This method sorts the Names of the players in a lexicographically order using the classic Bubble method.<br>
		 * @param game the game that contains the registered players with the names that are going to be sort.
		 */
		public void sortByName(Game game) {
			for(int i=0;i<game.getPlayers().size()-1;i++) {
				for(int j=0;j<game.getPlayers().size()-i-1;j++) {
					if(game.getPlayers().get(j).getName().compareTo(game.getPlayers().get(j+1).getName())>0) {
						Player aux = game.getPlayers().get(j);
						game.getPlayers().set(j, game.getPlayers().get(j+1));
						game.getPlayers().set(j+1, aux);
					}
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method sorts the color of the players in a lexicographically order using the classic Bubble method.<br>
		 * @param game the game that contains the registered players with the colors that are going to be sort.
		 */
		public void sortByColor(Game game) {
			for(int i=0;i<game.getPlayers().size()-1;i++) {
				for(int j=0;j<game.getPlayers().size()-i-1;j++) {
					if(game.getPlayers().get(j).getFavColor().compareTo(game.getPlayers().get(j+1).getFavColor())>0) {
						Player aux = game.getPlayers().get(j);
						game.getPlayers().set(j, game.getPlayers().get(j+1));
						game.getPlayers().set(j+1, aux);
					}
				}
			}
		}
//_________________________________________________________________________________________________________________________________________
}
