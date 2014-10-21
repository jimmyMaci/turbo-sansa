package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import user.management.model.Users;
import address.book.model.Addresses;

/**
 * The Entity class {@OfferedEventLocations} is keeping
 * the information for the offered event locations from a provider.
 */
@Entity
@Table(name = "offered_event_locations")
public class OfferedEventLocations extends BaseEntity<Integer> implements
		Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventLocationData attribute that references to the Entity class
	 * {@EventLocationData}.
	 */
	private EventLocationData eventLocationData;
	/** A description from the location and how to get there. */
	private String locationDescription;
	/** A description from the equipment from the event location. */
	private String locationEquipmentDescription;
	/** A description from which provider is the location offered. */
	private String offeredFromDescription;
	/** A description of the support from this location. */
	private String supportDescription;
	/**
	 * The Addresses attribute that references to the Entity class
	 * {@UserAddresses}.
	 */
	private Addresses userAddress;
	/**
	 * The contactPerson attribute that references to the Entity class {@Users
	 * 
	 * } and is the contact person for this offered event location.
	 */
	private Users contactPerson;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_OFFERED_EVENT_LOCATIONS_CONTACT_PERSON_ID")
	@ForeignKey(name = "FK_OFFERED_EVENT_LOCATIONS_CONTACT_PERSON_ID")
	public Users getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(Users contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public OfferedEventLocations() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: eventLocationData
	 * 
	 * @return A EventLocationData object (this.eventLocationData)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_location_data_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_EVENT_LOCATION_DATA_ID")
	@ForeignKey(name = "FK_OFFERED_EVENT_LOCATIONS_EVENT_LOCATION_DATA_ID")
	public EventLocationData getEventLocationData() {
		return this.eventLocationData;
	}

	/**
	 * Set the value related to the column: eventLocationData
	 * 
	 * @param eventLocationData
	 *            the eventLocationData value you wish to set
	 */
	public void setEventLocationData(final EventLocationData eventLocationData) {
		this.eventLocationData = eventLocationData;
	}

	/**
	 * Return the value associated with the column: locationDescription
	 * 
	 * @return A String object (this.locationDescription)
	 */
	@Column(name = "location_description", length = 21845)
	public String getLocationDescription() {
		return this.locationDescription;
	}

	/**
	 * Set the value related to the column: locationDescription
	 * 
	 * @param locationDescription
	 *            the locationDescription value you wish to set
	 */
	public void setLocationDescription(final String locationDescription) {
		this.locationDescription = locationDescription;
	}

	/**
	 * Return the value associated with the column: locationEquipmentDescription
	 * 
	 * @return A String object (this.locationEquipmentDescription)
	 */
	@Column(name = "location_equipment_description", length = 21845)
	public String getLocationEquipmentDescription() {
		return this.locationEquipmentDescription;
	}

	/**
	 * Set the value related to the column: locationEquipmentDescription
	 * 
	 * @param locationEquipmentDescription
	 *            the locationEquipmentDescription value you wish to set
	 */
	public void setLocationEquipmentDescription(
			final String locationEquipmentDescription) {
		this.locationEquipmentDescription = locationEquipmentDescription;
	}

	/**
	 * Return the value associated with the column: offeredFromDescription
	 * 
	 * @return A String object (this.offeredFromDescription)
	 */
	@Column(name = "offered_from_description", length = 21845)
	public String getOfferedFromDescription() {
		return this.offeredFromDescription;
	}

	/**
	 * Set the value related to the column: offeredFromDescription
	 * 
	 * @param offeredFromDescription
	 *            the offeredFromDescription value you wish to set
	 */
	public void setOfferedFromDescription(final String offeredFromDescription) {
		this.offeredFromDescription = offeredFromDescription;
	}

	/**
	 * Return the value associated with the column: supportDescription
	 * 
	 * @return A String object (this.supportDescription)
	 */
	@Column(name = "support_description", length = 21845)
	public String getSupportDescription() {
		return this.supportDescription;
	}

	/**
	 * Set the value related to the column: supportDescription
	 * 
	 * @param supportDescription
	 *            the supportDescription value you wish to set
	 */
	public void setSupportDescription(final String supportDescription) {
		this.supportDescription = supportDescription;
	}

	/**
	 * Return the value associated with the column: userAddress
	 * 
	 * @return A UserAddresses object (this.userAddress)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_address_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_OFFERED_EVENT_LOCATIONS_USER_ADDRESS_ID")
	@ForeignKey(name = "FK_OFFERED_EVENT_LOCATIONS_USER_ADDRESS_ID")
	public Addresses getUserAddress() {
		return this.userAddress;
	}

	/**
	 * Set the value related to the column: userAddress
	 * 
	 * @param userAddress
	 *            the userAddress value you wish to set
	 */
	public void setUserAddress(final Addresses userAddress) {
		this.userAddress = userAddress;
	}

}
