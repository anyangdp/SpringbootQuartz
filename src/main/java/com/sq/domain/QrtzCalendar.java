package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qrtz_calendars database table.
 * 
 */
@Entity
@Table(name="qrtz_calendars")
@NamedQuery(name="QrtzCalendar.findAll", query="SELECT q FROM QrtzCalendar q")
public class QrtzCalendar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QrtzCalendarPK id;

	@Lob
	private byte[] calendar;

	public QrtzCalendar() {
	}

	public QrtzCalendarPK getId() {
		return this.id;
	}

	public void setId(QrtzCalendarPK id) {
		this.id = id;
	}

	public byte[] getCalendar() {
		return this.calendar;
	}

	public void setCalendar(byte[] calendar) {
		this.calendar = calendar;
	}

}