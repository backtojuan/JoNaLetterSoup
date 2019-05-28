//_________________________________________________________________________________________________________________________________________
	package threads;
//_________________________________________________________________________________________________________________________________________
	import gui.lettersoupgui.LetterSoupController;
	import javafx.application.Platform;
//_________________________________________________________________________________________________________________________________________
	public class TimeThread extends Thread{
		
		private LetterSoupController lettersoupcontroller;
		private int over;
		private boolean finished;
	//_____________________________________________________________________________________________________________________________________
		public TimeThread(LetterSoupController lettersoupcontroller,boolean finished,int minutes) {
			this.lettersoupcontroller = lettersoupcontroller;
			this.finished = finished;
			this.over = minutes;
		}
	//_____________________________________________________________________________________________________________________________________
		public void finished() {
			finished = true;
		}
	//_____________________________________________________________________________________________________________________________________
		@Override
		public void run() {
			while(finished==false || over!=0) {
				Platform.setImplicitExit(true);
				lettersoupcontroller.runTime();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				over--;
			}
		}	
//_________________________________________________________________________________________________________________________________________
}
	
