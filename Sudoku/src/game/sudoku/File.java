package game;

import java.io.IOException;

public interface File {

	public  void writeFileArray(String[][] array) throws IOException;
	public  void readFileArray(String file) throws IOException;
}
