package user.management.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;

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
import org.hibernate.annotations.TypeDefs;

import user.management.enums.RuleViolationReason;
import user.management.model.Users;

/**
 * Object mapping for hibernate-handled table: rule_violations 
 */
@Entity
@Table(name="rule_violations")
@TypeDefs({ 
	@TypeDef(name = "reasonConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "user.management.enums.RuleViolationReason") }) })
public class RuleViolations
extends BaseEntity<Integer>
implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RuleViolationReason reason;
	
	private Users detector;
	
	private Users violator;
	
	private String description;
	/**
	 * Gets the search.
	 *
	 * @return the search
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "reason")
	@Type(type = "reasonConverter")
	public RuleViolationReason getReason() {
		return reason;
	}

	public void setReason(RuleViolationReason reason) {
		this.reason = reason;
	}
    /**
     * Return the value associated with the column: detector
	 * @return A Users object (this.detector)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "detector_user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_DETECTOR_USER_ID")
	@ForeignKey(name = "FK_DETECTOR_USER_ID")
	public Users getDetector() {
		return detector;
	}

	public void setDetector(Users detector) {
		this.detector = detector;
	}

    /**
     * Return the value associated with the column: violator
	 * @return A Users object (this.violator)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "violator_user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_VIOLATOR_USER_ID")
	@ForeignKey(name = "FK_VIOLATOR_USER_ID")
	public Users getViolator() {
		return violator;
	}

	public void setViolator(Users violator) {
		this.violator = violator;
	}


    /**
     * Return the value associated with the column: description
	 * @return A String object (this.description)
	 */
	@Column( name="description", length = 1000  )
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
