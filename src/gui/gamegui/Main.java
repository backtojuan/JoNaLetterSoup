//___________________________________________PACKAGE OF THIS CLASS_________________________________________________________________________

	package gui.gamegui;
//___________________________________________USED PACKAGES FOR THIS CLASS__________________________________________________________________
	
	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import javafx.scene.image.Image;
	import javafx.scene.media.Media;
	import javafx.scene.media.MediaPlayer;
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
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
			
			Parent root = loader.load();
			
			GameController gc = loader.getController();
			gc.setStage(stage);
			
			Scene scene = new Scene(root);
			stage.setTitle("Main Game Menu");
			
			Image image = new Image("gui/gamegui/images/icon.png");
			stage.getIcons().add(image);
			
			Media media = new Media("file://gui/gamegui/music/backgroundmusic.mp3");
			MediaPlayer player = new MediaPlayer(media);
			player.play();
			
			stage.setScene(scene);
			stage.show();
		}
	//___________________________________________________________________________________________________________________________________
	
		public static void main(String[]args){
			launch(args);
		}	
//___________________________________________________________________________________________________________________________________
}
