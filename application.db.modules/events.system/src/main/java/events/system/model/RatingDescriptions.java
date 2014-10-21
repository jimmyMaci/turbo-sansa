package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

/**
 * The Entity class {@RatingDescriptions} is keeping the
 * information for the rating descriptions and is associatate with the Entity
 * class {@EventRatings}.
 */
@Entity
@Table(name = "rating_descriptions")
public class RatingDescriptions extends BaseEntity<Integer> implements
		Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The eventRatings attribute that references to the Entity class
	 * {@EventRatings}.
	 */
	private EventRatings eventRatings;
	/** A description what the user liked less from the event. */
	private String lessLikeRating;
	/** A description what the user liked most from the event. */
	private String mostLikeRating;
	/** A description if the user recommend the consultant from the event. */
	private String recommendConsultant;
	/** A description if the user recommend the event. */
	private String recommendEvent;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public RatingDescriptions() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: eventRatings
	 * 
	 * @return A EventRatings object (this.eventRatings)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_ratings_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_RATING_DESCRIPTIONS_EVENT_RATINGS_ID")
	@ForeignKey(name = "FK_RATING_DESCRIPTIONS_EVENT_RATINGS_ID")
	public EventRatings getEventRatings() {
		return this.eventRatings;
	}

	/**
	 * Set the value related to the column: eventRatings
	 * 
	 * @param eventRatings
	 *            the eventRatings value you wish to set
	 */
	public void setEventRatings(final EventRatings eventRatings) {
		this.eventRatings = eventRatings;
	}

	/**
	 * Return the value associated with the column: lessLikeRating
	 * 
	 * @return A String object (this.lessLikeRating)
	 */
	@Column(name = "less_like_rating", length = 1024)
	public String getLessLikeRating() {
		return this.lessLikeRating;
	}

	/**
	 * Set the value related to the column: lessLikeRating
	 * 
	 * @param lessLikeRating
	 *            the lessLikeRating value you wish to set
	 */
	public void setLessLikeRating(final String lessLikeRating) {
		this.lessLikeRating = lessLikeRating;
	}

	/**
	 * Return the value associated with the column: mostLikeRating
	 * 
	 * @return A String object (this.mostLikeRating)
	 */
	@Column(name = "most_like_rating", length = 1024)
	public String getMostLikeRating() {
		return this.mostLikeRating;
	}

	/**
	 * Set the value related to the column: mostLikeRating
	 * 
	 * @param mostLikeRating
	 *            the mostLikeRating value you wish to set
	 */
	public void setMostLikeRating(final String mostLikeRating) {
		this.mostLikeRating = mostLikeRating;
	}

	/**
	 * Return the value associated with the column: recommendConsultant
	 * 
	 * @return A String object (this.recommendConsultant)
	 */
	@Column(name = "recommend_consultant", length = 1024)
	public String getRecommendConsultant() {
		return this.recommendConsultant;
	}

	/**
	 * Set the value related to the column: recommendConsultant
	 * 
	 * @param recommendConsultant
	 *            the recommendConsultant value you wish to set
	 */
	public void setRecommendConsultant(final String recommendConsultant) {
		this.recommendConsultant = recommendConsultant;
	}

	/**
	 * Return the value associated with the column: recommendEvent
	 * 
	 * @return A String object (this.recommendEvent)
	 */
	@Column(name = "recommend_event", length = 1024)
	public String getRecommendEvent() {
		return this.recommendEvent;
	}

	/**
	 * Set the value related to the column: recommendEvent
	 * 
	 * @param recommendEvent
	 *            the recommendEvent value you wish to set
	 */
	public void setRecommendEvent(final String recommendEvent) {
		this.recommendEvent = recommendEvent;
	}

}
