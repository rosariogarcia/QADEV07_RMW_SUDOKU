package gameTest;

import static org.junit.Assert.*;

import org.junit.Test;

import game.ValidateSoduko;

public class ValidateSodukoTest {

	@Test
	public void readSodukoInvalidInRow() {
		int grid[][] = new int[][] { { 1, 1, 6, 0, 0, 4, 2, 0, 0 }, { 0, 7, 0, 0, 6, 5, 0, 8, 0 },
				{ 0, 4, 0, 7, 0, 0, 9, 0, 6 }, { 0, 0, 0, 0, 9, 0, 4, 0, 3 }, { 9, 1, 4, 0, 8, 9, 7, 5, 2 },
				{ 3, 0, 5, 0, 4, 0, 0, 0, 0 }, { 6, 0, 2, 0, 0, 9, 0, 4, 0 }, { 0, 8, 0, 3, 2, 0, 0, 9, 7 },
				{ 0, 0, 9, 4, 0, 0, 6, 0, 1 } };
		assertFalse(ValidateSoduko.isValidArray(grid));
	}

	@Test
	public void readSodukoInvalidInColumn() {
		int grid[][] = new int[][] { { 1, 0, 6, 0, 0, 4, 2, 0, 0 }, { 2, 7, 0, 0, 6, 5, 0, 8, 0 },
				{ 0, 4, 0, 7, 6, 0, 9, 0, 6 }, { 0, 0, 0, 0, 9, 0, 4, 0, 3 }, { 9, 1, 4, 0, 8, 0, 7, 5, 2 },
				{ 3, 0, 5, 0, 4, 0, 0, 0, 0 }, { 6, 0, 2, 0, 0, 9, 0, 4, 0 }, { 0, 8, 0, 3, 6, 0, 0, 9, 7 },
				{ 0, 0, 9, 4, 0, 0, 6, 0, 1 } };
		assertFalse(ValidateSoduko.isValidArray(grid));
	}

	@Test
	public void readSodukoInvalidInTheBox3X3() {
		int grid[][] = new int[][] { { 1, 0, 6, 0, 0, 4, 2, 0, 0 }, { 2, 7, 1, 4, 6, 5, 0, 8, 0 },
				{ 0, 1, 0, 7, 4, 0, 9, 0, 6 }, { 0, 0, 0, 0, 9, 0, 4, 0, 3 }, { 9, 1, 4, 0, 8, 0, 7, 5, 2 },
				{ 3, 0, 5, 0, 4, 0, 0, 0, 0 }, { 6, 0, 2, 0, 0, 9, 0, 4, 0 }, { 0, 8, 0, 3, 6, 0, 0, 9, 7 },
				{ 0, 0, 9, 4, 0, 0, 6, 0, 1 } };
		assertFalse(ValidateSoduko.isValidArray(grid));
	}

	@Test
	public void readSodukoValid() {
		int grid[][] = new int[][] { { 1, 0, 6, 0, 0, 4, 2, 0, 0 }, { 2, 7, 0, 0, 6, 5, 0, 8, 0 },
				{ 0, 4, 0, 7, 0, 0, 9, 0, 6 }, { 0, 0, 0, 0, 9, 0, 4, 0, 3 }, { 9, 1, 4, 0, 8, 0, 7, 5, 2 },
				{ 3, 0, 5, 0, 4, 0, 0, 0, 0 }, { 6, 0, 2, 0, 0, 9, 0, 4, 0 }, { 0, 8, 0, 3, 2, 0, 0, 9, 7 },
				{ 0, 0, 9, 4, 0, 0, 6, 0, 1 } };
		assertTrue(ValidateSoduko.isValidArray(grid));
	}

}
