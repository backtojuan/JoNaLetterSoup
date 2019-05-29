//_________________________________________________________________________________________________________________________________________
	package model.gamemodel;
//_________________________________________________________________________________________________________________________________________
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manages the necessary attributes and methods to creates a Player
	 *@author Lina Johanna Salinas Delgado
	 *@author Juan José Valencia Jaramillo
	 *@version V_01_MAY_2019
	 */
	public class Player {
		
		private String name;
		private String nickname;
		private String password;
		private String favColor;
		private LocalDate birthday;
		private Shape avatar;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>Player Constructor</b> 
		 * @param name the name of the player
		 * @param nickname the nickname which the player wants to be identify as
		 * @param password the pasword that is going to be used for signing in
		 * @param favColor the favorite color of the player
		 * @param birthday the birthday of the player
		 * @param avatar the avatar of the player
		 */
		public Player(String name,String nickname, String password, String favColor, LocalDate birthday, Shape avatar) {
			this.name = name;
			this.nickname = nickname;
			this.password = password;
			this.favColor = favColor;
			this.birthday = birthday;
			this.avatar = avatar;
		}
		
		/**
		 * This method returns the name of the player
		 * @return the name of the player
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * This method returns the nickname of the player
		 * @return the nickname of the player
		 */
		public String getNickname() {
			return nickname;
		}
		
		/**
		 * This method returns the password of the player
		 * @return the password of the player
		 */
		public String getPassword() {
			return password;
		}
		
		/**
		 * This method returns the favorite color of the player
		 * @return the fav color of the player
		 */
		public String getFavColor() {
			return favColor;
		}
		
		/**
		 * This method returns the birthday of the player as a String representation by parsing the selected one for the user
		 * @return a string representation of the birthday of the player
		 */
		public String getBirthday() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String formattedString = birthday.format(formatter); 
			return formattedString;
		}
		
		/**
		 * This method returns the birthday of the player as a LoCalDate representation
		 * @return the localdate object representation of the birthday 
		 */
		public LocalDate getBirthdate() {
			return birthday;
		}
		
		
		/**
		 * This method returns thee avatar of the player
		 * @return the related shape representation of the avatar of the player
		 */
		public Shape getAvatar() {
			return avatar;
		}
//_________________________________________________________________________________________________________________________________________
}
