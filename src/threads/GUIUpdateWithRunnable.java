//_________________________________________________________________________________________________________________________________________
	package threads;
//_________________________________________________________________________________________________________________________________________
	import gui.lettersoupgui.LetterSoupController;
	import javafx.application.Platform;
//_________________________________________________________________________________________________________________________________________
	public class GUIUpdateWithRunnable implements Runnable{
		
		private LetterSoupController lettersoupcontroller;
	//_____________________________________________________________________________________________________________________________________
		public GUIUpdateWithRunnable(LetterSoupController lettersoupcontroller) {
			this.lettersoupcontroller = lettersoupcontroller;
		}
	//_____________________________________________________________________________________________________________________________________
		@Override
		public void run() {
			lettersoupcontroller.setTime();
		}	
//_________________________________________________________________________________________________________________________________________
}
	
