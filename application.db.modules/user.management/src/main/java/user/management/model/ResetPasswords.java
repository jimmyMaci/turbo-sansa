package user.management.model;

import hbm.entity.BaseEntity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

/**
 * The Entity class {@link ResetPasswords} is keeping the
 * information for reseting the password from a user. Data will be inserted when
 * a user forgets his password and enter his data in the form.
 */
@Entity
@Table(name = "reset_passwords")
public class ResetPasswords 
extends BaseEntity<Integer>
implements Cloneable {

	/** The serial Version UID */
	private static final long serialVersionUID = -4437962692764644264L;
	/** The date which this data expire. */
	private Date expiryDate;
	/** mapping */
	private String generatedPassword;
	/** The time that the user send the form. */
	private Date starttime;
	/** The user attribute that references to the Entity class {@link Users}. */
	private Users user;

	/**
	 * Default constructor.
	 */
	public ResetPasswords() {
	}

	/**
	 * Return the value associated with the column: expiryDate
	 * 
	 * @return A Date object (this.expiryDate)
	 */
	@Column(name = "expiry_date")
	public Date getExpiryDate() {
		return this.expiryDate;
	}

	/**
	 * Set the value related to the column: expiryDate
	 * 
	 * @param expiryDate
	 *            the expiryDate value you wish to set
	 */
	public void setExpiryDate(final Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * Return the value associated with the column: generatedPassword
	 * 
	 * @return A String object (this.generatedPassword)
	 */
	@Column(name = "generated_password", length = 1024)
	public String getGeneratedPassword() {
		return this.generatedPassword;
	}

	/**
	 * Set the value related to the column: generatedPassword
	 * 
	 * @param generatedPassword
	 *            the generatedPassword value you wish to set
	 */
	public void setGeneratedPassword(final String generatedPassword) {
		this.generatedPassword = generatedPassword;
	}

	/**
	 * Return the value associated with the column: starttime
	 * 
	 * @return A Date object (this.starttime)
	 */

	public Date getStarttime() {
		return this.starttime;
	}

	/**
	 * Set the value related to the column: starttime
	 * 
	 * @param starttime
	 *            the starttime value you wish to set
	 */
	public void setStarttime(final Date starttime) {
		this.starttime = starttime;
	}

	/**
	 * Return the value associated with the column: user
	 * 
	 * @return A Users object (this.user)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_RESET_PASSWORDS_USER_ID")
	@ForeignKey(name = "FK_RESET_PASSWORDS_USER_ID")
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
