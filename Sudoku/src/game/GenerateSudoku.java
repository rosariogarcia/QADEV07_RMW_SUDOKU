package game;

import java.util.Random;
import algorithm.branchandbound.*;
import game.file.FileSudoku;
import game.file.WriteFileNiceTxt;

/**
 * This class use to generate a new Sudoku Game to will be solve
 * @author rosariogarcia
 *
 */
public class GenerateSudoku {

	public int[][] sudokuPuzzle;
	private LevelSudoku level;
	private static final int SIZESUDOKU = 9;

	/**
	 * Construct initialize the difficult level value. 
	 * @param level, it is the difficult level of the Sudoku game.
	 */
	public GenerateSudoku(LevelSudoku level) {
		this.level = level;
	}

	/**
	 * This method generate a Sudoku game, return true when the Sudoku game is
	 * generated return false when the Sudoku game not is generated.
	 */
	public boolean generate() {
		int[][] sudokuGrid = new int[SIZESUDOKU][SIZESUDOKU];
		boolean flag_solved = false;
		// for (int attemps = 0; attemps < 100; attemps++)
		while (true) {
			sudokuGrid = randomMatrix();
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

	/**
	 * Sudoku Game with 30 random values initials
	 * @return sudokuGrid, this grid contain 30 numbers random generated to solver
	 */
	private int[][] randomMatrix() {
		int[][] sudokuGrid = new int[SIZESUDOKU][SIZESUDOKU];
		for (int i = 1; i <= 30; i++) {
			int rowPosition = new Random().nextInt(SIZESUDOKU);
			int columnPosition = new Random().nextInt(SIZESUDOKU);
			int sudokuNumber = new Random().nextInt(SIZESUDOKU) + 1;
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
			int rowPosition = new Random().nextInt(SIZESUDOKU);
			int columnPosition = new Random().nextInt(SIZESUDOKU);
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
	 * @param possibleSolution,it contain the posible solution of sudoku game
	 * @param row, it is the row of number to verify
	 * @param colunn, it is the column of number to verify
	 * @param number, it is the number value of the row and column positions. @return, this method return true when there isn't conflict, and false when there is.
	 *
	 */
	public static boolean noConflict(int[][] possibleSolution, int row, int column, int number) {

		for (int i = 0; i < 9; i++) {
			if (possibleSolution[row][i] == number || possibleSolution[i][column] == number)
				return false;
		}
		int gridRow = row - (row % 3);
		int gridColumn = column - (column % 3);
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
	
	public void printTxt(){
	    FileSudoku write = new WriteFileNiceTxt();
	    write.writeFileArray(sudokuPuzzle, "D:/test/test.txt");	   
	}
}
