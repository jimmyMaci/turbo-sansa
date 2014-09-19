package user.management.model;

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
 * The Entity class {@link Recommendations} is keeping the
 * information for the recommendations that a user recommended another user to an email with an invitation text.
 */
@Entity
@Table(name = "recommendations")
public class Recommendations
extends BaseEntity<Integer>
implements Cloneable, Serializable { 

	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/** The user that made the recommendation. */
    private Users user;
	/** The user that is recommended. */
    private Users recommended; 
	/** The email where this recommendation is send. */
	private String email;
	/** The text from the invitation from the user. This is optional. */
    private String invitationText;
	/** The sent flag, if true the recommendation is successfully sent with the message system. */
	private Boolean sent;

	/**
	 * Default constructor.
	 */
	public Recommendations() {
	}    

	/**
	 * Return the value associated with the column: user.
	 *
	 * @return A Users object (this.user)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_RECOMMENDATIONS_USER_ID")
	@ForeignKey(name = "FK_RECOMMENDATIONS_USER_ID")
	public Users getUser() {
		return this.user;
	}

	/**
	 * Set the value related to the column: user.
	 *
	 * @param user the user value you wish to set
	 */
	public void setUser(final Users user) {
		this.user = user;
	}
	
	/**
	 * Return the value associated with the column: recommended.
	 *
	 * @return A Users object (this.recommended)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recommended_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_RECOMMENDATIONS_RECOMMENDED_ID")
	@ForeignKey(name = "FK_RECOMMENDATIONS_RECOMMENDED_ID")
	public Users getRecommended() {
		return this.recommended;
	}

	/**
	 * Set the value related to the column: recommended.
	 *
	 * @param recommended the recommended value you wish to set
	 */
	public void setRecommended(final Users recommended) {
		this.recommended = recommended;
	}

	/**
	 * Return the value associated with the column: email.
	 * 
	 * @return A String object (this.email)
	 */
	@Column( name="email", length = 1024  )
	public String getEmail() {
		return email;
	}

	/**
	 * Set the value related to the column: email.
	 * 
	 * @param email
	 *            the email value you wish to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Return the value associated with the column: invitationText.
	 * 
	 * @return A String object (this.invitationText)
	 */
	@Column( name="invitation_text", length = 1024  )
	public String getInvitationText() {
		return invitationText;
	}

	/**
	 * Set the value related to the column: invitationText.
	 * 
	 * @param invitationText
	 *            the invitationText value you wish to set
	 */
	public void setInvitationText(String invitationText) {
		this.invitationText = invitationText;
	}

	/**
	 * Return the value associated with the column: sent
	 * 
	 * @return A Boolean object (this.sent)
	 */
	@Column(name = "sent")
	public Boolean isSent() {
		return sent;
	}

	/**
	 * Set the value related to the column: sent.
	 * 
	 * @param sent
	 *            the sent value you wish to set
	 */
	public void setSent(Boolean sent) {
		this.sent = sent;
	}
}