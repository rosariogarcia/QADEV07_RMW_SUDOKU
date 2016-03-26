
import static org.junit.Assert.*;

import org.junit.Test;
import xml.GameConfiguration;

public class GameConfigTest {

	@Test
	public void GameConfigurationCanBeCreatedWithNoParameters() {
		GameConfiguration newgame = new GameConfiguration();
		assertNotNull(newgame);
	}
	
	@Test
	public void GameConfigCanBeCreatedWithParameters() {
		GameConfiguration anotherGameConfiguration = new GameConfiguration("TXT", "C://", "Solution", "algorithmX", "PRincipiante", "Principiante", 90, 1, 2);
		assertTrue( anotherGameConfiguration instanceof GameConfiguration);
	}
	
	@Test
	public void verifiedReturnGeTaParameters() {
		GameConfiguration anotherGameConfiguration = new GameConfiguration("TXT", "C://", "Solution", "algorithmX", "PRincipiante", "Principiante", 90, 1, 2);
		assertEquals( anotherGameConfiguration.getExtensionOutput(), "TXT");
	}
	
	@Test
	public void verifiedReturnSeTaParameters() {
		GameConfiguration anotherGameConfiguration = new GameConfiguration("TXT", "C://", "Solution", "algorithmX", "PRincipiante", "Principiante", 90, 1, 2);
		anotherGameConfiguration.setExtensionOutput("csv");
		assertEquals( anotherGameConfiguration.getExtensionOutput(), "csv");
	}

}
