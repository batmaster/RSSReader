package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Rss item model of rss.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
@XmlAccessorType (XmlAccessType.FIELD)
public class Item {
	
	private String title;
	private String link;
	private String description;
	private String pubDate;
	private Enclosure enclosure;
	
	protected Item() {
		
	}
	
	/**
	 * Constructor with description attribute.
	 * @param title title of the item
	 * @param link link  of the item
	 * @param description description  of the item
	 * @param pubDate publish date  of the item
	 * @param enclosure enclosure  of the item
	 */
	public Item(String title, String link, String description, String pubDate, Enclosure enclosure) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
		this.enclosure= enclosure;
		System.out.println(title.substring(0, 10) + " " + enclosure);
	}

	/**
	 * Get title.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Get link.
	 * @return link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Get description.
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Get publish date.
	 * @return publish date
	 */
	public String getPubDate() {
		return pubDate;
	}
	
	/**
	 * Get enclosure.
	 * @return enclosure
	 */
	public Enclosure getEnclosure() {
		return enclosure;
	}
}
