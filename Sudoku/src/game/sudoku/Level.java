package game.sudoku;

public enum Level {
	/**
	 * Enum class for difficulty levels. 
	 * 
	 * Its bottom and top limits set a range.
	 * 
	 */
    EASY(75,70),
    MEDIUM(55,70),
    HARD(20,30),
    CUSTOM(40,50);

	private final int topLimit;
	private final int bottomLimit;

    Level(int topLimit, int bottomLimit) {
        this.topLimit = topLimit;
        this.bottomLimit = bottomLimit;
    }

	public int getTopLimit() {
		return topLimit;
	}

	public int getBottomLimit() {
		return bottomLimit;
	}


}
