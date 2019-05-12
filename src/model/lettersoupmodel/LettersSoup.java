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
		 * 
		 * @param topic
		 */
		public LettersSoup(Topic topic) {
			this.topic = topic;
		}
	//_____________________________________________________________________________________________________________________________________
		/**
		 * 
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
				}
			}
			else if(topic == Topic.CITIES) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = cities.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
				}
			}
			else if(topic == Topic.NUMBERS) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = numbers.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
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
				}
			}
			else if(topic == Topic.CITIES) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = cities.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
				}
			}
			else if(topic == Topic.NUMBERS) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = numbers.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
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
				}
			}
			else if(topic == Topic.CITIES) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = cities.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
				}
			}
			else if(topic == Topic.NUMBERS) {
				loadCities();
				for(int i=0;i<solution.length;i++) {
					String wordfromfiletext = numbers.get(random.nextInt(animals.size()));
					solution[i] = new Word(wordfromfiletext,random.nextInt(size),random.nextInt(size),wordfromfiletext.length());
				}
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
			
			while(row>0) {
				if(verifyColumn(word.getColumn())) {
					c = Character.toString(word.getName().charAt(i));
					lettersoup[row][column] = c;
					i++;
					row--;
					length--;
				}
				
			}
		}
	//_____________________________________________________________________________________________________________________________________
//_________________________________________________________________________________________________________________________________________
	
	}
