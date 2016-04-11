package game;

import java.util.Scanner;

public class Reedkeyboard {

	public static int[][] reed() {
		Scanner scanner = new Scanner(System.in);
		boolean endMenu = false;
		int[][] result = null;
		do {
			System.out.println("Enter a sudoku");
			String stringReed = scanner.next();
			if (stringReed.length() == 81 && ImputValidate.isNumeric(stringReed)) {
				endMenu = true;
				result = ImputValidate.convertToMatrix(stringReed);
			}

		} while (endMenu == false);

		return result;
	}

}
