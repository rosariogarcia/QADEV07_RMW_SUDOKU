package game;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import junit.framework.TestCase;

public class WriteFileNiceTxtTest {

	@Test
	public void writefileWithFormatInTxt()
	{
		String[][] dataSudoku = new String[][]{{"1","2","3","4","5","6","7","8","9"},
				  {"1","2","3","4","5","6","7","8","9"},
				  {"1","2","3","4","5","6","7","8","9"},
				  {"1","2","3","4","5","6","7","8","9"},
				  {"1","2","3","4","5","6","7","8","9"},
				  {"1","2","3","4","5","6","7","8","9"},
				  {"1","2","3","4","5","6","7","8","9"},
				  {"1","2","3","4","5","6","7","8","9"},
				  {"1","2","3","4","5","6","7","8","9"}};
		String pathFile = new String();
		pathFile="src\\data\\testWriteNice2.txt";
		WriteFileNiceTxt file = new WriteFileNiceTxt();
		file.writeFileArray(dataSudoku,pathFile);	
		
		assertNotNull(file);
		
	}
	
}
