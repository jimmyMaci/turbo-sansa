package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import message.system.model.Messages;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

/**
 * The Entity class {@EventMessages } is keeping the information
 * for the connection between the Entity class {@EventLocations
 *  } and the Entity class {@Messages }.
 */
@Entity
@Table(name = "event_messages")
public class EventMessages  
extends BaseEntity<Integer>
implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventLocation attribute that references to the Entity class
	 * {@EventLocations}.
	 */
	private EventLocations eventLocation;
	/**
	 * The message attribute that references to the Entity class {@Messages
	 * }.
	 */
	private Messages message;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public EventMessages() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: eventLocation
	 * 
	 * @return A EventLocations object (this.eventLocation)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_location_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_EVENT_LOCATION_ID")
	@ForeignKey(name = "FK_EVENT_MESSAGES_EVENT_LOCATION_ID")
	public EventLocations getEventLocation() {
		return this.eventLocation;
	}

	/**
	 * Set the value related to the column: eventLocation
	 * 
	 * @param eventLocation
	 *            the eventLocation value you wish to set
	 */
	public void setEventLocation(final EventLocations eventLocation) {
		this.eventLocation = eventLocation;
	}

	/**
	 * Return the value associated with the column: message
	 * 
	 * @return A Messages object (this.message)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "message_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_EVENT_MESSAGES_ID")
	@ForeignKey(name = "FK_EVENT_MESSAGES_MESSAGE_ID")
	public Messages getMessage() {
		return this.message;
	}

	/**
	 * Set the value related to the column: message
	 * 
	 * @param message
	 *            the message value you wish to set
	 */
	public void setMessage(final Messages message) {
		this.message = message;
	}
	
}
