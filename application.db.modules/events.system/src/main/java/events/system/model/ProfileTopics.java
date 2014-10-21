package events.system.model;

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
 * The Entity class {@ProfileTopics} is keeping the information
 * for the connection between the Entity class {@Users} and the Entity
 * class {@Topics}.
 */
@Entity
@Table(name = "profile_topics")
public class ProfileTopics extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The topic attribute that references to the Entity class {@Topics
	 * 
	 * 
	 * }.
	 */
	private Topics topic;
	/** The user attribute that references to the Entity class {@Users}. */
	private Users user;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public ProfileTopics() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: topic
	 * 
	 * @return A Topics object (this.topic)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PROFILE_TOPICS_TOPIC_ID")
	@ForeignKey(name = "FK_PROFILE_TOPICS_TOPIC_ID")
	public Topics getTopic() {
		return this.topic;
	}

	/**
	 * Set the value related to the column: topic
	 * 
	 * @param topic
	 *            the topic value you wish to set
	 */
	public void setTopic(final Topics topic) {
		this.topic = topic;
	}

	/**
	 * Return the value associated with the column: user
	 * 
	 * @return A Users object (this.user)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PROFILE_TOPICS_USER_ID")
	@ForeignKey(name = "FK_PROFILE_TOPICS_USER_ID")
	public Users getUser() {
		return this.user;
	}

	/**
	 * Set the value related to the column: user
	 * 
	 * @param user
	 *            the user value you wish to set
	 */
	public void setUser(final Users user) {
		this.user = user;
	}

}
