package hbm.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import net.sourceforge.jaulp.lang.ObjectUtils;
import net.sourceforge.jaulp.xml.XmlUtils;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * The Class BaseEntity holds the primary key.
 */
@MappedSuperclass
public abstract class BaseEntity<PK extends Serializable> implements
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The technical primary key. */
	private PK id;

	/**
	 * Return the value associated with the column: id.
	 *
	 * @return A Integer object (this.id)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	public PK getId() {
		return this.id;
	}

	/**
	 * Set the value related to the column: id.
	 *
	 * @param id
	 *            the id value you wish to set
	 */
	public void setId(final PK id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, newToStringStyle());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return ObjectUtils.cloneObjectQuietly(this);
	}

	/**
	 * Factory method that can be overwritten to get another
	 * {@link ToStringStyle} object for the {@link BaseEntity#toString()}.
	 * Default is {@link ToStringStyle#SHORT_PREFIX_STYLE}.
	 */
	protected ToStringStyle newToStringStyle() {
		return ToStringStyle.SHORT_PREFIX_STYLE;
	}

	/**
	 * Returns a xml string representation of the object.
	 *
	 * @return the xml string.
	 */
	public String toXml() {
		Map<String, Class<?>> aliases = new HashMap<String, Class<?>>();
		String lqSimpleName = this.getClass().getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, getClass());
		String xml = XmlUtils.toXmlWithXStream(this, aliases);
		return xml;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
