package game;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class SolveAlgorithmTest {

	@Test
	public void arraySolutionIsEqualToAArrayWithSevenDatas() {
		
		  int userGrid[][] = new int[][]
			       {{1,0,0,0,0,0,0,0,8},
					{0,0,0,4,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{5,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0},
					{3,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,5,0},
					{0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,9}};
		  int solveGrid[][]=new int[][]
				  {{1,2,3,5,6,7,4,9,8},
				  	{6,5,7,4,8,9,1,2,3},
					{4,8,9,1,2,3,5,6,7},
					{5,1,2,3,4,8,9,7,6},
					{7,4,6,2,9,1,3,8,5},
					{3,9,8,6,7,5,2,1,4},
					{2,7,4,9,3,6,8,5,1},
					{9,6,1,8,5,4,7,3,2},
					{8,3,5,7,1,2,6,4,9}};
		SolveAlgorithm solve=new SolveAlgorithm();
		solve.solveSudoku(userGrid);
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
		Assert.assertEquals(solveGrid[i][j], solve.solveGrid(0, 8, 8, 8, userGrid,userGrid)[i][j]);
			}}
	}
	
	@Test
	public void arraySolutionIsEqualToASudokuAdvanced()
	{
		int user[][] = new int[][]
			       {{0,0,0,5,0,1,0,0,0},
					{0,5,0,0,2,0,0,1,0},
					{0,0,6,0,0,0,4,0,0},
					{3,0,0,1,0,9,0,0,5},
					{0,9,0,0,0,0,0,8,0},
					{2,0,0,8,0,3,0,0,4},
					{0,0,7,0,0,0,5,0,0},
					{0,6,0,0,8,0,0,9,0},
					{0,0,0,2,0,6,0,0,0}};
		 int solveGrid[][]=new int[][]
				 {{9,3,2,5,4,1,6,7,8},
					{7,5,4,6,2,8,3,1,9},
					{1,8,6,3,9,7,4,5,2},
					{3,4,8,1,6,9,7,2,5},
					{6,9,5,4,7,2,1,8,3},
					{2,7,1,8,5,3,9,6,4},
					{8,2,7,9,1,4,5,3,6},
					{4,6,3,7,8,5,2,9,1},
					{5,1,9,2,3,6,8,4,7}};
		SolveAlgorithm solve=new SolveAlgorithm();
		System.out.println("another sample advanced");
		//solve.solveSudoku(user);
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
		Assert.assertEquals(solveGrid[i][j], solve.solveGrid(0, 0, 8, 8, user,user)[i][j]);
			}}
	}
	@Test
	public void arraySolutionIsEqualToASudokuIntermedium()
	{
		int user[][] = new int[][]
			       {{0,0,7,0,3,0,8,0,0},
					{0,0,0,2,0,5,0,0,0},
					{4,0,0,9,0,6,0,0,1},
					{0,4,3,0,0,0,2,1,0},
					{1,0,0,0,0,0,0,0,5},
					{0,5,8,0,0,0,6,7,0},
					{5,0,0,1,0,8,0,0,9},
					{0,0,0,5,0,3,0,0,0},
					{0,0,2,0,9,0,5,0,0}};
		int userGrid[][] = new int[][]
			       {{2,9,7,4,3,1,8,5,6},
					{3,6,1,2,8,5,4,9,7},
					{4,8,5,9,7,6,3,2,1},
					{7,4,3,6,5,9,2,1,8},
					{1,2,6,8,4,7,9,3,5},
					{9,5,8,3,1,2,6,7,4},
					{5,3,4,1,2,8,7,6,9},
					{8,7,9,5,6,3,1,4,2},
					{6,1,2,7,9,4,5,8,3}};
		SolveAlgorithm solve=new SolveAlgorithm();
		System.out.println("another sample intermidium");
		//solve.solveSudoku(user);`
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
		Assert.assertEquals(userGrid[i][j],solve.solveGrid(0, 0, 8, 8, user,user)[i][j]);
			}}
	}
	@Test
	public void arraySolutionIsEqualToASudokuEasy()
	{
		int user[][] = new int[][]
			       {{0,4,0,9,0,1,0,3,0},
					{9,0,0,5,3,6,0,0,8},
					{0,0,5,0,8,0,1,0,0},
					{4,9,0,0,0,0,0,5,3},
					{0,5,7,0,0,0,8,1,0},
					{1,8,0,0,0,0,0,4,6},
					{0,0,6,0,4,0,2,0,0},
					{8,0,0,3,2,7,0,0,9},
					{0,2,0,6,0,5,0,8,0}};
		int userGrid[][] = new int[][]
			       {{2,4,8,9,7,1,6,3,5},
					{9,7,1,5,3,6,4,2,8},
					{3,6,5,2,8,4,1,9,7},
					{4,9,2,1,6,8,7,5,3},
					{6,5,7,4,9,3,8,1,2},
					{1,8,3,7,5,2,9,4,6},
					{5,3,6,8,4,9,2,7,1},
					{8,1,4,3,2,7,5,6,9},
					{7,2,9,6,1,5,0,8,0}};
		 
		SolveAlgorithm solve=new SolveAlgorithm();
		System.out.println("another sample easy");
		//solve.solveSudoku(user);
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
		Assert.assertEquals(userGrid[i][j], solve.solveGrid(0, 0, 8, 8, user,user)[i][j]);
			}}	
	}
}

