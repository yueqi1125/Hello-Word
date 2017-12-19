package com.xt.java.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.java.user.dao.UserDao;
import com.xt.java.user.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao ud;
	
	public User login(User user){
		return ud.login(user);
	}
}
