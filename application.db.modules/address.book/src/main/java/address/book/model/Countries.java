package address.book.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Entity class {@link Countries} is keeping the information for all
 * countries in the world.
 */
@Entity
@Table(name = "countries")
public class Countries 
extends BaseEntity<Integer>
implements Cloneable, Serializable {

	/** The serial Version UID. */
	private static final long serialVersionUID = 1L;
	/** The iso3166 name with two characters. */
	private String iso3166A2name;
	/** The iso3166 name with three characters. */
	private String iso3166A3name;
	/** The iso3166 number with three characters. */
	private String iso3166Number;
	/** The name of the country. */
	private String name;

	/**
	 * Default constructor.
	 */
	public Countries() {
	}

	/**
	 * Return the value associated with the column: iso3166A2name.
	 *
	 * @return A String object (this.iso3166A2name)
	 */
	@Column(name = "iso3166_a2name", length = 2)
	public String getIso3166A2name() {
		return this.iso3166A2name;
	}

	/**
	 * Return the value associated with the column: iso3166A3name.
	 *
	 * @return A String object (this.iso3166A3name)
	 */
	@Column(name = "iso3166_a3name", length = 3)
	public String getIso3166A3name() {
		return this.iso3166A3name;
	}

	/**
	 * Return the value associated with the column: iso3166Number.
	 *
	 * @return A String object (this.iso3166Number)
	 */
	@Column(name = "iso3166_number", length = 3)
	public String getIso3166Number() {
		return this.iso3166Number;
	}

	/**
	 * Return the value associated with the column: name.
	 *
	 * @return A String object (this.name)
	 */
	@Column(length = 128)
	public String getName() {
		return this.name;
	}

	/**
	 * Set the value related to the column: iso3166A2name.
	 *
	 * @param iso3166A2name the iso3166A2name value you wish to set
	 */
	public void setIso3166A2name(final String iso3166A2name) {
		this.iso3166A2name = iso3166A2name;
	}

	/**
	 * Set the value related to the column: iso3166A3name.
	 *
	 * @param iso3166A3name the iso3166A3name value you wish to set
	 */
	public void setIso3166A3name(final String iso3166A3name) {
		this.iso3166A3name = iso3166A3name;
	}

	/**
	 * Set the value related to the column: iso3166Number.
	 *
	 * @param iso3166Number the iso3166Number value you wish to set
	 */
	public void setIso3166Number(final String iso3166Number) {
		this.iso3166Number = iso3166Number;
	}

    /**
	 * Set the value related to the column: name.
	 *
	 * @param name the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
}
