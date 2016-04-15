/**
 * 
 */
package algorithm;

/**
 * Interface that define the method to solver a Sudoku game with an algorithm.
 * @author rosariogarcia
 *
 */
public interface AlgorithmSolver {

	/**
	 * Method to solver a Sudoku game, that will be implement by all algorithms
	 * @param grid. it contains the Sudoku puzzle
	 * @return int[][], this method return the Suduko game solved.
	 */
	public  int[][] solver(int grid[][]);
}
