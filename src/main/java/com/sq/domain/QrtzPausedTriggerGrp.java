package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qrtz_paused_trigger_grps database table.
 * 
 */
@Entity
@Table(name="qrtz_paused_trigger_grps")
@NamedQuery(name="QrtzPausedTriggerGrp.findAll", query="SELECT q FROM QrtzPausedTriggerGrp q")
public class QrtzPausedTriggerGrp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QrtzPausedTriggerGrpPK id;

	public QrtzPausedTriggerGrp() {
	}

	public QrtzPausedTriggerGrpPK getId() {
		return this.id;
	}

	public void setId(QrtzPausedTriggerGrpPK id) {
		this.id = id;
	}

}