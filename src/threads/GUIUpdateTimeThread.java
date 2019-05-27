//_________________________________________________________________________________________________________________________________________
	package threads;
//_________________________________________________________________________________________________________________________________________
	import gui.lettersoupgui.LetterSoupController;
import javafx.application.Platform;
//_________________________________________________________________________________________________________________________________________
	public class GUIUpdateTimeThread extends Thread{
		
		private LetterSoupController lettersoupcontroller;
		private boolean finished;
	//_____________________________________________________________________________________________________________________________________
		public GUIUpdateTimeThread(LetterSoupController lettersoupcontroller) {
			this.lettersoupcontroller = lettersoupcontroller;
		}
	//_____________________________________________________________________________________________________________________________________
		public void isFinished() {
			finished = true;
		}
	//_____________________________________________________________________________________________________________________________________
		@Override
		public void run() {
			while(finished == false) {
				GUIUpdateWithRunnable guiupdaterunnable = new GUIUpdateWithRunnable(lettersoupcontroller);
				Platform.setImplicitExit(true);
				Platform.runLater(guiupdaterunnable);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}	
//_________________________________________________________________________________________________________________________________________
}
	
