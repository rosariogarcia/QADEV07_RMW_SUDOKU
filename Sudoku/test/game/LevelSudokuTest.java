package game;

import static org.junit.Assert.*;
import org.junit.Test;

import game.LevelSudoku;

/**
 * 
 * @author RosarioGarcia
 *
 */
public class LevelSudokuTest {


	@Test
	public void levelCanBeCreatedWithNameTopLimitAndBottomLimitParameters() {
		LevelSudoku newLevel = new LevelSudoku("Easy", 75, 70);
		assertTrue(newLevel instanceof LevelSudoku);
	}

	@Test
	public void levelCreatedWithNameTopLimitAndBottomLimitParametersShouldReturnThem() {
		LevelSudoku anotherLevel = new LevelSudoku("Easy", 75, 70);
		assertEquals("Easy", anotherLevel.getName());
		assertEquals(75, anotherLevel.getTopLimit());
		assertEquals(70, anotherLevel.getBottomLimit());
	}

	@Test
	public void topLimitAndBottomLimitShouldMajorThanZero() {
		LevelSudoku anotherLevel = new LevelSudoku("Easy", 75, 70);
		assertTrue(anotherLevel.getTopLimit() > 0);
		assertTrue(anotherLevel.getBottomLimit() > 0);
	}

	@Test
	public void topLimitAndBottomLimitShouldBeDiferents() {
		LevelSudoku anotherLevel = new LevelSudoku("Easy", 75, 70);
		assertFalse(anotherLevel.getTopLimit() == anotherLevel.getBottomLimit());
	}

	@Test
	public void theRandomValueShouldBeBetweentopLimitAndBottomLimit() {
		LevelSudoku anotherLevel = new LevelSudoku("Easy", 75, 70);
		assertTrue(anotherLevel.getBlankCellsNumber() > anotherLevel.getBottomLimit()
				&& anotherLevel.getBlankCellsNumber() <= anotherLevel.getTopLimit());
	}
}
