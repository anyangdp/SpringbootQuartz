package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the qrtz_cron_triggers database table.
 * 
 */
@Embeddable
public class QrtzCronTriggerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SCHED_NAME")
	private String schedName;

	@Column(name="TRIGGER_NAME")
	private String triggerName;

	@Column(name="TRIGGER_GROUP")
	private String triggerGroup;

	public QrtzCronTriggerPK() {
	}
	public String getSchedName() {
		return this.schedName;
	}
	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}
	public String getTriggerName() {
		return this.triggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public String getTriggerGroup() {
		return this.triggerGroup;
	}
	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QrtzCronTriggerPK)) {
			return false;
		}
		QrtzCronTriggerPK castOther = (QrtzCronTriggerPK)other;
		return 
			this.schedName.equals(castOther.schedName)
			&& this.triggerName.equals(castOther.triggerName)
			&& this.triggerGroup.equals(castOther.triggerGroup);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.schedName.hashCode();
		hash = hash * prime + this.triggerName.hashCode();
		hash = hash * prime + this.triggerGroup.hashCode();
		
		return hash;
	}
}