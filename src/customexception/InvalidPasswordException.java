//_________________________________________________________________________________________________________________________________________
	package customexception;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the necessary attributes and methods to creates exception objects of type InvalidPasswordException
	 *@author Lina Johanna Salinas Delgado
	 *@author Juan José Valencia Jaramillo
	 *@version V_01_MAY_2019
	 */
	public class InvalidPasswordException extends Exception{	
		private String password;
		private String confirmpassword;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>InvalidPasswordException constructor</b><br>
		 */
		public InvalidPasswordException(String password, String confirmpassword) {
			super();
			this.password = password;
			this.confirmpassword = confirmpassword;
		}
//_________________________________________________________________________________________________________________________________________
		public boolean isUpperCase(String value) {
			return value == value.toUpperCase();
		}
//_________________________________________________________________________________________________________________________________________
		/**
		 * This method allow the exception to generates an special message for every case where the user enter invalid passwords
		 * @return A string report with the reason that lead the program to caused an exception
		 */
		@Override
		public String getMessage() {
			//report that is going to be return
			String report = "";
			if(this.password!=this.confirmpassword || this.password.length()!=this.confirmpassword.length()) {
				report += "Your password should match together and not be different in any aspect (length or content)";
			}
			else if(this.password.length()<8) {
				report += "Your password should have at least 8 characters or more";
			}
			else if(this.isUpperCase(this.password)) {
				report += "Your password must not containg uppercase content";
			}
			return report;
		}
//____________________________________________________________________________________________________________________________________
	
}
