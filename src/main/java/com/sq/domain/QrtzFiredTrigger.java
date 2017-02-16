package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the qrtz_fired_triggers database table.
 * 
 */
@Entity
@Table(name="qrtz_fired_triggers")
@NamedQuery(name="QrtzFiredTrigger.findAll", query="SELECT q FROM QrtzFiredTrigger q")
public class QrtzFiredTrigger implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QrtzFiredTriggerPK id;

	@Column(name="FIRED_TIME")
	private BigInteger firedTime;

	@Column(name="INSTANCE_NAME")
	private String instanceName;

	@Column(name="IS_NONCONCURRENT")
	private String isNonconcurrent;

	@Column(name="JOB_GROUP")
	private String jobGroup;

	@Column(name="JOB_NAME")
	private String jobName;

	private int priority;

	@Column(name="REQUESTS_RECOVERY")
	private String requestsRecovery;

	@Column(name="SCHED_TIME")
	private BigInteger schedTime;

	private String state;

	@Column(name="TRIGGER_GROUP")
	private String triggerGroup;

	@Column(name="TRIGGER_NAME")
	private String triggerName;

	public QrtzFiredTrigger() {
	}

	public QrtzFiredTriggerPK getId() {
		return this.id;
	}

	public void setId(QrtzFiredTriggerPK id) {
		this.id = id;
	}

	public BigInteger getFiredTime() {
		return this.firedTime;
	}

	public void setFiredTime(BigInteger firedTime) {
		this.firedTime = firedTime;
	}

	public String getInstanceName() {
		return this.instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getIsNonconcurrent() {
		return this.isNonconcurrent;
	}

	public void setIsNonconcurrent(String isNonconcurrent) {
		this.isNonconcurrent = isNonconcurrent;
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

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getRequestsRecovery() {
		return this.requestsRecovery;
	}

	public void setRequestsRecovery(String requestsRecovery) {
		this.requestsRecovery = requestsRecovery;
	}

	public BigInteger getSchedTime() {
		return this.schedTime;
	}

	public void setSchedTime(BigInteger schedTime) {
		this.schedTime = schedTime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTriggerGroup() {
		return this.triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	public String getTriggerName() {
		return this.triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

}