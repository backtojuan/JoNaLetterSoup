//___________________________________________PACKAGE OF THIS CLASS_________________________________________________________________________
	package model.lettersoupmodel;
//___________________________________________USED PACKAGES FOR THIS CLASS__________________________________________________________________
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Random;
	import model.gamemodel.Difficulty;
	import model.gamemodel.Game;
//___________________________________________ATTRIBUTES____________________________________________________________________________________
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
//_________________________________________METHODS FOR THIS CLASS__________________________________________________________________________
		/**
		 * <b>Letters Soup Constructor</b><br>
		 * This method allows to construct objects of type letters soup
		 * @param topic the topic that is going to determinate the words inside the letters soup
		 * @throws IOException 
		 */
		public LettersSoup(Topic topic,Difficulty difficultylevel) throws IOException {
			super(difficultylevel);
			this.topic = topic;
			animals = new ArrayList<>();
			cities = new ArrayList<>();
			numbers = new ArrayList<>();
			random = new Random();
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method loads the textfile that contains the words related with animals topic<br>
		 * <b>Pos:</b> The textfile with the topic words about animals is read.
		 * @param path
		 * @throws IOException
		 */
		public void loadAnimals() throws IOException {
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
		 * 
		 * @param path
		 * @throws IOException
		 */
		public void loadCities() throws IOException {
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
		 * 
		 * @param path
		 * @throws IOException
		 */
		public void loadNumbers() throws IOException {
			String path = "data/dictionaries(lettersoup)/cities.txt";
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
		 * @throws IOException 
		 * 
		 */
		public void generateBasicLetterSoup(Topic topic) throws IOException {
			size = 15;
			lettersoup = new String[size][size]; 
			solution = new Word[5];
			if(topic == Topic.ANIMALS ) {
				loadAnimals();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = animals.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					checkForNonRepitedElements(solution[i], i);
					determinateAddOfWord(solution[i]);
				}
				fillSoupWithLetters();
			}
			else if(topic == Topic.CITIES) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = cities.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					checkForNonRepitedElements(solution[i], i);
					determinateAddOfWord(solution[i]);
				}
				fillSoupWithLetters();
			}
			else if(topic == Topic.NUMBERS) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = numbers.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					checkForNonRepitedElements(solution[i], i);
					determinateAddOfWord(solution[i]);
				}
				fillSoupWithNumbers();
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @throws IOException
		 */
		public void generateIntermediumLetterSoup(Topic topic) throws IOException {
			size = 30;
			lettersoup = new String[size][size]; 
			solution = new Word[12];
			if(topic == Topic.ANIMALS ) {
				loadAnimals();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = animals.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					checkForNonRepitedElements(solution[i], i);
					determinateAddOfWord(solution[i]);
				}
				fillSoupWithLetters();
			}
			else if(topic == Topic.CITIES) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = cities.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					checkForNonRepitedElements(solution[i], i);
					determinateAddOfWord(solution[i]);
				}
				fillSoupWithLetters();
			}
			else if(topic == Topic.NUMBERS) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = numbers.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					checkForNonRepitedElements(solution[i], i);
					determinateAddOfWord(solution[i]);
				}
				fillSoupWithNumbers();
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @throws IOException
		 */
		public void generateHardLetterSoup(Topic topic) throws IOException {
			size = 50;
			lettersoup = new String[size][size]; 
			solution = new Word[20];
			if(topic == Topic.ANIMALS ) {
				loadAnimals();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = animals.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					checkForNonRepitedElements(solution[i], i);
					determinateAddOfWord(solution[i]);
				}
				fillSoupWithLetters();
			}
			else if(topic == Topic.CITIES) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = cities.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					checkForNonRepitedElements(solution[i], i);
					determinateAddOfWord(solution[i]);
				}
				fillSoupWithLetters();
			}
			else if(topic == Topic.NUMBERS) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = numbers.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size-1),random.nextInt(size-1),wordfromfiletext.length());
					checkForNonRepitedElements(solution[i], i);
					determinateAddOfWord(solution[i]);
				}
				fillSoupWithNumbers();
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void fillSoupWithLetters() {
			for(int i=0;i<lettersoup.length;i++) {
				for(int j=0;j<lettersoup[i].length;j++) {
					if(lettersoup[i][j] == null) {
						if(topic == Topic.ANIMALS) {
							lettersoup[i][j] = Character.toString(animals.get(random.nextInt(animals.size())).charAt(0));
						}
						else if(topic == Topic.CITIES) {
							lettersoup[i][j] = Character.toString(cities.get(random.nextInt(cities.size())).charAt(0));
						}
					}
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void fillSoupWithNumbers() {
			for(int i=0;i<lettersoup.length;i++) {
				for(int j=0;j<lettersoup[i].length;j++) {
					if(lettersoup[i][j] == null) {
						lettersoup[i][j] = Character.toString(numbers.get(random.nextInt(animals.size())).charAt(0));
					}
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void checkForNonRepitedElements(Word word, int pos) {
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
		 * 
		 */
		public void determinateAddOfWord(Word word) {
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
				case NORTHWEST:
					addWordToNorthWest(word,row,column,length);
					break;
				case NORTHEAST:
					addWordToNorthEast(word,row,column,length);
					break;
				case SOUTHWEST:
					addWordToSouthWest(word,row,column,length);
					break;
				case SOUTHEAST:
					addWordToSouthEast(word,row,column,length);
					break;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public boolean verifyColumn(int column) {
			boolean empty = true;
			for(int i=0;i<lettersoup.length&&empty;i++) {
				if(lettersoup[i][column] != null) {
					empty = false;
				}
			}
			return empty;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public boolean verifyRow(int row) {
			boolean empty = true;
			for(int i=0;i<lettersoup.length&&empty;i++) {
				if(lettersoup[row][i] != null){
					empty = false;
				}
			}
			return empty;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public boolean verifyNorthWestDiagonal(Word word) {
			boolean empty = true;
			int row = word.getRow();
			int column = word.getColumn();
			for(int i=0;i<word.getLength()&&empty;i++) {
				if(lettersoup[row][column] != null) {
					empty = false;
				}
			}
			return empty;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public boolean verifyNorthEastDiagonal(Word word) {
			boolean empty = true;
			int row = word.getRow();
			int column = word.getColumn();
			for(int i=0;i<word.getLength()&&empty;i++) {
				if(lettersoup[row][column] != null) {
					empty = false;
				}
				row--;
				column++;
			}
			return empty;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public boolean verifySouthWestDiagonal(Word word) {
			boolean empty = true;
			int row = word.getRow();
			int column = word.getColumn();
			for(int i=0;i<word.getLength()&&empty;i++){
				if(lettersoup[row][column] != null) {
					empty = false;
				}
				System.out.println(row);
				System.out.println(column);
				System.out.println();
				row++;
				column--;
			}
			return empty;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public boolean verifySouthEastDiagonal(Word word) {
			boolean empty = true;
			int row = word.getRow();
			int column = word.getColumn();
			System.out.println("verify");
			System.out.println(row);
			System.out.println(column);		
			for(int i=0;i<word.getLength()&&empty;i++) {
				if(lettersoup[row][column] != null) {
					empty = false;
				}
				row++;
				column++;
			}
			return empty;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToUp(Word word, int row, int column, int length) {
			String c;
			int i = 0;
			
			System.out.println(word);
			
			while(verifyColumn(word.getColumn())==false) {
				word.setColumn(random.nextInt(lettersoup.length-1));
			}
			if(row!=(length-1)) {
				word.setRow(length);
				row = word.getRow();
			}
			while(i<=length) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordtoDown(Word word, int row, int column, int length) {
			String c;
			int i = 0;
		
			System.out.println(word);
			
			while(verifyColumn(column)==false) {
				word.setColumn(random.nextInt(lettersoup.length-1));
			}
			while((lettersoup.length-1)-row!=length) {
				row--;
				if((lettersoup.length-1)-row==length){
					word.setRow(row);
					row = word.getRow();
				}
			}
			while(length>=0 && i<word.getLength()) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row++;
				length--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToLeft(Word word, int row, int column, int length) {
			String c;
			int i = 0;
			
			while(verifyRow(row)==false) {
				word.setRow(random.nextInt(lettersoup.length-1));
			}
			
			if(column<=length) {
				word.setColumn(length);
				column = word.getColumn();
			}
			
			while(length>=0 && i<word.getLength()) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				column--;
				length--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToRight(Word word, int row, int column, int length) {
			String c;
			int i = 0;
			
			System.out.println(word);
			
			while(verifyColumn(word.getRow())==false) {
				word.setRow(random.nextInt(lettersoup.length-1));
			}
			while(column+length>lettersoup.length-1) {
				column--;
				if(column+length==lettersoup.length-1) {
					word.setColumn(column);
				}
			}
			while(length>=0 && i<word.getLength()) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				column++;
				length--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToNorthWest(Word word,int row, int column, int length) {
			String c;
			int i = 0;
				
			while(verifyNorthWestDiagonal(word)==false) {
				word.setRow(random.nextInt(lettersoup.length-1));
				word.setColumn(random.nextInt(lettersoup.length-1));
			}
			if(column<length) {
				word.setColumn(column);
				word.setRow(row);
			}
			while(length>=0 && i<word.getLength()) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row--;
				column--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToNorthEast(Word word, int row, int column, int length) {
			String c;
			int i = 0;
			
			while((lettersoup.length-1)-column<length || row<length) {
				column = random.nextInt(lettersoup.length);
				row = random.nextInt(lettersoup.length);
				if((lettersoup.length-1)-column>=length && row>= length) {
					word.setColumn(column);
					word.setRow(row);
				}
				
			}
			while(i<=length) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row--;
				column++;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToSouthWest(Word word,int row, int column, int length) {
			String c;
			int i = 0;
	
			while(row+length>(lettersoup.length-1) || length>column) {
				row = random.nextInt(lettersoup.length-1);
				column = random.nextInt(lettersoup.length-1);
				if(row+length<=(lettersoup.length-1) && length<=column){
					word.setRow(row);
					word.setColumn(column);
				}
			}			
			while(verifySouthWestDiagonal(word)==false) {
				word.setRow(random.nextInt(lettersoup.length-1));
				word.setColumn(random.nextInt(lettersoup.length-1));
			}
			while(i<=length) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row++;
				column--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToSouthEast(Word word, int column, int row, int length) {
			String c;
			int i = 0;
			while((lettersoup.length-1)-column<length || (row+length>lettersoup.length-1)) {
				column = random.nextInt(lettersoup.length-1);
				row = random.nextInt(lettersoup.length-1);
				if((lettersoup.length-1)-column>=length && row+length<=(lettersoup.length-1)){
					word.setColumn(column);
					word.setRow(row);
				}
			}
			while(verifySouthEastDiagonal(word)==false) {
				word.setRow(random.nextInt(lettersoup.length-1));
				word.setColumn(random.nextInt(lettersoup.length-1));
			}
			while(i<=length) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row++;
				column++;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public boolean checkSolution(Word word) {
			boolean correct = false;
			for(int i=0;i<solution.length&&correct==false;i++) {
				if(solution[i].getName() == word.getName()) {
					correct = true;
				}
			}
			return correct;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @return
		 */
		public int countSolutions() {
			int size=0;
			for(int i=0;i<solution.length;i++) {
				if(solution[i]!=null) {
					size++;
				}
			}
			return size;
		}
	//_____________________________________________________________________________________________________________________________________
		public String[][] getLetterSoup() {
			return lettersoup;
		}
//_________________________________________________________________________________________________________________________________________
}
