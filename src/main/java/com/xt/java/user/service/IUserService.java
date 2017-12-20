package com.xt.java.user.service;

import com.xt.java.user.model.User;

public interface IUserService {

	/**
	 * 用户登录
	 * 将Action传递来的用户登录信息传送至Dao层
	 * 返回包含用户信息的User对象
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 查询用户是否存在
	 * 将用户名传递至Dao层
	 * 判断返回的值是否为空
	 */
	public boolean queUserName(String userName);
}
