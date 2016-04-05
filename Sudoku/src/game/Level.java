package game;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "level")
@XmlType(propOrder = { "name", "top", "low" })
public class Level {
    @XmlAttribute
    private String name;
    private int top;
    private int low;

    public Level() {

    }

    public Level(String name, int top, int low) {
        this.name = name;
        this.top = top;
        this.low = low;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    @Override
    public String toString() {
        return "\n Level [name=" + name + ", top=" + top + ", low=" + low + "]";
    }
    
    
}