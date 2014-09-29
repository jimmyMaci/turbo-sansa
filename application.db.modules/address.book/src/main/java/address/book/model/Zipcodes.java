package address.book.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

/**
 * The Entity class {@link Zipcodes} is keeping the information for the
 * cities and the corresponding zipcodes.
 */
@Entity
@Table(name = "zipcodes")
public class Zipcodes 
extends BaseEntity<Integer>
implements Cloneable, Serializable {

	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	private Countries country;
	/** The name from the city. */
	private String zipcode;
	/** The name from the city. */
	private String city;
	/** The zipcode from the city. */

	/**
	 * Default constructor.
	 */
	public Zipcodes() {
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public Zipcodes clone() throws CloneNotSupportedException {
		super.clone(); 
		Zipcodes copy = new Zipcodes();

		copy.setCity(this.getCity());
		copy.setId(this.getId());
		copy.setZipcode(this.getZipcode());
		return copy;
	}

	/**
	 * Return the value associated with the column: city
	 * 
	 * @return A String object (this.city)
	 */
	@Column(length = 128)
	public String getCity() {
		return this.city;
	}

	/**
	 * Return the value associated with the column: zipcode
	 * 
	 * @return A String object (this.zipcode)
	 */
	@Column(nullable = false, length = 10)
	public String getZipcode() {
		return this.zipcode;
	}

	/**
	 * Return the value associated with the column: country
	 * 
	 * @return A Countries object (this.country)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_ZIP_CODES_COUNTRY_ID")
	@ForeignKey(name = "FK_ZIP_CODES_COUNTRY_ID")
	public Countries getCountry() {
		return this.country;
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
	 * Set the value related to the column: city
	 * 
	 * @param city
	 *            the city value you wish to set
	 */
	public void setCity(final String city) {
		this.city = city;
	}

    /**
	 * Set the value related to the column: zipcode
	 * 
	 * @param zipcode
	 *            the zipcode value you wish to set
	 */
	public void setZipcode(final String zipcode) {
		this.zipcode = zipcode;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("city: " + this.city + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("zipcode: " + this.zipcode);
		return sb.toString();
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
