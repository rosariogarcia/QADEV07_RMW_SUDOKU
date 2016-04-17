package game;

import exception.NumberException;

public class ImputValidate {
    
    /**
     * converts a String to a two-dimensional array
     * @param stringRead for convert a array
     * @return A two-dimensional array
     */

    public static int[][] convertToMatrix(String stringRead) {
        int[][] grid = new int[9][9];
        int row = 0;
        int col = 0;
        int sizeGrid = 8;
        for (char number : stringRead.toCharArray()) {
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
     * @param stringRead for convert a array
     * @return return true if convert the String to a number
     */
    public static boolean isNumeric(String stringRead) {
        try {
           
                Integer.parseInt(stringRead );
            

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Verified if String is a number
     * @param stringRead for convert a array
     * @return return true if convert the String to a number
     */
    public static boolean isNumericStingLog(String stringRead) {
        try {
            for (char number : stringRead.toCharArray()) {
                Integer.parseInt(number + "");
            }

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    /**
     *  Verified that contain 81 characters. 
     * @param stringRead for convert a array
     * @return true if contain 81 position.
     */
    public static boolean contain81position(String stringRead) {
        return stringRead.length() == 81;
    }
    
    public static boolean number1_9(int numberRead) {
       if(numberRead >= 0 && numberRead<=9)
           return true;
       return false;
    }

}

