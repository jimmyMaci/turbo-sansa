package message.system.application.models.send;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.sourceforge.jaulp.xml.XmlUtils;
import net.sourceforge.jaulp.xml.api.Transformable;

import message.system.application.models.send.api.ISendInformationModel;

import user.management.model.Users;

/**
 * The Class SendInformationModel captures information about the sender and the
 * recipients of a message.
 */
public class SendInformationModel implements ISendInformationModel, Transformable<ISendInformationModel> {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The recipients of this message. */
	private Set<Users> recipients = new HashSet<Users>();

	/** The sender of this message. */
	private Users sender;

	/** The sent date of this message. */
	private Date sentDate;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Users> getRecipients() {
		return recipients;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Users getSender() {
		return sender;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date getSentDate() {
		return sentDate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRecipients(Set<Users> recipients) {
		this.recipients = recipients;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSender(Users sender) {
		this.sender = sender;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addRecipient(Users recipient) {
		if (recipients == null) {
			recipients = new HashSet<Users>();
		}
		recipients.add(recipient);
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public boolean removeRecipient(Users recipient) {
		return recipients.remove(recipient);
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String toXml() {
		String xml = XmlUtils.toXmlWithXStream(this);
		return xml;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public ISendInformationModel toObject(String xml) {
		ISendInformationModel model = XmlUtils.toObjectWithXStream(xml);
		return model;
	}

}
