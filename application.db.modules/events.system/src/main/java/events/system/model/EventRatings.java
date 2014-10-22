package events.system.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import rating.system.model.Ratings;

/**
 * The Entity class {@EventRatings} is keeping the information
 * for the ratings from the events.
 * 
 * TODO check if the rating object should be rather an EventLocation.
 */
@Entity
@Table(name = "event_ratings")
@TypeDefs({ @TypeDef(
		name = "ratingVisibilityConverter", 
		typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, 
		parameters = { @Parameter(name = "enumClassName", value = "rating.system.enums.RatingVisibility") }) })
public class EventRatings extends Ratings {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The rating for the contact. */
	private Integer contact;
	/**
	 * The event attribute that references to the Entity class
	 * {@link EventTemplate}.
	 */
	private EventTemplate event;
	/** The rating for the event location. */
	private Integer eventlocation;
	/** The rating for the material. */
	private Integer material;
	/** The rating for the presentation. */
	private Integer presentation;
	/** The rating for the support. */
	private Integer support;
	/** The rating for the topic. */
	private Integer topic;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public EventRatings() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: contact
	 * 
	 * @return A Integer object (this.contact)
	 */

	public Integer getContact() {
		return this.contact;
	}

	/**
	 * Set the value related to the column: contact
	 * 
	 * @param contact
	 *            the contact value you wish to set
	 */
	public void setContact(final Integer contact) {
		this.contact = contact;
	}

	/**
	 * Return the value associated with the column: event
	 * 
	 * @return A Events object (this.event)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_EVENT_RATINGS_ID")
	@ForeignKey(name = "FK_EVENT_RATINGS_EVENT_ID")
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
	 * Return the value associated with the column: eventlocation
	 * 
	 * @return A Integer object (this.eventlocation)
	 */

	public Integer getEventlocation() {
		return this.eventlocation;
	}

	/**
	 * Set the value related to the column: eventlocation
	 * 
	 * @param eventlocation
	 *            the eventlocation value you wish to set
	 */
	public void setEventlocation(final Integer eventlocation) {
		this.eventlocation = eventlocation;
	}

	/**
	 * Return the value associated with the column: material
	 * 
	 * @return A Integer object (this.material)
	 */

	public Integer getMaterial() {
		return this.material;
	}

	/**
	 * Set the value related to the column: material
	 * 
	 * @param material
	 *            the material value you wish to set
	 */
	public void setMaterial(final Integer material) {
		this.material = material;
	}

	/**
	 * Return the value associated with the column: presentation
	 * 
	 * @return A Integer object (this.presentation)
	 */

	public Integer getPresentation() {
		return this.presentation;
	}

	/**
	 * Set the value related to the column: presentation
	 * 
	 * @param presentation
	 *            the presentation value you wish to set
	 */
	public void setPresentation(final Integer presentation) {
		this.presentation = presentation;
	}

	/**
	 * Return the value associated with the column: support
	 * 
	 * @return A Integer object (this.support)
	 */

	public Integer getSupport() {
		return this.support;
	}

	/**
	 * Set the value related to the column: support
	 * 
	 * @param support
	 *            the support value you wish to set
	 */
	public void setSupport(final Integer support) {
		this.support = support;
	}

	/**
	 * Return the value associated with the column: topic
	 * 
	 * @return A Integer object (this.topic)
	 */

	public Integer getTopic() {
		return this.topic;
	}

	/**
	 * Set the value related to the column: topic
	 * 
	 * @param topic
	 *            the topic value you wish to set
	 */
	public void setTopic(final Integer topic) {
		this.topic = topic;
	}

}
