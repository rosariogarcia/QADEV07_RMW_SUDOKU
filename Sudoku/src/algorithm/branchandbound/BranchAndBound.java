package algorithm.branchandbound;

import algorithm.AlgorithmSolver;

/**This class in an Algorithm to solver an sudoku game based on Trees
 * @author rosariogarcia
 *
 */
public class BranchAndBound implements AlgorithmSolver {

	public static int SIZESUDOKU = 9;

	/*
	 * @see algorithm.Algorithmsolutionver#solutionver(int[][])
	 * This method is for solver the Sudoku game
	 */
	@Override
	public int[][] solver(int sudoku[][]) {
		Queue possibleSolutionsQueue = new Queue();
		Node possibleSolution = new Node();

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
	/**
	 * This method is for verify if is possible make a new branch
	 * @param possibleSolution, it is a Node object
	 * @param possibleSolutionsQueue, it is the queue of possible solutions
	 * @return, the return depends of the case
	 */
	private int[][] verifyAndChangePosibleSolution(Node possibleSolution, Queue possibleSolutionsQueue) {
		Node auxiliarSolution;
		int cases = Utils.boolToInt(possibleSolution.row == SIZESUDOKU - 1 && possibleSolution.column == SIZESUDOKU - 1)* 1
				+ Utils.boolToInt(possibleSolution.row < SIZESUDOKU - 1 && possibleSolution.column == SIZESUDOKU - 1)* 2
				+ Utils.boolToInt(possibleSolution.row <= SIZESUDOKU - 1 && possibleSolution.column < SIZESUDOKU - 1)* 3;
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
		return null;

	}

	/**
	 * This method allow verify if the possible solution is workable
	 * @param possibleSolutionsQueue, it is an Queue object
	 * @param possibleSolution. it is an Node object
	 * @param initialSudokuBoolean, it is the grid with initial values of the Sudoku game
	 * @return
	 */
	private int[][] verifyPossibleSolution(Queue possibleSolutionsQueue, Node possibleSolution,
			boolean[][] initialSudokuBoolean) {
		Node auxiliarSolution;
		int[][] response = null;
		if (initialSudokuBoolean[possibleSolution.row][possibleSolution.column]) {
			for (int k = 0; k < SIZESUDOKU; k++) {
				possibleSolution.solution[possibleSolution.row][possibleSolution.column] = k + 1;
				if (workable(possibleSolution.row, possibleSolution.column, possibleSolution.solution)) {
					response = this.verifyAndChangePosibleSolution(possibleSolution, possibleSolutionsQueue);
					if (response != null)
						return response;
				}
			}
		} else {
			response = this.verifyAndChangePosibleSolution(possibleSolution, possibleSolutionsQueue);
			if (response != null)
				return response;
		}
		return response;
	}

	/**
	 * This method refill the matrix with true when no exist the element value
	 * @param solution, It is the sudoku game initial
	 * @param inicial, this is the sudoku game with boolean values
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
	/**
	 * this method verify if the element should be in this row, column and box
	 * @param i: position in the row
	 * @param j:position in the column
	 * @param solution: grid with possible solution
	 * @return, true if the element is workable, false if there isn't
	 */
	private boolean workable(int i, int j, int solution[][]) {
		boolean valido;
		int k;
		int l;
		valido = true;
		k = 0;

		while (k < SIZESUDOKU && valido) {
			if (solution[i][j] == solution[i][k] && k != j) {
				valido = false;
			}
			k++;
		}
		k = 0;
		while (k < SIZESUDOKU && valido) {
			if (solution[i][j] == solution[k][j] && k != i) {
				valido = false;
			}
			k++;
		}

		k = correspondencia3x3(i + 1);
		l = correspondencia3x3(j + 1);
		// System.out.println("entra***");
		while (k < correspondencia3x3(i + 1) + 3 && valido) {
			l = correspondencia3x3(j + 1);
			while (l < correspondencia3x3(j + 1) + 3 && valido) {
				if (solution[i][j] == solution[k - 1][l - 1] && (i != k - 1 && j != l - 1))
					valido = false;
				l++;
			}
			k++;
		}
		return valido;
	}
	/**
	 * Verify if is an box 
	 * @param i
	 * @return
	 */
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