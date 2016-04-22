package game;

public class ValidateSudoku {
    
    /**
     * Verified that contain 81 numbers  0 - 9 
     * @param grid the array a numbers
     * @return true if it have 81 positions.
     */

    public static boolean contain81Position(int[][] grid) {
        return grid.length * grid.length == 81;
    }
    
    /**
     * verified if in column or row  has repeated a number
     * @param grid the array a numbers
     * @return true if the sudoku not contain repeated.
     */

    public static boolean isValidArray(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            if (!runTheColumns(grid, i))
                return false;
        }
        return true;
    }
    
    /**
     * Verified the column the number (i) not contain repeated 
     * @param grid the array a numbers
     * @param i column the column Iteration
     * @return true if not contain repeated
     */

    private static boolean runTheColumns(int[][] grid, int i) {

        int number;
        for (int j = 0; j < 9; j++) {
            number = grid[i][j];
            if (repeterANumber(grid, i, number, j) == false) {
                return false;
            }
        }
        return true;
    }
    
    /**
     *  verified if in column, row and box 3X3  has repeated a number
     * @param grid the array a numbers
     * @param i column the column Iteration
     * @param number to be searched
     * @param j row the column Iteration
     * @return if true the grid not contain repeated 
     */

    private static boolean repeterANumber(int[][] grid, int i, int number, int j) {
        boolean result;
        if (number != 0) {
            result = usedInRow(i, number, grid) >= 2 || usedInColumn(j, number, grid) >= 2
                    || usedInBox(i - i % 3, j - j % 3, number, grid) >= 2;
            if (result == true)
                return false;
        }
        return true;
    }
    
    /**
     * Verified the row the number (number) not contain repeated 
     * @param row the row Iteration
     * @param number to be searched
     * @param grid grid the array a numbers
     * @return if the number is greater than 1 are repeated in the row
     */

    public static int usedInRow(int row, int number, int[][] grid) {
        int result = 0;
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == number) {
                result++;
            }
        }
        return result;
    }
    
    /**
     * Verified the column the number  not contain repeated 
     * @param col  the column Iteration
     * @param number to be searched
     * @param grid the array a numbers
     * @return if the number is greater than 1 are repeated in the column
     */

    public static int usedInColumn(int col, int number, int[][] grid) {
        int result = 0;
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == number) {
                result++;
            }
        }
        return result;
    }
    

    /**
     * Verified the box 3X3 the number not contain repeated 
     * @param boxStartRow  star position the box of the row
     * @param boxStartCol  star position the box of the column
     * @param number to be searched
     * @param grid the array a numbers
     * @return if the number is greater than 1 are repeated in the box 3X3
     */
    public static int usedInBox(int boxStartRow, int boxStartCol, int number, int[][] grid) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result = result + solvegrid3X3(boxStartRow, boxStartCol, number, i, grid);
        }

        return result;
    }
    
    /**
     * Verified the box 3X3 the number not contain repeated 
     * @param boxStartRow star position the box of the row
     * @param boxStartCol star position the box of the column
     * @param number to be searched
     * @param i position to be searched 
     * @param grid the array a numbers
     * @return if the number is greater than 1 are repeated in the box 3X3
     */

    private static int solvegrid3X3(int boxStartRow, int boxStartCol, int number, int i, int[][] grid) {
        int result = 0;
        for (int j = 0; j < 3; j++) {
            if (grid[i + boxStartRow][j + boxStartCol] == number) {
                result++;
            }
        }
        return result;
    }
    
    public static int [][] twoDimensionalArrayClone(int [][] otherArray) {
        int [][] result = new int[otherArray.length][];
        for (int i = 0; i < otherArray.length; i++) {
            result[i] = otherArray[i].clone();
        }
        return result;
      }
    

}
