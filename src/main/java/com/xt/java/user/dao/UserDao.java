package com.xt.java.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xt.java.user.model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> rmu = new BeanPropertyRowMapper<User>(User.class);
	
	public User login(User user){
		String sql = "select * from user where user_name = ? and user_passwd = password(?)";
		return jdbcTemplate.queryForObject(sql, rmu);
	}
}
