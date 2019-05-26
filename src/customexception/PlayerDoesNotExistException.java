//_________________________________________________________________________________________________________________________________________
	package customexception;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the necessary attributes and methods to creates exception objects of type PlayerDoesNotExistException
	 *@author Lina Johanna Salinas Delgado
	 *@author Juan José Valencia Jaramillo
	 *@version V_01_MAY_2019
	 */
	public class PlayerDoesNotExistException extends Exception{	
		private String nickname;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>PlayerDoesNotExistException constructor</b><br>
		 */
		public PlayerDoesNotExistException (String nickname) {
			super();
			this.nickname = nickname;
		}
//_________________________________________________________________________________________________________________________________________
		/**
		 * This method allow the exception to generates an special message for every case where the user tries to sign in with a player
		 * that does not exist
		 * @return A string report with the reason that lead the program to caused an exception
		 */
		@Override
		public String getMessage() {
			String report = "";
			
			if(nickname.equals("")) {
				report += "You can not sign in if you haven't enter any information";
			}
			else {
				report += "The:"+nickname +"player does not exists or maybe it was removed. Try signing up if the problem persists";
			}
			return report;
		}
//____________________________________________________________________________________________________________________________________
	
}
