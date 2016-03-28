package game.sudouku;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimerTest {

	@Test
	public void timeInitialCanBeCreateWithNoParameters() {
		Timer newTimer= new Timer();
		assertNotNull(newTimer);
	}
	
	@Test
	public void timeInitialCreatedWithNoParamsHasCurrentTimeValue(){
		Timer anotherTimer= new Timer();
		assertEquals(System.currentTimeMillis(), anotherTimer.getTimeInitial(),0);
	}

	@Test
	public void timeFinalShouldBeDiferenceBeetwenCurrentTimeAndTimeInitial(){
		Timer anotherTimer= new Timer();
		assertEquals(System.currentTimeMillis()-anotherTimer.timeInitial,
						anotherTimer.timeSolve(),0);
	}
}
