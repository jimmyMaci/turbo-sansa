package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import user.management.model.Contactmethods;
import user.management.model.Users;

/**
 * The Entity class {@UserContactsAllowedContactmethods
 * 
 * 
 * } is holding the information for the
 * allowed contactmethods that the user can see from his contact person.
 */
@Entity
@Table(name = "user_contacts_allowed_contactmethods")
public class UserContactsAllowedContactmethods extends BaseEntity<Integer>
		implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The userContact attribute that references to the Entity class
	 * {@UserContacts} and is the contact from the user.
	 */
	private Users userContact;
	/**
	 * The userContactmethod attribute that references to the Entity class
	 * {@UserContactmethods} and is the allowed contact
	 * method from the user.
	 */
	private Contactmethods userContactmethod;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public UserContactsAllowedContactmethods() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: userContact
	 * 
	 * @return A UserContacts object (this.userContact)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_contact_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_USER_CONTACT_ID")
	@ForeignKey(name = "FK_ALLOWED_CONTACTMETHODS_USER_CONTACT_ID")
	public Users getUserContact() {
		return this.userContact;
	}

	/**
	 * Set the value related to the column: userContact
	 * 
	 * @param userContact
	 *            the userContact value you wish to set
	 */
	public void setUserContact(final Users userContact) {
		this.userContact = userContact;
	}

	/**
	 * Return the value associated with the column: userContactmethod
	 * 
	 * @return A UserContactmethods object (this.userContactmethod)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_contactmethod_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_USER_CONTACTMETHOD_ID")
	@ForeignKey(name = "FK_ALLOWED_CONTACTMETHODS_USER_CONTACTMETHOD_ID")
	public Contactmethods getUserContactmethod() {
		return this.userContactmethod;
	}

	/**
	 * Set the value related to the column: userContactmethod
	 * 
	 * @param userContactmethod
	 *            the userContactmethod value you wish to set
	 */
	public void setUserContactmethod(final Contactmethods userContactmethod) {
		this.userContactmethod = userContactmethod;
	}

}
