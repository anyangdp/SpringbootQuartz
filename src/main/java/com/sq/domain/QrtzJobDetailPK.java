package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the qrtz_job_details database table.
 * 
 */
@Embeddable
public class QrtzJobDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SCHED_NAME")
	private String schedName;

	@Column(name="JOB_NAME")
	private String jobName;

	@Column(name="JOB_GROUP")
	private String jobGroup;

	public QrtzJobDetailPK() {
	}
	public String getSchedName() {
		return this.schedName;
	}
	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}
	public String getJobName() {
		return this.jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return this.jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QrtzJobDetailPK)) {
			return false;
		}
		QrtzJobDetailPK castOther = (QrtzJobDetailPK)other;
		return 
			this.schedName.equals(castOther.schedName)
			&& this.jobName.equals(castOther.jobName)
			&& this.jobGroup.equals(castOther.jobGroup);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.schedName.hashCode();
		hash = hash * prime + this.jobName.hashCode();
		hash = hash * prime + this.jobGroup.hashCode();
		
		return hash;
	}
}