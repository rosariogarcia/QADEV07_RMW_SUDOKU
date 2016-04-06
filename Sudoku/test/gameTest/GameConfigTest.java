package gameTest;

import static org.junit.Assert.*;

import org.junit.Test;

import game.GameConfiguration;

public class GameConfigTest {

	@Test
	public void GameConfigurationCanBeCreatedWithNoParameters() {
		GameConfiguration newgame = new GameConfiguration();
		assertNotNull(newgame);
	}
	
	@Test
	public void GameConfigCanBeCreatedWithParameters() {
		GameConfiguration anotherGameConfiguration = new GameConfiguration("TXT", "C://", "Solution", "algorithmX");
		assertTrue( anotherGameConfiguration instanceof GameConfiguration);
	}
	
	@Test
	public void verifiedReturnGeTaParameters() {
		GameConfiguration anotherGameConfiguration = new GameConfiguration("TXT", "C://", "Solution", "algorithmX");
		assertEquals( anotherGameConfiguration.getExtensionOutput(), "TXT");
	}
	
	@Test
	public void verifiedReturnSeTaParameters() {
		GameConfiguration anotherGameConfiguration = new GameConfiguration ("TXT", "C://", "Solution", "algorithmX");
		anotherGameConfiguration.setExtensionOutput("csv");
		assertEquals( anotherGameConfiguration.getExtensionOutput(), "csv");
	}

}
