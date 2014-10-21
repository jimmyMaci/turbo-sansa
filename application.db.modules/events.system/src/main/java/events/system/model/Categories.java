package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Entity class {@Categories} is keeping the information for
 * the categories from the events.
 */
@Entity
@Table(name = "categories")
public class Categories extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The name from the catecory. */
	private String name;

	/**
	 * Default constructor.
	 */
	public Categories() {
	}

	/**
	 * Return the value associated with the column: name
	 * 
	 * @return A String object (this.name)
	 */
	@Column(length = 40)
	public String getName() {
		return this.name;
	}

	/**
	 * Set the value related to the column: name
	 * 
	 * @param name
	 *            the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
}
