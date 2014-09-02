package controller;

import java.net.URL;

import javax.management.InstanceAlreadyExistsException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Rss;

/**
 * Unmarshaller class used to create java objects from xml data.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
public class RssReader {
	
	private static RssReader instance;
	
	private RssReader() {
		
	}
	
	/**
	 * To support the Singleton pattern.
	 * @return the instance object of this class
	 */
	public static RssReader getInstance() {
		if (instance == null)
			instance = new RssReader();
		return instance;
	}
	
	/**
	 * Create Rss object with a url link of xml.
	 * @param url link of the xml file
	 * @return Rss object created by using xml data
	 * @throws JAXBException
	 */
	public Rss getRss(URL url) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Rss.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object obj = unmarshaller.unmarshal(url);
		Rss rss = (Rss) obj;
		return rss;
	}
}
