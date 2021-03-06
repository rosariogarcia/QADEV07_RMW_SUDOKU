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
public class XML {
    static final String NAMEFile = "ConfigSuduko.xml";
    
   
    /**
     * Reads an XML file and convert to a object of the class GameConfiguration 
     * @return GameConfiguration is a object
     */
    public static GameConfiguration readXml() {
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
    public static boolean updateXml(GameConfiguration gameConfiguration) {
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
    
    public static void main(String args[]){
         XML xml= new XML();
            List<Level>leves = new ArrayList<>();
             leves.add(new Level("easy",2,1));
            leves.add(new Level("medium",78,18));
            leves.add(new Level("hard",78,18));
            leves.add(new Level("Custom",78,18));
             GameConfiguration game=xml.readXml();
             game.setPathOutput("C:\\");
              game.setLevel(leves);
              System.out.println(xml.updateXml(game));
         }

}
