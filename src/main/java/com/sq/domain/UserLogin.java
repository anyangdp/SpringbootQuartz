package com.sq.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="logintable")
@Setter
@Getter
public class UserLogin {
	@Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Integer id;

    @NotNull
    @Column(name="login_name")
    private  String loginName;

    @NotNull
    @Column(name="login_password")
    private  String loginPassword;

    public UserLogin(){}

    public UserLogin(String a, String b){
        this.loginName = a;
        this.loginPassword = b;
    }

//Getter and Setter
}
