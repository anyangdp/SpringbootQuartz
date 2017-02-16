package com.sq.dao;

import org.springframework.data.repository.CrudRepository;

import com.sq.domain.UserLogin;

public interface UserLoginDao extends CrudRepository<UserLogin, Long> {
	UserLogin findByloginNameAndLoginPassword(String loginName, String loginPassword);
}
