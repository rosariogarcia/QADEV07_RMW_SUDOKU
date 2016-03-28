package game;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.util.StringTokenizer;
import java.io.FileReader;

public class FileTxt implements File {

	int ROWC = 0;
	static int COLC = 0;
	
	static String line = "";
	final static String COMA_LIMITER = ",";
	final static String NEW_LINE_SEPARATOR = "\n";
	final static String character = "";
	
	     /**
	     * @param array
	     * @throws IOException 
	     * Read a array and write on a file
	     */
	@Override
	public void writeFileArray(String[][] array) throws IOException {
		// TODO Auto-generated method stub
		try {
			FileWriter fileWriter = new FileWriter("src\\data\\array4.txt");

			for (ROWC = 0; ROWC < 9; ROWC++) {
				String content = " ";
				
				for (COLC = 0; COLC < 9; COLC++) {
					content += array[ROWC][COLC] + " ";

				}
				
				fileWriter.write(NEW_LINE_SEPARATOR);
				fileWriter.write(String.valueOf(content));
				fileWriter.write(COMA_LIMITER);

			}
			fileWriter.flush();
			fileWriter.close();

		} catch (Exception e) {
			Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	     /**
	     * @param file
	     * @throws IOException 
	     * Read a file TXT and put on a array
	     */
	@Override
	public void readFileArray(String file) throws IOException {
		// TODO Auto-generated method stub
		String[][] data = new String[9][9];
		int row = 0;
		int col = 0;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader stdin = new BufferedReader(fileReader);
			
			String line = null;
			while ((line = reader.readLine()) != null && row < data.length) {
			StringTokenizer st = new StringTokenizer(line, "\t");
				while (st.hasMoreTokens()) {
				data[col][row] = String.valueOf(st.nextToken());
				
				col++;

				}

			col = 0;
			row++;
			}

	}

}