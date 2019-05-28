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
		 * 
		 * @param name
		 * @param nickname
		 * @param password
		 * @param favColor
		 * @param birthday
		 * @param avatar
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
		 * 
		 * @return
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * 
		 * @return
		 */
		public String getNickname() {
			return nickname;
		}
		
		/**
		 * 
		 * @return
		 */
		public String getPassword() {
			return password;
		}
		
		/**
		 * 
		 * @return
		 */
		public String getFavColor() {
			return favColor;
		}
		
		/**
		 * 
		 * @return
		 */
		public String getBirthday() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String formattedString = birthday.format(formatter); 
			return formattedString;
		}
		
		/**
		 * 
		 * @return
		 */
		public Shape getAvatar() {
			return avatar;
		}
//_________________________________________________________________________________________________________________________________________
}
