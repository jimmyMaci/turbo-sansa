package message.system.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import message.system.enums.MessageState;
import message.system.enums.MessageType;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import resource.system.model.Resources;
import user.management.model.Contactmethods;
import user.management.model.Users;

/**
 * The Entity class {@Messages } is keeping the information for the
 * messages or notes from users.
 */
@Entity
@Table(name = "messages")
@TypeDefs({
		@TypeDef(name = "messagetypeConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "message.system.enums.MessageType") }),
		@TypeDef(name = "stateConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "message.system.enums.MessageState") }) })
public class Messages 
extends BaseEntity<Integer>
implements Cloneable, Serializable {

	/** The serial Version UID */
	private static final long serialVersionUID = 920286633675636537L;
	/**
	 * The parent of this message can be null if its the root message.
	 **/
	private Messages parent;
	/**
	 * A flag that indicates that the message is deleted from the sender but will not really deleted
	 * because of references to other messages.
	 */
	private Boolean senderDeletedFlag;
	/**
	 *  A flag that indicates that the message is deleted from the recipient but will not really deleted
	 * because of references to other messages.
	 */
	private Boolean recipientDeletedFlag;
	/** A flag that indicates that the message could not be sent. */
	private Boolean failed2sentemail;
	/** The folder of the message. */
	private String folder;
	/** The content of the message. */
	private String messageContent;
	/** An enum for the message type. */
	private MessageType messagetype;
	/**
	 * A flag that indicates if the message is readed(at least opened) from the
	 * recipient(s).
	 */
	private Boolean readFlag;
	/** The sender of the message. */
	private Users sender;
	/** The email address from the sender of this message. */
	private Contactmethods senderEmail;
	/** The sent date of the message. */
	private Date sentDate;
	/** A flag that indicates if the message is a spam message. */
	private Boolean spamFlag;
	/** An enum for the state from the message. */
	private MessageState state;
	/** The subject of the message. */
	private String subject;
	/** The attachments of the message. */
	private Set<Resources> attachments = new HashSet<Resources>();

	/**
	 * Gets the attachments.
	 * 
	 * @return the attachments
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "message_attachments", joinColumns = { @JoinColumn(name = "message_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "resource_id", referencedColumnName = "id") })
	public Set<Resources> getAttachments() {
		return attachments;
	}

	/**
	 * Sets the attachments.
	 * 
	 * @param attachments
	 *            the new attachments
	 */
	public void setAttachments(Set<Resources> attachments) {
		this.attachments = attachments;
	}

	/**
	 * Default constructor.
	 */
	public Messages() {
	}

	/**
	 * Return the value associated with the column: deletedFlag
	 * 
	 * @return A Boolean object (this.deletedFlag)
	 */
	@Column(name = "sender_deleted_flag")
	public Boolean isSenderDeletedFlag() {
		return this.senderDeletedFlag;
	}

	/**
	 * Return the value associated with the column: recipientDeletedFlag
	 * 
	 * @return A Boolean object (this.recipientDeletedFlag)
	 */
	@Column(name = "recipient_deleted_flag")
	public Boolean isRecipientDeletedFlag() {
		return this.recipientDeletedFlag;
	}

	/**
	 * Set the value related to the column: deletedFlag
	 * 
	 * @param deletedFlag
	 *            the deletedFlag value you wish to set
	 */
	public void setSenderDeletedFlag(final Boolean deletedFlag) {
		this.senderDeletedFlag = deletedFlag;
	}

	/**
	 * Set the value related to the column: recipientDeletedFlag
	 * 
	 * @param recipientDeletedFlag
	 *            the recipientDeletedFlag value you wish to set
	 */
	public void setRecipientDeletedFlag(final Boolean recipientDeletedFlag) {
		this.recipientDeletedFlag = recipientDeletedFlag;
	}

	/**
	 * Return the value associated with the column: failed2sentemail
	 * 
	 * @return A Boolean object (this.failed2sentemail)
	 */

	public Boolean isFailed2sentemail() {
		return this.failed2sentemail;
	}

	/**
	 * Set the value related to the column: failed2sentemail
	 * 
	 * @param failed2sentemail
	 *            the failed2sentemail value you wish to set
	 */
	public void setFailed2sentemail(final Boolean failed2sentemail) {
		this.failed2sentemail = failed2sentemail;
	}

	/**
	 * Return the value associated with the column: folder
	 * 
	 * @return A String object (this.folder)
	 */
	@Column(length = 64)
	public String getFolder() {
		return this.folder;
	}

	/**
	 * Set the value related to the column: folder
	 * 
	 * @param folder
	 *            the folder value you wish to set
	 */
	public void setFolder(final String folder) {
		this.folder = folder;
	}

	/**
	 * Return the value associated with the column: messageContent
	 * 
	 * @return A String object (this.messageContent)
	 */
	@Column(length = 21845)
	public String getMessageContent() {
		return this.messageContent;
	}

	/**
	 * Set the value related to the column: messageContent
	 * 
	 * @param messageContent
	 *            the messageContent value you wish to set
	 */
	public void setMessageContent(final String messageContent) {
		this.messageContent = messageContent;
	}

	/**
	 * Return the value associated with the column: messagetype
	 * 
	 * @return A MessageType object (this.messagetype)
	 */

	@Enumerated(EnumType.STRING)
	@Column(name = "messagetype")
	@Type(type = "messagetypeConverter")
	public MessageType getMessagetype() {
		return this.messagetype;
	}

	/**
	 * Set the value related to the column: messagetype
	 * 
	 * @param messagetype
	 *            the messagetype value you wish to set
	 */
	public void setMessagetype(final MessageType messagetype) {
		this.messagetype = messagetype;
	}

	/**
	 * Return the value associated with the column: readFlag
	 * 
	 * @return A Boolean object (this.readFlag)
	 */
	@Column(name = "read_flag")
	public Boolean isReadFlag() {
		return this.readFlag;
	}

	/**
	 * Set the value related to the column: readFlag
	 * 
	 * @param readFlag
	 *            the readFlag value you wish to set
	 */
	public void setReadFlag(final Boolean readFlag) {
		this.readFlag = readFlag;
	}

	/**
	 * Return the value associated with the column: sender
	 * 
	 * @return A Users object (this.sender)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sender", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_SENDER")
	@ForeignKey(name = "FK_MESSAGES_SENDER")
	public Users getSender() {
		return this.sender;
	}

	/**
	 * Return the value associated with the column: senderEmail
	 * 
	 * @return A Contactmethods object (this.senderEmail)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sender_email", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_SENDER_EMAIL")
	@ForeignKey(name = "FK_MESSAGES_SENDER_EMAIL")
	public Contactmethods getSenderEmail() {
		return senderEmail;
	}

	/**
	 * Set the value related to the column: senderEmail
	 * 
	 * @param senderEmail
	 *            the senderEmail value you wish to set
	 */
	public void setSenderEmail(Contactmethods senderEmail) {
		this.senderEmail = senderEmail;
	}

	/**
	 * Set the value related to the column: sender
	 * 
	 * @param sender
	 *            the sender value you wish to set
	 */
	public void setSender(final Users sender) {
		this.sender = sender;
	}

	/**
	 * Return the value associated with the column: sentDate
	 * 
	 * @return A Date object (this.sentDate)
	 */
	@Column(name = "sent_date")
	public Date getSentDate() {
		return this.sentDate;
	}

	/**
	 * Set the value related to the column: sentDate
	 * 
	 * @param sentDate
	 *            the sentDate value you wish to set
	 */
	public void setSentDate(final Date sentDate) {
		this.sentDate = sentDate;
	}

	/**
	 * Return the value associated with the column: spamFlag
	 * 
	 * @return A Boolean object (this.spamFlag)
	 */
	@Column(name = "spam_flag")
	public Boolean isSpamFlag() {
		return this.spamFlag;
	}

	/**
	 * Set the value related to the column: spamFlag
	 * 
	 * @param spamFlag
	 *            the spamFlag value you wish to set
	 */
	public void setSpamFlag(final Boolean spamFlag) {
		this.spamFlag = spamFlag;
	}

	/**
	 * Return the value associated with the column: state
	 * 
	 * @return A MessageState object (this.state)
	 */

	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	@Type(type = "stateConverter")
	public MessageState getState() {
		return this.state;
	}

	/**
	 * Set the value related to the column: state
	 * 
	 * @param state
	 *            the state value you wish to set
	 */
	public void setState(final MessageState state) {
		this.state = state;
	}

	/**
	 * Return the value associated with the column: subject
	 * 
	 * @return A String object (this.subject)
	 */
	@Column(length = 1000)
	public String getSubject() {
		return this.subject;
	}

	/**
	 * Set the value related to the column: subject
	 * 
	 * @param subject
	 *            the subject value you wish to set
	 */
	public void setSubject(final String subject) {
		this.subject = subject;
	}

	/**
	 * Return the value associated with the column:  parent
	 * 
	 * @return A Messages object (this.parent)
	 */
	@OneToOne
	@JoinColumn(name="parent")
	@Index(name = "IDX_PARENT_MESSAGE_ID")
	@ForeignKey(name = "FK_PARENT_MESSAGE_ID")
	public Messages getParent() {
		return parent;
	}

	/**
	 * Set the value related to the column: parent
	 * 
	 * @param parent
	 *            the parent value you wish to set
	 */
	public void setParent(Messages parent) {
		this.parent = parent;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public Messages clone() throws CloneNotSupportedException {
		super.clone(); 
		Messages copy = new Messages();
		copy.setSenderDeletedFlag(this.isSenderDeletedFlag());
		copy.setRecipientDeletedFlag(this.recipientDeletedFlag);
		copy.setParent(this.parent);
		copy.setFailed2sentemail(this.isFailed2sentemail());
		copy.setFolder(this.getFolder());
		copy.setId(this.getId());
		copy.setMessageContent(this.getMessageContent());
		copy.setMessagetype(this.getMessagetype());
		copy.setReadFlag(this.isReadFlag());
		copy.setSender(this.getSender());
		copy.setSentDate(this.getSentDate());
		copy.setSpamFlag(this.isSpamFlag());
		copy.setState(this.getState());
		copy.setSubject(this.getSubject());
		return copy;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("senderDeletedFlag: " + this.senderDeletedFlag + ", ");
		sb.append("recipientDeletedFlag: " + this.recipientDeletedFlag + ", ");
		sb.append("failed2sentemail: " + this.failed2sentemail + ", ");
		sb.append("parent: " + this.parent + ", ");
		sb.append("folder: " + this.folder + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("messageContent: " + this.messageContent + ", ");
		sb.append("messagetype: " + this.messagetype + ", ");
		sb.append("readFlag: " + this.readFlag + ", ");
		sb.append("sentDate: " + this.sentDate + ", ");
		sb.append("sender: " + this.sender + ", ");
		sb.append("spamFlag: " + this.spamFlag + ", ");
		sb.append("state: " + this.state + ", ");
		sb.append("subject: " + this.subject);
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
