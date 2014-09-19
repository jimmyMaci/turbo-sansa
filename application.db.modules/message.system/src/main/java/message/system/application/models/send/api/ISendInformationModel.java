package message.system.application.models.send.api;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import user.management.model.Users;

/**
 * The interface ISendInformationModel provides information about the sender and the
 * recipients of a message.
 */
public interface ISendInformationModel extends Serializable {


	/**
	 * Gets the recipients.
	 *
	 * @return the recipients
	 */
	Set<Users> getRecipients();

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	Users getSender();

	/**
	 * Gets the sent date.
	 *
	 * @return the sent date
	 */
	Date getSentDate();

	/**
	 * Sets the recipients.
	 *
	 * @param recipients the new recipients
	 */
	void setRecipients(Set<Users> recipients);

	/**
	 * Sets the sender.
	 *
	 * @param sender the new sender
	 */
	void setSender(Users sender);

	/**
	 * Sets the sent date.
	 *
	 * @param sentDate the new sent date
	 */
	void setSentDate(Date sentDate);
	
	/**
	 * Adds a recipient to the recipients.
	 *
	 * @param recipient the recipient to add.
	 */
	void addRecipient(Users recipient);
	
	/**
	 * Removes a recipient from the recipients.
	 *
	 * @param recipient the recipient to remove.
	 */
	boolean removeRecipient(Users recipient);

}