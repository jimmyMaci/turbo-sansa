package db.resource.bundles.model;
import hbm.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/** 
 * Entity class for saving resource bundles in database.
 * @author: Asterios Raptis
 */
@Entity
@Table(name="resourcebundles")
public class Resourcebundles 
extends BaseEntity<Integer>
implements Cloneable, Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;	
	/** The bundle name. */
	private String baseName;
	/** The locale of this entry. */
	private String locale;	
	/** The properties key. */
	private String key;	
	/** The value for the properties key. */
	private String value;

    /**
     * Return the value associated with the column: baseName
	 * @return A String object (this.baseName)
	 */
	@Column( name = "base_name", length = 1024  )
	public String getBaseName() {
		return baseName;
	}

    /**  
     * Set the value related to the column: baseName 
	 * @param baseName the baseName value you wish to set
	 */
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

    /**
     * Return the value associated with the column: locale
	 * @return A String object (this.locale)
	 */
	@Column( length = 64  )
	public String getLocale() {
		return this.locale;
	}
	

  
    /**  
     * Set the value related to the column: locale 
	 * @param locale the locale value you wish to set
	 */
	public void setLocale (final String locale) {
		this.locale = locale;
	}


    /**
     * Return the value associated with the column: properties_key
	 * @return A String object (this.propertieskey)
	 */
	@Column(name = "properties_key", length = 1024  )
	public String getKey() {
		return this.key;
	}
	

  
    /**  
     * Set the value related to the column: properties_key 
	 * @param propertieskey the propertieskey value you wish to set
	 */
	public void setKey (final String propertieskey) {
		this.key = propertieskey;
	}


    /**
     * Return the value associated with the column: value
	 * @return A String object (this.value)
	 */
	@Column( name="value", length = 2048  )
	public String getValue() {
		return this.value;
	}
	

  
    /**  
     * Set the value related to the column: value 
	 * @param value the value value you wish to set
	 */
	public void setValue (final String value) {
		this.value = value;
	}

	/**
     * {@inheritDoc}
     */
	@Override
    public Resourcebundles clone() throws CloneNotSupportedException {
        Resourcebundles copy = new Resourcebundles();
		copy.setBaseName(this.getBaseName());
		copy.setId(this.getId());
		copy.setLocale(this.getLocale());
		copy.setKey(this.getKey());
		copy.setValue(this.getValue());
		return copy;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("baseName: "+this.baseName + ", ");
		sb.append("id: "+this.getId() + ", ");
		sb.append("locale: "+this.locale + ", ");
		sb.append("key: "+this.key + ", ");
		sb.append("value: "+this.value);
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