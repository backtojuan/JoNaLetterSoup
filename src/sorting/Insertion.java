//_________________________________________________________________________________________________________________________________________
	package sorting;
//_________________________________________________________________________________________________________________________________________
	import model.gamemodel.Game;
	import model.gamemodel.Player;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and sort Players with insertion methods
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_MAY-2019
	 */
	public class Insertion {
//_________________________________________________________________________________________________________________________________________		
		
		/**
		 * This method sorts the nicknames of the players lexicographycally using the classic Insertion method
		 * @param game The game that contains the registered players with the nicknames that are going to be sort.
		 */
		public void sortByNickName(Game game) {
			for(int i=1;i<game.getPlayers().size();i++) {
				for(int j=i;j>0 && game.getPlayers().get(j-1).getNickname().compareTo(game.getPlayers().get(j).getNickname())>0;j--) {
					Player aux = game.getPlayers().get(j);
					game.getPlayers().set(j,game.getPlayers().get(j-1));
					game.getPlayers().set(j-1, aux);
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method sorts the passwords of the players lexicographycally using the classic Insertion method
		 * @param game The game that contains the registered players with the passwords that are going to be sort.
		 */
		public void sortByPassword(Game game) {
			for(int i=1;i<game.getPlayers().size();i++) {
				for(int j=i;j>0 && game.getPlayers().get(j-1).getPassword().compareTo(game.getPlayers().get(j).getPassword())>0;j--) {
					Player aux = game.getPlayers().get(j);
					game.getPlayers().set(j,game.getPlayers().get(j-1));
					game.getPlayers().set(j-1, aux);
				}
			}
		}
//_________________________________________________________________________________________________________________________________________
}