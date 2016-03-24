package game.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class LevelTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void isOutOfLimits(int limit) {
        return blankCells.size() >= limit;
    }



    public int getBlankCellsNumber(){
        return topLimit-bottomLimit;
    }
}
