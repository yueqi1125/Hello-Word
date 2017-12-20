package com.xt.java.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.java.user.dao.IUserDao;
import com.xt.java.user.model.User;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao ud;
	
	/**
	 * 用户登录
	 * 将Action传递来的用户登录信息传送至Dao层
	 * 返回包含用户信息的User对象
	 */
	public User login(User user){
		return ud.login(user);
	}
	
	/**
	 * 查询用户是否存在
	 * 将用户名传递至Dao层
	 * 判断返回的值是否为空
	 * 为空则返回true
	 * 不为空返回false
	 * @param userName
	 * @return
	 */
	public boolean queUserName(String userName){
		if(ud.queUserName(userName) != null){ 
			return false;
		}
		return true;
	}
}
