package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteFileNiceTxt implements File {
	/**
	 * This method write in a file txt the value of a array that contain string
	 * data and save it in a place specific from the PC
	 * 
	 * @param arraySudoku	the arraySudoku contain the data to export to the file
	 * @param pathFile		the pathFile contain the root and the name file
	 */
	@Override
	public void writeFileArray(String[][] arraySudoku, String pathFile) {
		try {
			FileWriter fileWriter = new FileWriter(pathFile);
			getContentFile(arraySudoku, fileWriter);
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			Logger.getLogger(WriteFileNiceTxt.class.getName()).log(
					Level.SEVERE, null, e);
		}
	}

	/**
	 * This method runs every segment of the array to put in a segment from the
	 * file
	 * 
	 * @param arraySudoku	contain the data for put in a file 
	 * @param fileWriter	the fileWriter to allow to write in the file txt
	 * @throws IOException	If an input or output exception occurred internally in the class
	 */
	private void getContentFile(String[][] arraySudoku, FileWriter fileWriter)
			throws IOException {
		for (int row = 0; row < 9; row++) {
			String content = " ";
			for (int col = 0; col < 9; col++) {
				content = putLimitColumnBox(arraySudoku, row, content, col);
			} 
			putLimitRowBox(fileWriter, row);
			fileWriter.write(new_line_separator);
			fileWriter.write(String.valueOf(content));
		}
	}

	/**
	 * This method put "--" and "+" in the output of the file with format on every 
	 * third and sixth row
	 * 
	 * @param fileWriter	the fileWriter to allow to write in the file txt with format
	 * @param row			is the row what it will have a print "-" and "+"
	 * @throws IOException	If an input or output exception occurred internally in the class
	 */
	private void putLimitRowBox(FileWriter fileWriter, int row)
			throws IOException {
		if (row == 3 || row == 6) {
			fileWriter.write("\n------ + ----- + -----");
		}
	}

	/**
	 * 
	 * @param arraySudoku	contain the data for put in a file
	 * @param row			is the row what it will have a print "|" 
	 * @param content		contain all row of the arraySudoku 
	 * @param col			is the column what it will have a print "|"
	 * @return				return the value of the column and row
	 */
	private String putLimitColumnBox(String[][] arraySudoku, int row,
			String content, int col) {
		if (col == 3 || col == 6) {
			content += "| " + arraySudoku[row][col] + " ";
		} else {
			content += arraySudoku[row][col] + " ";
		}
		return content;
	}

	@Override
	public void readFileArray(String file) throws IOException {

	}
}
