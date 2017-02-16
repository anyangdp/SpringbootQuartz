package com.sq.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the logintable database table.
 * 
 */
@Entity
@NamedQuery(name="Logintable.findAll", query="SELECT l FROM Logintable l")
public class Logintable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="login_name")
	private String loginName;

	@Column(name="login_password")
	private String loginPassword;

	public Logintable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

}