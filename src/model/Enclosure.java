package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Enclosure data model of rss.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
@XmlAccessorType (XmlAccessType.FIELD)
public class Enclosure {
	
	private String url;
	private int length;
	private String type;
	
	protected Enclosure() {
		
	}
	
	/**
	 * Constructor with description attribute.
	 * @param url link of the enclosure
	 * @param length length of the enclosure
	 * @param type description of the enclosure
	 */
	public Enclosure(String url, int length, String type) {
		this.url = url;
		this.length = length;
		this.type = type;
	}
	
	/**
	 * Get enclosure url.
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Get length of the enclosure in a form of integer.
	 * @return length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Get enclosure type.
	 * @return type
	 */
	public String getType() {
		return type;
	}
}
