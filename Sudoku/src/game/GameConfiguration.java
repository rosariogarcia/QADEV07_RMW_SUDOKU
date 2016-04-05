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
    
    /*
     * Returns the name Type the file.
     * @return name of a extension output
     */
    public String getExtensionOutput()
    {
        return extensionOutput;
    }
    
    /**
     * Change the extension Output name.
     * @param extensionOutput
     */
    public void setExtensionOutput(String extensionOutput) 
    {
        this.extensionOutput = extensionOutput;
    }
    
    /**
     * Return the path out file.
     * @return
     */
    public String getPathOutput()
    {
        return pathOutput;
    }
    
    /**
     * set path output 
     * @param pathOutput
     */
    public void setPathOutput(String pathOutput)
    {
        this.pathOutput = pathOutput;
    }
    
    /**
     * Return the name output
     * @return
     */
    public String getNameOutput() 
    {
        return nameOutput;
    }
    
    /**
     * set the name output
     * @param nameOutput
     */
    public void setNameOutput(String nameOutput) 
    {
        this.nameOutput = nameOutput;
    }
    
    /**
     * Return the Type algorithm solver sudoku
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
     * Retur the list  level
     * @return
     */
    public List<Level> getLevel() {
        return levels;
    }
    
    /**
     * Set list level
     * @param levels
     */
    public void setLevel(List<Level> levels) {
        this.levels = levels;
    }

 
    @Override
    public String toString() {
        return " GameConfiguration \n [extensionOutput=" + extensionOutput + ", pathOutput=" + pathOutput + ", \n nameOutput="
                + nameOutput + ", algorithmSolve=" + algorithmSolve + ", levels=" + levels.toString() + "]";
    }
    
    
    
    
    
    
    
    

}
