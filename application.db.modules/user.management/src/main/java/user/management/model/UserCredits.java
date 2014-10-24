package user.management.model;

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

/**
 * The Entity class {@link UserCredits} is keeping the
 * information for the credits from a user. A user can buy credits that is
 * inserted in this table.
 */
@Entity
@Table(name = "user_credits")
public class UserCredits
extends BaseEntity<Integer>
implements Cloneable {
	/**
	 * The serial Version UID.
	 */
	private static final long serialVersionUID = 6658246250439811798L;
	/** The points that the user have buyed. */
	private Integer credits;
	/**
	 * The user attribute that references to the Entity class {@link Users}
	 * that owns the credits.
	 */
	private Users user;

	/**
	 * Default constructor.
	 */
	public UserCredits() {
	}

	/**
	 * Return the value associated with the column: points
	 * 
	 * @return A Integer object (this.points)
	 */
	@Column(name = "credits", nullable = true)
	public Integer getCredits() {
		return this.credits;
	}

	/**
	 * Set the value related to the column: points
	 * 
	 * @param credits
	 *            the points value you wish to set
	 */
	public void setCredits(final Integer credits) {
		this.credits = credits;
	}

	/**
	 * Return the value associated with the column: user
	 * 
	 * @return A Users object (this.user)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_USER_CREDITS_USER_ID")
	@ForeignKey(name = "FK_USER_CREDITS_USER_ID")
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
