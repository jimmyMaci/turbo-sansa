package de.alpharogroup.scheduler.system.model;

import hbm.entity.BaseEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import de.alpharogroup.scheduler.system.enums.Rhythm;


/**
 * The Entity class {@Appointments} is keeping the information
 * for the appointments from a given event. This can combined for instance with a user
 * address to get an event location with an appointment.
 */
@Entity
@Table(name = "appointments")
@TypeDefs({ @TypeDef(name = "rhythmConverter", typeClass = hbm.dao.postgres.usertype.PGEnumUserType.class, parameters = { @Parameter(name = "enumClassName", value = "de.alpharogroup.scheduler.system.enums.Rhythm") }) })
public class Appointments 
extends BaseEntity<Integer>
 implements Cloneable {
	/** The serial Version UID */
	private static final long serialVersionUID = 1L;
	/** The last time from the appointment. */
	private Date endtime;
	/** The next time from the apointment. */
	private Date nexttime;
	/** An enum that gives us the rhythm from the appointment. */
	private Rhythm rhythm;
	/** The start time from the appointment. */
	private Date starttime;

	/**
	 * Default constructor.
	 */
	public Appointments() {
	}

	/**
	 * Return the value associated with the column: endtime
	 * 
	 * @return A Date object (this.endtime)
	 */

	public Date getEndtime() {
		return this.endtime;
	}

	/**
	 * Set the value related to the column: endtime
	 * 
	 * @param endtime
	 *            the endtime value you wish to set
	 */
	public void setEndtime(final Date endtime) {
		this.endtime = endtime;
	}

	/**
	 * Return the value associated with the column: nexttime
	 * 
	 * @return A Date object (this.nexttime)
	 */

	public Date getNexttime() {
		return this.nexttime;
	}

	/**
	 * Set the value related to the column: nexttime
	 * 
	 * @param nexttime
	 *            the nexttime value you wish to set
	 */
	public void setNexttime(final Date nexttime) {
		this.nexttime = nexttime;
	}

	/**
	 * Return the value associated with the column: rhythm
	 * 
	 * @return A Rhythm object (this.rhythm)
	 */
	@Column(name = "rhythm")
	@Type(type = "rhythmConverter")
	public Rhythm getRhythm() {
		return this.rhythm;
	}

	/**
	 * Set the value related to the column: rhythm
	 * 
	 * @param rhythm
	 *            the rhythm value you wish to set
	 */
	public void setRhythm(final Rhythm rhythm) {
		this.rhythm = rhythm;
	}

	/**
	 * Return the value associated with the column: starttime
	 * 
	 * @return A Date object (this.starttime)
	 */

	public Date getStarttime() {
		return this.starttime;
	}

	/**
	 * Set the value related to the column: starttime
	 * 
	 * @param starttime
	 *            the starttime value you wish to set
	 */
	public void setStarttime(final Date starttime) {
		this.starttime = starttime;
	}
	
}
