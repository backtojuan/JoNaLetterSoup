//_________________________________________________________________________________________________________________________________________
	package gui.lettersoupgui;
	import org.controlsfx.control.Notifications;
//_________________________________________________________________________________________________________________________________________
	import javafx.fxml.FXML;
	import javafx.geometry.Pos;
	import javafx.scene.canvas.Canvas;
	import javafx.scene.canvas.GraphicsContext;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.ColorPicker;
	import javafx.scene.control.TextField;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.paint.Color;
	import javafx.stage.Stage;
	import javafx.util.Duration;
	import javafx.scene.input.MouseEvent;
//_________________________________________________________________________________________________________________________________________
	/**
	 * This class manage the necessary attributes and methods to manage and launch the notes special gui 
	 * @author Lina Johanna Salinas Delgado
	 * @author Juan José Valencia Jaramillo
	 * @version V_01_MAY-2019
	 */
	public class NotesController {
	    
		@FXML
	    private Canvas canvasPainter;
	    @FXML
	    private CheckBox eraser;
	    @FXML
	    private ColorPicker colorPckr;
	    @FXML
	    private TextField brushSz;
	    
	    private Stage stage;
	    private GraphicsContext g;
//_________________________________________________________________________________________________________________________________________
	    @FXML 
	    /**
	     * This method initializes the GUI once it has been launched making sure the needed objects are ready to work
	     */
	    private void initialize() {
	        g = canvasPainter.getGraphicsContext2D();	         
	    }
	 //____________________________________________________________________________________________________________________________________
	    /**
	     * This method sets the stage of the window that is going to manage this controller once it has been initialized
	     * @param stage the new stage for this window
	     */
	    public void setStage(Stage stage) {
	    	this.stage = stage;
	    }
	 //____________________________________________________________________________________________________________________________________
	    @FXML
	    /**
	     * this method allows the user to paint and make notes
	     * @param event the event triggered by the user when clicking in the canvas
	     */
	    private void paintonSurface(MouseEvent event) {
	    	try {
	            double size = Double.parseDouble(brushSz.getText());
	            double x = event.getX() - size / 2;
	            double y = event.getY() - size / 2;
	
	            if (eraser.isSelected()) {
	                g.clearRect(x, y, size, size);
	            } else {
	                g.setFill(colorPckr.getValue());
	                g.fillRect(x, y, size, size);
	            }
	    	}
	    	catch(NumberFormatException nfe) {
	    		Notifications.create()
	    		.title("Announcement")
	    		.text("Please set the size of your brush!!")
	    		.graphic(new ImageView(new Image("gui/gamegui/images/error.png")))
	    		.darkStyle()
	    		.position(Pos.TOP_RIGHT)
	    		.hideCloseButton()
    			.hideAfter(Duration.seconds(8))
	    		.show();
	    	}
	    }
//_________________________________________________________________________________________________________________________________________
}
