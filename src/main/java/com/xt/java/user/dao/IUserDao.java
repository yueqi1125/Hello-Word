package com.xt.java.user.dao;

import java.util.List;

import com.xt.java.user.model.Student;
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
	
	/**
	 * 向数据库传入用户数据
	 * 完成用户注册
	 * @param user
	 */
	public void register(User user);
	
	/**
	 * 查询全部学生信息
	 * 返回学生信息列表
	 * @return
	 */
	public List<Student> getAllStuInfo();
	
	/**
	 * 向数据库添加学生信息
	 * @param stu
	 */
	public void addStu(Student stu);
	
	/**
	 * 通过学生编号查询学生信息
	 * @param stuNo
	 * @return
	 */
	public Student queStuNo(String stuNo);
	
	/**
	 * 通过学生编号删除学生
	 * @param stuNo
	 */
	public void delStu(String stuNo);
	
	/**
	 * 修改学生信息
	 * @param stu
	 */
	public void updateStu(Student stu);
}
