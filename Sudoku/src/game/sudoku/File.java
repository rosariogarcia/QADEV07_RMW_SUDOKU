package game;

import java.io.IOException;

public interface File {
	
	String line = "";
	String coma_limiter = ",";
	String new_line_separator = "\n";	
	
	public  void writeFileArray(String[][] array, String pathFile) throws IOException;
	public  void readFileArray(String file) throws IOException;
		
}
