package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

/**
 * An event can have multiply topics. The Entity class {@EventTopics
 * 
 * 
 *  } is keeping the information for the connection between the
 * Entity class {@Events} and the Entity class {@Topics}.
 */
@Entity
@Table(name = "event_topics")
public class EventTopics extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The event attribute that references to the Entity class {@Events
	 * 
	 * 
	 * }.
	 */
	private EventTemplate event;
	/**
	 * The topic attribute that references to the Entity class {@Topics
	 * 
	 * 
	 * }.
	 */
	private Topics topic;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public EventTopics() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: event
	 * 
	 * @return A Events object (this.event)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_EVENT_TOPICS_ID")
	@ForeignKey(name = "FK_EVENT_TOPICS_EVENT_ID")
	public EventTemplate getEvent() {
		return this.event;
	}

	/**
	 * Set the value related to the column: event
	 * 
	 * @param event
	 *            the event value you wish to set
	 */
	public void setEvent(final EventTemplate event) {
		this.event = event;
	}

	/**
	 * Return the value associated with the column: topic
	 * 
	 * @return A Topics object (this.topic)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_EVENT_TOPICS_TOPIC_ID")
	@ForeignKey(name = "FK_EVENT_TOPICS_TOPIC_ID")
	public Topics getTopic() {
		return this.topic;
	}

	/**
	 * Set the value related to the column: topic
	 * 
	 * @param topic
	 *            the topic value you wish to set
	 */
	public void setTopic(final Topics topic) {
		this.topic = topic;
	}

}
