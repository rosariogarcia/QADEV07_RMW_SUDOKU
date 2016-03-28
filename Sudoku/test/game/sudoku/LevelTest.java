package game.sudouku;

import static org.junit.Assert.*;
import org.junit.Test;


public class LevelTest {

	@Test
	public void levelCanBeCreatedWithNameTopLimitAndBottomLimitParameters(){
		Level newLevel = new Level("Easy",75,70);
		assertTrue(newLevel instanceof Level);
	}
	
	@Test
	public void levelCreatedWithNameTopLimitAndBottomLimitParametersShouldReturnThem(){
		Level anotherLevel = new Level("Easy",75,70);
		assertEquals("Easy",anotherLevel.getName());
		assertEquals(75,anotherLevel.getTopLimit());
		assertEquals(70,anotherLevel.getBottomLimit());
	}
	
	@Test
	public void topLimitAndBottomLimitShouldMajorThanZero(){
		Level anotherLevel = new Level("Easy",75,70);
		assertTrue(anotherLevel.getTopLimit()>0);
		assertTrue(anotherLevel.getBottomLimit()>0);
	}
	
	@Test
	public void topLimitAndBottomLimitShouldBeDiferents(){
		Level anotherLevel = new Level("Easy",75,70);
		assertFalse(anotherLevel.getTopLimit()==anotherLevel.getBottomLimit());
	}
	
	@Test
	public void theRandomValueShouldBeBetweentopLimitAndBottomLimit(){
		Level anotherLevel = new Level("Easy",75,70);
		assertTrue(	anotherLevel.getBlankCellsNumber()	>	anotherLevel.getBottomLimit() && 
					anotherLevel.getBlankCellsNumber()	<= 	anotherLevel.getTopLimit());
	}	
}
