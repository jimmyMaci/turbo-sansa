package user.management.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

/**
 * This class describes the permissions that a user can give to another user. 
 * For instance: if a user(the provider of the permissions) have private resources like images
 * and want to release them to another user(the subscriber) so he can see this resources, 
 * than an entry of a provider and the specified permission have to be added in the set of permission. 
 */
@Entity
@Table(name="relation_permissions")
public class RelationPermissions 
extends BaseEntity<Integer>
implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The subscriber of the permissions. */
	private Users subscriber;	
	/** The provider of the permissions. */
	private Users provider;	
	/** The permissions of the role. */
	private Set<Permissions> permissions = new HashSet<Permissions>();

    /**
     * Return the value associated with the column: provider.
     *
     * @return A Users object (this.provider)
     */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PROVIDER_ID")
	@ForeignKey(name = "FK_USER_RELATION_PERMISSIONS_PROVIDER_ID")
	public Users getProvider() {
		return this.provider;
	}
	
    /**
     * Return the value associated with the column: subscriber.
     *
     * @return A Users object (this.subscriber)
     */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscriber_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_SUBSCRIBER_ID")
	@ForeignKey(name = "FK_USER_RELATION_PERMISSIONS_SUBSCRIBER_ID")
	public Users getSubscriber() {
		return this.subscriber;
	}
	
    /**
     * Set the value related to the column: provider.
     *
     * @param provider the provider value you wish to set
     */
	public void setProvider(final Users provider) {
		this.provider = provider;
	}
	
    /**
     * Set the value related to the column: subscriber.
     *
     * @param provider the subscriber value you wish to set
     */
	public void setSubscriber(Users subscriber) {
		this.subscriber = subscriber;
	}
	
	/**
	 * Gets the permissions of this RelationPermissions object.
	 *
	 * @return the permissions
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		      name="user_relation_permissions",
		      joinColumns={@JoinColumn(name="user_relation_permission_id", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="permission_id", referencedColumnName="id")})
	public Set<Permissions> getPermissions() {
		return permissions;
	}
	
	/**
	 * Sets the permissions.
	 *
	 * @param permissions the new permissions
	 */
	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}

}