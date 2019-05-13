//___________________________________________PACKAGE OF THIS CLASS_________________________________________________________________________

	package gui.lettersoupgui;
//___________________________________________USED PACKAGES FOR THIS CLASS__________________________________________________________________
	
	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import javafx.scene.image.Image;
//___________________________________________ATTRIBUTES____________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and launch the User Interface.
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	public class Main extends Application{
		
//_________________________________________METHODS FOR THIS CLASS__________________________________________________________________________
		
		@Override
		public void start(Stage stage) throws Exception{
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("lettersoup.fxml"));
			
			Parent root = loader.load();
			
			LetterSoupController lsc = loader.getController();
			lsc.setStage(stage);
			
			Scene scene = new Scene(root);
			stage.setTitle("Letters Soup Game");
			stage.setScene(scene);
		}
	//___________________________________________________________________________________________________________________________________
	
		public static void main(String[]args){
			launch(args);
		}	
//___________________________________________________________________________________________________________________________________
}
