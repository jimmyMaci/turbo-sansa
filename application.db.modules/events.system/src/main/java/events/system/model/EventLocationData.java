package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Entity class {@EventLocationData} is keeping the
 * information for the data from the location. It is used if a provider wants to
 * offer an event location.
 */
@Entity
@Table(name = "event_location_data")
public class EventLocationData extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The quantity of the available rooms or places. */
	private Integer availableRooms;
	/** If the subscriber from the event location can hire a catering. */
	private Integer cateringAbilities;
	/** If the event location is near by a restaurant. */
	private Integer nearByRestaurant;
	/** If the event location is offered at evenings. */
	private Boolean offeredEvening;
	/** If the event location is offered at weekdays. */
	private Boolean offeredWeekdays;
	/** If the event location is offered at weekends. */
	private Boolean offeredWeekend;
	/** If the event location offer parking for cars. */
	private Integer parkingAbilities;
	/** The type of room from the offered room or place. */
	private String roomtype;
	/** Available seats per room. */
	private Integer seatsPerRoom;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public EventLocationData() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: availableRooms
	 * 
	 * @return A Integer object (this.availableRooms)
	 */
	@Column(name = "available_rooms")
	public Integer getAvailableRooms() {
		return this.availableRooms;
	}

	/**
	 * Set the value related to the column: availableRooms
	 * 
	 * @param availableRooms
	 *            the availableRooms value you wish to set
	 */
	public void setAvailableRooms(final Integer availableRooms) {
		this.availableRooms = availableRooms;
	}

	/**
	 * Return the value associated with the column: cateringAbilities
	 * 
	 * @return A Integer object (this.cateringAbilities)
	 */
	@Column(name = "catering_abilities")
	public Integer getCateringAbilities() {
		return this.cateringAbilities;
	}

	/**
	 * Set the value related to the column: cateringAbilities
	 * 
	 * @param cateringAbilities
	 *            the cateringAbilities value you wish to set
	 */
	public void setCateringAbilities(final Integer cateringAbilities) {
		this.cateringAbilities = cateringAbilities;
	}

	/**
	 * Return the value associated with the column: nearByRestaurant
	 * 
	 * @return A Integer object (this.nearByRestaurant)
	 */
	@Column(name = "near_by_restaurant")
	public Integer getNearByRestaurant() {
		return this.nearByRestaurant;
	}

	/**
	 * Set the value related to the column: nearByRestaurant
	 * 
	 * @param nearByRestaurant
	 *            the nearByRestaurant value you wish to set
	 */
	public void setNearByRestaurant(final Integer nearByRestaurant) {
		this.nearByRestaurant = nearByRestaurant;
	}

	/**
	 * Return the value associated with the column: offeredEvening
	 * 
	 * @return A Boolean object (this.offeredEvening)
	 */
	@Column(name = "offered_evening")
	public Boolean isOfferedEvening() {
		return this.offeredEvening;
	}

	/**
	 * Set the value related to the column: offeredEvening
	 * 
	 * @param offeredEvening
	 *            the offeredEvening value you wish to set
	 */
	public void setOfferedEvening(final Boolean offeredEvening) {
		this.offeredEvening = offeredEvening;
	}

	/**
	 * Return the value associated with the column: offeredWeekdays
	 * 
	 * @return A Boolean object (this.offeredWeekdays)
	 */
	@Column(name = "offered_weekdays")
	public Boolean isOfferedWeekdays() {
		return this.offeredWeekdays;
	}

	/**
	 * Set the value related to the column: offeredWeekdays
	 * 
	 * @param offeredWeekdays
	 *            the offeredWeekdays value you wish to set
	 */
	public void setOfferedWeekdays(final Boolean offeredWeekdays) {
		this.offeredWeekdays = offeredWeekdays;
	}

	/**
	 * Return the value associated with the column: offeredWeekend
	 * 
	 * @return A Boolean object (this.offeredWeekend)
	 */
	@Column(name = "offered_weekend")
	public Boolean isOfferedWeekend() {
		return this.offeredWeekend;
	}

	/**
	 * Set the value related to the column: offeredWeekend
	 * 
	 * @param offeredWeekend
	 *            the offeredWeekend value you wish to set
	 */
	public void setOfferedWeekend(final Boolean offeredWeekend) {
		this.offeredWeekend = offeredWeekend;
	}

	/**
	 * Return the value associated with the column: parkingAbilities
	 * 
	 * @return A Integer object (this.parkingAbilities)
	 */
	@Column(name = "parking_abilities")
	public Integer getParkingAbilities() {
		return this.parkingAbilities;
	}

	/**
	 * Set the value related to the column: parkingAbilities
	 * 
	 * @param parkingAbilities
	 *            the parkingAbilities value you wish to set
	 */
	public void setParkingAbilities(final Integer parkingAbilities) {
		this.parkingAbilities = parkingAbilities;
	}

	/**
	 * Return the value associated with the column: roomtype
	 * 
	 * @return A String object (this.roomtype)
	 */
	@Column(length = 256)
	public String getRoomtype() {
		return this.roomtype;
	}

	/**
	 * Set the value related to the column: roomtype
	 * 
	 * @param roomtype
	 *            the roomtype value you wish to set
	 */
	public void setRoomtype(final String roomtype) {
		this.roomtype = roomtype;
	}

	/**
	 * Return the value associated with the column: seatsPerRoom
	 * 
	 * @return A Integer object (this.seatsPerRoom)
	 */
	@Column(name = "seats_per_room")
	public Integer getSeatsPerRoom() {
		return this.seatsPerRoom;
	}

	/**
	 * Set the value related to the column: seatsPerRoom
	 * 
	 * @param seatsPerRoom
	 *            the seatsPerRoom value you wish to set
	 */
	public void setSeatsPerRoom(final Integer seatsPerRoom) {
		this.seatsPerRoom = seatsPerRoom;
	}

}
