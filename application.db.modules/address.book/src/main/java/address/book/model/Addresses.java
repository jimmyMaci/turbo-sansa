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
 * The Entity class {@link Addresses} is keeping the information for
 * addresses.
 */
@Entity
@Table(name = "addresses")
public class Addresses 
extends BaseEntity<Integer>
implements Cloneable {

	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The address comment. */
	private String addressComment;
	/**
	 * The federalstate attribute is the federal state from this {@link Addresses
	 * } object.
	 */
	private Federalstates federalstate;
	/** The geohash from this {@link Addresses} object. */
	private String geohash;
	/**
	 * The latitude from the address. Latitude is a geographical term denoting
	 * the north/south angular location of a place on a sphere.
	 */
	private String latitude;
	/** The longitude from the address. */
	private String longitude;
	/** The name of the street. */
	private String street;
	/** The streetnumber. */
	private String streetnumber;
	/** The zipcode from this {@link Addresses} object. */
	private Zipcodes zipcode;

	/**
	 * Default constructor.
	 */
	public Addresses() {
	}

	/**
	 * Return the value associated with the column: addressComment
	 * 
	 * @return A String object (this.addressComment)
	 */
	@Column(name = "address_comment", length = 100)
	public String getAddressComment() {
		return this.addressComment;
	}

	/**
	 * Return the value associated with the column: federalstate
	 * 
	 * @return A Federalstates object (this.federalstate)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "federalstate_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_FEDERALSTATE_ID")
	@ForeignKey(name = "FK_ADDRESSES_FEDERALSTATE_ID")
	public Federalstates getFederalstate() {
		return this.federalstate;
	}

	/**
	 * Return the value associated with the column: geohash
	 * 
	 * @return A String object (this.geohash)
	 */
	@Column(length = 16)
	public String getGeohash() {
		return this.geohash;
	}

	/**
	 * Return the value associated with the column: latitude
	 * 
	 * @return A String object (this.latitude)
	 */
	@Column(length = 12)
	public String getLatitude() {
		return this.latitude;
	}

	/**
	 * Return the value associated with the column: longitude
	 * 
	 * @return A String object (this.longitude)
	 */
	@Column(length = 12)
	public String getLongitude() {
		return this.longitude;
	}

	/**
	 * Return the value associated with the column: street
	 * 
	 * @return A String object (this.street)
	 */
	@Column(length = 64)
	public String getStreet() {
		return this.street;
	}

	/**
	 * Return the value associated with the column: streetnumber
	 * 
	 * @return A String object (this.streetnumber)
	 */
	@Column(length = 5)
	public String getStreetnumber() {
		return this.streetnumber;
	}

	/**
	 * Return the value associated with the column: zipcode
	 * 
	 * @return A Zipcodes object (this.zipcode)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "zipcode_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_ZIPCODE_ID")
	@ForeignKey(name = "FK_ADDRESSES_ZIPCODE_ID")
	public Zipcodes getZipcode() {
		return this.zipcode;
	}

	/**
	 * Set the value related to the column: addressComment
	 * 
	 * @param addressComment
	 *            the addressComment value you wish to set
	 */
	public void setAddressComment(final String addressComment) {
		this.addressComment = addressComment;
	}

	/**
	 * Set the value related to the column: federalstate
	 * 
	 * @param federalstate
	 *            the federalstate value you wish to set
	 */
	public void setFederalstate(final Federalstates federalstate) {
		this.federalstate = federalstate;
	}

	/**
	 * Set the value related to the column: geohash
	 * 
	 * @param geohash
	 *            the geohash value you wish to set
	 */
	public void setGeohash(final String geohash) {
		this.geohash = geohash;
	}

	/**
	 * Set the value related to the column: latitude
	 * 
	 * @param latitude
	 *            the latitude value you wish to set
	 */
	public void setLatitude(final String latitude) {
		this.latitude = latitude;
	}

	/**
	 * Set the value related to the column: longitude
	 * 
	 * @param longitude
	 *            the longitude value you wish to set
	 */
	public void setLongitude(final String longitude) {
		this.longitude = longitude;
	}

	/**
	 * Set the value related to the column: street
	 * 
	 * @param street
	 *            the street value you wish to set
	 */
	public void setStreet(final String street) {
		this.street = street;
	}

	/**
	 * Set the value related to the column: streetnumber
	 * 
	 * @param streetnumber
	 *            the streetnumber value you wish to set
	 */
	public void setStreetnumber(final String streetnumber) {
		this.streetnumber = streetnumber;
	}

    /**
	 * Set the value related to the column: zipcode
	 * 
	 * @param zipcode
	 *            the zipcode value you wish to set
	 */
	public void setZipcode(final Zipcodes zipcode) {
		this.zipcode = zipcode;
	}
	
}
