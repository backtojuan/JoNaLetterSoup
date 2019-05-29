//_________________________________________________________________________________________________________________________________________
	package customexception;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the necessary attributes and methods to creates exception objects of type InvalidInformationException
	 *@author Lina Johanna Salinas Delgado
	 *@author Juan José Valencia Jaramillo
	 *@version V_01_MAY_2019
	 */
	public class InvalidInformationException extends Exception{
		private String invalidInformation;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>InvalidInformationException constructor</b><br>
		 */
		public InvalidInformationException(String invalidInformation) {
			super();
			this.invalidInformation = invalidInformation;
		}
//_________________________________________________________________________________________________________________________________________
		/**
		 * This method allow the exception to generates an special message for every case where the user enter or choosed wrong values
		 * @return A string report with the reason that lead the program to caused an exception
		 */
		@Override
		public String getMessage() {
			//report that is going to be return
			String report = "";
			if(this.invalidInformation==null) {
				report += "You can not create a new Profile Player if you haven't enter enough information";
			}
			else if(this.invalidInformation.equals("")) {
				report += "Please type the information requested in order to apply the task in the program";
			}
			return report;
		}
//____________________________________________________________________________________________________________________________________
	
}
