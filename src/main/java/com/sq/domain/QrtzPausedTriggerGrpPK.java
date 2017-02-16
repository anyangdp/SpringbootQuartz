package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the qrtz_paused_trigger_grps database table.
 * 
 */
@Embeddable
public class QrtzPausedTriggerGrpPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SCHED_NAME")
	private String schedName;

	@Column(name="TRIGGER_GROUP")
	private String triggerGroup;

	public QrtzPausedTriggerGrpPK() {
	}
	public String getSchedName() {
		return this.schedName;
	}
	public void setSchedName(String schedName) {
		this.schedName = schedName;
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
		if (!(other instanceof QrtzPausedTriggerGrpPK)) {
			return false;
		}
		QrtzPausedTriggerGrpPK castOther = (QrtzPausedTriggerGrpPK)other;
		return 
			this.schedName.equals(castOther.schedName)
			&& this.triggerGroup.equals(castOther.triggerGroup);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.schedName.hashCode();
		hash = hash * prime + this.triggerGroup.hashCode();
		
		return hash;
	}
}