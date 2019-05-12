//___________________________________________PACKAGE OF THIS CLASS_________________________________________________________________________
	package model.lettersoupmodel;
//___________________________________________USED PACKAGES FOR THIS CLASS__________________________________________________________________
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Random;
//___________________________________________ATTRIBUTES____________________________________________________________________________________
	/**
	 * This class manages the nedeed methods and attributes to create letters soup.
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01 May_2019
	 * 
	 */
	public class LettersSoup {
	
	private String[][] lettersoup;
	private Difficulty difficultylevel;
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
			this.topic = topic;
			this.difficultylevel = difficultylevel;
			init(this.difficultylevel);
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * @throws IOException 
		 * 
		 */
		public void init(Difficulty difficultylevel) throws IOException {
			if(difficultylevel == Difficulty.BASIC) {
				generateBasicLetterSoup();
			}
			else if(difficultylevel == Difficulty.INTERMEDIUM) {
				generateIntermediumLetterSoup();
			}
			else if(difficultylevel == Difficulty.HARD) {
				generateHardLetterSoup();
			}
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
		public void generateBasicLetterSoup() throws IOException {
			size = 15;
			lettersoup = new String[size][size]; 
			solution = new Word[5];
			if(topic == Topic.ANIMALS ) {
				loadAnimals();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = animals.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
					determinateAddOfWord(solution[i]);
				}
			}
			else if(topic == Topic.CITIES) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = cities.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
					determinateAddOfWord(solution[i]);
				}
			}
			else if(topic == Topic.NUMBERS) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = numbers.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
					determinateAddOfWord(solution[i]);
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @throws IOException
		 */
		public void generateIntermediumLetterSoup() throws IOException {
			size = 30;
			lettersoup = new String[size][size]; 
			solution = new Word[12];
			if(topic == Topic.ANIMALS ) {
				loadAnimals();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = animals.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
					determinateAddOfWord(solution[i]);
				}
			}
			else if(topic == Topic.CITIES) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = cities.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
					determinateAddOfWord(solution[i]);
				}
			}
			else if(topic == Topic.NUMBERS) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = numbers.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
					determinateAddOfWord(solution[i]);
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 * @throws IOException
		 */
		public void generateHardLetterSoup() throws IOException {
			size = 50;
			lettersoup = new String[size][size]; 
			solution = new Word[20];
			if(topic == Topic.ANIMALS ) {
				loadAnimals();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = animals.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
					determinateAddOfWord(solution[i]);
				}
			}
			else if(topic == Topic.CITIES) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = cities.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
					determinateAddOfWord(solution[i]);
				}
			}
			else if(topic == Topic.NUMBERS) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = numbers.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
					determinateAddOfWord(solution[i]);
				}
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void determinateAddOfWord(Word word) {
			Direction dir = word.getDirection();
			switch(dir) {
				case DOWN:
					addWordtoDown(word);
				break;
				case UP:
					addWordToUp(word);
				break;
				case LEFT:
					addWordToLeft(word);
				break;
				case RIGHT:
					addWordToRight(word);
				break;
				case NORTHWEST:
					addWordToNorthWest(word);
					break;
				case NORTHEAST:
					addWordToNorthEast(word);
					break;
				case SOUTHWEST:
					addWordToSouthWest(word);
					break;
				case SOUTHEAST:
					addWordToSouthEast(word);
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
				if(lettersoup[i][column] == null) {
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
				if(lettersoup[row][i] == null){
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
				if(lettersoup[row][column] == null) {
					empty = false;
				}
				row--;
				column--;
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
				if(lettersoup[row][column] == null) {
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
				if(lettersoup[row][column] == null) {
					empty = false;
				}
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
			for(int i=0;i<word.getLength()&&empty;i++) {
				if(lettersoup[row][column] == null) {
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
		public void addWordToUp(Word word) {
			String c;
			int row = word.getRow();
			int column = word.getColumn();
			int length = word.getLength();
			int i = 0;
	
			while(verifyColumn(word.getColumn())==false) {
				word.setColumn(random.nextInt(lettersoup.length));
			}
			
			while(length>=0) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row--;
				length--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordtoDown(Word word) {
			String c;
			int row = word.getRow();
			int column = word.getColumn();
			int length = word.getLength();
			int i = 0;
			
			while(verifyColumn(word.getColumn())==false) {
				word.setColumn(random.nextInt(lettersoup.length));
			}
			
			while(length>=0) {
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
		public void addWordToLeft(Word word) {
			String c;
			int row = word.getRow();
			int column = word.getColumn();
			int length = word.getLength();
			int i = 0;
			
			while(verifyColumn(word.getRow())==false) {
				word.setRow(random.nextInt(lettersoup.length));
			}
			
			while(length>=0) {
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
		public void addWordToRight(Word word) {
			String c;
			int row = word.getRow();
			int column = word.getColumn();
			int length = word.getLength();
			int i = 0;
			
			while(verifyColumn(word.getRow())==false) {
				word.setRow(random.nextInt(lettersoup.length));
			}
			
			while(length>=0) {
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
		public void addWordToNorthWest(Word word) {
			String c;
			int row = word.getRow();
			int column = word.getColumn();
			int length = word.getLength();
			int i = 0;
			
			while(verifyNorthWestDiagonal(word)==false) {
				word.setRow(random.nextInt(lettersoup.length));
				word.setColumn(random.nextInt(lettersoup.length));
			}
			
			while(length>=0) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row--;
				column--;
				length--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToNorthEast(Word word) {
			String c;
			int row = word.getRow();
			int column = word.getColumn();
			int length = word.getLength();
			int i = 0;
			
			while(verifyNorthEastDiagonal(word)==false) {
				word.setRow(random.nextInt(lettersoup.length));
				word.setColumn(random.nextInt(lettersoup.length));
			}
			
			while(length>=0) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row--;
				column++;
				length--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToSouthWest(Word word) {
			String c;
			int row = word.getRow();
			int column = word.getColumn();
			int length = word.getLength();
			int i = 0;
			
			while(verifySouthWestDiagonal(word)==false) {
				word.setRow(random.nextInt(lettersoup.length));
				word.setColumn(random.nextInt(lettersoup.length));
			}
			
			while(length>=0) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row++;
				column--;
				length--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
		 */
		public void addWordToSouthEast(Word word) {
			String c;
			int row = word.getRow();
			int column = word.getColumn();
			int length = word.getLength();
			int i = 0;
			
			while(verifySouthEastDiagonal(word)==false) {
				word.setRow(random.nextInt(lettersoup.length));
				word.setColumn(random.nextInt(lettersoup.length));
			}
			
			while(length>=0) {
				c = Character.toString(word.getName().charAt(i));
				lettersoup[row][column] = c;
				i++;
				row++;
				column++;
				length--;
			}
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * This method
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
//_________________________________________________________________________________________________________________________________________
	
	}
