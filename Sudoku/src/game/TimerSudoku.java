package game;

import java.util.Timer;
import java.sql.Time;


/**
 * 
 * @author RosarioGarcia
 * This class calculate the time 
 * that an algorithm take to solver 
 * a sudoko game
 *
 */
public class TimerSudoku {

	static long totalTime;
	
	/**
	 *  This method take the start time
	 *  when the algorithm solve the sudoku game
	 */
	public static long startSudoku(){
		return System.currentTimeMillis();
	}
	
	/**
	 * This method return the time that
	 * the algorithm solve the sudoko game
	 * 
	 * @return System.currentTimeMillis() - startSudoku()
	 */
	public static long stop(){
		return System.currentTimeMillis() - startSudoku();
	}

}
