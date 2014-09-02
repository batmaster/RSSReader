package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Rss model of rss.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Rss {
	
	private Channel channel;
	
	protected Rss() {
		
	}
	
	/**
	 * Constructor with a channel attribute required.
	 * @param channel channel used in rss
	 */
	public Rss(Channel channel) {
		this.channel = channel;
	}
	
	/**
	 * Get the channel
	 * @return the channel
	 */
	public Channel getChannel() {
		return channel;
	}
}
