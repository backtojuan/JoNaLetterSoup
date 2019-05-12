//___________________________________________________package of the class___________________________________________________________

	package gui.lettersoupgui;

//__________________________________________________________________________________________________________________________________
	
	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	import javafx.scene.image.Image;
//__________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and launch the User Interface.
	 * 
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_April-2019
	 */
	public class Main extends Application{
		@Override
		public void start(Stage stage) throws Exception{
			Parent root =
					FXMLLoader.load(getClass().getResource("LetterSoup.fxml"));
	
			Scene scene = new Scene(root);
			stage.setTitle("Letters Soup Game");
			stage.resizableProperty().setValue(Boolean.TRUE);
			stage.setScene(scene);
		}
//___________________________________________________________________________________________________________________________________
	
	public static void main(String[]args){
		launch(args);
	}
	
//___________________________________________________________________________________________________________________________________
}
