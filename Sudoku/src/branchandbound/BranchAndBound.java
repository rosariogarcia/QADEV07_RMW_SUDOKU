/**
 * 
 */
package branchandbound;

import algorithm.AlgorithmSolver;

/**
 * @author rosariogarcia
 *
 */
public class BranchAndBound implements AlgorithmSolver {

	public static int SIZESUDOKU = 9;

	/*
	 * @see algorithm.Algorithmsolutionver#solutionver(int[][])
	 */
	@Override
	public int[][] solver(int sudoku[][]) {
		Queue possibleSolutionsQueue = new Queue();
		Node possibleSolution = new Node();
		Node auxiliarSolution;

		boolean initialSudokuBoolean[][] = new boolean[SIZESUDOKU][SIZESUDOKU];
		possibleSolution.row = 0;
		possibleSolution.column = 0;
		possibleSolution.solution = sudoku;
		possibleSolutionsQueue.askAgain(possibleSolution);
		refillSudokuPuzzleWithBooleanInput(sudoku, initialSudokuBoolean);

		while (possibleSolutionsQueue.emptyQueue() == false) {
			possibleSolution = possibleSolutionsQueue.atend();
			int[][] verifyMatrix = verifyPossibleSolution(possibleSolutionsQueue, possibleSolution,
					initialSudokuBoolean);
			if (verifyMatrix != null)
				return verifyMatrix;
		}
		return null;
	}

	private int[][] verifyPossibleSolution(Queue possibleSolutionsQueue, Node possibleSolution,
			boolean[][] initialSudokuBoolean) {
		Node auxiliarSolution;
		if (initialSudokuBoolean[possibleSolution.row][possibleSolution.column]) {
			for (int k = 0; k < SIZESUDOKU; k++) {
				possibleSolution.solution[possibleSolution.row][possibleSolution.column] = k + 1;
				if (workable(possibleSolution.row, possibleSolution.column, possibleSolution.solution)) {
					int cases = Utils.boolToInt(
							possibleSolution.row == SIZESUDOKU - 1 && possibleSolution.column == SIZESUDOKU - 1) * 1
							+ Utils.boolToInt(
									possibleSolution.row < SIZESUDOKU - 1 && possibleSolution.column == SIZESUDOKU - 1)
									* 2
							+ Utils.boolToInt(
									possibleSolution.row <= SIZESUDOKU - 1 && possibleSolution.column < SIZESUDOKU - 1)
									* 3;
					switch (cases) {
					case 1:
						return possibleSolution.solution;
					case 2:
						auxiliarSolution = new Node();
						auxiliarSolution.solution = possibleSolution.solution;
						auxiliarSolution.row = possibleSolution.row + 1;
						auxiliarSolution.column = 0;
						possibleSolutionsQueue.askAgain(auxiliarSolution);
						break;
					case 3:
						auxiliarSolution = new Node();
						auxiliarSolution.solution = possibleSolution.solution;
						auxiliarSolution.row = possibleSolution.row;
						auxiliarSolution.column = possibleSolution.column + 1;
						if (auxiliarSolution.column == 9) {
							int r = 0;
						}
						possibleSolutionsQueue.askAgain(auxiliarSolution);
						break;
					}
				}
			}
		} else {
			int casos = Utils
					.boolToInt(possibleSolution.row == SIZESUDOKU - 1 && possibleSolution.column == SIZESUDOKU - 1) * 1
					+ Utils.boolToInt(
							possibleSolution.row < SIZESUDOKU - 1 && possibleSolution.column == SIZESUDOKU - 1) * 2
					+ Utils.boolToInt(
							possibleSolution.row <= SIZESUDOKU - 1 && possibleSolution.column < SIZESUDOKU - 1) * 3;
			switch (casos) {
			case 1:
				return possibleSolution.solution;
			case 2:
				auxiliarSolution = new Node();
				auxiliarSolution.solution = possibleSolution.solution;
				auxiliarSolution.row = possibleSolution.row + 1;
				auxiliarSolution.column = 0;
				possibleSolutionsQueue.askAgain(auxiliarSolution);
				break;
			case 3:
				auxiliarSolution = new Node();
				auxiliarSolution.solution = possibleSolution.solution;
				auxiliarSolution.row = possibleSolution.row;
				auxiliarSolution.column = possibleSolution.column + 1;
				possibleSolutionsQueue.askAgain(auxiliarSolution);
				break;
			}
		}
		return null;
	}

	/**
	 * This method refill the matrix with true when no exist the element value
	 * 
	 * @param solution
	 * @param inicial
	 */
	private void refillSudokuPuzzleWithBooleanInput(int[][] solution, boolean[][] inicial) {
		for (int i = 0; i < SIZESUDOKU; i++) {
			for (int j = 0; j < SIZESUDOKU; j++) {
				if (solution[i][j] != 0) {
					inicial[i][j] = false;
				} else {
					inicial[i][j] = true;
				}
			}
		}
	}

	private boolean workable(int i, int j, int solution[][]) {
		boolean valido;// el valor que vamos a retornar
		int k;
		int l;
		valido = true;
		k = 0;
		// verificamos en cada column
		while (k < SIZESUDOKU && valido) {
			if (solution[i][j] == solution[i][k] && k != j) {
				valido = false;
			}
			k++;
		}
		k = 0;// verificamos en cada row
		while (k < SIZESUDOKU && valido) {
			// System.out.println("2");
			if (solution[i][j] == solution[k][j] && k != i) {
				valido = false;
			}
			k++;
		}
		// comprobamos cada sub gruop de 3X3
		k = correspondencia3x3(i + 1);
		l = correspondencia3x3(j + 1);// Comprobamos el subgrupo de 3x3
		while (k < correspondencia3x3(i + 1) + 3 && valido) {// correspondencia3x3(i)
			// System.out.println("3");
			while (l < correspondencia3x3(j + 1) + 3 && valido) {
				// System.out.println("4rep");
				if (solution[i][j] == solution[k - 1][l - 1] && i != k - 1 && j != l - 1)
					valido = false;
				l++;
			}
			k++;
		}
		return valido;
	}

	private int correspondencia3x3(int i) {
		int k;
		int resultado = 0;

		if (i % 3 == 0) {
			k = (i / 3);
		} else {
			k = (i / 3) + 1;
		}
		switch (k) {
		case 1:
			resultado = 1;
			break;
		case 2:
			resultado = 4;
			break;
		case 3:
			resultado = 7;
			break;
		}
		return resultado;
	}

}
