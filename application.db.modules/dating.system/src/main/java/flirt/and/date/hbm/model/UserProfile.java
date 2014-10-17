package flirt.and.date.hbm.model;

import flirt.and.date.hbm.enums.EducationState;
import flirt.and.date.hbm.enums.FigureType;
import flirt.and.date.hbm.enums.HaircolorType;
import flirt.and.date.hbm.enums.InterestsType;
import flirt.and.date.hbm.enums.RelationshipState;
import flirt.and.date.hbm.enums.SmokerState;
import flirt.and.date.hbm.enums.ZodiacSignType;
import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import resource.system.model.Resources;
import user.management.model.Users;


/** 
 * Object mapping for hibernate-handled table: user_profile
 */
@Entity
@Table(name="user_profile")
@TypeDefs({
	@TypeDef(name = "educationStateConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "flirt.and.date.hbm.enums.EducationState") }),
	@TypeDef(name = "figureConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "flirt.and.date.hbm.enums.FigureType") }),
	@TypeDef(name = "haircolorConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "flirt.and.date.hbm.enums.HaircolorType") }),
	@TypeDef(name = "interestsConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "flirt.and.date.hbm.enums.InterestsType") }),
	@TypeDef(name = "relationshipStateConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "flirt.and.date.hbm.enums.RelationshipState") }),
	@TypeDef(name = "smokerstateConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "flirt.and.date.hbm.enums.SmokerState") }),
	@TypeDef(name = "zodiacSignConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "flirt.and.date.hbm.enums.ZodiacSignType") }) })
public class UserProfile 
extends BaseEntity<Integer>
implements Cloneable {	
	/** The serial Version UID. */
	private static final long serialVersionUID = 8626651299912885319L;
	/** Field mapping */
	private Integer age;	
	/** Field mapping */
	private EducationState educationState;	
	/** Field mapping */
	private FigureType figure;	
	/** Field mapping */
	private HaircolorType haircolor;	
	/** Field mapping */
	private Integer height;	
	/** Field mapping */
	private InterestsType interests;	
	/** Field mapping */
	private String occupation;	
	/** Field mapping */
	private String profileText;	
	/** Field mapping */
	private RelationshipState relationshipState;
	/** Field mapping */	
	private SearchCriteria searchCriteria;	
	/** Field mapping */
	private SmokerState smokerstate;	
	/** The user attribute that references to the Entity class {@link Users}. */
	private Users user;
	/**
	 * The image from the profile. The userImage attribute that references to the Entity class {@link Resources
	 * }.
	 */
	private Resources userImage;
	/** Field mapping */
	private Integer weight;
	/** Field mapping */
	private ZodiacSignType zodiacSign;	
	
	/**
	 * Default constructor.
	 */
	public UserProfile(){
	}
	
    /**
     * Return the value associated with the column: age
	 * @return A Integer object (this.age)
	 */
	@Column( name="age"  )
	public Integer getAge() {
		return this.age;
	}
  
    /**
     * Return the value associated with the column: educationState
	 * @return A UserProfileEducationStateEnum object (this.educationState)
	 */
	@Enumerated(EnumType.STRING)
	@Column( name="education_state"  )
	@Type(type = "educationStateConverter")
	public EducationState getEducationState() {
		return this.educationState;
	}
	
    /**
     * Return the value associated with the column: figure
	 * @return A FigureType object (this.figure)
	 */	
	@Column( name="figure"  )
	@Enumerated(EnumType.STRING)
	@Type(type = "figureConverter")
	public FigureType getFigure() {
		return this.figure;
	}
  
    /**
     * Return the value associated with the column: haircolor
	 * @return A HaircolorType object (this.haircolor)
	 */	
	@Column( name="haircolor"  )
	@Enumerated(EnumType.STRING)
	@Type(type = "haircolorConverter")
	public HaircolorType getHaircolor() {
		return this.haircolor;
	}

    /**
     * Return the value associated with the column: height
	 * @return A Integer object (this.height)
	 */	
	@Column( name="height"  )
	public Integer getHeight() {
		return this.height;
	}

    /**
     * Return the value associated with the column: interests
	 * @return A InterestsType object (this.interests)
	 */	
	@Column( name="interests"  )
	@Enumerated(EnumType.STRING)
	@Type(type = "interestsConverter")
	public InterestsType getInterests() {
		return this.interests;
	}
  
    /**
     * Return the value associated with the column: occupation
	 * @return A String object (this.occupation)
	 */
	@Column( name="occupation", length = 50  )
	public String getOccupation() {
		return this.occupation;
	}

    /**
     * Return the value associated with the column: profileText
	 * @return A String object (this.profileText)
	 */
	@Column( name="profile_text", length = 1000  )
	public String getProfileText() {
		return this.profileText;
	}
  
    /**
     * Return the value associated with the column: relationshipState
	 * @return A RelationshipState object (this.relationshipState)
	 */
	@Column( name="relationship_status"  )
	@Enumerated(EnumType.STRING)
	@Type(type = "relationshipStateConverter")
	public RelationshipState getRelationshipState() {
		return this.relationshipState;
	}

    @OneToOne
	@JoinColumn(name="search_criteria")
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}
  
    /**
     * Return the value associated with the column: smokerstate
	 * @return A SmokerState object (this.smokerstate)
	 */
	@Column( name="smokerstate"  )
	@Enumerated(EnumType.STRING)
	@Type(type = "smokerstateConverter")
	public SmokerState getSmokerstate() {
		return this.smokerstate;
	}

    /**
     * Return the value associated with the column: userId
	 * @return A Integer object (this.userId)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_USER_PROFILE_USER_ID")
	@ForeignKey(name = "FK_USER_PROFILE_USER_ID")
	public Users getUser() {
		return this.user;
	}
  
    /**
     * Return the value associated with the column: userImageId
	 * @return A Integer object (this.userImageId)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PROFILE_IMAGE_ID")
	@ForeignKey(name = "FK_PROFILE_IMAGE_ID")
	public Resources getUserImage() {
		return this.userImage;
	}
	
    /**
     * Return the value associated with the column: weight
	 * @return A Integer object (this.weight)
	 */
	@Column( name="weight"  )
	public Integer getWeight() {
		return this.weight;
	}
  
    /**
     * Return the value associated with the column: zodiacSign
	 * @return A ZodiacSignType object (this.zodiacSign)
	 */
	@Column( name="zodiac_sign"  )
	@Enumerated(EnumType.STRING)
	@Type(type = "zodiacSignConverter")
	public ZodiacSignType getZodiacSign() {
		return this.zodiacSign;
	}
  
    /**  
     * Set the value related to the column: age 
	 * @param age the age value you wish to set
	 */
	public void setAge (final Integer age) {
		this.age = age;
	}

    /**  
     * Set the value related to the column: educationState 
	 * @param educationState the educationState value you wish to set
	 */
	public void setEducationState (final EducationState educationState) {
		this.educationState = educationState;
	}
	  
    /**  
     * Set the value related to the column: figure 
	 * @param figure the figure value you wish to set
	 */
	public void setFigure (final FigureType figure) {
		this.figure = figure;
	}

    /**  
     * Set the value related to the column: haircolor 
	 * @param haircolor the haircolor value you wish to set
	 */
	public void setHaircolor (final HaircolorType haircolor) {
		this.haircolor = haircolor;
	}

    /**  
     * Set the value related to the column: height 
	 * @param height the height value you wish to set
	 */
	public void setHeight (final Integer height) {
		this.height = height;
	}

	/**  
     * Set the value related to the column: interests 
	 * @param interests the interests value you wish to set
	 */
	public void setInterests (final InterestsType interests) {
		this.interests = interests;
	}

    /**  
     * Set the value related to the column: occupation 
	 * @param occupation the occupation value you wish to set
	 */
	public void setOccupation (final String occupation) {
		this.occupation = occupation;
	}

    /**  
     * Set the value related to the column: profileText 
	 * @param profileText the profileText value you wish to set
	 */
	public void setProfileText (final String profileText) {
		this.profileText = profileText;
	}

    /**  
     * Set the value related to the column: relationshipState 
	 * @param relationshipState the relationshipState value you wish to set
	 */
	public void setRelationshipState (final RelationshipState relationshipState) {
		this.relationshipState = relationshipState;
	}

    public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

    /**  
     * Set the value related to the column: smokerstate 
	 * @param smokerstate the smokerstate value you wish to set
	 */
	public void setSmokerstate (final SmokerState smokerstate) {
		this.smokerstate = smokerstate;
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

    /**  
     * Set the value related to the column: userImageId 
	 * @param userImageId the userImageId value you wish to set
	 */
	public void setUserImage (final Resources userImage) {
		this.userImage = userImage;
	}

	/**  
     * Set the value related to the column: weight 
	 * @param weight the weight value you wish to set
	 */
	public void setWeight (final Integer weight) {
		this.weight = weight;
	}

	/**  
     * Set the value related to the column: zodiacSign 
	 * @param zodiacSign the zodiacSign value you wish to set
	 */
	public void setZodiacSign (final ZodiacSignType zodiacSign) {
		this.zodiacSign = zodiacSign;
	}

}