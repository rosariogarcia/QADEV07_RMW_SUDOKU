package game;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author MijhailVillarroel
 *
 */
public class Xml {
    static final String NAMEFile = "ConfigSuduko.xml";
    
   
    /**
     * Reads an XML file and convert to a object of the class GameConfiguration 
     * @return GameConfiguration is a object
     */
    public GameConfiguration readXml() {
        try {

            File file = new File(NAMEFile);
            JAXBContext jaxbContext = JAXBContext.newInstance(GameConfiguration.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (GameConfiguration) (jaxbUnmarshaller.unmarshal(file));
        } catch (JAXBException e) {
            System.out.println("Errorr");
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Update the XML file with the GameConfiguration.
     * @param GameConfiguration the game settings
     */
    public boolean updateXml(GameConfiguration gameConfiguration) {
        try {
            File file = new File(NAMEFile);
            JAXBContext jaxbContext = JAXBContext.newInstance(GameConfiguration.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(gameConfiguration, file);
            return true;
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }
}
