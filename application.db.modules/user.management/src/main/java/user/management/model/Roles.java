package user.management.model;

import hbm.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Entity class {@link Roles} is keeping the information for the user
 * roles.
 */
@Entity
@Table(name = "roles")
public class Roles 
extends BaseEntity<Integer>
implements Cloneable {

	/** The serial Version UID. */
	private static final long serialVersionUID = -5523602462337489391L;
	/** A description of the role. */
	private String description;
	/** The permissions of the role. */
	private Set<Permissions> permissions = new HashSet<Permissions>();
	/** The name of the role. */
	private String rolename;
	
	/**
	 * Default constructor.
	 */
	public Roles() {
	}
	
	/**
	 * Adds the permission.
	 *
	 * @param permission the permission
	 * @return true, if successful
	 */
	public boolean addPermission(Permissions permission){
		return permissions.add(permission);
	}

	/**
	 * Return the value associated with the column: description.
	 *
	 * @return A String object (this.description)
	 */
	@Column(length = 64)
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the permissions of this Roles object.
	 *
	 * @return the permissions
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		      name="role_permissions",
		      joinColumns={@JoinColumn(name="role_id", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="permission_id", referencedColumnName="id")})
	public Set<Permissions> getPermissions() {
		return permissions;
	}

	/**
	 * Return the value associated with the column: rolename.
	 *
	 * @return A String object (this.rolename)
	 */
	@Column(length = 64, unique = true)
	public String getRolename() {
		return this.rolename;
	}

	/**
	 * Set the value related to the column: description.
	 *
	 * @param description the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * Sets the permissions.
	 *
	 * @param permissions the new permissions
	 */
	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}

    /**
	 * Set the value related to the column: rolename.
	 *
	 * @param rolename the rolename value you wish to set
	 */
	public void setRolename(final String rolename) {
		this.rolename = rolename;
	}
	
}
