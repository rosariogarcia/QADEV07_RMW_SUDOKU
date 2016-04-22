package game;

import java.util.Scanner;

import algorithm.AlgorithmSolver;
import algorithm.Backtracking;
import game.GameConfiguration;
import game.XML;

public class Menu {
    private Scanner scanner;
    private int optionMenu;
    private XML xml;
    GameConfiguration gameConfig;
    PlayGame playGame;

    public Menu(){
		scanner=new Scanner(System.in);
		optionMenu = 0;
		xml = new XML();
		gameConfig = xml.readXml();								
	}

    public static void main(String ags[]) {
        Menu main = new Menu();
        main.mainMenu();       
    }

    public void mainMenu() {
       
        System.out.print("\n ******************************************************");
        System.out.print("\n **********************--Sudoku--**********************");
        System.out.print("\n ******************************************************");
        optionMenu = 0;
        do {
            System.out.println("\n **********************--Menu--**********************");
            System.out.println("1 .- Settings of the Game");
            System.out.println("2 .- Play");
            System.out.println("3 .- Load Txt and Csv");
            System.out.println("4 .- Export the generated Sudoku");
            System.out.println("5 .- Quit");
            System.out.print("\n Enter an option: ");
            optionMenu = scanner.nextInt();
            switch (optionMenu) {
            case 1:
                SubMenuConfiguracion();
                break;
            case 2:
                menuJugar();
                break;            
            case 3:
                scanner = new Scanner(System.in);
                System.out.print("Enter Path File: ");
                String pathFile = scanner.nextLine();
                new PlayTXTAndCSV(pathFile);
                
            break;
            case 4:
                Level level = gameConfig.getDifficulty();
                SudokuGenerator ge=new SudokuGenerator();
                ge.nextBoard(level.getBlankCellsNumber());  
                String path = gameConfig.getPathOutput()+"/"+gameConfig.getNameOutput()+".txt";
                System.out.println(path);
                ge.printTxt(path);
                
                
            break;
           }
        
        } while (optionMenu != 5);
    }

   

    public void SubMenuConfiguracion() {
        int optionSubMenu = 0;
        do {
            System.out.println("\n **********************-- Sub Menu Configuration --**********************");
            System.out.println("1.- Show Configuracion");
            System.out.println("2.- Modify");
            System.out.println("3.- Return Main Menu");
            System.out.print("\n Enter an option: ");
            optionSubMenu = scanner.nextInt();
            switch (optionSubMenu) {
            case 1:
                System.out.println(xml.readXml().toString());
                break;
            case 2:
                modifyConfiguration();
                break;            
            }
        } while (optionSubMenu != 3);

    }

    public void subMenuModifyConfiguration() {
        System.out.println("**********************-- Set Parameters an Configuration --**********************");
        System.out.println("1.- Algorithm Solve");
        System.out.println("2.- Difficulty");
        System.out.println("3.- Path Output");
        System.out.println("4.- Name File Output");
        System.out.println("5.- Return");
        System.out.print("\n Enter an option: ");
        optionMenu = scanner.nextInt();        
    }

    public void menuLevelCustomConfiguration() {
        System.out.println("**********************-- Custom Level --**********************");

        System.out.println("1.- Limite Level");
        System.out.println("3.- Return");
        System.out.print("\n Enter an option : ");
        int optionLevel = scanner.nextInt();

        do {
            switch (optionLevel) {
            case 1:
                System.out.print("Enter a Top Limete (Integer): ");

                String top = scanner.nextLine();

                System.out.print("Enter a Low Limite (Integer): ");
                String low = scanner.nextLine();
                ImputValidate.isNumeric(low);
            }
        } while (optionLevel != 2);

    }

    public void menuAlgorith() {
        optionMenu = 0;
        do {
            System.out.println("\n **********************-- Algorithm --**********************");
            System.out.println("1 .- Backtracking");
            System.out.println("2 .- Norvig");
            System.out.println("3 .- Branch and Bound");
            System.out.println("4 .- Quit");
            System.out.print("\n Enter an option: ");
            optionMenu = scanner.nextInt();
            switch (optionMenu) {
            case 1:
                gameConfig.setAlgorithmSolve("Backtracking");
                break;
            case 2:               
                gameConfig.setAlgorithmSolve("Norvig");
                break;
            case 3:               
                gameConfig.setAlgorithmSolve("Branch");
                break;
            }
        } while (optionMenu != 4);
    }

    public void menuTypeOutput() {
        optionMenu = 0;
        do {
            System.out.println("\n **********************-- Extension File --**********************");
            System.out.println("1 .- CSV");
            System.out.println("2 .- TXT");
            System.out.println("3 .- Return");
            System.out.print("\n Enter an option: ");
            optionMenu = scanner.nextInt();
            switch (optionMenu) {
            case 1:
                gameConfig.setExtensionOutput("csv");
                break;
            case 2:
                gameConfig.setExtensionOutput("txt");
                break;
            }
        } while (optionMenu != 3);
    }

