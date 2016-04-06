package gameTest;

import static org.junit.Assert.*;

import org.junit.Test;

import game.GameConfiguration;
import game.Xml;

public class xmlTest {

	@Test
	public void xmlCanBeCreatedWithNoParameters() {
		Xml newXml = new Xml();
		assertNotNull(newXml);
	}

	@Test
	public void xmlreadFile() {
		Xml newXml = new Xml();

		assertNotNull(newXml.readXml());
	}

	@Test
	public void aInstanceOfXMLAlsoInstanceOfGameConfiguration() {
		Xml newXml = new Xml();
		assertTrue(newXml.readXml() instanceof GameConfiguration);
	}

	@Test
	public void aUpdateFileXmlWhithParameter() {
		Xml newXml = new Xml();
		GameConfiguration game = newXml.readXml();
		game.setNameOutput("Sudoku");
		game.setExtensionOutput("CSV");
		assertTrue(newXml.updateXml(game));
	}

	@Test
	public void verifedaUpdateFileXmlWhithParameter() {
		Xml newXml = new Xml();
		GameConfiguration game = newXml.readXml();
		game.setNameOutput("Sudoku01");
		game.setExtensionOutput("CSV");
		newXml.updateXml(game);
		game = newXml.readXml();
		assertEquals("Sudoku01", game.getNameOutput());
		assertEquals("CSV", game.getExtensionOutput());
	}

}
