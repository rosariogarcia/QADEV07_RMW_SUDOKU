package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileCsv implements File {

	int ROWC = 0;
	static int COLC = 0;
	
	static String line = "";
	final static String COMA_LIMITER = ",";
	final static String NEW_LINE_SEPARATOR = "\n";
	final static String character = "";
	
	
	@Override
	public void writeFileArray(String[][] array) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			FileWriter fileWriter = new FileWriter("src\\data\\array2.csv");

			for (ROWC = 0; ROWC < array.length; ROWC++) {
				String content = " ";
				
				for (COLC = 0; COLC < 9; COLC++) {
					content += array[ROWC][COLC] + ",";

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


	@Override
	public void readFileArray(String file) throws IOException {
		// TODO Auto-generated method stub
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader stdin = new BufferedReader(fileReader);
			
			for(ROWC = 0; ROWC  < 9; ROWC ++)
			{
				line = stdin.readLine();
				for(COLC= 0; COLC< 9; COLC++){
					
					System.out.println("This is the value:"+character);
					
				}
			}
			fileReader.close();

		} catch (Exception e) {
			Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
}
