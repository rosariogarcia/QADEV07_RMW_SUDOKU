package game;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "level")
@XmlType(propOrder = { "name", "idActual", "top", "low" })
public class Level {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int idActual;
    private int top;
    private int low;

    public Level() {

    }
    /**
     * LevelSudoku Constructor, Initialize a level with name, and bottom and top
     * limits
     * 
     * @param name
     *            : level's name
     * @param top
     *            : level's top limit
     * @param Low
     *            : level's bottom limit
     */   
    public Level(String name, int top, int low) {
        this.name = name;
        this.idActual = 0;
        this.top = top;
        this.low = low;
    }

    /**
     * getName(): This method return level's name
     * 
     * @return name : level's name
     */   
    public String getName() {
        return name;
    }
    
    /**
     * setName(): This method set the level name value
     * 
     * @param name
     *            : level's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gettop(): This method return level's top limit
     * 
     * @return top : level's top limit
     */    
    public int getTop() {
        return top;
    }
    /**
     * settop(): This method set the top limit value
     * 
     * @param top
     *            : level's top limit
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * getLow(): This method return level's bottom limit
     * 
     * @return Low :level's bottom limit
     */
    public int getLow() {
        return low;
    }
    
    /**
     * setLow(): This method set the bottom limit value
     * 
     * @param Low
     *            :level's bottom limit
     */
    public void setLow(int low) {
        this.low = low;
    }

    /**
     * @return the idActual
     */
    public int getIdActual() {
        return idActual;
    }

    /**
     * @param idActual
     *        the idActual to set
     */
    public void setIdActual(int idActual) {
        this.idActual = idActual;
    }

    
    @Override
    public String toString() {
        return "\n Level [name=" + name + ", top=" + top + ", low=" + low + "]";
    }
    
    /**
     * @return random number from limits from bottom to top number of blank
     *         cells for given difficulty level.
     */
    public int getBlankCellsNumber() {
        return new Random().nextInt((top - low) + 1) + low;
    }
    
   

    
    
}