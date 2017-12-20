package com.xt.java.user.dao;

import com.xt.java.user.model.User;

public interface IUserDao {

	/**
	 * 用户登录
	 * 通过连接数据库核对用户登录信息
	 * 返回包含用户信息的User对象
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 通过用户名
	 * 查询用户信息
	 * 装配成User对象
	 * @param userName
	 * @return
	 */
	public User queUserName(String userName);
}
