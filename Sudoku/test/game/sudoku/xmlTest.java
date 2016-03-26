

import static org.junit.Assert.*;

import org.junit.Test;


import xml.GameConfiguration;
import xml.Xml;

public class xmlTest {

	@Test
	public void xmlCanBeCreatedWithNoParameters() 
	{
		Xml newXml = new Xml();
		assertNotNull(newXml);
	}
	
	@Test
	public void xmlreedFile() 
	{
		Xml newXml = new Xml();
		
		assertNotNull(newXml.readXml());
	}
	
	@Test
	public void aInstanceOfXMLAlsoInstanceOfGameConfiguration() 
	{
		Xml newXml = new Xml();
		assertTrue(newXml.readXml() instanceof GameConfiguration);
	}
	
	@Test
	public void aUpdateFileXmlWhithParameter() 
	{
		Xml newXml = new Xml();
		GameConfiguration game=newXml.readXml();
		 game.setPathOutput("C:'\'");
		 game.setAlgorithmSolve("Backtracking");
		assertTrue(newXml.isUpdateXml(game));
	}
	
	@Test
	public void verifedaUpdateFileXmlWhithParameter() 
	{
		Xml newXml = new Xml();
		GameConfiguration game=newXml.readXml();
		game.setPathOutput("C:\\");
		game.setAlgorithmSolve("Backtracking");
		newXml.isUpdateXml(game);
		game=newXml.readXml();
		assertEquals("C:\\",game.getPathOutput());
		assertEquals("Backtracking",game.getAlgorithmSolve());
	}


}
