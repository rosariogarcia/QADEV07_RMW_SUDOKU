package game;

import java.util.Random;

import branchandbound.BranchAndBound;

/**
 * 
 * @author rosariogarcia
 *
 */
public class GenerateSudoku {

	public int[][] matrix;

	public void generate() {

		int[][] sudokuGrid = new int[9][9];

		int row = 0;
		int col = 0;
		Random random = new Random();
		int randomNumber = 0;

		for (int i = 1; i <= 10; i++) {
			row = random.nextInt((8 - 0) + 1) + 0; // obtener una posicion de
													// una fila aleatoriamente
			col = random.nextInt((8 - 0) + 1) + 0; // obtener una posicion de
													// una columna
													// aleatoriamente
			randomNumber = random.nextInt((9 - 1) + 1) + 1;// generar un numero
															// randomico entre 9
															// y 1

			if (sudokuGrid[row][col] == 0 && noConflict(sudokuGrid, row, col, randomNumber)) {
				sudokuGrid[row][col] = randomNumber;
			} else {
				i--;
			}
		}
		
		BranchAndBound solver = new BranchAndBound();
		

		this.matrix = sudokuGrid;

		/*
		 * for (int i = 0; i < 9; i++) { for (int j = 0; j < 9; j++) {
		 * System.out.print(grid[i][j] + "  "); } System.out.println(); }
		 */

	}

	public static boolean noConflict(int[][] array, int row, int col, int num) {

		for (int i = 0; i < 9; i++) {
			if (array[row][i] == num) {
				return false;
			}
			if (array[i][col] == num) {
				return false;
			}
		}

		int gridRow = row - (row % 3);
		int gridColumn = col - (col % 3);
		for (int p = gridRow; p < gridRow + 3; p++) {
			for (int q = gridColumn; q < gridColumn + 3; q++) {
				if (array[p][q] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
