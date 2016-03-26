import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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
	private List<Level> level;
	
	  /**
     * Builder class game Configuration
     * @param numeroItems El parámetro numeroItems define el número de elementos que va a tener la serie aleatoria
     */
	
	
	public GameConfiguration(String extensionOutput, String pathOutput, String nameOutput, String algorithmSolve,
			String nameDifficulty, String nameLevel, int rangeLevel, int topLimiteLevel, int bottomLimiteLevel) {
		this.extensionOutput = extensionOutput;
		this.pathOutput = pathOutput;
		this.nameOutput = nameOutput;
		this.algorithmSolve = algorithmSolve;
	
	}
	public GameConfiguration(){
		
	}

	public String getExtensionOutput()
	{
		return extensionOutput;
	}
	

	public void setExtensionOutput(String extensionOutput) 
	{
		this.extensionOutput = extensionOutput;
	}
	
	public String getPathOutput()
	{
		return pathOutput;
	}
	

	public void setPathOutput(String pathOutput)
	{
		this.pathOutput = pathOutput;
	}
	
	public String getNameOutput() 
	{
		return nameOutput;
	}

	public void setNameOutput(String nameOutput) 
	{
		this.nameOutput = nameOutput;
	}
	
	public String getAlgorithmSolve()
	{
		return algorithmSolve;
	}

	public void setAlgorithmSolve(String algorithmSolve)
	{
		this.algorithmSolve = algorithmSolve;
	}
	

	@Override
	public String toString() {
		return "GameConfig \n extensionOutput=" + extensionOutput + ",\n pathOutput=" + pathOutput + ",\n nameOutput="
				+ nameOutput + ",\n algorithmSolve=" + algorithmSolve+"]";
	}
	
	

	public List<Level> getLevel() {
		return level;
	}
	public void setLevel(List<Level> level) {
		this.level = level;
	}
	
	
	
	
	
	
	

}
