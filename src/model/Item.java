package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType (XmlAccessType.FIELD)
public class Item {
	
	private String title;
	private String link;
	private String description;
	private String pubDate;
	
	protected Item() {
		
	}
	
	public Item(String title, String link, String description, String pubDate) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
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
	
	public String getPubDate() {
		return pubDate;
	}
}
