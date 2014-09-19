package user.management.sign.up;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import address.book.model.Addresses;

import user.management.enums.Gender;

/**
 * The Class UserModel holds data of the user.
 */
public class UserModel implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The birthname. */
	private String birthname;

	/** The dateofbirth. */
	private Date dateofbirth;

	/** The firstname. */
	private String firstname;

	/** The gender. */
	private Gender gender;

	/** The IP address. */
	private String ipAddress;

	/** The lastname. */
	private String lastname;

	/** The locale. */
	private Locale locale;

	/** The mobile. */
	private String mobile;

	/** The telefon. */
	private String telefon;
	
	private Addresses address;

	public Addresses getAddress() {
		return address;
	}

	public void setAddress(Addresses address) {
		this.address = address;
	}

	/**
	 * Gets the birthname.
	 *
	 * @return the birthname
	 */
	public String getBirthname() {
		return birthname;
	}

	/**
	 * Gets the dateofbirth.
	 *
	 * @return the dateofbirth
	 */
	public Date getDateofbirth() {
		return dateofbirth;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Gets the ip address.
	 *
	 * @return the ip address
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Gets the telefon.
	 *
	 * @return the telefon
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * Sets the birthname.
	 *
	 * @param birthname the new birthname
	 */
	public void setBirthname(String birthname) {
		this.birthname = birthname;
	}

	/**
	 * Sets the dateofbirth.
	 *
	 * @param dateofbirth the new dateofbirth
	 */
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Sets the ip address.
	 *
	 * @param ipAddress the new ip address
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Sets the locale.
	 *
	 * @param locale the new locale
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	
	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Sets the telefon.
	 *
	 * @param telefon the new telefon
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}
