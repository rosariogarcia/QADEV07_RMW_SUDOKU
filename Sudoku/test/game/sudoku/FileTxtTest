package game;

import static org.junit.Assert.*;


import junit.framework.Assert;


import org.junit.Test;


public class FileTxtTest {

	@Test
	public void writeAnDataArrayInAFileTxt() {
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
		pathFileOutput="src\\data\\test1.txt";
		FileTxt file = new FileTxt();
		
		file.writeFileArray(dataSudoku,pathFileOutput);	
		
		//assertEquals("test1.txt", file.getName());
		Assert.assertNotNull(file);
		
	}
	
	@Test
	public void putTheDatasFromFileTxtToTheArraySudoku()
	{
		String pathFileInput = new String();
		pathFileInput="src\\data\\test1.txt";
		FileTxt file = new FileTxt();
		file.readFileArray(pathFileInput);
		
		Assert.assertNotNull(file);
	}
}
