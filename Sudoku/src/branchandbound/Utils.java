/**
 * 
 */
package branchandbound;

/**
 * @author rosariogarcia
 *
 */
public class Utils {
	public static int[][] copiarmatrix(int[][] matrix) {
		int[][] myInt = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++)
			myInt[i] = matrix[i].clone();
		return myInt;
	}
	
	public static int boolToInt(boolean myBoolean){
        return (myBoolean) ? 1 : 0;
    }
}
