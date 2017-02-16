package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qrtz_blob_triggers database table.
 * 
 */
@Entity
@Table(name="qrtz_blob_triggers")
@NamedQuery(name="QrtzBlobTrigger.findAll", query="SELECT q FROM QrtzBlobTrigger q")
public class QrtzBlobTrigger implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QrtzBlobTriggerPK id;

	@Lob
	@Column(name="BLOB_DATA")
	private byte[] blobData;

	public QrtzBlobTrigger() {
	}

	public QrtzBlobTriggerPK getId() {
		return this.id;
	}

	public void setId(QrtzBlobTriggerPK id) {
		this.id = id;
	}

	public byte[] getBlobData() {
		return this.blobData;
	}

	public void setBlobData(byte[] blobData) {
		this.blobData = blobData;
	}

}