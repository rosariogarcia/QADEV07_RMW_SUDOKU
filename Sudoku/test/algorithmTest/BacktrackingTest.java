package algorithmTest;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithm.AlgorithmSolver;
import algorithm.Backtracking;

public class BacktrackingTest {

    @Test
    public void backtrackingCanBeCreatedWithNoParameters() {
        Backtracking backtracking = new Backtracking();
        assertNotNull(backtracking);
    }
    
    @Test
    public void backtrackingCanBeCreatedWithParameters() {
        int grid[][] = new int[][] { 
            { 1, 0, 6, 0, 0, 4, 2, 0, 0 }, 
            { 2, 7, 0, 0, 6, 5, 0, 8, 0 },
            { 0, 4, 0, 7, 0, 0, 9, 0, 6 }, 
            { 0, 0, 0, 0, 9, 0, 4, 0, 3 },
            { 9, 1, 4, 0, 8, 0, 7, 5, 2 },
            { 3, 0, 5, 0, 4, 0, 0, 0, 0 }, 
            { 6, 0, 2, 0, 0, 9, 0, 4, 0 }, 
            { 0, 8, 0, 3, 2, 0, 0, 9, 7 },
            { 0, 0, 9, 4, 0, 0, 6, 0, 1 } };
            
        AlgorithmSolver backtracking = new Backtracking();
        assertTrue( backtracking instanceof Backtracking);
    }

   
	@Test
    public void backtrackingCanresolverWithParameters() {
    	
    	int resolver[][] = new int[][] { {1, 9, 6, 8, 3, 4, 2, 7, 5 },
    	{2, 7, 3, 9, 6, 5, 1, 8, 4 },
    	{5, 4, 8, 7, 1, 2, 9, 3, 6 },
    	{8, 2, 7, 5, 9, 1, 4, 6, 3 },
    	{9, 1, 4, 6, 8, 3, 7, 5, 2 },
    	{3, 6, 5, 2, 4, 7, 8, 1, 9 },
    	{6, 5, 2, 1, 7, 9, 3, 4, 8 },
    	{4, 8, 1, 3, 2, 6, 5, 9, 7 },
    	{7, 3, 9, 4, 5, 8, 6, 2, 1}
    	};
        int grid[][] = new int[][] { 
            { 1, 0, 6, 0, 0, 4, 2, 0, 0 }, 
            { 2, 7, 0, 0, 6, 5, 0, 8, 0 },
            { 0, 4, 0, 7, 0, 0, 9, 0, 6 }, 
            { 0, 0, 0, 0, 9, 0, 4, 0, 3 },
            { 9, 1, 4, 0, 8, 0, 7, 5, 2 },
            { 3, 0, 5, 0, 4, 0, 0, 0, 0 }, 
            { 6, 0, 2, 0, 0, 9, 0, 4, 0 }, 
            { 0, 8, 0, 3, 2, 0, 0, 9, 7 },
            { 0, 0, 9, 4, 0, 0, 6, 0, 1 } 
            };
            
            
        AlgorithmSolver backtracking = new Backtracking ();
        assertEquals (backtracking.solver(grid),resolver);
    }
}
