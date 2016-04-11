package game;

import exception.NumberException;

public class ImputValidate {
    
    /**
     * converts a String to a two-dimensional array
     * @param stringReed for convert a array
     * @return A two-dimensional array
     */

	public static int[][] convertToMatrix(String stringReed) {
		int[][] grid = new int[9][9];
		int row = 0;
		int col = 0;
		int sizeGrid = 8;
		for (char number : stringReed.toCharArray()) {
			grid[row][col] = Integer.parseInt(number + "");
			if (col++ == sizeGrid) {
				row++;
				col = 0;
				sizeGrid = +8;
			}
		}
		return grid;
	}

	/**
	 * Verified if String is a number
	 * @param stringReed for convert a array
	 * @return return true if convert the String to a number
	 */
	public static boolean isNumeric(String stringReed) {
		try {
			for (char number : stringReed.toCharArray()) {
				Integer.parseInt(number + "");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 *  Verified that contain 81 characters. 
	 * @param stringReed for convert a array
	 * @return true if contain 81 position.
	 */
	public static boolean contain81position(String stringReed) {
		return stringReed.length() == 81;
	}

}
