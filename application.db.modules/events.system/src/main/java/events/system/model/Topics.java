package events.system.model;

import hbm.entity.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

/**
 * The Entity class {@Topics} is keeping the information for all the
 * topics that events can have. The table 'topics' has a tree structure so every
 * topic has a parent. The root topic has no parent.
 */
@Entity
@Table(name = "topics")
public class Topics extends BaseEntity<Integer> implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The name from the topic. */
	private String name;
	/** A flag that indicates if this topic is a node. */
	private Boolean node;
	/** The parent Topics object that references to the parent topic. */
	private Topics parent;

	/**
	 * Default constructor, mainly for hibernate use
	 */
	public Topics() {
		// Default constructor
	}

	/**
	 * Return the value associated with the column: name
	 * 
	 * @return A String object (this.name)
	 */
	@Column(length = 1024)
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

	/**
	 * Return the value associated with the column: node
	 * 
	 * @return A Boolean object (this.node)
	 */

	public Boolean isNode() {
		return this.node;
	}

	/**
	 * Set the value related to the column: node
	 * 
	 * @param node
	 *            the node value you wish to set
	 */
	public void setNode(final Boolean node) {
		this.node = node;
	}

	/**
	 * Return the value associated with the column: parent
	 * 
	 * @return A Topics object (this.parent)
	 */

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_PARENT_ID")
	@ForeignKey(name = "FK_TOPICS_PARENT_ID")
	public Topics getParent() {
		return this.parent;
	}

	/**
	 * Set the value related to the column: parent
	 * 
	 * @param parent
	 *            the parent value you wish to set
	 */
	public void setParent(final Topics parent) {
		this.parent = parent;
	}

}
