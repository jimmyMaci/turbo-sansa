package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import user.management.model.Users;
import address.book.model.Federalstates;

/**
 * The Entity class {@ProfileFederalstates} is keeping
 * the information for the connection between the Entity class {@Users}
 * and the Entity class {@Federalstates}.
 */
@Entity
@Table(name = "profile_federalstates")
public class ProfileFederalstates extends BaseEntity<Integer> implements
		Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The federalstate attribute that references to the Entity class
	 * {@Federalstates}.
	 */
	private Federalstates federalstate;
	/** The user attribute that references to the Entity class {@Users}. */
	private Users user;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public ProfileFederalstates() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: federalstate
	 * 
	 * @return A Federalstates object (this.federalstate)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "federalstate_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PROFILE_FEDERALSTATES_ID")
	@ForeignKey(name = "FK_PROFILE_FEDERALSTATES_FEDERALSTATE_ID")
	public Federalstates getFederalstate() {
		return this.federalstate;
	}

	/**
	 * Set the value related to the column: federalstate
	 * 
	 * @param federalstate
	 *            the federalstate value you wish to set
	 */
	public void setFederalstate(final Federalstates federalstate) {
		this.federalstate = federalstate;
	}

	/**
	 * Return the value associated with the column: user
	 * 
	 * @return A Users object (this.user)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PROFILE_FEDERALSTATES_USER_ID")
	@ForeignKey(name = "FK_PROFILE_FEDERALSTATES_USER_ID")
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
