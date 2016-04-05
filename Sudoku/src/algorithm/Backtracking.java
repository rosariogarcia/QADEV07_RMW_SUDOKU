package algorithm;

/**
 * 
 * @author MijhailVillarroel
 *
 */
public class Backtracking implements AlgorithmSolver {
    private int[][] grid;
    static final int SIZESUDOKU = 9;
    
    /**
     * Constructs algorithmSolver Empty.
     */
    public Backtracking (){
        grid = new int [9][9];
    }
    
    /**
     * Constructs algorithm Solver, this initialize the array parameters
     * @param grid It contains the matrix to solve sudoku.
     */
    public Backtracking (int [][] grid){
        this.grid = grid;
    }
    
    /**
     * Return if resolved returns the array but returns null.
     * @param grid the array to solver.
     * @return
     */
    public int[][] solver(int grid[][]) {
        this.grid = grid;
        if (solveSudoku()) {
            return grid;
        } else
            return null;
    }

    /**
     * Return true if soduko can solver.
     * @return
     */
    public boolean solveSudoku() {
        int row;
        int col;
        int[] blankCell = findBlankLocation();
        row = blankCell[0];
        col = blankCell[1];
        if (row == -1) {

            return true;
        }
        
        if(testValue(row, col))
            return true;
        return false; 
    }
    
    /**
     * return true if can solver.
     * @param row value row	
     * @param col value column
     * @return
     */
    private boolean testValue(int row, int col) {
        boolean result = false;
        for (int i = 1; i <= SIZESUDOKU; i++) {
            
            if (canResolver(row, col, i))
                return true;
        }
        return result;
    }

    /**
     * Return true if de sodoku is solver
     * @param row value row	
     * @param col value column
     * @param i value number into the sodoku
     * @return
     */
    private boolean canResolver(int row, int col, int i) {
        boolean result = false;
        if (isSafe(row, col, i)) {
            
            grid[row][col] = i;
            
            if (solveSudoku()) {
                return true;
            }
           
            grid[row][col] = 0;
        }
        return result;
    }
    
    /**
     * Return true if find a position within the sudoku. 
     * @param row position row	
     * @param col value column
     * @param number
     * @return
     */
    public boolean isSafe(int row, int col, int number) {
    
        if (!UsedInRow(row, number) && !UsedInColumn(col, number) && !UsedInBox(row - row % 3, col - col % 3, number)) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if in the column contains the specified number
     * @param row position row
     * @param number contains the row an column.
     * @return
     */
    public boolean UsedInRow(int row, int number) {
        for (int i = 0; i < SIZESUDOKU; i++) {
            if (grid[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if in the row contains the specified number
     * @param col position column
     * @param number
     * @return boolean 
     */
    public boolean UsedInColumn(int col, int number) {
        for (int i = 0; i < SIZESUDOKU; i++) {
            if (grid[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if in the grid 3 X 3 contains the specified number
     * @param boxStartRow
     * @param boxStartCol
     * @param number
     * @return
     */
    public boolean UsedInBox(int boxStartRow, int boxStartCol, int number) {
        for (int i = 0; i < 3; i++) {
            if(solve(boxStartRow, boxStartCol, number, i))
                return true;
        }
        
        return false;
    }

    /**
     * Return true if in grid 3 X 3 not contains the number
     * @param boxStartRow
     * @param boxStartCol
     * @param number
     * @param i
     * @return
     */
    private boolean solve(int boxStartRow, int boxStartCol, int number, int i) {
        boolean result = false;
        for (int j = 0; j < 3; j++) {
            if (grid[i + boxStartRow][j + boxStartCol] == number) {
                return true;
            }
        }
        return result;  
    }

    /**
     * Returns the position of a blank place in the sudoku
     * @return
     */
    public int[] findBlankLocation() {
        int[] cell = new int[2];
        for (int i = 0; i < SIZESUDOKU; i++) {

            if (sudokuPositionBlank(cell, i) != null)
                return sudokuPositionBlank(cell, i);
        }
        cell[0] = -1;
        cell[1] = -1;
        return cell;
    }
    
    /**
     * Return a position blank on the grid 9 X 9.
     * @param cell
     * @param i
     * @return
     */
    private int[] sudokuPositionBlank(int[] cell, int i) {
        int [] resCell=null;
        for (int j = 0; j < SIZESUDOKU; j++) {
            if (grid[i][j] == 0) {
                cell[0] = i;
                cell[1] = j;
                resCell = cell;
            }
        }
        return resCell;
    }
  
}
