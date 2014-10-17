package flirt.and.date.hbm.model;

import hbm.entity.BaseEntity;

import java.lang.reflect.InvocationTargetException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.sourceforge.jaulp.lang.ObjectUtils;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import user.management.model.Users;

/**
 * The Entity class {@link ProfileNotice} is keeping the
 * information for the notices for a profile from a user.
 */
@Entity
@Table(name = "profile_notice")
public class ProfileNotice 
extends BaseEntity<Integer>
implements Cloneable, Comparable<ProfileNotice> {
	
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -4842057287428474623L;

	/** The notice for this user profile.*/
	private String notice;
	
	/**
	 * The user attribute that references to the Entity class {@link Users}
	 * that owns the notice for this user profile.
	 */
	private Users user;
	/** The reference to the user profile for this notice. */
	private UserProfile userProfile;

	/**
	 * Default constructor.
	 */
	public ProfileNotice() {
	}

	/**
	 * Gets the notice.
	 *
	 * @return the notice
	 */
	@Column( name="notice", length = 1000  )
	public String getNotice() {
		return notice;
	}

	/**
	 * Return the value associated with the column: user.
	 *
	 * @return A Users object (this.user)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PROFILE_NOTICE_USER_ID")
	@ForeignKey(name = "FK_PROFILE_NOTICE_USER_ID")
	public Users getUser() {
		return this.user;
	}

	/**
	 * Gets the user profile.
	 *
	 * @return the user profile
	 */
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_profile")
	public UserProfile getUserProfile() {
		return userProfile;
	}

	/**
	 * Sets the notice.
	 *
	 * @param notice the new notice
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

	/**
	 * Set the value related to the column: user.
	 *
	 * @param user the user value you wish to set
	 */
	public void setUser(final Users user) {
		this.user = user;
	}

	/**
	 * Sets the user profile.
	 *
	 * @param userProfile the new user profile
	 */
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public int compareTo(ProfileNotice o) {
		try {
			return ObjectUtils.compareTo(this.getUser(), o.getUser(), "username");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
