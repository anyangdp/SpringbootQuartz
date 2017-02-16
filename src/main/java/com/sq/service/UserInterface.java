package com.sq.service;

import com.sq.domain.UserLogin;

public interface UserInterface {
	
	UserLogin queryUser(String name, String pwd);
	
}
