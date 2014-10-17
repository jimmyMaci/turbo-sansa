package flirt.and.date.hbm.model;

import hbm.entity.BaseEntity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import user.management.model.Users;

/**
 * Object mapping for hibernate-handled table: profile_visitors
 * author: auto-generated.
 */
@Entity
@Table(name="profile_visitors")
public class ProfileVisitors 
extends BaseEntity<Integer>
implements Cloneable {
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 7152349023775145105L;
	
	/** Shows the last Date that the visitor visited this profile. */
	private Date visitingDate;	
	/** The visitor of this profile. */
	private Users visitor;	
	/** The visited profile. */
	private UserProfile visitedProfile;
	/** The count shows how many times a visitor visited this profile. */	
	private Integer count;	

	/**
	 * Gets the rated profile.
	 *
	 * @return the rated profile
	 */
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "visited_profile")
	public UserProfile getVisitedProfile() {
		return visitedProfile;
	}

	/**
	 * Sets the rated profile.
	 *
	 * @param visitedProfile the new visited profile
	 */
	public void setVisitedProfile(UserProfile visitedProfile) {
		this.visitedProfile = visitedProfile;
	}

    /**
     * Return the value associated with the column: visitingDate.
     *
     * @return A Date object (this.visitingDate)
     */
	@Column( name="visiting_date"  )
	public Date getVisitingDate() {
		return this.visitingDate;
	}
	

  
    /**
     * Set the value related to the column: visitingDate.
     *
     * @param visitingDate the visitingDate value you wish to set
     */
	public void setVisitingDate (final Date visitingDate) {
		this.visitingDate = visitingDate;
	}


    /**
     * Return the value associated with the column: visitor.
     *
     * @return A Users object (this.visitor)
     */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "visitor_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PROFILE_VISITORS_VISITOR_ID")
	@ForeignKey(name = "FK_PROFILE_VISITORS_VISITOR_ID")
	public Users getVisitor() {
		return this.visitor;
	}
	

  
    /**
     * Set the value related to the column: visitor.
     *
     * @param visitor the visitor value you wish to set
     */
	public void setVisitor(final Users visitor) {
		this.visitor = visitor;
	}	

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	@Column(name = "count", nullable = true)
    public Integer getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

}