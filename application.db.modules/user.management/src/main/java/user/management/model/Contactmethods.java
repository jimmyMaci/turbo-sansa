package user.management.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import user.management.enums.Contactmethod;

/**
 * The Entity class {@link Contactmethods} is keeping the
 * information for the contact methods and the corresponding value.
 */
@Entity
@Table(name = "contactmethods")
@TypeDef(name = "contactmethodConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "user.management.enums.Contactmethod") })
public class Contactmethods 
extends BaseEntity<Integer>
implements Cloneable, Serializable {

	/** The serial Version UID */
	private static final long serialVersionUID = -3939311384481132485L;
	/** The contact method like email, telefon etc. */
	private Contactmethod contactmethod;
	/**
	 * The value from the contact method. For instance 'abc@gmail.com' for email
	 * or 'http://www.google.com' for internet.
	 */
	private String contactvalue;

	/**
	 * Default constructor
	 */
	public Contactmethods() {
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public Contactmethods clone() throws CloneNotSupportedException {
		super.clone();
		Contactmethods copy = new Contactmethods();
		copy.setContactmethod(this.getContactmethod());
		copy.setContactvalue(this.getContactvalue());
		copy.setId(this.getId());
		return copy;
	}

	/**
	 * Return the value associated with the column: contactmethod
	 * 
	 * @return A ContactmethodsContactmethodEnum object (this.contactmethod)
	 */

	@Enumerated(EnumType.STRING)
	@Column(name = "contactmethod")
	@Type(type = "contactmethodConverter")
	public Contactmethod getContactmethod() {
		return this.contactmethod;
	}

	/**
	 * Return the value associated with the column: contactvalue
	 * 
	 * @return A String object (this.contactvalue)
	 */
	@Column(length = 1024)
	public String getContactvalue() {
		return this.contactvalue;
	}

	/**
	 * Set the value related to the column: contactmethod
	 * 
	 * @param contactmethod
	 *            the contactmethod value you wish to set
	 */
	public void setContactmethod(final Contactmethod contactmethod) {
		this.contactmethod = contactmethod;
	}

    /**
	 * Set the value related to the column: contactvalue
	 * 
	 * @param contactvalue
	 *            the contactvalue value you wish to set
	 */
	public void setContactvalue(final String contactvalue) {
		this.contactvalue = contactvalue;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("contactmethod: " + this.contactmethod + ", ");
		sb.append("contactvalue: " + this.contactvalue + ", ");
		sb.append("id: " + this.getId());
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
