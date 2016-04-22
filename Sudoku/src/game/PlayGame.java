package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algorithm.AlgorithmSolver;
import algorithm.Backtracking;

public class PlayGame {
    private SudokuGenerator sudokuGenerator;
    private GameConfiguration configuration;
    private int [][] gridSudoku ;
    private int [][] solver;   
    private Level level;
    static final int SIZESUDOKU = 9;
   
    public PlayGame(){
       
        configuration = XML.readXml();
        level = configuration.getDifficulty();
        sudokuGenerator = new SudokuGenerator(); 
        sudokuGenerator.nextBoard(blankCellsNumber());       
        this.gridSudoku = sudokuGenerator.getBoard();
        this.solver = sudokuGenerator.getSolver();               
    }
        
    public boolean reviewPositionFilled(int row, int col){
        //missing create  method generateSudoku.getFilledPosition()
        List<Position> filledPosition = sudokuGenerator.getFilledPositions();
        for (Position position : filledPosition) {
            if(position.equals(new Position(row, col)))
                return true;
            
        }
        return false;
    }
   
    public void addNumber(int row, int col, int number){
        
        this.gridSudoku [row][col]=number;
    }
    
    public int [][] getgrid(){
        return this.gridSudoku;
        
    }
    
    public void setSolver(int [] [] grid){
        this.solver = grid;
        
    }
    
    public void printRow(){
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) {
                System.out.print("| "); // for more readability
            }
            System.out.print(row+" ");
        }
        System.out.println();
    }
    
    public void printSudoku() {
        printRow();
        for (int row = 0; row < SIZESUDOKU; row++) {
            if (row % 3 == 0) {
                System.out.println("-------+------+-------"); // for more
                                                                // readability
            } System.out.print(row);
            for (int col = 0; col < SIZESUDOKU; col++) {
                if (col % 3 == 0) {
                    System.out.print("|"); // for more readability
                }
                System.out.print(this.gridSudoku[row][col] + " ");

            }
            System.out.println("|");
        }
    }
    
    public void printSudokuPuzzle2() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(this.gridSudoku[i][j] + "  ");
            }
            System.out.println();
        }
    }
    
    public int countZero() {
        int result = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.gridSudoku[i][j] == 0)
                    result++;
            }
        }
        return result;
    }
    
    
    public Position positionZero() {
        Position result = null;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.gridSudoku[i][j] == 0){
                    return  new Position(i, j);              
                }                    
            }
        }
        return result;
    }
    
    public int hepl(int row, int col) {
        addNumber(row, col, solver[row][col]);
        printSudoku();
        return solver[row][col];
    }



    public void heplWithoutRowCol() {
        
        Position position = positionZero();
        int row = position.getRow();
        int col = position.getCol();
        addNumber(row, col, solver[row][col]);
        printSudoku();
        System.out.println("Hepl :\n Row: " +row+"\n Column: "+ col +"\n Number: "+ solver[row][col]);
               
    }
    
    public int blankCellsNumber() {    
        return new Random().nextInt((level.getTop() - level.getLow()) + 1) + level.getLow();
    }
    
    public boolean correctlySolved(){
        for (int i = 0; i < gridSudoku.length; i++) {
            for (int j = 0; j < gridSudoku.length; j++) {
                if(gridSudoku[i][j] != solver[i][j]){
                    System.out.println("Mistakes");
                    System.out.println("Row: " +i+"Column: "+j+" numbre: "+solver[i][j]);
                    
                }
            }
            
        }
       
        if(gridSudoku == solver){
            System.out.println("Good Job");
            return true;
            
        }            
        return false;
        
    }

}
