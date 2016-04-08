/**
 * 
 */
package game;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author rosariogarcia
 *
 */
public class GenerateSudokuTest {

	@Test
	public void test() {

		GenerateSudoku sudoku = new GenerateSudoku();
		sudoku.generate();

		int [][] grid = sudoku.matrix;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
