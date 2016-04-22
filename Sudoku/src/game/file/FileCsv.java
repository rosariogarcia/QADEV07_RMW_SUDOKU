package game.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileCsv extends FileSudoku {
	int row = 0;
	int col = 0;

	/**
	 * This method write in a file csv the value of a array that contain string
	 * data and save it in a place specific from the PC
	 * 
	 * @param arraySudoku  	the arraySudoku contain the data to export to the file
	 * @param pathFile	the pathFile contain the root and the name file
	 */

	@Override
	public void writeFileArray(int[][] arraySudoku, String pathFile) {
		try {
			FileWriter fileWriter = new FileWriter(pathFile);
			getContentFile(arraySudoku, fileWriter);
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			Logger.getLogger(FileCsv.class.getName()).log(Level.SEVERE, null,
					e);
		}
	}

	/**
	 * This method read from the file and put the data in a array of integer
	 * value
	 * 
	 * @param file	the file to allow to read the data from the file
	 */
	@Override
	public String readFileArray(String file) {
		String result = null;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader stdin = new BufferedReader(fileReader);
			//putOnArraySudoku(dataSudoku, stdin);
			result = putOnArraySudoku(stdin);
			fileReader.close();
			return  result;
			
			
		}catch (FileNotFoundException e) {
            
            return result;
            
            
        } 
		catch (Exception e) {
			Logger.getLogger(FileCsv.class.getName())
					.log(Level.SEVERE, null, e);
			return result;
		}
	}

	/**
	 * This method run every line of the file in put in a specific place in a
	 * array
	 * 
	 * @throws IOException	If an input or output exception occurred
	 * @param dataSudoku	the dataSudoku to display a array of string of 9X9
	 * @param stdin		the stdin to allow to read of the file txt
	 */
	private String putOnArraySudoku( BufferedReader stdin)
			throws IOException {
	    String sudokuLine = ""; 
		String line = null;
		while ((line = stdin.readLine()) != null ) {
			StringTokenizer st = new StringTokenizer(line, "\t");
			while (st.hasMoreTokens()) {
				//dataSudoku[col][row] = Integer.parseInt(st.nextToken());
			    sudokuLine = sudokuLine+ (st.nextToken(" ,"));
				col++;
			}
			col = 0;
			row++;
		}
		return sudokuLine;
	}

	/**
	 * This method runs every segment of the array to put in a segment from the
	 * file
	 * 
	 * @throws IOException	If an input or output exception occurred
	 * @param arraySudoku	the arraySudoku to contain a array of string of 9X9
	 * @param fileWriter	the fileWriter to allow to write in the file txt
	 */
	private void getContentFile(int[][] arraySudoku, FileWriter fileWriter)
			throws IOException {
		for (int row = 0; row < arraySudoku.length; row++) {
			String content = " ";
			for (int col = 0; col < 9; col++) {
				content += arraySudoku[row][col] + ",";
			}
			fileWriter.write(new_line_separator);
			fileWriter.write(String.valueOf(content));
			fileWriter.write(coma_limiter);
		}
	}
}
