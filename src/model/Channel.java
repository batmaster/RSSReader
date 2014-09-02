package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Channel model of rss.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
@XmlAccessorType (XmlAccessType.FIELD)
public class Channel {
	
	private String title;
	private String link;
	private String description;
	
	@XmlElement(name = "item")
	private List<Item> items;
	
	protected Channel() {
		
	}
	
	/**
	 * Constructor with description attribute.
	 * @param title title of the channel
	 * @param link link of the channel
	 * @param description description of the channel
	 */
	public Channel(String title, String link, String description) {
		this.title = title;
		this.link = link;
		this.description = description;
	}
	
	/**
	 * Get channel title.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Get channel link.
	 * @return link
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Get channel description.
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Get lists of Items in the channel.
	 * @return list of Item objects
	 */
	public List<Item> getItems() {
		return items;
	}
}
