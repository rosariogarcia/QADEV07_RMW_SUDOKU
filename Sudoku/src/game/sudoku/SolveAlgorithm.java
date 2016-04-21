package game;

public class SolveAlgorithm {

	static int grid[][] = new int[9][9];

	/**
	 * This method sends to print the solution Sudoku with the 
	 * array initial of the Sudoku
	 * 
	 * @param userGrid	is a array of the Sudoku generated to resolve
	 */
	public static void solveSudoku(int[][] userGrid) {
		for (int i = 0; i < 9; i += 1) {
			for (int j = 0; j < 9; j += 1) {
				grid[i][j] = userGrid[i][j];
			}
		}
		print(grid);

		int lastPos = findLastCell(userGrid);
		if (lastPos == 0) {
			return;
		}
		int lastY = lastPos % 16;
		int lastX = lastPos / 16;

		print(solveGrid(0, 0, lastY, lastX, grid, userGrid));

	}

	/**
	 * This method finds the last cell of the array to resolve
	 * 
	 * @param userGrid	is the array of the solution
	 * @return			return the cell next to resolve
	 */
	public static int findLastCell(int[][] userGrid) {
		for (int i = 8; i >= 0; i--) {
			for (int j = 8; j >= 0; j--) {
				if (userGrid[i][j] == 0) {
					return ((j * 16) + i);
				}
			}
		}
		return 0;
	}

	/**
	 * This method resolve the Sudoku generated
	 * 
	 * @param y			is the position of the initial column 
	 * @param x			is the position of the initial row
	 * @param lastY		is the position of the last column
	 * @param lastX		is the position of the last row
	 * @param grid		is a new array to put the solution 
	 * @param userGrid	is the array of the Sudoku generated.
	 * @return			return the array solved
	 */
	public static int[][] solveGrid(int y, int x, int lastY, int lastX,
			int[][] grid, int[][] userGrid) {
		while (!validateCell(lastY, lastX, grid) || grid[lastY][lastX] == 0) {
			while (userGrid[y][x] != 0) {
				if (x == 8) {
					y = y + 1;
					x = 0;
				} else {
					x = x + 1;
				}
			}
			if (grid[y][x] < 9) {

				grid[y][x] += 1;
				if (validateCell(y, x, grid)) {
					int yy, xx;
					if (x == 8) {
						yy = y + 1;
						xx = 0;
					} else {
						yy = y;
						xx = x + 1;
					}
					solveGrid(yy, xx, lastY, lastX, grid, userGrid);
				}
			} else {
				grid[y][x] = 0;
				break;
			}
		}
		return grid;
	}

	/**
	 * This method validates the array before of every solution
	 * 
	 * @param x		is the position of the row for the array
	 * @param y		is the position of the column for the array
	 * @param grid	is the array to validate
	 * @return		return true or false to continue the solution
	 */
	public static boolean validateCell(int x, int y, int[][] grid) {
		String temp = "";
		for (int i = 0; i < 9; i += 1) {
			temp += Integer.toString(grid[i][y]);// horizontal
			temp += Integer.toString(grid[x][i]);// vertical
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp += Integer
						.toString(grid[(x / 3) * 3 + i][(y / 3) * 3 + j]);
			}
		}

		int count = 0, idx = 0;
		while ((idx = temp.indexOf(Integer.toString(grid[x][y]), idx)) != -1) {
			idx += 1;
			count += 1;
		}

		return count == 3;
	}

	/**
	 * This method prints the solution of the Sudoku
	 * 
	 * @param grid	is the Sudoku solved
	 */
	public static void print(int[][] grid) {
		System.out.println();
		for (int i = 0; i < 9; i += 1) {
			for (int j = 0; j < 9; j += 1) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

}
