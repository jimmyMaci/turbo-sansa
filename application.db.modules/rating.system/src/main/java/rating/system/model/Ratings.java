package rating.system.model;

import hbm.entity.BaseEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import rating.system.enums.RatingVisibility;
import user.management.model.Users;

/**
 * Object mapping for hibernate-handled table: profile_ratings author:
 * 
 */
@MappedSuperclass
public class Ratings 
extends BaseEntity<Integer>
implements Cloneable {

	/** Serial Version UID */
	private static final long serialVersionUID = -559039798L;

	/** The id from the user that rated the entity. */
	private Users rater;
	/** Field mapping */
	private Integer ratingpoints;
	/** The time that the user made the last rating. */
	private Date ratingDate;
	/** A description for the rating. */
	private String ratingDescription;
	/** The title from the event rating. */
	private String titleRating;
	/** Field mapping */
	private RatingVisibility visibility;
	
	/**
	 * Return the value associated with the column: rater
	 * 
	 * @return A Integer object (this.rater)
	 */
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "rater")
	public Users getRater() {
		return this.rater;
	}

	/**
	 * Set the value related to the column: rater
	 * 
	 * @param rater
	 *            the rater value you wish to set
	 */
	public void setRater(final Users rater) {
		this.rater = rater;
	}

	/**
	 * Return the value associated with the column: ratingpoints
	 * 
	 * @return A Integer object (this.ratingpoints)
	 */

	public Integer getRatingpoints() {
		return this.ratingpoints;
	}

	/**
	 * Set the value related to the column: ratingpoints
	 * 
	 * @param ratingpoints
	 *            the ratingpoints value you wish to set
	 */
	public void setRatingpoints(final Integer ratingpoints) {
		this.ratingpoints = ratingpoints;
	}

	/**
	 * Return the value associated with the column: ratingDate
	 * 
	 * @return A Date object (this.ratingDate)
	 */
	@Column(name = "rating_date")
	public Date getRatingDate() {
		return this.ratingDate;
	}

	/**
	 * Set the value related to the column: ratingDate
	 * 
	 * @param ratingDate
	 *            the ratingDate value you wish to set
	 */
	public void setRatingDate(final Date ratingDate) {
		this.ratingDate = ratingDate;
	}

	/**
	 * Return the value associated with the column: ratingDescription
	 * 
	 * @return A String object (this.ratingDescription)
	 */
	@Column(name = "rating_description", length = 1024)
	public String getRatingDescription() {
		return this.ratingDescription;
	}

	/**
	 * Set the value related to the column: ratingDescription
	 * 
	 * @param ratingDescription
	 *            the ratingDescription value you wish to set
	 */
	public void setRatingDescription(final String ratingDescription) {
		this.ratingDescription = ratingDescription;
	}

	/**
	 * Return the value associated with the column: titleRating
	 * 
	 * @return A String object (this.titleRating)
	 */
	@Column(name = "title_rating", length = 256)
	public String getTitleRating() {
		return this.titleRating;
	}

	/**
	 * Set the value related to the column: titleRating
	 * 
	 * @param titleRating
	 *            the titleRating value you wish to set
	 */
	public void setTitleRating(final String titleRating) {
		this.titleRating = titleRating;
	}

	/**
	 * Return the value associated with the column: visibility
	 * 
	 * @return A ProfileRatingsVisibilityEnum object (this.visibility)
	 */
	@Column(name = "visibility")
	@Enumerated(EnumType.STRING)
	@Type(type = "ratingVisibilityConverter")
	public RatingVisibility getVisibility() {
		return this.visibility;
	}

	/**
	 * Set the value related to the column: visibility
	 * 
	 * @param visibility
	 *            the visibility value you wish to set
	 */
	public void setVisibility(final RatingVisibility visibility) {
		this.visibility = visibility;
	}
	
}