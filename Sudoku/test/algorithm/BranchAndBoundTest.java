/**
 * 
 */
package algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

import branchandbound.BranchAndBound;

/**
 * @author rosariogarcia
 *
 */
public class BranchAndBoundTest {

	@Test
	public void canSolverSudokuGameWithBranchAndBoundAlgorithm() {
		int[][] matrix = {
                { 0,5,3, 0,0,0, 0,0,7 },
                { 7,0,0, 0,4,0, 0,6,0 },
                { 0,0,0, 0,8,0, 9,0,1 },
                { 0,1,0, 0,6,9, 3,0,0 },
                { 9,0,0, 8,0,1, 0,0,4 },
                { 0,0,6, 7,5,0, 0,1,0 },
                { 3,0,7, 0,9,0, 0,0,0 },
                { 0,8,0, 0,2,0, 0,0,6 },
                { 6,0,0, 0,0,0, 2,9,0 },
              };
		
		
		BranchAndBound branchBound =new BranchAndBound();
		matrix = branchBound.solver(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
	    
		System.out.println("\nFIN");
	}

}
