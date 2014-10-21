package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import user.management.model.Users;
import events.system.enums.UsereventsRelationType;

/**
 * The Entity class {@Userevents } is keeping the information for
 * the connection between the Entity class {@Users } and the Entity class
 * {@Events }. It holds information from providers that have 'provided'
 * the event and from subscribers that have 'requested' the event.
 */
@Entity
@Table(name = "userevents")
@TypeDefs({ @TypeDef(name = "relationtypeConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "events.system.enums.UsereventsRelationType") }) })
public class Userevents extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The event attribute that references to the Entity class {@Events
	 * 
	 * 
	 * }.
	 */
	private EventTemplate event;
	/** An enum for the type of the relation with the event. */
	private UsereventsRelationType relationtype;
	/** The user attribute that references to the Entity class {@Users}. */
	private Users user;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public Userevents() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: event
	 * 
	 * @return A Events object (this.event)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_USEREVENTS_USER_ID")
	@ForeignKey(name = "FK_USEREVENTS_USER_ID")
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
	 * Return the value associated with the column: relationtype
	 * 
	 * @return A UsereventsRelationType object (this.relationtype)
	 */

	@Enumerated(EnumType.STRING)
	@Column(name = "relationtype")
	@Type(type = "relationtypeConverter")
	public UsereventsRelationType getRelationtype() {
		return this.relationtype;
	}

	/**
	 * Set the value related to the column: relationtype
	 * 
	 * @param relationtype
	 *            the relationtype value you wish to set
	 */
	public void setRelationtype(final UsereventsRelationType relationtype) {
		this.relationtype = relationtype;
	}

	/**
	 * Return the value associated with the column: user
	 * 
	 * @return A Users object (this.user)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_USEREVENTS_ID")
	@ForeignKey(name = "FK_USEREVENTS_EVENT_ID")
	public Users getUser() {
		return this.user;
	}

	/**
	 * Set the value related to the column: user
	 * 
	 * @param user
	 *            the user value you wish to set
	 */
	public void setUser(final Users user) {
		this.user = user;
	}

}
