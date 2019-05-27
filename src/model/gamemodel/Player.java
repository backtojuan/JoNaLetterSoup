//_________________________________________________________________________________________________________________________________________
	package model.gamemodel;
//_________________________________________________________________________________________________________________________________________
	import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//_________________________________________________________________________________________________________________________________________
	
	public class Player {
		
		private String name;
		private String nickname;
		private String password;
		private String favColor;
		private LocalDate birthday;
		private Shape avatar;
//_________________________________________________________________________________________________________________________________________
		
		public Player(String name,String nickname, String password, String favColor, LocalDate birthday, Shape avatar) {
			this.name = name;
			this.nickname = nickname;
			this.password = password;
			this.favColor = favColor;
			this.birthday = birthday;
			this.avatar = avatar;
		}

		public String getName() {
			return name;
		}

		public String getNickname() {
			return nickname;
		}

		public String getPassword() {
			return password;
		}

		public String getFavColor() {
			return favColor;
		}

		public String getBirthday() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String formattedString = birthday.format(formatter); 
			return formattedString;
		}

		public Shape getAvatar() {
			return avatar;
		}
//_________________________________________________________________________________________________________________________________________
}
