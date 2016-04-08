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

	public static int SIZE = 9;
	
	/*
	 * @see algorithm.Algorithmsolutionver#solutionver(int[][])
	 */
	@Override
	public  int [][] solver(int solution[][]) {
		Queue live = new Queue();// Queue of Node's objects 
		Node X = new Node();
		Node Y; //auxiliar node
		
		boolean inicial[][] = new boolean[SIZE][SIZE];
		
		// live := emptyQueue(); //Preparamos la raíz del árbol de exploración
		X.row = 0;
		X.column = 0;
		X.solution = solution;
		live.askAgain(X);// askAgain (live, X); => posiblemente sea agregar X a los live
		
		refillMatrixWithBooleanInput(solution, inicial); 

		while (live.emptyQueue()== false) {
			X = live.atend();// X := atend(live);<== sacamos un elemnto de la cola
			if (inicial[X.row][X.column]) {// se comprueba si el elemento es false, si no hay elemento en la matriz
				for (int k = 0; k < SIZE; k++) {
					X.solution[X.row][X.column] = k + 1;
					if (workable(X.row, X.column, X.solution)) {
						int casos = Utils.boolToInt(X.row == SIZE - 1 && X.column == SIZE - 1) * 1 + 
								Utils.boolToInt(X.row < SIZE - 1 && X.column == SIZE - 1) * 2 + 
								Utils.boolToInt(X.row <= SIZE - 1 && X.column < SIZE - 1) * 3;
						switch (casos) {
						case 1:
							return X.solution;
						case 2:
							Y = new Node();
							Y.solution = X.solution;
							Y.row = X.row + 1;
							Y.column = 0;
							live.askAgain(Y);// pedir_vez(live, Y);
							break;
						case 3:
							Y = new Node();
							Y.solution = X.solution;
							Y.row = X.row;
							Y.column = X.column + 1;
							if (Y.column == 9) {
								int r = 0;
							}
							live.askAgain(Y);// askAgain(live, Y);
							break;
						}
					}
				}
			} else {// ocurre cuando la pocicion en la que se encuentra tiene un valor diferente de 0 inicial[X.row, X.column] = Cierto
				int casos = Utils.boolToInt(X.row == SIZE - 1 && X.column == SIZE - 1) * 1 + 
						Utils.boolToInt(X.row < SIZE - 1 && X.column == SIZE - 1) * 2 + 
						Utils.boolToInt(X.row <= SIZE - 1 && X.column < SIZE - 1) * 3;
				switch (casos) {
				case 1:
					return X.solution;
				case 2:
					Y = new Node();
					Y.solution = X.solution;
					Y.row = X.row + 1;
					Y.column = 0;
					live.askAgain(Y);// askAgain(live, Y);
					break;
				case 3:
					Y = new Node();
					Y.solution = X.solution;
					Y.row = X.row;
					Y.column = X.column + 1;
					live.askAgain(Y);// askAgain(live, Y);
					break;
				}
			}
		}
		return null;
	}


	/**
	 * This method refill the matrix with true when no exist the element value
	 * @param solution
	 * @param inicial
	 */
	private void refillMatrixWithBooleanInput(int[][] solution, boolean[][] inicial) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (solution[i][j] != 0) {
					inicial[i][j] = false; // cuando tiene un elemento
				} else {
					inicial[i][j] = true;// cuando es vacio
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
		while (k < SIZE && valido) {
			if (solution[i][j] == solution[i][k] && k != j) {
				valido = false;
			}
			k++;
		}
		k = 0;// verificamos en cada row
		while (k < SIZE && valido) {
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
