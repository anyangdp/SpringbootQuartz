package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the qrtz_scheduler_state database table.
 * 
 */
@Embeddable
public class QrtzSchedulerStatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SCHED_NAME")
	private String schedName;

	@Column(name="INSTANCE_NAME")
	private String instanceName;

	public QrtzSchedulerStatePK() {
	}
	public String getSchedName() {
		return this.schedName;
	}
	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}
	public String getInstanceName() {
		return this.instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QrtzSchedulerStatePK)) {
			return false;
		}
		QrtzSchedulerStatePK castOther = (QrtzSchedulerStatePK)other;
		return 
			this.schedName.equals(castOther.schedName)
			&& this.instanceName.equals(castOther.instanceName);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.schedName.hashCode();
		hash = hash * prime + this.instanceName.hashCode();
		
		return hash;
	}
}