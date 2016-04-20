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
		
		int[][] solved = {
				{8,5,3, 9,1,6, 4,2,7}, 
				{7,9,1, 2,4,3, 5,6,8}, 
				{2,6,4, 5,8,7, 9,3,1},
				{5,1,8, 4,6,9, 3,7,2}, 
				{9,7,2, 8,3,1, 6,5,4}, 
				{4,3,6, 7,5,2, 8,1,9},
				{3,2,7, 6,9,4, 1,8,5},
				{1,8,9, 3,2,5, 7,4,6}, 
				{6,4,5, 1,7,8, 2,9,3},
				};
		BranchAndBound branchBound =new BranchAndBound();
		matrix = branchBound.solver(matrix);
		
		assertArrayEquals(solved, matrix);
		
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
	}

}
