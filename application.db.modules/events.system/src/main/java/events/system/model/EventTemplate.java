package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import user.management.model.Users;
import events.system.enums.Difficulty;
import events.system.enums.EventType;

/**
 * The Entity class {@Events} is keeping the information for the
 * events.
 */
@Entity
@Table(name = "events")
@TypeDefs({
		@TypeDef(name = "difficultyConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "events.system.enums.Difficulty") }),

		@TypeDef(name = "eventtypeConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "events.system.enums.EventType") }) })
public class EventTemplate extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The category of the event. */
	private Categories categories;
	/** The name of the consultant for the event. */
	private String consultant;
	/** A description for the content from the event. */
	private String content;
	/** An enum for the difficulty from the event. */
	private Difficulty difficulty;
	/** The duration in days from the event. */
	private Integer duration;
	/** An enum for the event type. */
	private EventType eventtype;
	/** The head text from the event. */
	private String head;
	/** A description for the introduction from the event. */
	private String introduction;
	/** The locale language from the event when it is registred. */
	private String locale;
	/**
	 * A flag that signals if the provider have material for the event like
	 * books etc.
	 */
	private Boolean material;
	/** The name from this event. */
	private String name;
	/** The price from the event. */
	private java.math.BigDecimal price;
	/** The user id from the provider. */
	private Users provider;
	/** A description for the requirements from the event. */
	private String requirements;
	/** The minimum that have to subscribe to this event so it can be executed. */
	private Integer subscribermax;
	/** The maximum that can subscribe to this event. */
	private Integer subscribermin;
	/** A description for the targetgroup from the event. */
	private String targetgroup;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public EventTemplate() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: categories
	 * 
	 * @return A Categories object (this.categories)
	 */

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "categories_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_CATEGORIES_ID")
	@ForeignKey(name = "FK_EVENTS_CATEGORIES_ID")
	public Categories getCategories() {
		return this.categories;
	}

	/**
	 * Set the value related to the column: categories
	 * 
	 * @param categories
	 *            the categories value you wish to set
	 */
	public void setCategories(final Categories categories) {
		this.categories = categories;
	}

	/**
	 * Return the value associated with the column: consultant
	 * 
	 * @return A String object (this.consultant)
	 */
	@Column(length = 64)
	public String getConsultant() {
		return this.consultant;
	}

	/**
	 * Set the value related to the column: consultant
	 * 
	 * @param consultant
	 *            the consultant value you wish to set
	 */
	public void setConsultant(final String consultant) {
		this.consultant = consultant;
	}

	/**
	 * Return the value associated with the column: content
	 * 
	 * @return A String object (this.content)
	 */
	@Column(length = 21845)
	public String getContent() {
		return this.content;
	}

	/**
	 * Set the value related to the column: content
	 * 
	 * @param content
	 *            the content value you wish to set
	 */
	public void setContent(final String content) {
		this.content = content;
	}

	/**
	 * Return the value associated with the column: difficulty
	 * 
	 * @return A Difficulty object (this.difficulty)
	 */
	@Column(name = "difficulty")
	@Type(type = "difficultyConverter")
	public Difficulty getDifficulty() {
		return this.difficulty;
	}

	/**
	 * Set the value related to the column: difficulty
	 * 
	 * @param difficulty
	 *            the difficulty value you wish to set
	 */
	public void setDifficulty(final Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Return the value associated with the column: duration
	 * 
	 * @return A Integer object (this.duration)
	 */

	public Integer getDuration() {
		return this.duration;
	}

	/**
	 * Set the value related to the column: duration
	 * 
	 * @param duration
	 *            the duration value you wish to set
	 */
	public void setDuration(final Integer duration) {
		this.duration = duration;
	}

	/**
	 * Return the value associated with the column: eventtype
	 * 
	 * @return A EventType object (this.eventtype)
	 */

	@Enumerated(EnumType.STRING)
	@Column(name = "eventtype")
	@Type(type = "eventtypeConverter")
	public EventType getEventtype() {
		return this.eventtype;
	}

	/**
	 * Set the value related to the column: eventtype
	 * 
	 * @param eventtype
	 *            the eventtype value you wish to set
	 */
	public void setEventtype(final EventType eventtype) {
		this.eventtype = eventtype;
	}

	/**
	 * Return the value associated with the column: head
	 * 
	 * @return A String object (this.head)
	 */
	@Column(length = 21845)
	public String getHead() {
		return this.head;
	}

	/**
	 * Set the value related to the column: head
	 * 
	 * @param head
	 *            the head value you wish to set
	 */
	public void setHead(final String head) {
		this.head = head;
	}

	/**
	 * Return the value associated with the column: introduction
	 * 
	 * @return A String object (this.introduction)
	 */
	@Column(length = 21845)
	public String getIntroduction() {
		return this.introduction;
	}

	/**
	 * Set the value related to the column: introduction
	 * 
	 * @param introduction
	 *            the introduction value you wish to set
	 */
	public void setIntroduction(final String introduction) {
		this.introduction = introduction;
	}

	/**
	 * Return the value associated with the column: locale
	 * 
	 * @return A String object (this.locale)
	 */
	@Column(length = 3)
	public String getLocale() {
		return this.locale;
	}

	/**
	 * Set the value related to the column: locale
	 * 
	 * @param locale
	 *            the locale value you wish to set
	 */
	public void setLocale(final String locale) {
		this.locale = locale;
	}

	/**
	 * Return the value associated with the column: material
	 * 
	 * @return A Boolean object (this.material)
	 */

	public Boolean isMaterial() {
		return this.material;
	}

	/**
	 * Set the value related to the column: material
	 * 
	 * @param material
	 *            the material value you wish to set
	 */
	public void setMaterial(final Boolean material) {
		this.material = material;
	}

	/**
	 * Return the value associated with the column: name
	 * 
	 * @return A String object (this.name)
	 */
	@Column(length = 64)
	public String getName() {
		return this.name;
	}

	/**
	 * Set the value related to the column: name
	 * 
	 * @param name
	 *            the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Return the value associated with the column: price
	 * 
	 * @return A java.math.BigDecimal object (this.price)
	 */

	public java.math.BigDecimal getPrice() {
		return this.price;
	}

	/**
	 * Set the value related to the column: price
	 * 
	 * @param price
	 *            the price value you wish to set
	 */
	public void setPrice(final java.math.BigDecimal price) {
		this.price = price;
	}

	/**
	 * Return the value associated with the column: provider
	 * 
	 * @return A Integer object (this.provider)
	 */
	@Column(name = "provider")
	public Users getProvider() {
		return this.provider;
	}

	/**
	 * Set the value related to the column: providerId
	 * 
	 * @param providerId
	 *            the providerId value you wish to set
	 */
	public void setProvider(final Users provider) {
		this.provider = provider;
	}

	/**
	 * Return the value associated with the column: requirements
	 * 
	 * @return A String object (this.requirements)
	 */
	@Column(length = 21845)
	public String getRequirements() {
		return this.requirements;
	}

	/**
	 * Set the value related to the column: requirements
	 * 
	 * @param requirements
	 *            the requirements value you wish to set
	 */
	public void setRequirements(final String requirements) {
		this.requirements = requirements;
	}

	/**
	 * Return the value associated with the column: subscribermax
	 * 
	 * @return A Integer object (this.subscribermax)
	 */

	public Integer getSubscribermax() {
		return this.subscribermax;
	}

	/**
	 * Set the value related to the column: subscribermax
	 * 
	 * @param subscribermax
	 *            the subscribermax value you wish to set
	 */
	public void setSubscribermax(final Integer subscribermax) {
		this.subscribermax = subscribermax;
	}

	/**
	 * Return the value associated with the column: subscribermin
	 * 
	 * @return A Integer object (this.subscribermin)
	 */

	public Integer getSubscribermin() {
		return this.subscribermin;
	}

	/**
	 * Set the value related to the column: subscribermin
	 * 
	 * @param subscribermin
	 *            the subscribermin value you wish to set
	 */
	public void setSubscribermin(final Integer subscribermin) {
		this.subscribermin = subscribermin;
	}

	/**
	 * Return the value associated with the column: targetgroup
	 * 
	 * @return A String object (this.targetgroup)
	 */
	@Column(length = 21845)
	public String getTargetgroup() {
		return this.targetgroup;
	}

	/**
	 * Set the value related to the column: targetgroup
	 * 
	 * @param targetgroup
	 *            the targetgroup value you wish to set
	 */
	public void setTargetgroup(final String targetgroup) {
		this.targetgroup = targetgroup;
	}

}
