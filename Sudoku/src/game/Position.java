package game;

public class Position {
    private int row;
    private int col;
    
    public Position (int row, int col){
        this.row=row;
        this.col=col;        
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the column
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the column to set
     */
    public void setCol(int col) {
        this.col = col;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + col;
        result = prime * result + row;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {     
        Position other = (Position) obj;
        if (col == other.col && row == other.row)
            return true;
        
        return false;
    }
    
    
    
    
    
    

}
