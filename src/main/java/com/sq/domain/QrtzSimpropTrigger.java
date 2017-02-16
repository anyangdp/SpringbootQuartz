package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * The persistent class for the qrtz_simprop_triggers database table.
 * 
 */
@Entity
@Table(name="qrtz_simprop_triggers")
@NamedQuery(name="QrtzSimpropTrigger.findAll", query="SELECT q FROM QrtzSimpropTrigger q")
public class QrtzSimpropTrigger implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QrtzSimpropTriggerPK id;

	@Column(name="BOOL_PROP_1")
	private String boolProp1;

	@Column(name="BOOL_PROP_2")
	private String boolProp2;

	@Column(name="DEC_PROP_1")
	private BigDecimal decProp1;

	@Column(name="DEC_PROP_2")
	private BigDecimal decProp2;

	@Column(name="INT_PROP_1")
	private int intProp1;

	@Column(name="INT_PROP_2")
	private int intProp2;

	@Column(name="LONG_PROP_1")
	private BigInteger longProp1;

	@Column(name="LONG_PROP_2")
	private BigInteger longProp2;

	@Column(name="STR_PROP_1")
	private String strProp1;

	@Column(name="STR_PROP_2")
	private String strProp2;

	@Column(name="STR_PROP_3")
	private String strProp3;

	public QrtzSimpropTrigger() {
	}

	public QrtzSimpropTriggerPK getId() {
		return this.id;
	}

	public void setId(QrtzSimpropTriggerPK id) {
		this.id = id;
	}

	public String getBoolProp1() {
		return this.boolProp1;
	}

	public void setBoolProp1(String boolProp1) {
		this.boolProp1 = boolProp1;
	}

	public String getBoolProp2() {
		return this.boolProp2;
	}

	public void setBoolProp2(String boolProp2) {
		this.boolProp2 = boolProp2;
	}

	public BigDecimal getDecProp1() {
		return this.decProp1;
	}

	public void setDecProp1(BigDecimal decProp1) {
		this.decProp1 = decProp1;
	}

	public BigDecimal getDecProp2() {
		return this.decProp2;
	}

	public void setDecProp2(BigDecimal decProp2) {
		this.decProp2 = decProp2;
	}

	public int getIntProp1() {
		return this.intProp1;
	}

	public void setIntProp1(int intProp1) {
		this.intProp1 = intProp1;
	}

	public int getIntProp2() {
		return this.intProp2;
	}

	public void setIntProp2(int intProp2) {
		this.intProp2 = intProp2;
	}

	public BigInteger getLongProp1() {
		return this.longProp1;
	}

	public void setLongProp1(BigInteger longProp1) {
		this.longProp1 = longProp1;
	}

	public BigInteger getLongProp2() {
		return this.longProp2;
	}

	public void setLongProp2(BigInteger longProp2) {
		this.longProp2 = longProp2;
	}

	public String getStrProp1() {
		return this.strProp1;
	}

	public void setStrProp1(String strProp1) {
		this.strProp1 = strProp1;
	}

	public String getStrProp2() {
		return this.strProp2;
	}

	public void setStrProp2(String strProp2) {
		this.strProp2 = strProp2;
	}

	public String getStrProp3() {
		return this.strProp3;
	}

	public void setStrProp3(String strProp3) {
		this.strProp3 = strProp3;
	}

}