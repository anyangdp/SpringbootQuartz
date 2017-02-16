package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qrtz_job_details database table.
 * 
 */
@Entity
@Table(name="qrtz_job_details")
@NamedQuery(name="QrtzJobDetail.findAll", query="SELECT q FROM QrtzJobDetail q")
public class QrtzJobDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QrtzJobDetailPK id;

	private String description;

	@Column(name="IS_DURABLE")
	private String isDurable;

	@Column(name="IS_NONCONCURRENT")
	private String isNonconcurrent;

	@Column(name="IS_UPDATE_DATA")
	private String isUpdateData;

	@Column(name="JOB_CLASS_NAME")
	private String jobClassName;

	@Lob
	@Column(name="JOB_DATA")
	private byte[] jobData;

	@Column(name="REQUESTS_RECOVERY")
	private String requestsRecovery;

	public QrtzJobDetail() {
	}

	public QrtzJobDetailPK getId() {
		return this.id;
	}

	public void setId(QrtzJobDetailPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsDurable() {
		return this.isDurable;
	}

	public void setIsDurable(String isDurable) {
		this.isDurable = isDurable;
	}

	public String getIsNonconcurrent() {
		return this.isNonconcurrent;
	}

	public void setIsNonconcurrent(String isNonconcurrent) {
		this.isNonconcurrent = isNonconcurrent;
	}

	public String getIsUpdateData() {
		return this.isUpdateData;
	}

	public void setIsUpdateData(String isUpdateData) {
		this.isUpdateData = isUpdateData;
	}

	public String getJobClassName() {
		return this.jobClassName;
	}

	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}

	public byte[] getJobData() {
		return this.jobData;
	}

	public void setJobData(byte[] jobData) {
		this.jobData = jobData;
	}

	public String getRequestsRecovery() {
		return this.requestsRecovery;
	}

	public void setRequestsRecovery(String requestsRecovery) {
		this.requestsRecovery = requestsRecovery;
	}

}