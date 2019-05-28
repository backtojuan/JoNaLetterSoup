//_________________________________________________________________________________________________________________________________________
	package threads;
//_________________________________________________________________________________________________________________________________________
	import gui.lettersoupgui.LetterSoupController;
//_________________________________________________________________________________________________________________________________________
	public class LoadingThread extends Thread{
		
		private LetterSoupController lettersoupcontroller;
	//_____________________________________________________________________________________________________________________________________
		public LoadingThread(LetterSoupController lettersoupcontroller) {
			this.lettersoupcontroller = lettersoupcontroller;
		}
	//_____________________________________________________________________________________________________________________________________
		@Override
		public void run() {
			int indicator = 1;
			lettersoupcontroller.disableButton(true);
			while(indicator<=4) {
				lettersoupcontroller.setFill(indicator);
				if(indicator==4) {
					lettersoupcontroller.disableButton(false);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				indicator++;
			}
		}	
//_________________________________________________________________________________________________________________________________________
}
	