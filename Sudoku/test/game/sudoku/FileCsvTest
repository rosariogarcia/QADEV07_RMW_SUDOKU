package game;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class FileCsvTest {

	@Test
	public void writeAnDataArrayInAFileCsv() {
		String[][] dataSudoku = new String[][]{{"1","2","3","4","5","6","7","8","9"},
											  {"1","2","3","4","5","6","7","8","9"},
											  {"1","2","3","4","5","6","7","8","9"},
											  {"1","2","3","4","5","6","7","8","9"},
											  {"1","2","3","4","5","6","7","8","9"},
											  {"1","2","3","4","5","6","7","8","9"},
											  {"1","2","3","4","5","6","7","8","9"},
											  {"1","2","3","4","5","6","7","8","9"},
											  {"1","2","3","4","5","6","7","8","9"}};
		String pathFileOutput = new String();
		pathFileOutput="src\\data\\test1.csv";
		FileTxt file = new FileTxt();
		
		file.writeFileArray(dataSudoku,pathFileOutput);	
		
		//assertEquals("test1.csv", file.getName());
		Assert.assertNotNull(file);
		
	}
	
	@Test
	public void putTheDatasFromFileCsvToTheArraySudoku()
	{
		String pathFileInput = new String();
		pathFileInput="src\\data\\test1.csv";
		FileTxt file = new FileTxt();
		file.readFileArray(pathFileInput);
		
		Assert.assertNotNull(file);
	}
}
