package com.xt.java.user.service;

import java.util.List;

import com.xt.java.user.model.Student;
import com.xt.java.user.model.User;

public interface IUserService {

	/**
	 * 用户登录
	 * 返回包含用户信息的User对象
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 查询用户名是否存在
	 */
	public boolean queUserName(String userName);
	
	/**
	 * 用户注册
	 * 返回登录信息User
	 * @param user
	 * @return
	 */
	public User register(User user);
	
	/**
	 * 获得全部学生信息列表
	 * 返回list
	 * @return
	 */
	public List<Student> getAllStuInfo();
	
	/**
	 * 添加学生
	 * @param stu
	 */
	public void addStu(Student stu);
	
	/**
	 * 查询学生编号是否重复
	 * @param stuNo
	 * @return
	 */
	public boolean queStuNo(String stuNo);
}
