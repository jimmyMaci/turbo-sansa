package user.management.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import resource.system.model.Resources;
import user.management.enums.Gender;
import address.book.model.Addresses;

/**
 * The Class UserData hold user specific data.
 */
@Entity
@Table(name = "user_data")
@TypeDefs({ @TypeDef(name = "genderConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "user.management.enums.Gender") }) })
public class UserData 
extends BaseEntity<Integer> 
implements Cloneable, Serializable {

	/**
	 * The serial Version UID.
	 */
	private static final long serialVersionUID = 1L;
	/** The addresses of the user. */
	private Set<Addresses> addresses = new HashSet<Addresses>();
	/** The birth name from the user if he or she had one. */
	private String birthname;
	/** The contacts of the user that are black listed. */
	private Set<Users> blacklistedContacts = new HashSet<Users>();
	/** The contact data of the user. */
	private Set<Contactmethods> contactmethods = new HashSet<Contactmethods>();
	/** The date of birth from the user. */
	private Date dateofbirth;
	/** The first name of the user. */
	private String firstname;
	/** The enum for the gender of the user. */
	private Gender gender;
	/** The resources of the user. */
	private Set<Resources> resources = new HashSet<Resources>();
	/** The ip address from where the user has register his self. */
	private String ipAddress;
	/** The last name of the user. */
	private String lastname;
	/** The locale from the user when she/he registered. */
	private String locale;
	/** The primary address of the user. */	
	private Addresses primaryAddress;
	/** The contacts of the user to other users. */
	private Set<Users> userContacts = new HashSet<Users>();

	/**
	 * Default constructor.
	 */
	public UserData() {
	}

	/**
     * {@inheritDoc}
     */
	public Object clone() throws CloneNotSupportedException {
		super.clone();
		UserData copy = new UserData();
		copy.setAddresses(this.addresses);
		
		copy.birthname = this.birthname == null ? null : new String(
				this.birthname);
		copy.setContactmethods(this.contactmethods);
		copy.dateofbirth = this.dateofbirth == null ? null
				: (Date) copy.dateofbirth.clone();
		copy.firstname = this.firstname == null ? null : new String(
				this.firstname);
		copy.setGender(this.gender);
		copy.setResources(this.resources);
		
		copy.ipAddress = this.ipAddress == null ? null : new String(
				this.ipAddress);
		copy.lastname = this.lastname == null ? null
				: new String(this.lastname);
		copy.locale = this.locale == null ? null : new String(this.locale);
		copy.setUserContacts(this.userContacts);
		return copy;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	/**
	 * Gets the addresses.
	 * 
	 * @return the addresses
	 */
	@ManyToMany(fetch=FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinTable(name = "user_addresses", joinColumns = { 
			@JoinColumn(name = "user_data_id", referencedColumnName = "id") }, inverseJoinColumns = { 
			@JoinColumn(name = "addresses_id", referencedColumnName = "id") })
	public Set<Addresses> getAddresses() {
		return addresses;
	}

	/**
	 * Return the value associated with the column: birthname.
	 * 
	 * @return A String object (this.birthname)
	 */
	@Column(length = 64)
	public String getBirthname() {
		return this.birthname;
	}

	/**
	 * Gets the blacklisted contacts.
	 *
	 * @return the blacklisted contacts
	 */
	@ManyToMany(fetch=FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinTable(name = "blacklisted_contacts", 
	joinColumns = { @JoinColumn(name = "user_data_id", referencedColumnName = "id") }, 
	inverseJoinColumns = { @JoinColumn(name = "blacklisted_id", referencedColumnName = "id") })	
	public Set<Users> getBlacklistedContacts() {
		return blacklistedContacts;
	}

	/**
	 * Gets the contactmethods.
	 * 
	 * @return the contactmethods
	 */
	@ManyToMany(fetch=FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinTable(name = "user_contactmethods", joinColumns = { 
			@JoinColumn(name = "user_data_id", referencedColumnName = "id") }, inverseJoinColumns = { 
			@JoinColumn(name = "contactmethods_id", referencedColumnName = "id") })
	public Set<Contactmethods> getContactmethods() {
		return contactmethods;
	}

	/**
	 * Return the value associated with the column: dateofbirth.
	 * 
	 * @return A Date object (this.dateofbirth)
	 */
	public Date getDateofbirth() {
		return this.dateofbirth;
	}

	/**
	 * Return the value associated with the column: firstname.
	 * 
	 * @return A String object (this.firstname)
	 */
	@Column(length = 64)
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * Return the value associated with the column: gender.
	 * 
	 * @return A UsersGenderEnum object (this.gender)
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	@Type(type = "genderConverter")
	public Gender getGender() {
		return this.gender;
	}

	/**
	 * Gets the resources.
	 * 
	 * @return the resources
	 */
	@ManyToMany(fetch=FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	@JoinTable(name = "user_resources", joinColumns = { 
			@JoinColumn(name = "user_data_id", referencedColumnName = "id") }, inverseJoinColumns = { 
			@JoinColumn(name = "resources_id", referencedColumnName = "id") })
	public Set<Resources> getResources() {
		return resources;
	}

	/**
	 * Return the value associated with the column: ipAddress.
	 * 
	 * @return A String object (this.ipAddress)
	 */
	@Column(name = "ip_address", length = 16)
	public String getIpAddress() {
		return this.ipAddress;
	}

	/**
	 * Return the value associated with the column: lastname.
	 * 
	 * @return A String object (this.lastname)
	 */
	@Column(length = 64)
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * Return the value associated with the column: locale.
	 * 
	 * @return A String object (this.locale)
	 */
	@Column(length = 12)
	public String getLocale() {
		return this.locale;
	}

	/**
	 * Gets the primary address of this user.
	 * 
	 * @return the addresses
	 */
	@ManyToOne
    @Cascade({CascadeType.ALL})
	@JoinColumn(name = "primary_address_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PRIMARY_ADDRESS_ID")
	@ForeignKey(name = "FK_USER_DATA_PRIMARY_ADDRESS_ID")
	public Addresses getPrimaryAddress() {
		return primaryAddress;
	}

	/**
	 * Gets the user contacts.
	 * 
	 * @return the user contacts
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_contacts", joinColumns = { 
			@JoinColumn(name = "user_data_id", referencedColumnName = "id") }, inverseJoinColumns = { 
			@JoinColumn(name = "user_contact_id", referencedColumnName = "id") })
	public Set<Users> getUserContacts() {
		return userContacts;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Sets the addresses.
	 * 
	 * @param addresses
	 *            the new addresses
	 */
	public void setAddresses(Set<Addresses> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Set the value related to the column: birthname.
	 * 
	 * @param birthname
	 *            the birthname value you wish to set
	 */
	public void setBirthname(final String birthname) {
		this.birthname = birthname;
	}

	/**
	 * Sets the blacklisted contacts.
	 *
	 * @param blacklistedContacts the new blacklisted contacts
	 */
	public void setBlacklistedContacts(Set<Users> blacklistedContacts) {
		this.blacklistedContacts = blacklistedContacts;
	}

	/**
	 * Sets the contactmethods.
	 * 
	 * @param contactmethods
	 *            the new contactmethods
	 */
	public void setContactmethods(Set<Contactmethods> contactmethods) {
		this.contactmethods = contactmethods;
	}

	/**
	 * Set the value related to the column: dateofbirth.
	 * 
	 * @param dateofbirth
	 *            the dateofbirth value you wish to set
	 */
	public void setDateofbirth(final Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	/**
	 * Set the value related to the column: firstname.
	 * 
	 * @param firstname
	 *            the firstname value you wish to set
	 */
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Set the value related to the column: gender.
	 * 
	 * @param gender
	 *            the gender value you wish to set
	 */
	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	/**
	 * Sets the resources.
	 * 
	 * @param resources
	 *            the new resources
	 */
	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}

	/**
	 * Set the value related to the column: ipAddress.
	 * 
	 * @param ipAddress
	 *            the ipAddress value you wish to set
	 */
	public void setIpAddress(final String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Set the value related to the column: lastname.
	 * 
	 * @param lastname
	 *            the lastname value you wish to set
	 */
	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}
	
    /**
	 * Set the value related to the column: locale.
	 * 
	 * @param locale
	 *            the locale value you wish to set
	 */
	public void setLocale(final String locale) {
		this.locale = locale;
	}

    /**
	 * Sets the primary address.
	 *
	 * @param primaryAddress the new primary address
	 */
	public void setPrimaryAddress(Addresses primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	
    /**
	 * Sets the user contacts.
	 * 
	 * @param userContacts
	 *            the new user contacts
	 */
	public void setUserContacts(Set<Users> userContacts) {
		this.userContacts = userContacts;
	}
	
    /**
     * {@inheritDoc}
     */
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[UserData:");
		buffer.append("id: ");
		buffer.append(getId());
		buffer.append(" addresses: ");
		buffer.append(addresses);
		buffer.append(" birthname: ");
		buffer.append(birthname);
		buffer.append(" contactmethods: ");
		buffer.append(contactmethods);
		buffer.append(" dateofbirth: ");
		buffer.append(dateofbirth);
		buffer.append(" firstname: ");
		buffer.append(firstname);
		buffer.append(" gender: ");
		buffer.append(gender);
		buffer.append(" resources: ");
		buffer.append(resources);
		buffer.append(" ipAddress: ");
		buffer.append(ipAddress);
		buffer.append(" lastname: ");
		buffer.append(lastname);
		buffer.append(" locale: ");
		buffer.append(locale);
		buffer.append(" userContacts: ");
		buffer.append(userContacts);
		buffer.append("]");
		return buffer.toString();
	}
}
