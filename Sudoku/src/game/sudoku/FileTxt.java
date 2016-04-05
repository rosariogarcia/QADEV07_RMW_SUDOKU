
package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class FileTxt implements File {
	int row = 0;
	int col = 0;
	/**
	 * This method write in a file txt the value of a array that contain string data
	 * and save it in a place specific from the PC
	 * @param arraySudoku	 the arraySudoku contain the data to export to the file                     
	 * @param pathFile        the pathFile contain the root and the name file	 
	 */	
	@Override
	public void writeFileArray(String[][] arraySudoku,String pathFile)  {
		// TODO Auto-generated method stub
		try {
			FileWriter fileWriter = new FileWriter(pathFile);

			ContentFile(arraySudoku, fileWriter);
			fileWriter.flush();
			fileWriter.close();

		} catch (Exception e) {
			Logger.getLogger(FileTxt.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	/**
	 * This method read from the file and put the data in a array of integer value 
	 *                      
	 * @param file        the file to allow to read the data from the file	 
	 */
	@Override
	public void readFileArray(String file){
		// TODO Auto-generated method stub
		int[][] dataSudoku = new int[9][9];
		
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader stdin = new BufferedReader(fileReader);
						
			PutOnArraySudoku(dataSudoku, stdin);
			fileReader.close();
			
		} catch (Exception e) {
			Logger.getLogger(FileTxt.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	/**
	 * This method run every line of the file in put in a specific place in a array
	 * @throws IOException  If an input or output 
	 *                      exception occurred
	 * @param data          the data to display a array of int value of 9X9
	 * @param stdin         the stdin to allow to read of the file txt
	 */
	private void PutOnArraySudoku(int[][] dataSudoku, BufferedReader stdin)
			throws IOException {
		String line = null;
		
		while ((line = stdin.readLine()) != null && row < dataSudoku.length) {
		StringTokenizer st = new StringTokenizer(line, "\t");
			while (st.hasMoreTokens()) {
			dataSudoku[col][row] = Integer.parseInt(st.nextToken());			
			col++;
			}
		col = 0;
		row++;
		}
	}
	/**
	 * This method runs every segment of the array to put in a segment from the file
	 * @throws IOException  If an input or output 
	 *                      exception occurred
	 * @param arraySudoku    the arraySudoku to contain a array of string of 9X9
	 * @param fileWriter 	the fileWriter to allow to write in the file txt
	 */
	private void ContentFile(String[][] arraySudoku, FileWriter fileWriter) throws IOException {
		for (int row = 0; row < 9; row++) {
			String content = " ";
			
			for (int col = 0; col < 9; col++) {
				content += arraySudoku[col][col] + " ";
			}			
			fileWriter.write(new_line_separator);
			fileWriter.write(String.valueOf(content));
			fileWriter.write(coma_limiter);

		}
	}
	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}	

}
