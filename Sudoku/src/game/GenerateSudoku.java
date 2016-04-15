package game;

import java.util.Random;
import branchandbound.BranchAndBound;

/**
 * 
 * @author rosariogarcia
 *
 */
public class GenerateSudoku {

	public int[][] sudokuPuzzle;
	private LevelSudoku level;

	/**
	 * Construct initialize the difficult level value.
	 * 
	 * @param level,
	 *            its is the difficult level of the Sudoku game.
	 */
	public GenerateSudoku(LevelSudoku level) {
		this.level = level;
	}

	/**
	 * This method generate a Sudoku game, return the Sudoku game if is
	 * generated, return null when the Sudoku game not is generated.
	 */
	public boolean generate() {
		int[][] sudokuGrid = new int[9][9];
		boolean flag_solved = false;
		for (int attemps = 0; attemps < 30; attemps++) {

			sudokuGrid = randomMatriz();
			BranchAndBound bb = new BranchAndBound();
			this.sudokuPuzzle = bb.solver(sudokuGrid);
			if (!(this.sudokuPuzzle == null)) {
				flag_solved = true;
				break;
			}
		}
		if (flag_solved)
			this.removeElementsByLevel();
		
		return flag_solved;
	}

	private int[][] randomMatriz() {
		int[][] sudokuGrid = new int[9][9];
		for (int i = 1; i <= 30; i++) {
			int rowPosition = new Random().nextInt((8 - 0) + 1) + 0;
			int columnPosition = new Random().nextInt((8 - 0) + 1) + 0;
			int sudokuNumber = new Random().nextInt((9 - 1) + 1) + 1;
			if (sudokuGrid[rowPosition][columnPosition] == 0
					&& noConflict(sudokuGrid, rowPosition, columnPosition, sudokuNumber)) {
				sudokuGrid[rowPosition][columnPosition] = sudokuNumber;
			} else
				i--;
		}
		return sudokuGrid;
	}

	/**
	 * This method hint cells by difficult level
	 */
	private void removeElementsByLevel() {
		int blankCells = level.getBlankCellsNumber();
		for (int i = 1; i <= blankCells; i++) {
			int rowPosition = new Random().nextInt((8 - 0) + 1) + 0;
			int columnPosition = new Random().nextInt((8 - 0) + 1) + 0;
			this.sudokuPuzzle[rowPosition][columnPosition] = 0;
		}
	}

	/**
	 * This method print the Sudoku generated in console.
	 */
	public void printSudokuPuzzle() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudokuPuzzle[i][j] + "  ");
			}
			System.out.println();
		}
	}

	/**
	 * This method verify that the Number no repeat in the Row, column and box.
	 * 
	 * @param possibleSolution,
	 *            its contain the posible solution of sudoku game
	 * @param row,
	 *            its the row of number to verify
	 * @param colunn,
	 *            its the column of number to verify
	 * @param number,
	 *            its the number value of the row and column positions. @return,
	 *            this method return true when there isn't conflict, and false
	 *            when there is.
	 */
	public static boolean noConflict(int[][] possibleSolution, int row, int colunn, int number) {

		for (int i = 0; i < 9; i++) {
			if (possibleSolution[row][i] == number || possibleSolution[i][colunn] == number)
				return false;
		}

		int gridRow = row - (row % 3);
		int gridColumn = colunn - (colunn % 3);
		for (int p = gridRow; p < gridRow + 3; p++) {
			for (int q = gridColumn; q < gridColumn + 3; q++) {
				if (possibleSolution[p][q] == number)
					return false;
			}
		}
		return true;
	}

	/**
	 * This method print the positions Sudoku generated in console.
	 */
	public void printItemsSudokuPositions() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print("(" + i + "," + j + "):" + this.sudokuPuzzle[i][j]);
				System.out.print("  -  ");
			}
			System.out.println();
		}
	}
}
