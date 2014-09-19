package message.system.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import user.management.model.Contactmethods;
import user.management.model.Users;

/**
 * The Entity class {@MessageRecipients } is keeping the
 * information which recipients received the message.
 */
@Entity
@Table(name = "message_recipients")
public class MessageRecipients 
extends BaseEntity<Integer> 
implements Cloneable, Serializable {

	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/**
	 * The message attribute that references to the Entity class {@Messages
	 * 
	 * }.
	 */
	private Messages message;
	/**
	 * The recipient attribute that references to the Entity class {@Users
	 * 
	 * }.
	 */
	private Users recipient;
	/**
	 * The recipient email as a String object that can be indicate that the
	 * recipient is a user outside from the system. For instance a user from the
	 * system makes a recommendation to a friend.
	 */
	private Contactmethods recipientEmail;

	/**
	 * Default constructor.
	 */
	public MessageRecipients() {
	}

	/**
	 * Return the value associated with the column: message
	 * 
	 * @return A Messages object (this.message)
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "message_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_MESSAGE_RECIPIENTS_ID")
	@ForeignKey(name = "FK_MESSAGE_RECIPIENTS_MESSAGE_ID")
	public Messages getMessage() {
		return this.message;
	}

	/**
	 * Set the value related to the column: message
	 * 
	 * @param message
	 *            the message value you wish to set
	 */
	public void setMessage(final Messages message) {
		this.message = message;
	}

	/**
	 * Return the value associated with the column: recipient
	 * 
	 * @return A Users object (this.recipient)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipient_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_RECIPIENT_ID")
	@ForeignKey(name = "FK_MESSAGE_RECIPIENTS_RECIPIENT_ID")
	public Users getRecipient() {
		return this.recipient;
	}

	/**
	 * Set the value related to the column: recipient
	 * 
	 * @param recipient
	 *            the recipient value you wish to set
	 */
	public void setRecipient(final Users recipient) {
		this.recipient = recipient;
	}

	/**
	 * Return the value associated with the column: recipientEmail
	 * 
	 * @return A Contactmethods object (this.recipientEmail)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipient_email", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_RECIPIENT_EMAIL")
	@ForeignKey(name = "FK_MESSAGE_RECIPIENTS_RECIPIENT_EMAIL")
	public Contactmethods getRecipientEmail() {
		return recipientEmail;
	}

	/**
	 * Set the value related to the column: recipientEmail
	 * 
	 * @param recipientEmail
	 *            the recipient email value you wish to set
	 */
	public void setRecipientEmail(Contactmethods recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MessageRecipients clone() throws CloneNotSupportedException {
		super.clone();
		MessageRecipients copy = new MessageRecipients();

		copy.setId(this.getId());
		copy.setMessage(this.getMessage());
		copy.setRecipient(this.getRecipient());
		copy.setRecipientEmail(this.getRecipientEmail());
		return copy;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[MessageRecipients:");
		buffer.append("id: ");
		buffer.append(getId());
		buffer.append(" message: ");
		buffer.append(message);
		buffer.append(" recipient: ");
		buffer.append(recipient);
		buffer.append(" recipientEmail: ");
		buffer.append(recipientEmail);
		buffer.append("]");
		return buffer.toString();
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
