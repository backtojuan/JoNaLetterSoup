//_________________________________________________________________________________________________________________________________________

	package gui.lettersoupgui;
//_________________________________________________________________________________________________________________________________________
	
	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import javafx.scene.image.Image;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and launch the User Interface.
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_May-2019
	 */
	public class Main extends Application{
//_________________________________________________________________________________________________________________________________________
		
		@Override
		public void start(Stage stage) throws Exception{
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("lettersoup.fxml"));
			
			Parent root = loader.load();
			
			LetterSoupController lsc = loader.getController();
			lsc.setStage(stage);
			
			Image image = new Image("gui/gamegui/images/icon.png");
			stage.getIcons().add(image);
			
			Scene scene = new Scene(root);
			stage.setTitle("Letters Soup Game");
			stage.setScene(scene);
			stage.show();
;		}
	//___________________________________________________________________________________________________________________________________
		public static void main(String[]args){
			launch(args);
		}	
//___________________________________________________________________________________________________________________________________
}
