package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType (XmlAccessType.FIELD)
public class Channel {
	
	private String title;
	private String link;
	private String description;
	
	@XmlElement(name = "item")
	private List<Item> items;
	
	protected Channel() {
		
	}
	
	public Channel(String title, String link, String description) {
		this.title = title;
		this.link = link;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<Item> getItems() {
		return items;
	}
}
