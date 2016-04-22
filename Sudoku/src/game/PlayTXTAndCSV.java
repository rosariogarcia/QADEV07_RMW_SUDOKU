package game;

import algorithm.AlgorithmSolver;
import algorithm.Backtracking;
import algorithm.branchandbound.BranchAndBound;
import game.file.FileCsv;
import game.file.FileSudoku;
import game.file.FileTxt;

public class PlayTXTAndCSV {
    
    private GameConfiguration configuration; 
    private String path;
    private FileSudoku fileSudoku;
    private String sudoku;
    private AlgorithmSolver algoritmo;
    
    public PlayTXTAndCSV(String path){  
        configuration = XML.readXml(); 
        this.path = path;
        readFile();      
    }
    
    private String getFileExtension(String file) {
        try {
            return file.substring(file.lastIndexOf(".") + 1);
            
        } catch (Exception e) {
            return "";
        }
    }
    
    private void readFile() {
       String extencion = getFileExtension(path);
       if(extencion.equalsIgnoreCase("TXT")){
           fileSudoku = new FileTxt();     
           sudoku = fileSudoku.readFileArray(path);
           if(sudoku !=null)
               play();
           else System.out.println("Path not valid");
          
       }else
       if(extencion.equalsIgnoreCase("CSV")){
           fileSudoku = new FileCsv();
           sudoku = fileSudoku.readFileArray(path);
           if(sudoku !=null)
               play();
           else 
               System.out.println("Path not valid");
       }else System.out.println("Path not valid");               
    }
    
    public void play (){
        System.out.println(TimerSudoku.startSudoku());
        if(ImputValidate.isNumericStingLog(sudoku)){
            
            int [][] grid = ImputValidate.convertToMatrix(sudoku);
            if(ValidateSudoku.isValidArray(ImputValidate.convertToMatrix(sudoku))){
                resolver(grid);                
            }else System.out.println("Sudoku not Valid");           
                
        }else System.out.println("Contain Strings");
        System.out.println(TimerSudoku.stop());
    }
    
    public void resolver(int [][] grid){
        String algorithName = configuration.getAlgorithmSolve();
        
        if (algorithName.equalsIgnoreCase("Backtracking")){
            algoritmo = new Backtracking();
            printSudoku(algoritmo.solver(grid)); 
                           
        }else
            if (algorithName.equalsIgnoreCase("Norvig")){
                //algoritmo = new Backtracking();
                //printSudoku(algoritmo.solver(grid)); 
            
            }else
                if (algorithName.equalsIgnoreCase("Branch")){
                    algoritmo = new BranchAndBound();
                    printSudoku(algoritmo.solver(grid)); 
            
                }        
    }
  
    public void printSudoku(int [][] gridSudoku) {
        
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) {
                System.out.println("-------+------+-------"); // for more
                                                                // readability
            } 
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) {
                    System.out.print("|"); // for more readability
                }
                System.out.print(gridSudoku[row][col] + " ");

            }
            System.out.println("|");
        }
    }

    

}