    public void menuDifficulty() {
        optionMenu = 0;
        do {
            System.out.println("\n **********************-- Difficulty --**********************");
            System.out.println("1 .- Easy");
            System.out.println("2 .- Medium");
            System.out.println("3 .- Hard");
            System.out.println("4 .- Custom");
            System.out.println("5 .- Exit");
            System.out.print("\n Enter an option: ");
            optionMenu = scanner.nextInt();
            switch (optionMenu) {
            case 1:
                gameConfig.setDifficulty("easy");
                break;
            case 2:
                gameConfig.setDifficulty("medium");
                break;
            case 3:
                gameConfig.setDifficulty("hard");
                break;
            case 4:
                gameConfig.setDifficulty("custom");
                break;

            }
        } while (optionMenu != 5);
    }


    public void menuJugar() {        
        playGame = new PlayGame();
        playGame.printSudoku();
        System.out.println("-----------------------Game Start-----------------------");
        
        readRowColum();

    }

    public void readRowColum() {
        boolean exit = true;
        Scanner scannerRead = new Scanner(System.in);
        do {
            System.out.print("Enter Row: ");
            String row = scannerRead.nextLine();
            System.out.print(" Enter Column: ");
            String col = scannerRead.nextLine();
            System.out.print(" Enter Number: ");
            String number = scannerRead.nextLine();
           
            if (ImputValidate.isNumeric(row) && ImputValidate.isNumeric(col)) {
                int intRow = Integer.parseInt(row);
                int intCol = Integer.parseInt(col);
                if (ImputValidate.number1_9(intCol) && ImputValidate.number1_9(intRow)) {
                    if(ImputValidate.isNumeric(number)){
                        int intNumber = Integer.parseInt(number);
                        if(ImputValidate.number1_9(intNumber)){
                            if(!playGame.reviewPositionFilled(intRow, intCol)){
                                playGame.addNumber(intRow, intCol, intNumber);
                                playGame.printSudoku();
                            }else {
                                System.out.println("You can not change box is disabled");
                            }                                                       
                        }
                    }else{
                        if(number.equalsIgnoreCase("h")){
                            int numberHelp=playGame.hepl(intRow, intCol);
                            System.out.println("Hepl :\n Row: " +intRow+"\n Column: "+ intCol+"\n Number: "+numberHelp);
                        }
                        if(number.equalsIgnoreCase("e")){
                                exit = false;
                                System.out.println("------------------**** Game Over ****------------------");
                        }
                                                    
                    }
                    
              

                } else{                
                    
                    System.out.println("Only Number 0 - 9 !!");
                }
                    

            } else{
                if(row.equalsIgnoreCase("h") || col.equalsIgnoreCase("h") || number.equalsIgnoreCase("h")){                        
                    playGame.heplWithoutRowCol();
                    
                }
                if(row.equalsIgnoreCase("e") || col.equalsIgnoreCase("e") || number.equalsIgnoreCase("e")){                        
                    exit = false;
                    System.out.println("------------------**** Game Over ****------------------");
                } else
                    System.out.println("Only Number, E= Exit, H= help!!");
                
            }               
            if (playGame.countZero() == 0){
                playGame.correctlySolved();
                exit = false;
                System.out.println("------------------**** Game Over ****------------------");
            }                          
        } while (exit);

    }

  public boolean numberRowAndColumn(String row, String col ){
      if (ImputValidate.isNumeric(row) && ImputValidate.isNumeric(col) ){
          return true;
      } 
      return false;
  }
    
    public void modifyConfiguration() {
        Scanner read = new Scanner(System.in);
        int optionModify;
        do {
            System.out.println("**********************-- Set Parameters an Configuration --**********************");
            System.out.println("1.- Algorithm Solve");
            System.out.println("2.- Extension Output");
            System.out.println("3.- Difficulty");
            System.out.println("4.- Name File Output");
            System.out.println("5.- Custom Level");
            System.out.println("6.- Return");
            System.out.print("\n Enter an option: ");
            optionModify = scanner.nextInt();

            String nameScanner = "";
            int numberScanner = 0;
            switch (optionModify) {
            case 1:
            
                menuAlgorith();
                break;
            case 2:
           
                menuTypeOutput();
                break;
            case 3:
            
                menuDifficulty();

                break;
            case 4:
                System.out.print("Enter an Name File Output (String): ");
                nameScanner = read.nextLine();
                gameConfig.setNameOutput(nameScanner);

                break;
            case 5:
                System.out.print("Enter a Low Value: ");                
                String  low = read.nextLine();
                System.out.print("Enter a Top: ");                
                String  top = read.nextLine();                
                gameConfig.updateLevelCustom(Integer.parseInt(top),Integer.parseInt(low));                
                break;
            }            
            System.out.println("The update: " + xml.updateXml(gameConfig));
           
        } while (optionModify != 6);
        SubMenuConfiguracion();
    }
}
