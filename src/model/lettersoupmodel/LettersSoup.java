//_________________________________________________________________________________________________________________________________________
	package model.lettersoupmodel;
//_________________________________________________________________________________________________________________________________________
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Random;
	import org.controlsfx.control.Notifications;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import model.gamemodel.Difficulty;
	import model.gamemodel.Game;
//_________________________________________________________________________________________________________________________________________
		/**
		 * This class manages the nedeed methods and attributes to create letters soup.
		 * @author Lina Johanna Salinas Delgado
		 * @author Juan José Valencia Jaramillo
		 * @version V_01 May_2019
		 * 
		 */
		public class LettersSoup extends Game{
		
		private String[][] lettersoup;
		private Topic topic;
		private int size;
		
		private ArrayList<String> animals;
		private ArrayList<String> cities;
		private ArrayList<String> numbers; 
		
		private Word[] solution;
		private Random random;
//_________________________________________________________________________________________________________________________________________
		/**
		 * <b>Letters Soup Constructor</b><br>
		 * This method allows to construct objects of type letters soup<br>
		 * @param topic the topic that is going to determinate the words inside the letters soup
		 * @param difficultylevel the difficultylevel that is going to determinate the words to be found
		 */
		public LettersSoup(Topic topic,Difficulty difficultylevel){
			super(difficultylevel);
			this.topic = topic;
			animals = new ArrayList<>();
			cities = new ArrayList<>();
			numbers = new ArrayList<>();
			random = new Random();
			generateLetterSoup(topic);
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method returns the lettersoup matrix to be manipulated and be printed, modified, etc.<br>
		 * <b>Pre:</b> the lettersoup exists.<br>
		 * @return the matrix of Strings that represents the lettersoup
		 */
		public String[][] getLetterSoup() {
			return lettersoup;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method gets the solution for the current lettersoup 
		 * @return an array that contains the current solution for this lettersoup
		 */
		public Word[] getSolution(){
			return solution;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method gets the topic related for the current lettersoup
		 * @return the related topic for this lettersoup
		 */
		public Topic getTopic() {
			return topic;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method generates a random word from the dictionaries of words in the data folder
		 * @return the Current String that represents a word taken out for a topic related dictionary
		 */
		private String generateRandomWord() {
			String randomWord = "";
			if(topic == Topic.ANIMALS) {
				randomWord = animals.get(random.nextInt(animals.size()));
			}
			else if(topic == Topic.CITIES) {
				randomWord = cities.get(random.nextInt(cities.size()));
			}
			else {
				randomWord = numbers.get(random.nextInt(numbers.size()));
			}
			return randomWord;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method loads the dictionaries file text that contains the words to generate the lettersoup
		 * <b>Pre:</b> the textfile with the words exists
		 * <b>Pos:</b> the dictionaries of words are being loaded
		 */
		private void load(){
			try {
				if(topic == Topic.ANIMALS) {
					loadAnimals();
				}
				else if(topic == Topic.CITIES) {
					loadCities();
				}
				else {
					loadNumbers();
				}
			}
			catch(IOException ioe) {
				Notifications.create()
				.title("Announcement")
				.text("The dictionaries cannot be found please make sure there are file texts in the data folder of the project")
				.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
				.darkStyle();
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method initialize the size of the lettersoup and the number of words that this lettersoup is going to have
		 * depending on its difficulty level
		 */
		private void initData() {
			if(this.getDifficultylevel() == Difficulty.BASIC) {
				size = 10;
				solution = new Word[3];
			}
			else {
				size = 15;
				solution = new Word[6];
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method loads the textfile that contains the words related with animals topic<br>
		 * <b>Pos:</b> The textfile with the topic words about animals is read.
		 * @param path the path related to the dictionarie of words
		 * @throws IOException
		 */
		private void loadAnimals() throws IOException {
			String path = "data/dictionaries(lettersoup)/animals.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
				while(line!=null) {
					animals.add(line);
					line = br.readLine();
				}
			br.close();
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method loads the textfile that contains the words related with cities topic<br>
		 * <b>Pos:</b> The textfile with the topic words about cities is read.
		 * @param path the path related to the dictionarie of words
		 * @throws IOException
		 */
		private void loadCities() throws IOException {
			String path = "data/dictionaries(lettersoup)/cities.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
				while(line!=null) {
					cities.add(line);
					line = br.readLine();
				}
			br.close();
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method loads the textfile that contains the words related with numbers topic<br>
		 * <b>Pos:</b> The textfile with the topic words about numbers is read.
		 * @param path the path related to the dictionarie of words
		 * @throws IOException
		 */
		private void loadNumbers() throws IOException {
			String path = "data/dictionaries(lettersoup)/numbers.txt";
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
				while(line!=null) {
					numbers.add(line);
					line = br.readLine();
				}
			br.close();
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method generates the whole lettersoup depending of the topic and the difficulty level. adds the word by its random directions
		 * checks that the words are not repited and finally fills the whole soup in the empty spaces.
		 * @param topic the related topic for this lettersoup
		 */
		private void generateLetterSoup(Topic topic){
			initData();
			lettersoup = new String[size][size]; 
			load();
			for(int i=0;i<solution.length;i++) {
				String wordfromfiletext = generateRandomWord();
				solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
				checkForNonRepitedElements(solution[i], i);
				addWord(solution[i]);
			}
			fillSoup();
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method fills the empty spaces of the current lettersoup
		 */
		private void fillSoup() {
			for(int i=0;i<lettersoup.length;i++) {
				for(int j=0;j<lettersoup[i].length;j++) {
					if(lettersoup[i][j] == null) {
						if(topic == Topic.ANIMALS) {
							lettersoup[i][j] = Character.toString(animals.get(random.nextInt(animals.size())).charAt(0));
						}
						else if(topic == Topic.CITIES) {
							lettersoup[i][j] = Character.toString(cities.get(random.nextInt(cities.size())).charAt(1));
						}
						else {
							lettersoup[i][j] = Character.toString(numbers.get(random.nextInt(numbers.size())).charAt(2));
						}
					}
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method checks that the current generated word is not repited comparing it with the past generated random words
		 * @param word the current word that needs to be check with the past generateed ones
		 * @param pos the current pos for this word.
		 */
		private void checkForNonRepitedElements(Word word, int pos) {
			String wordfromfiletext = "";
			boolean nonrepited = false;
			if(countSolutions()>1) {
				for(int i=0;i<solution.length && nonrepited==false;i++) {					
					if(solution[i].getName().equals(word.getName())) {
						if(topic == Topic.ANIMALS) {
							wordfromfiletext = animals.get(random.nextInt(animals.size()));
						}
						else if(topic == Topic.CITIES) {
							wordfromfiletext = cities.get(random.nextInt(cities.size()));
						}
						else if(topic == Topic.NUMBERS) {
							wordfromfiletext = numbers.get(random.nextInt(numbers.size()));
						}
						solution[pos] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					}
					else {
						nonrepited = true;
					}
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method determines the adding process of the word
		 * @param word the word that is going to be add in the lettersoup
		 */
		private void addWord(Word word) {
			Direction dir = word.getDirection();
			int column = word.getColumn();
			int row = word.getRow();
			int length = word.getLength()-1;
			switch(dir) {
				case DOWN:
					addWordtoDown(word,row,column,length);
				break;
				case UP:
					addWordToUp(word,row,column,length);
				break;
				case LEFT:
					addWordToLeft(word,row,column,length);
				break;
				case RIGHT:
					addWordToRight(word,row,column,length);
				break;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method verifies that the current column has space so the word can be place on it
		 * @param column the current column that is going to be verified
		 * @return a boolean that confirms wether this column is empty or not
		 */
		private boolean verifyColumn(int column) {
			boolean empty = true;
			for(int i=0;i<lettersoup.length-1&&empty;i++) {
				if(lettersoup[i][column]!=null) {
					empty = false;
				}
			}
			return empty;
		}
		/**
		 * This method verifies that the current row has space so the word can be place on it
		 * @param column the current row that is going to be verified
		 * @return a boolean that confirms wether this row is empty or not
		 */
		private boolean verifyRow(int row) {

			boolean empty = true;
			for(int i=0;i<lettersoup.length-1&&empty;i++) {
				if(lettersoup[row][i]!=null){
					empty = false;
				}
			}
			return empty;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method adds a word to the upper direction (vertical)
		 * @param word the word that is going to be added
		 * @param row the current row where the word is going to be place
		 * @param column the current column where the word is going to be place
		 * @param length the current length for the word that is going to be added
		 */
		private void addWordToUp(Word word, int row, int column, int length){
			String c;
			int i = 0;
			
			if(row<length) {
				word.setRow(length);
				row = word.getRow();
			}
			
			boolean spacec = verifyColumn(column);
			boolean spacer = verifyRow(row);
			while(spacec==false && spacer == false) {
				column = random.nextInt(lettersoup.length-1);
				spacec = verifyColumn(column);
				spacer = verifyRow(row);	
			}
			word.setColumn(column);
			
			while(i<=length) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method adds a word to the inferior direction (vertical)
		 * @param word the word that is going to be added
		 * @param row the current row where the word is going to be place
		 * @param column the current column where the word is going to be place
		 * @param length the current length for the word that is going to be added
		 */
		private void addWordtoDown(Word word, int row, int column, int length){
			String c;
			int i = 0;
			
			if((lettersoup.length-1)-row<length) {
				word.setRow((lettersoup.length-1)-length);
				row = word.getRow();
			}
			
			boolean spacec = verifyColumn(column);
			boolean spacer = verifyRow(row);
			while(spacec==false && spacer==false){
				column = random.nextInt(lettersoup.length-1);
				spacec = verifyColumn(column);
				spacer = verifyRow(row);
			}
			word.setColumn(column);
			
			while(i<=length) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row++;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method adds a word to the western direction (horizontal)
		 * @param word the word that is going to be added
		 * @param row the current row where the word is going to be place
		 * @param column the current column where the word is going to be place
		 * @param length the current length for the word that is going to be added
		 */
		private void addWordToLeft(Word word, int row, int column, int length){
			String c;
			int i = 0;
			
			if(column<=length) {
				word.setColumn(length);
				column = word.getColumn();
			}
			boolean spacec = verifyColumn(column);
			boolean spacer = verifyRow(row);
			
			while((spacec==false)&&(spacer==false)){
				row = random.nextInt(lettersoup.length-1);
				spacec = verifyColumn(column);
				spacer = verifyRow(row);
			}			
			word.setRow(row);
			
			while(i<=length) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				column--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method adds a word to the eastern direction (horizontal)
		 * @param word the word that is going to be added
		 * @param row the current row where the word is going to be place
		 * @param column the current column where the word is going to be place
		 * @param length the current length for the word that is going to be added
		 */
		private void addWordToRight(Word word, int row, int column, int length){
			String c;
			int i = 0;
			
			if(column+length>lettersoup.length-1) {
				word.setColumn((lettersoup.length-1)-length);
				column = word.getColumn();
			}
			boolean spacec = verifyColumn(column);
			boolean spacer = verifyRow(row);
			
			while((verifyRow(row)==false)&&verifyColumn(column)==false){
				row = random.nextInt(lettersoup.length-1);
				spacec = verifyColumn(column);
				spacer = verifyRow(row);
			}
			word.setRow(row);
			
			while(i<=length){
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				column++;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method sets the row and the column for the solution once it had been changed due to problems in the space 
		 * @param i the row of the word that needs to be find and replaced
		 * @param j the column of the word that needs to be find and replaced
		 * @param row the new row value for the searched word
		 * @param column the new column value for the searched word
		 */
		private void setSolution(int i,int j, int row, int column) {
			Word word = null;
			for(int k=0;k<solution.length;k++) {
				word = solution[k];
				if(word.getRow()==i && word.getColumn()==j) {
					word.setRow(row);
					word.setColumn(column);
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method checks if the current word makes part of the solution for this lettersoup
		 * @param word the word that is going to be check
		 * @return a boolean that confirms wether this word makes part of the solution for this lettersoup or not
		 */
		public boolean checkSolution(Word word) {
			boolean correct = false;
			System.out.println(word.getName());
			for(int i=0;i<solution.length&&correct==false;i++) {
				if(solution[i].getName().equals(word.getName())) {
					correct = true;
				}
			}
			return correct;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method counts the current numbers of solution that had been added during the proccess of random generation
		 * @return the number of solutions that are in the current moment of adding 
		 */
		private int countSolutions() {
			int size=0;
			for(int i=0;i<solution.length;i++) {
				if(solution[i]!=null) {
					size++;
				}
			}
			return size;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method returns the size of a word related with its position
		 * @param i the postion of a word that needs to be searched in the solution array of this letter soup
		 * @return the size of a word searched with its position
		 */
		public int getLengthFromAPosition(int i) {
			int length = 0;
			for(Word word : solution) {
				if(word.getRow()==i) {
					length = word.getLength()-1;
				}
			}
			return length;
		}
//_________________________________________________________________________________________________________________________________________
}
