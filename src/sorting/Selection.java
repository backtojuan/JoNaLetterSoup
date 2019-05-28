//_________________________________________________________________________________________________________________________________________
	package sorting;
//_________________________________________________________________________________________________________________________________________
	import model.gamemodel.Game;
	import model.gamemodel.Player;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and sort Players with selection methods
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_MAY-2019
	 */
	public class Selection {
//_________________________________________________________________________________________________________________________________________
		
		/**
		 * This method sorts the date of the airlines in ascendent order using the classic Selection method
		 * @param game The game that contains the registered players with the dates that are going to be sort.
		 */
		public void sortByBirthday(Game game) {
				for (int i = 0; i < game.getPlayers().size()-1; i++) {
					int min = i;
					for (int j = i+1; j < game.getPlayers().size(); j++) {
						Player minValue = game.getPlayers().get(min);
						Player current  = game.getPlayers().get(j);
						if(current.getBirthdate().compareTo(minValue.getBirthdate())<0) {
							min = j;
						}
					}
					Player temp = game.getPlayers().get(min);
					game.getPlayers().set(min, game.getPlayers().get(i));
					game.getPlayers().set(i, temp);
				}		
			}
//_________________________________________________________________________________________________________________________________________
}