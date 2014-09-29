package user.management.model;

import hbm.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.sourceforge.jaulp.auth.interfaces.Permission;

/**
 * The Entity class {@link Permissions} is keeping the information for
 * the permissions of a role or roles.
 */
@Entity
@Table(name = "permissions")
public class Permissions 
extends BaseEntity<Integer>
implements Permission, Cloneable {

	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** A description for the permission. */
	private String description;
	/** The name from the permission. */
	private String permissionName;
	/** A shortcut for the permission. */
	private String shortcut;

	/**
	 * Default constructor.
	 */
	public Permissions() {
	}

	/**
	 * Return the value associated with the column: description
	 * 
	 * @return A String object (this.description)
	 */
	@Column(length = 64)
	public String getDescription() {
		return this.description;
	}

	/**
	 * Return the value associated with the column: permission
	 * 
	 * @return A String object (this.permission)
	 */
	@Column(length = 64, unique=true)
	public String getPermissionName() {
		return this.permissionName;
	}

	/**
	 * Return the value associated with the column: shortcut
	 * 
	 * @return A String object (this.shortcut)
	 */
	@Column(length = 10, unique=true)
	public String getShortcut() {
		return this.shortcut;
	}

	/**
	 * Set the value related to the column: description
	 * 
	 * @param description
	 *            the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Set the value related to the column: permission
	 * 
	 * @param name
	 *            the permission value you wish to set
	 */
	public void setPermissionName(final String name) {
		this.permissionName = name;
	}

    /**
	 * Set the value related to the column: shortcut
	 * 
	 * @param shortcut
	 *            the shortcut value you wish to set
	 */
	public void setShortcut(final String shortcut) {
		this.shortcut = shortcut;
	}
	
}
