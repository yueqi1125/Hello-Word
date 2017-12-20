package com.xt.java.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xt.java.user.model.Student;
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
	
	/**
	 * 向数据库的用户表传入用户数据
	 * 完成用户注册
	 */
	public void register(User user){
		String sql = "insert into user(user_name,user_passwd) values(?, password(?))";
		jdbcTemplate.update(sql, user.getUserName(),user.getPasswd());
	}
	
	/**
	 * 通过数据库查询全部学生信息
	 * 返回学生列表(数据库信息名和Student类里变量名相差过大时)
	 */
	public List<Student> getAllStuInfo(){
		String sql = "select * from student";
		return jdbcTemplate.query(sql, new RowMapper<Student>(){
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setStuNo(rs.getString(1));
				stu.setStuName(rs.getString(2));
				stu.setCollege(rs.getString(3));
				stu.setTel(rs.getString(4));
				stu.setAge(rs.getInt(5));
				return stu;
			}
		});
	}
	
	/**
	 * 添加学生
	 * 向数据库添加学生信息
	 */
	public void addStu(Student stu){
		String sql = "insert into student values(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,	stu.getStuNo(),
									stu.getStuName(),
									stu.getCollege(),
									stu.getTel(),
									stu.getAge());
	}
	
	/**
	 * 通过学生编号查询学生信息
	 * (数据库变量名与类变量名不匹配)
	 */
	public Student queStuNo(String stuNo){
		String sql = "select * from student where stu_No = ?";
		List<Student> stus = jdbcTemplate.query(sql,new Object[]{stuNo}, new RowMapper<Student>(){
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setStuNo(rs.getString(1));
				stu.setStuName(rs.getString(2));
				stu.setCollege(rs.getString(3));
				stu.setTel(rs.getString(4));
				stu.setAge(rs.getInt(5));
				return stu;
			}
		});
		Student stu = null;
		if(stus != null && stus.size() > 0){
			stu = stus.get(0);
		}
		return stu;
	}
}
