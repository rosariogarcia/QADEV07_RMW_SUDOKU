package game;

public class ValidateSoduko {
    
    public static boolean contain81Position(int [][] grid){
        return grid.length * grid.length == 81;
     } 
    
     public static boolean isValidArray(int[][] grid) {
         for (int i = 0; i < 9; i++) {
             if (! runTheColumns(grid, i))
                 return false;
         }
         return true;
     }
    private static boolean runTheColumns(int[][] grid, int i) {
        
        int number;
        for (int j = 0; j < 9; j++) {
             number = grid[i][j];
            if( repeterANumber(grid, i, number, j) == false ){
                return false;
            }
         }
        return true;
    }
    private static boolean repeterANumber(int[][] grid, int i, int number, int j) {
        boolean result;
        if (number != 0) {
             result = usedInRow(i, number, grid) >= 2 
                     || usedInColumn(j, number, grid) >= 2
                     || usedInBox(i - i % 3, j - j % 3, number, grid) >= 2 ;
             if (result == true)
                 return false;
         }
        return true;
    }
     private static int usedInRow(int row, int number, int [][] grid){
         int result = 0;
         for (int i = 0; i < 9; i++) {
             if (grid[row][i] == number) {
                 result++;
             }
         }
         return result;
     }
     private static int usedInColumn(int col, int number, int [][] grid) {
         int result = 0;
         for (int i = 0; i < 9; i++) {
             if (grid[i][col] == number) {
                 result++;
             }
         }
         return result;
     }

     private static int usedInBox(int boxStartRow, int boxStartCol, int number, int [][] grid) {
         int result = 0;
         for (int i = 0; i < 3; i++) {
             result = result + solvegrid3X3(boxStartRow, boxStartCol, number, i, grid);               
         }
         
         return result;
     }
     private static int solvegrid3X3(int boxStartRow, int boxStartCol, int number, int i, int [][] grid) {
         int result = 0;
         for (int j = 0; j < 3; j++) {                    
             if (grid[i + boxStartRow][j + boxStartCol] == number) {
                 result ++;
             }
         }
         return result;  
     }

}
