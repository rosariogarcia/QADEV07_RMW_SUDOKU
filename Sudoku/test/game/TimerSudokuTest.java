package game;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * 
 * @author RosarioGarcia
 *
 */
public class TimerSudokuTest {

	@Test
	public void timeInitialCanBeCreateWithNoParameters() {
		TimerSudoku newTimer = new TimerSudoku();
		assertNotNull(newTimer);
	}

	@Test
	public void timeInitialCreatedWithNoParamsHasCurrentTimeValue() {
		assertEquals(System.currentTimeMillis(), TimerSudoku.startSudoku(), 0);
	}


	@Test
	public void timeFinalShouldBeDiferenceBeetwenCurrentTimeAndTimeInitial() {
		assertEquals(System.currentTimeMillis() - TimerSudoku.startSudoku(), TimerSudoku.stop(), 0);
	}
}
