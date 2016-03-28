package game.sudouku;

public class Timer {
	
	long timeInitial, timeFinal;
	
	public Timer(){
	   this.timeInitial = System.currentTimeMillis();
	}

	public long getTimeInitial() {
		return timeInitial;
	}

	public long timeSolve(){
	   timeFinal = System.currentTimeMillis() - timeInitial;
	   return timeFinal;
	}

}
