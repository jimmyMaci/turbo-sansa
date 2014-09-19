package user.management.model;

import hbm.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
@Entity
@Table(name="robinsons")
public class Robinsons
extends BaseEntity<Integer>
implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	private Users robinson;

    /**
     * Return the value associated with the column: robinson
	 * @return A Users object (this.robinson)
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "robinson_user_id", nullable = true, referencedColumnName = "id")
	@Index(name = "IDX_ROBINSON_USER_ID")
	@ForeignKey(name = "FK_ROBINSON_USER_ID")
	public Users getRobinson() {
		return robinson;
	}

	public void setRobinson(Users robinson) {
		this.robinson = robinson;
	}
}
