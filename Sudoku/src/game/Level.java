/**
 * @author Charito,
 */
package game;

import java.util.Random;

public class Level {

	private String name;
	private int topLimit;
	private int bottomLimit;
	
	
		
	public Level(String name, int topLimit, int bottomLimit){
		this.setName(name);
		this.topLimit = topLimit;
		this.bottomLimit = bottomLimit;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getTopLimit() {
		return topLimit;
	}

	public void setTopLimit(int topLimit) {
		this.topLimit = topLimit;
	}

	public int getBottomLimit() {
		return bottomLimit;
	}

	public void setBottomLimit(int bottomLimit) {
		this.bottomLimit = bottomLimit;
	}
	
	/**
     	* @return random number from limits from bottom to top number of blank cells for given difficulty level.
     	*/
	public int getBlankCellsNumber(){
		return new Random().nextInt((topLimit - bottomLimit) + 1) + bottomLimit;
	}
}
