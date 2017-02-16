package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the qrtz_triggers database table.
 * 
 */
@Entity
@Table(name="qrtz_triggers")
@NamedQuery(name="QrtzTrigger.findAll", query="SELECT q FROM QrtzTrigger q")
public class QrtzTrigger implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QrtzTriggerPK id;

	@Column(name="CALENDAR_NAME")
	private String calendarName;

	private String description;

	@Column(name="END_TIME")
	private BigInteger endTime;

	@Lob
	@Column(name="JOB_DATA")
	private byte[] jobData;

	@Column(name="JOB_GROUP")
	private String jobGroup;

	@Column(name="JOB_NAME")
	private String jobName;

	@Column(name="MISFIRE_INSTR")
	private short misfireInstr;

	@Column(name="NEXT_FIRE_TIME")
	private BigInteger nextFireTime;

	@Column(name="PREV_FIRE_TIME")
	private BigInteger prevFireTime;

	private int priority;

	@Column(name="START_TIME")
	private BigInteger startTime;

	@Column(name="TRIGGER_STATE")
	private String triggerState;

	@Column(name="TRIGGER_TYPE")
	private String triggerType;

	public QrtzTrigger() {
	}

	public QrtzTriggerPK getId() {
		return this.id;
	}

	public void setId(QrtzTriggerPK id) {
		this.id = id;
	}

	public String getCalendarName() {
		return this.calendarName;
	}

	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigInteger getEndTime() {
		return this.endTime;
	}

	public void setEndTime(BigInteger endTime) {
		this.endTime = endTime;
	}

	public byte[] getJobData() {
		return this.jobData;
	}

	public void setJobData(byte[] jobData) {
		this.jobData = jobData;
	}

	public String getJobGroup() {
		return this.jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public short getMisfireInstr() {
		return this.misfireInstr;
	}

	public void setMisfireInstr(short misfireInstr) {
		this.misfireInstr = misfireInstr;
	}

	public BigInteger getNextFireTime() {
		return this.nextFireTime;
	}

	public void setNextFireTime(BigInteger nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	public BigInteger getPrevFireTime() {
		return this.prevFireTime;
	}

	public void setPrevFireTime(BigInteger prevFireTime) {
		this.prevFireTime = prevFireTime;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public BigInteger getStartTime() {
		return this.startTime;
	}

	public void setStartTime(BigInteger startTime) {
		this.startTime = startTime;
	}

	public String getTriggerState() {
		return this.triggerState;
	}

	public void setTriggerState(String triggerState) {
		this.triggerState = triggerState;
	}

	public String getTriggerType() {
		return this.triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

}