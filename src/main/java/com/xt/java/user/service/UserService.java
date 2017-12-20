package com.xt.java.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.java.user.dao.IUserDao;
import com.xt.java.user.model.Student;
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
	
	/**
	 * 传入User信息
	 * 完成注册
	 * 并返回登录用户信息User
	 * @param user
	 * @return
	 */
	public User register(User user){
		ud.register(user);
		return ud.login(user);
	}
	
	/**
	 * 通过dao层获取全部学生信息列表
	 * 返回list
	 */
	public List<Student> getAllStuInfo(){
		return ud.getAllStuInfo();
	}
	
	/**
	 * 添加学生
	 * 向Dao层传递学生信息
	 */
	public void addStu(Student stu){
		ud.addStu(stu);
	}
	
	/**
	 * 查询学生编号是否存在
	 * 将学生编号传递至Dao层
	 * 判断返回的值是否为空
	 * 为空则返回true
	 * 不为空返回false
	 */
	public boolean queStuNo(String stuNo){
		if(ud.queStuNo(stuNo) != null){ 
			return false;
		}
		return true;
	}
}
