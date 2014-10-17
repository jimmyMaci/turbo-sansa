package flirt.and.date.hbm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;

import rating.system.model.Ratings;

/**
 * The Class ProfileRatings extends the Ratings class that contains the general data for rating entities.
 */
@Entity
@Table(name = "profile_ratings")
@TypeDef(name = "visibilityConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "rating.system.enums.RatingVisibility") })
public class ProfileRatings extends Ratings {
	
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 5054268089145453933L;
	/** The rated profile. */
	private UserProfile ratedProfile;

	/**
	 * Gets the rated profile.
	 *
	 * @return the rated profile
	 */
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "rated_profile")
	public UserProfile getRatedProfile() {
		return ratedProfile;
	}

	/**
	 * Sets the rated profile.
	 *
	 * @param ratedProfile the new rated profile
	 */
	public void setRatedProfile(UserProfile ratedProfile) {
		this.ratedProfile = ratedProfile;
	}
}