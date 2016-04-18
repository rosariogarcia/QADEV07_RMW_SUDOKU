package game;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author rosariogarcia
 *
 */
public class GenerateSudokuTest {
	

	@Test
	public void aSudokuGameShouldBeCreateWithDifficultLevelDefined() {

		LevelSudoku level = new LevelSudoku("Easy");
		GenerateSudoku sudoku = new GenerateSudoku(level);
		sudoku.generate();

		assertTrue(sudoku instanceof GenerateSudoku);
	}

	@Test
	public void aSudokuGameShouldBeGeneratedByLevel() {

		LevelSudoku level = new LevelSudoku("Easy");
		GenerateSudoku sudoku = new GenerateSudoku(level);
		sudoku.generate();

		assertTrue(sudoku.generate());
	}
	
	
}
