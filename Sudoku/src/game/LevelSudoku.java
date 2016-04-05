package game;

import java.util.Random;

/**
 * 
 * @author RosarioGarcia
 * This class use to create a level of the game
 * 
 */
public class LevelSudoku {

	private String name;
	private int topLimit;
	private int bottomLimit;
	
	
	/**
	 * LevelSudoku Constructor,
	 * Initialize a level with name, and bottom and top limits
	 *  
	 * @param name : level's name
	 * @param topLimit : level's top limit
	 * @param bottomLimit : level's bottom limit
	 */
	public LevelSudoku(String name, int topLimit, int bottomLimit){
		this.setName(name);
		this.topLimit = topLimit;
		this.bottomLimit = bottomLimit;
	}
	
	/**
	 * getName(): This method return level's name 
	 * @return name : level's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setName(): This method set the level name value
	 * @param name : level's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getTopLimit(): This method return level's top limit
	 * @return topLimit : level's top limit
	 */
	public int getTopLimit() {
		return topLimit;
	}

	/**
	 * setTopLimit(): This method set the top limit value
	 * @param topLimit : level's top limit
	 */
	public void setTopLimit(int topLimit) {
		this.topLimit = topLimit;
	}

	/**
	 * getBottomLimit(): This method return level's bottom limit
	 * @return bottomLimit :level's bottom limit
	 */
	public int getBottomLimit() {
		return bottomLimit;
	}

	/**
	 * setBottomLimit(): This method set the bottom limit value
	 * @param bottomLimit :level's bottom limit
	 */
	public void setBottomLimit(int bottomLimit) {
		this.bottomLimit = bottomLimit;
	}

	/**
	 * @return random number from limits from bottom to top number 
	 * of blank cells for given difficulty level.
	 */
	public int getBlankCellsNumber(){
		return new Random().nextInt((topLimit - bottomLimit) + 1) + bottomLimit;
	}
}
