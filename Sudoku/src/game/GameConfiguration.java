package game;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



/**
 * @author Mijhail Villarroel
 * @version 1.0 
 *
 */
@XmlRootElement
@XmlType(propOrder = { "extensionOutput", "pathOutput", "nameOutput","algorithmSolve","level"})
public class GameConfiguration {


    
    private String extensionOutput; 
    private String pathOutput;
    private String nameOutput;  
    private String algorithmSolve;
    private List<Level> levels=new ArrayList<>();
    
      /**
     * Constructs Game Configuration, this initialize the game parameters
     * @param extensionOutput The default file type (the file extension).
     * @param pathOutput The address where solved Sudokus be saved.
     * @param nameOutput The default name of the saved sudoku.
     * @param algorithmSolve The default type of algorithm that will resolve the sudoku.
     */
    public GameConfiguration(String extensionOutput, String pathOutput, String nameOutput, String algorithmSolve) {
        this.extensionOutput = extensionOutput;
        this.pathOutput = pathOutput;
        this.nameOutput = nameOutput;
        this.algorithmSolve = algorithmSolve;
        levels=new ArrayList<>();
    
    }
    
    /**
     * Constructs an empty.
     */
    public GameConfiguration(){
        
    }
    
    /*Returns the name Type the file.
     * 
     * @return name of a extension output
     */
    public String getExtensionOutput()
    {
        return extensionOutput;
    }
    
    /**
     * 
     * @param extensionOutput
     */
    public void setExtensionOutput(String extensionOutput) 
    {
        this.extensionOutput = extensionOutput;
    }
    
    /**
     * 
     * @return
     */
    public String getPathOutput()
    {
        return pathOutput;
    }
    
    /**
     * 
     * @param pathOutput
     */
    public void setPathOutput(String pathOutput)
    {
        this.pathOutput = pathOutput;
    }
    
    /**
     * 
     * @return
     */
    public String getNameOutput() 
    {
        return nameOutput;
    }
    
    /**
     * 
     * @param nameOutput
     */
    public void setNameOutput(String nameOutput) 
    {
        this.nameOutput = nameOutput;
    }
    
    /**
     * 
     * @return
     */
    public String getAlgorithmSolve()
    {
        return algorithmSolve;
    }
    
    /**
     * 
     * @param algorithmSolve
     */
    public void setAlgorithmSolve(String algorithmSolve)
    {
        this.algorithmSolve = algorithmSolve;
    }
    
    /**
     * 
     * @return
     */
    public List<Level> getLevel() {
        return levels;
    }
    
    /**
     * 
     * @param levels
     */
    public void setLevel(List<Level> levels) {
        this.levels = levels;
    }

    
    
    @Override
    public String toString() {
        return " Game Configuration \n [extension Output=" + extensionOutput + ", path Output=" + pathOutput + ", \n nameOutput="
                + nameOutput + ", algorithm Solver=" + algorithmSolve + ", " + getDifficulty().toString() + "]";
    }
    
    public void updateLevelCustom( int top, int low){
        for (Level level : levels) {
            if(level.getName().toLowerCase().equals("custom")){
                level.setTop(top);
                level.setLow(low);
            }
        }
    }
    
    public void setDifficulty(String nameOtherLevel) {
        for (Level level : levels) {
            if (level.getName().toLowerCase().equals(nameOtherLevel)) {
                level.setIdActual(1);
            } else {
                level.setIdActual(0);
            }
        }
    }
    
    public  Level getDifficulty() {
        for (Level level : levels) {
            if (level.getIdActual() == 1) {
                return level;
            } 
        }
        return null;
    }
    
    
    
    
    
    
    
    

}
