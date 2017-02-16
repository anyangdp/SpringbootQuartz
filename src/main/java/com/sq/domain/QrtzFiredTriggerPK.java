package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the qrtz_fired_triggers database table.
 * 
 */
@Embeddable
public class QrtzFiredTriggerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SCHED_NAME")
	private String schedName;

	@Column(name="ENTRY_ID")
	private String entryId;

	public QrtzFiredTriggerPK() {
	}
	public String getSchedName() {
		return this.schedName;
	}
	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}
	public String getEntryId() {
		return this.entryId;
	}
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QrtzFiredTriggerPK)) {
			return false;
		}
		QrtzFiredTriggerPK castOther = (QrtzFiredTriggerPK)other;
		return 
			this.schedName.equals(castOther.schedName)
			&& this.entryId.equals(castOther.entryId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.schedName.hashCode();
		hash = hash * prime + this.entryId.hashCode();
		
		return hash;
	}
}