package flirt.and.date.hbm.model;

import flirt.and.date.hbm.enums.FriendshipRequestsState;
import hbm.entity.BaseEntity;

import java.util.Date;

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

import user.management.model.Users;


/** 
 * Object mapping for hibernate-handled table: friendship_requests
 * author: auto-generated
 */
@Entity
@Table(name="friendship_requests")
@TypeDef(name = "friendshipRequestsStateConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "flirt.and.date.hbm.enums.FriendshipRequestsState") })
public class FriendshipRequests 
extends BaseEntity<Integer>
implements Cloneable {
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -1113489530374059381L;
	/** Field mapping */
	private Users requestedUser;	
	/** Field mapping */
	private FriendshipRequestsState state;	
	/** Field mapping */
	private Users requestor;
	/** Shows the Date that the friendship is accepted. */
	private Date acceptedDate;	

    /**
     * Return the value associated with the column: acceptedDate.
     *
     * @return A Date object (this.acceptedDate)
     */
	@Column( name="accepted_date"  )
	public Date getAcceptedDate() {
		return this.acceptedDate;
	}
	

  
    /**
     * Set the value related to the column: acceptedDate.
     *
     * @param acceptedDate the acceptedDate value you wish to set
     */
	public void setAcceptedDate(final Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

    /**
     * Return the value associated with the column: requestedUser
	 * @return A Users object (this.requestedUser)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "requested_user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_FRIENDSHIPREQUESTS_R_USER_ID")
	@ForeignKey(name = "FK_FRIENDSHIPREQUESTS_R_USER_ID")
	public Users getRequestedUser() {
		return this.requestedUser;
	}
  
    /**  
     * Set the value related to the column: requestedUser 
	 * @param requestedUser the requestedUser value you wish to set
	 */
	public void setRequestedUser(final Users requestedUser) {
		this.requestedUser = requestedUser;
	}
	
    /**
     * Return the value associated with the column: state
	 * @return A FriendshipRequestsStateEnum object (this.state)
	 */
	@Column( name="state"  )	
	@Enumerated(EnumType.STRING)	
	@Type(type = "friendshipRequestsStateConverter")
	public FriendshipRequestsState getState() {
		return this.state;
	}
	
    /**  
     * Set the value related to the column: state 
	 * @param state the state value you wish to set
	 */
	public void setState (final FriendshipRequestsState state) {
		this.state = state;
	}

    /**
     * Return the value associated with the column: requestor
	 * @return A Users object (this.requestor)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "requestor_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_FRIENDSHIPREQUESTS_REQUESTOR_ID")
	@ForeignKey(name = "FK_FRIENDSHIPREQUESTS_REQUESTOR_ID")
	public Users getRequestor() {
		return this.requestor;
	}
	
    /**  
     * Set the value related to the column: requestor 
	 * @param requestor the requestor value you wish to set
	 */
	public void setRequestor(final Users requestor) {
		this.requestor = requestor;
	}
	
}