package xml;

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
			//System.out.println( Xml.class.getResource("/.."));
			File file = new File("configSuduko.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(GameConfiguration.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			return (GameConfiguration) jaxbUnmarshaller.unmarshal(file);
		}
		catch (JAXBException e) {
			System.out.println("Errorr");
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
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(gameConfig, file);
			//jaxbMarshaller.marshal(gameConfig, System.out);
			return true;
			} 
		catch (JAXBException e) {
			e.printStackTrace();
			return false;
			}
	}
	
	public static void main(String args[]){
		 Xml xml= new Xml();
		 List<Level>leves = new ArrayList<>();
		 leves.add(new Level("easy",2,1));
		 leves.add(new Level("hard",78,18));
		 GameConfiguration game=xml.readXml();
		 game.setPathOutput("C:\\");
		 game.setLevel(leves);
		 System.out.println(xml.isUpdateXml(game));
	}
}
