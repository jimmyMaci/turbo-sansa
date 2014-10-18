package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import address.book.model.Addresses;
import de.alpharogroup.scheduler.system.model.Appointments;
import user.management.model.Users;

/**
 * The Entity class {@EventLocations} is keeping the
 * information for the event locations with the appointments.
 */
@Entity
@Table(name = "event_locations")
public class EventLocations  
extends BaseEntity<Integer>
implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The appointment attribute that references to the Entity class
	 * {@Appointments}.
	 */
	private Appointments appointment;
	/**
	 * The contactperson attribute that references to the Entity class {@Users
	 * }.
	 */
	private Users contactperson;
	/**
	 * The event attribute that references to the Entity class {@Events
	 * }.
	 */
	private Events event;
	/**
	 * The eventLocation attribute that references to the Entity class
	 * {@link Addresses}.
	 */
	private Addresses eventLocation;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public EventLocations() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: appointment
	 * 
	 * @return A Appointments object (this.appointment)
	 */

	@ManyToOne
	@JoinColumn(name = "appointment_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_APPOINTMENT_ID")
	@ForeignKey(name = "FK_EVENTLOCATIONS_APPOINTMENT_ID")
	public Appointments getAppointment() {
		return this.appointment;
	}

	/**
	 * Set the value related to the column: appointment
	 * 
	 * @param appointment
	 *            the appointment value you wish to set
	 */
	public void setAppointment(final Appointments appointment) {
		this.appointment = appointment;
	}

	/**
	 * Return the value associated with the column: contactperson
	 * 
	 * @return A Users object (this.contactperson)
	 */

	@ManyToOne
	@JoinColumn(name = "contactperson_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_CONTACTPERSON_ID")
	@ForeignKey(name = "FK_EVENTLOCATIONS_CONTACTPERSON_ID")
	public Users getContactperson() {
		return this.contactperson;
	}

	/**
	 * Set the value related to the column: contactperson
	 * 
	 * @param contactperson
	 *            the contactperson value you wish to set
	 */
	public void setContactperson(final Users contactperson) {
		this.contactperson = contactperson;
	}

	/**
	 * Return the value associated with the column: event
	 * 
	 * @return A Events object (this.event)
	 */

	@ManyToOne
	@JoinColumn(name = "event_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_EVENTLOCATIONS_ID")
	@ForeignKey(name = "FK_EVENTLOCATIONS_EVENT_ID")
	public Events getEvent() {
		return this.event;
	}

	/**
	 * Set the value related to the column: event
	 * 
	 * @param event
	 *            the event value you wish to set
	 */
	public void setEvent(final Events event) {
		this.event = event;
	}
	
	/**
	 * Return the value associated with the column: eventLocation
	 * 
	 * @return A UserAddresses object (this.eventLocation)
	 */

	@ManyToOne
	@JoinColumn(name = "event_location_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_EVENT_LOCATION_ID")
	@ForeignKey(name = "FK_EVENT_LOCATION_ID")
	public Addresses getEventLocation() {
		return this.eventLocation;
	}

	/**
	 * Set the value related to the column: userAddress
	 * 
	 * @param eventLocation
	 *            the eventLocation value you wish to set
	 */
	public void setEventLocation(final Addresses eventLocation) {
		this.eventLocation = eventLocation;
	}
	
}