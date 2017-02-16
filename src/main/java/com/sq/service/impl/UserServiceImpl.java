package com.sq.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sq.dao.UserLoginDao;
import com.sq.domain.UserLogin;
import com.sq.service.UserInterface;

@Service
public class UserServiceImpl implements UserInterface{

	@Resource
    UserLoginDao userLoginDAO;
	
	@Override
	public UserLogin queryUser(String name, String pwd) {
		UserLogin ul = userLoginDAO.findByloginNameAndLoginPassword(name,pwd);
		return ul;
	}

}
