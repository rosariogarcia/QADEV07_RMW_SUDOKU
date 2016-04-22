package game.file;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class FileSudoku {
	
	String line = "";
	String coma_limiter = ",";
	String new_line_separator = "\r\n";	
	
	public  void writeFileArray(int[][] array, String pathFile)
	{
		System.out.println("HI");
	}
	public  String readFileArray(String file) 
	{
		System.out.println("HI");
        return file;
	}
		
}
