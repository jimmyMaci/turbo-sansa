package flirt.and.date.hbm.model;

import hbm.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import user.management.enums.Gender;

/**
 * Object mapping for hibernate-handled table: search_criteria.
 * Used for the users profile search.
 */
@Entity
@Table(name="search_criteria")
@TypeDefs({ 
	@TypeDef(name = "genderConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "user.management.enums.Gender") }) })
public class SearchCriteria 
extends BaseEntity<Integer>
implements Cloneable {
	
	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 8383260870729599158L;

	/** The age search criteria starting 'from'. */
	private Integer fromAge;
	
	/** The gender search criteria 'search'. */
	private Gender searchGender;
	
	/** The age search criteria ending 'until'. */
	private Integer untilAge;

	/**
	 * Instantiates a new search criteria.
	 */
	public SearchCriteria() {
	}
	
	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	@Column( name="from_age"  )
	public Integer getFromAge() {
		return fromAge;
	}
	
	/**
	 * Gets the search.
	 *
	 * @return the search
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "search_gender")
	@Type(type = "genderConverter")
	public Gender getSearchGender() {
		return searchGender;
	}
	
	/**
	 * Gets the until.
	 *
	 * @return the until
	 */
	@Column( name="until_age"  )
	public Integer getUntilAge() {
		return untilAge;
	}
	
	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFromAge(Integer fromAge) {
		this.fromAge = fromAge;
	}
	
	/**
	 * Sets the search.
	 *
	 * @param search the new search
	 */
	public void setSearchGender(Gender searchGender) {
		this.searchGender = searchGender;
	}
	
	/**
	 * Sets the until.
	 *
	 * @param until the new until
	 */
	public void setUntilAge(Integer untilAge) {
		this.untilAge = untilAge;
	}
	
}
