package user.management.model;

import hbm.entity.BaseEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseAttributesEntity extends BaseEntity<Integer> {


	/**  The serial Version UID. */
	private static final long serialVersionUID = 1L;
	private Set<Attributes> attributes = new HashSet<Attributes>(0);

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		      name="base_attributes",
		      joinColumns={@JoinColumn(name="base_attributes_id", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="attributes_id", referencedColumnName="id")})
	public Set<Attributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<Attributes> attributes) {
		this.attributes = attributes;
	}
	
}
