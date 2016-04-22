package algorithm;

import game.ImputValidate;

/**
 * 
 * @author MijhailVillarroel
 *
 */
public class Backtracking implements AlgorithmSolver {
	private int[][] grid;
	static final int SIZESUDOKU = 9;

	/**
	 * Constructs algorithmSolver Empty.
	 */
	public Backtracking() {
		grid = new int[9][9];
	}

	/**
	 * Constructs algorithm Solver, this initialize the array parameters
	 * 
	 * @param grid
	 *            It contains the matrix to solve sudoku.
	 */
	public Backtracking(int[][] grid) {
		this.grid = grid;
	}

	/**
	 * Return if resolved returns the array but returns null.
	 * 
	 * @param grid
	 *            the array to solver.
	 * @return
	 */
	public int[][] solver(int grid[][]) {
		this.grid = grid;
		if (solveSudoku()) {
			return this.grid;
		} else
			return null;
	}

	/**
	 * Return true if soduko can solver.
	 * 
	 * @return
	 */
	public boolean solveSudoku() {
		int row;
		int col;
		int[] blankCell = findBlankLocation();
		row = blankCell[0];
		col = blankCell[1];
		if (row == -1) {

			return true;
		}

		if (testValue(row, col))
			return true;
		return false;
	}

	/**
	 * return true if can solver.
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean testValue(int row, int col) {
		boolean result = false;
		for (int i = 1; i <= SIZESUDOKU; i++) {

			if (canResolver(row, col, i))
				return true;
		}
		return result;
	}

	/**
	 * 
	 * @param row
	 * @param col
	 * @param i
	 * @return
	 */
	private boolean canResolver(int row, int col, int i) {
		boolean result = false;
		if (isSafe(row, col, i)) {

			grid[row][col] = i;

			if (solveSudoku()) {
				return true;
			}

			grid[row][col] = 0;
		}
		return result;
	}

	/**
	 * Return true if find a position within the sudoku.
	 * 
	 * @param row
	 * @param col
	 * @param number
	 * @return
	 */
	public boolean isSafe(int row, int col, int number) {

		if (!UsedInRow(row, number) && !UsedInColumn(col, number) && !usedInBox(row - row % 3, col - col % 3, number)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if in the column contains the specified number
	 * 
	 * @param row
	 * @param number
	 *            contains the row an column.
	 * @return
	 */
	public boolean UsedInRow(int row, int number) {
		for (int i = 0; i < SIZESUDOKU; i++) {
			if (grid[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if in the row contains the specified number
	 * 
	 * @param col
	 * @param number
	 * @return boolean
	 */
	public boolean UsedInColumn(int col, int number) {
		for (int i = 0; i < SIZESUDOKU; i++) {
			if (grid[i][col] == number) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if in the grid 3 X 3 contains the specified number
	 * 
	 * @param boxStartRow
	 * @param boxStartCol
	 * @param number
	 * @return
	 */
	public boolean usedInBox(int boxStartRow, int boxStartCol, int number) {
		for (int i = 0; i < 3; i++) {
			if (solvegrid3X3(boxStartRow, boxStartCol, number, i))
				return true;
		}

		return false;
	}

	/**
	 * Return true if in grid 3 X 3 not contains the number
	 * 
	 * @param boxStartRow
	 * @param boxStartCol
	 * @param number
	 * @param i
	 * @return
	 */
	private boolean solvegrid3X3(int boxStartRow, int boxStartCol, int number, int i) {
		boolean result = false;
		for (int j = 0; j < 3; j++) {
			if (grid[i + boxStartRow][j + boxStartCol] == number) {
				return true;
			}
		}
		return result;
	}

	/**
	 * Returns the position of a blank place in the sudoku
	 * 
	 * @return
	 */
	public int[] findBlankLocation() {
		int[] cell = new int[2];
		for (int i = 0; i < SIZESUDOKU; i++) {

			if (getPositionBlank(cell, i) != null)
				return getPositionBlank(cell, i);
		}
		cell[0] = -1;
		cell[1] = -1;
		return cell;
	}

	/**
	 * Return a position blank on the grid 9 X 9.
	 * 
	 * @param cell
	 * @param i
	 * @return
	 */
	private int[] getPositionBlank(int[] cell, int i) {
		int[] resCell = null;
		for (int j = 0; j < SIZESUDOKU; j++) {
			if (grid[i][j] == 0) {
				cell[0] = i;
				cell[1] = j;
				resCell = cell;
			}
		}
		return resCell;
	}

	public void print() {
		for (int row = 0; row < SIZESUDOKU; row++) {
			if (row % 3 == 0) {
				System.out.println("-------+------+-------"); // for more
																// readability
			}
			for (int col = 0; col < SIZESUDOKU; col++) {
				if (col % 3 == 0) {
					System.out.print("|"); // for more readability
				}
				System.out.print(grid[row][col] + " ");

			}
			System.out.println("|");
		}
	}

}
