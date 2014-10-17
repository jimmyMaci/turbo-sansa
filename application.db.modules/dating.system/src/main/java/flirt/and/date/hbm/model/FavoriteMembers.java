package flirt.and.date.hbm.model;
import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import user.management.model.Users;


/** 
 * Object mapping for hibernate-handled table: favorite_members
 * author: auto-generated
 */
@Entity
@Table(name="favorite_members")
public class FavoriteMembers 
extends BaseEntity<Integer>
implements Cloneable {
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1335157141885208007L;

	/** Field mapping */
	private Users owner;

	/** The reference to the user profile for this notice. */
	private UserProfile favorite;
 


    /**
     * Return the value associated with the column: favorite
	 * @return A Users object (this.favorite)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "favorite_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_FAVORITE_MEMBERS_FAVORITE_ID")
	@ForeignKey(name = "FK_FAVORITE_MEMBERS_FAVORITE_ID")
	public UserProfile getFavorite() {
		return this.favorite;
	}
  
    /**  
     * Set the value related to the column: favorite 
	 * @param favorite the favoriteId value you wish to set
	 */
	public void setFavorite(final UserProfile favorite) {
		this.favorite = favorite;
	}	

    /**
     * Return the value associated with the column: userId
	 * @return A Integer object (this.userId)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_FAVORITE_MEMBERS_OWNER_ID")
	@ForeignKey(name = "FK_FAVORITE_MEMBERS_OWNER_ID")
	public Users getOwner() {
		return this.owner;
	}
  
    /**  
     * Set the value related to the column: userId 
	 * @param userId the userId value you wish to set
	 */
	public void setOwner(final Users owner) {
		this.owner = owner;
	}

}