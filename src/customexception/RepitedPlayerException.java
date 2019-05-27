//_________________________________________________________________________________________________________________________________________
	package customexception;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the necessary attributes and methods to creates exception objects of type RepitedPlayerException
	 *@author Lina Johanna Salinas Delgado
	 *@author Juan José Valencia Jaramillo
	 *@version V_01_MAY_2019
	 */
	public class RepitedPlayerException extends Exception{	
		private String nickname;
		private String repitednickname;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>RepitedPlayerException constructor</b><br>
		 */
		public RepitedPlayerException(String nickname,String repitednickname) {
			super();
			this.nickname = nickname;
			this.repitednickname = repitednickname;
		}
//_________________________________________________________________________________________________________________________________________
		/**
		 * This method allow the exception to generates an special message for every case where the user tries to sign up with a nickname
		 * of a player that already exists
		 * @return A string report with the reason that lead the program to caused an exception
		 */
		@Override
		public String getMessage() {
			return "There is already another player registered with this nickname, please try with other variant";
		}
//____________________________________________________________________________________________________________________________________
	
}
