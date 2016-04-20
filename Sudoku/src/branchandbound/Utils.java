/**
 * 
 */
package branchandbound;

/**
 * @author rosariogarcia
 * Contains utils methods to use in the algorithm
 */
public class Utils {
	/**
	 * Copy the matrix
	 * @param matrix
	 * @return
	 */
	public static int[][] copiarmatrix(int[][] matrix) {
		int[][] myInt = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++)
			myInt[i] = matrix[i].clone();
		return myInt;
	}
	/**
	 * Convert boolean value to int
	 * @param myBoolean
	 * @return
	 */
	public static int boolToInt(boolean myBoolean){
        return (myBoolean) ? 1 : 0;
    }
}
