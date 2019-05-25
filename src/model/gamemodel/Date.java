//________________________________________________packages used for this class________________________________________________________
	
	package model.gamemodel;
	
	import java.util.Random;

//____________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to generate Random Dates
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	public class Date {
		
		private int day;
		private int month;
		private int year;
	
	//________________________________________________________________________________________________________________________________
		
		/**
		 * <b>Date Constructor</b><br>
		 * this method creates objects of type date
		 */
		public Date(int day, int month, int year) {
			
		}			
	//____________________________________________________________________________________________________________________________
				
		/**
		* This method convert the date to a String so it can be read easily and not as numbers.				 
		** <b>Pre:</b> the date exist and is not null.<br>
		* <b>Pos:</b> the date was converted to String.<br>
		*/
		@Override
		public String toString() {
			return day+"/"+month+"/"+year;
		}
		
//____________________________________________________________________________________________________________________________________

}
