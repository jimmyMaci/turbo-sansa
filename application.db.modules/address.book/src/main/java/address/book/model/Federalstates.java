package address.book.model;

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
 * The Entity class {@link Federalstates} is keeping the information
 * for the federal states from the countries.
 */
@Entity
@Table(name = "federalstates")
public class Federalstates 
extends BaseEntity<Integer>
implements Cloneable {

	/** The serial Version UID */
	private static final long serialVersionUID = -2105692517269551804L;
	/** The reference to the country in wich the federal state exists. */
	private Countries country;
	/** The iso3166 code with two characters. */
	private String iso3166A2code;
	/** The name of the federal state. */
	private String name;
	/** The category from the subivision. */
	private String subdivisionCategory;
	/** The name from the subdivision. */
	private String subdivisionName;

	/**
	 * Default constructor.
	 */
	public Federalstates() {
	}

	/**
	 * Return the value associated with the column: country
	 * 
	 * @return A Countries object (this.country)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_COUNTRY_ID")
	@ForeignKey(name = "FK_FEDERAL_STATES_COUNTRY_ID")
	public Countries getCountry() {
		return this.country;
	}

	/**
	 * Return the value associated with the column: iso3166A2code
	 * 
	 * @return A String object (this.iso3166A2code)
	 */
	@Column(name = "iso3166_a2code", length = 6)
	public String getIso3166A2code() {
		return this.iso3166A2code;
	}

	/**
	 * Return the value associated with the column: name
	 * 
	 * @return A String object (this.name)
	 */
	@Column(length = 128)
	public String getName() {
		return this.name;
	}

	/**
	 * Return the value associated with the column: subdivisionCategory
	 * 
	 * @return A String object (this.subdivisionCategory)
	 */
	@Column(name = "subdivision_category", length = 128)
	public String getSubdivisionCategory() {
		return this.subdivisionCategory;
	}

	/**
	 * Return the value associated with the column: subdivisionName
	 * 
	 * @return A String object (this.subdivisionName)
	 */
	@Column(name = "subdivision_name", length = 56)
	public String getSubdivisionName() {
		return this.subdivisionName;
	}

	/**
	 * Set the value related to the column: country
	 * 
	 * @param country
	 *            the country value you wish to set
	 */
	public void setCountry(final Countries country) {
		this.country = country;
	}

	/**
	 * Set the value related to the column: iso3166A2code
	 * 
	 * @param iso3166A2code
	 *            the iso3166A2code value you wish to set
	 */
	public void setIso3166A2code(final String iso3166A2code) {
		this.iso3166A2code = iso3166A2code;
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
	 * Set the value related to the column: subdivisionCategory
	 * 
	 * @param subdivisionCategory
	 *            the subdivisionCategory value you wish to set
	 */
	public void setSubdivisionCategory(final String subdivisionCategory) {
		this.subdivisionCategory = subdivisionCategory;
	}
	
    /**
	 * Set the value related to the column: subdivisionName
	 * 
	 * @param subdivisionName
	 *            the subdivisionName value you wish to set
	 */
	public void setSubdivisionName(final String subdivisionName) {
		this.subdivisionName = subdivisionName;
	}

}
