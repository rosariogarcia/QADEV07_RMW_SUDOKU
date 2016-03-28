package game.sudouku;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Xml {

	public GameConfiguration readXml()
	{
		try {
			File file = new File("configSuduko.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(GameConfiguration.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (GameConfiguration) jaxbUnmarshaller.unmarshal(file);
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isUpdateXml(GameConfiguration gameConfig)
	{
		try {
			File file = new File("configSuduko.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(GameConfiguration.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(gameConfig, file);
			return true;
			} 
		catch (JAXBException e) {
			e.printStackTrace();
			return false;
			}
	}
}
