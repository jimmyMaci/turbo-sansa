package user.management.model;

import java.io.Serializable;

import hbm.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.sourceforge.jaulp.lang.ObjectUtils;

/**
 * The Entity class {@link Attributes} is keeping the information for
 * attributes that can be added to another Entity class.
 */
@Entity
@Table(name = "attributes")
public class Attributes
extends BaseEntity<Integer>
implements Cloneable, Serializable { 
	
	/**  The serial Version UID. */
	private static final long serialVersionUID = 1L;

	/** The name. */
	private String name;
	
	/** The type. */
	private String type; 
	
	/** The value. */
	private String value;
    
    /**
     * Instantiates a new attributes.
     */
    public Attributes() {
	}
    
    /**
     * {@inheritDoc}
     */
	@Override
	public Attributes clone() throws CloneNotSupportedException {
		return ObjectUtils.clone(this);
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column(length = 64)
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Column(length = 256)
	public String getType() {
		return type;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Column(length = 2048)
	public String getValue() {
		return value;
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(String value) {
		this.value = value;
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[Attributes:");
		buffer.append("id: ");
		buffer.append(getId());
		buffer.append(" name: ");
		buffer.append(name);
		buffer.append(" type: ");
		buffer.append(type);
		buffer.append(" value: ");
		buffer.append(value);
		buffer.append("]");
		return buffer.toString();
	}
 
}