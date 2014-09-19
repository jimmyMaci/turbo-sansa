package user.management.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Entity class {@link Users} is keeping the information for the users from
 * the application.
 */
@Entity
@Table(name = "users")
public class Users 
extends BaseEntity<Integer> 
implements Cloneable, Serializable {

	/** The serial Version UID. */
	private static final long serialVersionUID = 1L;
	/** The attribute active, if true the user account is active. */
	private Boolean active;
	/** A Flag that indicates if the user account is locked or not. */
	private Boolean locked;
	/** The hash from the password hashed with sha512. */
	private String pw;
	/** The roles of the user. */
	private Set<Roles> roles = new HashSet<Roles>();
	/** The salt that is used to compute the hash. */
	private String salt;
	/** The data of this user. */
	private UserData userData;
	/** The user name. */
	private String username;

	/**
	 * Default constructor.
	 */
	public Users() {
	}

	/**
	 * Adds a role to the user.
	 * 
	 * @param role
	 *            the role
	 * @return true, if successful
	 */
	public boolean addRole(Roles role) {
		return roles.add(role);
	}

	/**
     * {@inheritDoc}
     */
	public Object clone() throws CloneNotSupportedException {
		super.clone();
		Users copy = new Users();
		copy.active = this.active == null ? null : new Boolean(
				this.active.booleanValue());
		copy.locked = this.locked == null ? null : new Boolean(
				this.locked.booleanValue());
		copy.pw = this.pw == null ? null : new String(this.pw);
		copy.setRoles(this.roles);
		copy.salt = this.salt == null ? null : new String(this.salt);
		copy.userData = this.userData == null ? null : (UserData) copy.userData
				.clone();
		copy.username = this.username == null ? null
				: new String(this.username);
		return copy;
	}

	/**
	 * Return the value associated with the column: pw.
	 * 
	 * @return A String object (this.pw)
	 */	
	@Column(length = 1024)
	public String getPw() {
		return this.pw;
	}

	/**
	 * Gets the roles of the user.
	 * 
	 * @return the roles of the user.
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, 
	inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	public Set<Roles> getRoles() {
		return roles;
	}

	/**
	 * Return the value associated with the column: salt.
	 * 
	 * @return A String object (this.salt)
	 */
	@Column(length = 8)
	public String getSalt() {
		return this.salt;
	}

	/**
	 * Gets the user data.
	 * 
	 * @return the user data
	 */
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_data")
	public UserData getUserData() {
		return userData;
	}

	/**
	 * Return the value associated with the column: username.
	 * 
	 * @return A String object (this.username)
	 */
	@Column(length = 256, unique = true)
	public String getUsername() {
		return this.username;
	}

	/**
	 * Return the value associated with the column: active.
	 * 
	 * @return A Boolean object (this.active)
	 */
	public Boolean isActive() {
		return this.active;
	}

	/**
	 * Return the value associated with the column: locked.
	 * 
	 * @return A Boolean object (this.locked)
	 */
	public Boolean isLocked() {
		return this.locked;
	}

	/**
	 * Set the value related to the column: active.
	 * 
	 * @param active
	 *            the active value you wish to set
	 */
	public void setActive(final Boolean active) {
		this.active = active;
	}

	/**
	 * Set the value related to the column: locked.
	 * 
	 * @param locked
	 *            the locked value you wish to set
	 */
	public void setLocked(final Boolean locked) {
		this.locked = locked;
	}

	/**
	 * Set the value related to the column: pw.
	 * 
	 * @param pw
	 *            the pw value you wish to set
	 */
	public void setPw(final String pw) {
		this.pw = pw;
	}

	/**
	 * Sets the roles.
	 * 
	 * @param roles
	 *            the new roles
	 */
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	
	/**
	 * Set the value related to the column: salt.
	 * 
	 * @param salt
	 *            the salt value you wish to set
	 */
	public void setSalt(final String salt) {
		this.salt = salt;
	}

	/**
	 * Sets the user data.
	 * 
	 * @param userData
	 *            the new user data
	 */
	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	/**
	 * Set the value related to the column: username.
	 * 
	 * @param username
	 *            the username value you wish to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	
    /**
	 * {@inheritDoc}
	 */
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[Users:");
		buffer.append("id: ");
		buffer.append(getId());
		buffer.append(" active: ");
		buffer.append(active);
		buffer.append(" locked: ");
		buffer.append(locked);
		buffer.append(" pw: ");
		buffer.append(pw);
		buffer.append(" roles: ");
		buffer.append(roles);
		buffer.append(" salt: ");
		buffer.append(salt);
		buffer.append(" userData: ");
		buffer.append(userData);
		buffer.append(" username: ");
		buffer.append(username);
		buffer.append("]");
		return buffer.toString();
	}

}
