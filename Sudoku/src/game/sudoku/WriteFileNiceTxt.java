package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author WilmaPaca
 * 
 */
public class WriteFileNiceTxt implements File {
	/**
	 * @param arraySudoku
	 * @param pathFile
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
	 * 
	 * @param arraySudoku
	 * @param fileWriter
	 * @throws IOException
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
	 * 
	 * @param fileWriter
	 * @param row
	 * @throws IOException
	 */
	private void putLimitRowBox(FileWriter fileWriter, int row)
			throws IOException {
		if (row == 3 || row == 6) {
			fileWriter.write("\n------ + ----- + -----");
		}
	}

	/**
	 * 
	 * @param arraySudoku
	 * @param row
	 * @param content
	 * @param col
	 * @return
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
