package com.xt.java.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xt.java.user.model.User;

@Repository
public class UserDao implements IUserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> rmu = new BeanPropertyRowMapper<User>(User.class);
	
	/**
	 * 获得用户的登录信息
	 * 通过jdbc方式向数据库查询信息
	 * 装配成User对象
	 * 返回User
	 */
	public User login(User user){
		String sql = "select * from user where user_name = ? and user_passwd = password(?)";
		List<User> users = jdbcTemplate.query(sql, new Object[]{user.getUserName(),user.getPasswd()}, rmu);
		User u = null;
		if(users != null && users.size() > 0){
			u = users.get(0);
		}
		return u;
	}
	
	/**
	 * 通过用户名
	 * 查询用户信息
	 * 装配成User对象
	 * @param userName
	 * @return
	 */
	public User queUserName(String userName){
		String sql = "select * from user where user_name = ?";
		List<User> users = jdbcTemplate.query(sql, new Object[]{userName}, rmu);
		User u = null;
		if(users != null && users.size() > 0){
			u = users.get(0);
		}
		return u;
	}
}
