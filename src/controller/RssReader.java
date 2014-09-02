package controller;

import java.net.URL;

import javax.management.InstanceAlreadyExistsException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Rss;

public class RssReader {
	
	private static RssReader instance;
	
	private RssReader() {
		
	}
	
	public static RssReader getInstance() {
		if (instance == null)
			instance = new RssReader();
		return instance;
	}
	
	public Rss getRss(URL url) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Rss.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object obj = unmarshaller.unmarshal(url);
		Rss rss = (Rss) obj;
		return rss;
	}
}
