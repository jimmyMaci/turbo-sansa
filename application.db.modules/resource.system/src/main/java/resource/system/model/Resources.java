package resource.system.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Entity class {@link Resources} is keeping the information for the resources
 * from users like logos, files, images etc.
 */
@Entity
@Table(name = "resources")
public class Resources 
extends BaseEntity<Integer>
implements Cloneable, Serializable {

	/**
	 * The serial Version UID
	 */
	private static final long serialVersionUID = 4332810973781386766L;
	/** The checksum from this resource. */
	private String checksum;
	/** The binary data from this resource. */
	private Byte[] content;
	/** The content type from this resource. */
	private String contentType;
	/** The date when this resource is created in the database. */
	private Date created;
	/**
	 * A flag that indicates that the resource is deleted from the user. Will be deleted in batch process.
	 */
	private Boolean deletedFlag;
	/** A description for this resource. */
	private String description;
	/** The filename from this resource. */
	private String filename;
	/** The size from this resource. */
	private String filesize;

	/**
	 * Default constructor.
	 */
	public Resources() {
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public Resources clone() throws CloneNotSupportedException {
		super.clone();
		Resources copy = new Resources();
		copy.setDescription(this.getDescription());
		copy.setFilename(this.getFilename());
		copy.setFilesize(this.getFilesize());
		copy.setContentType(this.getContentType());
		copy.setId(this.getId());
		copy.setContent(this.getContent());
		copy.setCreated(this.getCreated());
		copy.setChecksum(this.getChecksum());
		copy.setDeletedFlag(this.isDeletedFlag());
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
	 * Return the value associated with the column: checksum.
	 * 
	 * @return A String object (this.checksum)
	 */
	@Column(name = "checksum")
	public String getChecksum() {
		return checksum;
	}

	/**
	 * Return the value associated with the column: content
	 * 
	 * @return A Byte[] object (this.content)
	 */
	@Column(name = "content", columnDefinition = "BYTEA")
	public Byte[] getContent() {
		return this.content;
	}

	/**
	 * Return the value associated with the column: filetype
	 * 
	 * @return A String object (this.filetype)
	 */
	@Column(length = 64)
	public String getContentType() {
		return this.contentType;
	}

	/**
	 * Return the value associated with the column: created.
	 * 
	 * @return A Date object (this.created)
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Return the value associated with the column: description
	 * 
	 * @return A String object (this.description)
	 */
	@Column(length = 1024)
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Return the value associated with the column: filename
	 * 
	 * @return A String object (this.filename)
	 */
	@Column(length = 1024)
	public String getFilename() {
		return this.filename;
	}

	/**
	 * Return the value associated with the column: filesize
	 * 
	 * @return A String object (this.filesize)
	 */
	@Column(length = 64)
	public String getFilesize() {
		return this.filesize;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Return the value associated with the column: deletedFlag.
	 * 
	 * @return A Boolean object (this.deletedFlag)
	 */
	@Column(name = "deleted_flag")
	public Boolean isDeletedFlag() {
		return deletedFlag;
	}

	/**
	 * Set the value related to the column: checksum
	 * 
	 * @param checksum
	 *            the checksum value you wish to set
	 */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	/**
	 * Set the value related to the column: content
	 * 
	 * @param content
	 *            the content value you wish to set
	 */
	public void setContent(final Byte[] content) {
		this.content = content;
	}

	/**
	 * Set the value related to the column: contentType
	 * 
	 * @param contentType
	 *            the content type value you wish to set
	 */
	public void setContentType(final String contentType) {
		this.contentType = contentType;
	}

	/**
	 * Set the value related to the column: created
	 * 
	 * @param saved
	 *            the saved value you wish to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Set the value related to the column: deletedFlag
	 * 
	 * @param deletedFlag
	 *            the deletedFlag value you wish to set
	 */
	public void setDeletedFlag(Boolean deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	
    /**
	 * Set the value related to the column: description
	 * 
	 * @param description
	 *            the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}
	
    /**
	 * Set the value related to the column: filename
	 * 
	 * @param filename
	 *            the filename value you wish to set
	 */
	public void setFilename(final String filename) {
		this.filename = filename;
	}

	
    /**
	 * Set the value related to the column: filesize
	 * 
	 * @param filesize
	 *            the filesize value you wish to set
	 */
	public void setFilesize(final String filesize) {
		this.filesize = filesize;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("description: " + this.description + ", ");
		sb.append("filename: " + this.filename + ", ");
		sb.append("filesize: " + this.filesize + ", ");
		sb.append("filetype: " + this.contentType + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("content: "
				+ (this.content == null ? null : Arrays.toString(this.content)));
		return sb.toString();
	}
}
