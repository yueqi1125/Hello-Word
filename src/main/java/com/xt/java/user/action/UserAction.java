package com.xt.java.user.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.xt.java.user.model.Student;
import com.xt.java.user.model.User;
import com.xt.java.user.service.IUserService;

@Controller
@SessionAttributes("userInfo")
public class UserAction{

	@Autowired
	private IUserService us;
	
	/**
	 * 用户登录
	 * 将页面传递来的用户登录信息传送至Service层
	 * 由返回的值，判断成功与否
	 * 成功跳转stuList页面
	 * 	并获取stuList信息跳转至stulist
	 * 失败返回login页面
	 * 并返回msg登录信息
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,Map<String,Object> map){
		User u = us.login(user);
		if(u != null){ 
			map.put("userInfo", u);
			return "redirect:/stuList";
		}
		map.put("msg", "用户名或密码不正确！");
		return "login";
	}
	
	/**
	 * 用户注册
	 * 将页面传递来的用户注册信息传送至Service层
	 * 由返回的值，判断成功与否
	 * 成功则自动登录，
	 * 	并获取stuList信息跳转至stulist
	 * 失败返回msg注册信息
	 * 并返回register页面
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/register")
	public String register(String userName,String password,Map<String,Object> map){
		User user = new User();
		user.setUserName(userName);
		user.setPasswd(password);
		User u = us.register(user);
		if(u != null){ 
			map.put("userInfo", u);
			return "redirect:/stuList";
		}
		map.put("msg", "用户注册异常！");
		return "register";
	}
	
	/**
	 * 验证注册用户用户名是否可用
	 * 返回相应的信息
	 * @param userName
	 * @param request
	 * @throws IOException 
	 */
	@RequestMapping("/queUserName")
	public void queUserName(String userName,Map<String,Object> map,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		String blmsg = "";
		Gson gson = new Gson();
		
		if(us.queUserName(userName)){
			blmsg = "用户名可用！";
		} else {
			blmsg = "用户名已存在！";
		}
		map.put("msg", blmsg);
		String msg = gson.toJson(map);
		response.getWriter().print(msg);
	}
	
	/**
	 * 验证学生编号是否重复
	 * 返回相应的信息
	 * @param stuNo
	 * @param map
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/queStuNo")
	public void queStuNo(String stuNo,Map<String,Object> map,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		String blmsg = "";
		Gson gson = new Gson();
		
		if(us.queStuNo(stuNo)){
			blmsg = "学生编号可用！";
		} else {
			blmsg = "学生编号重复！";
		}
		map.put("msg", blmsg);
		String msg = gson.toJson(map);
		response.getWriter().print(msg);
	}
	
	/**
	 * 获取stulist信息
	 * 返回stulist页面
	 * @param map
	 * @return
	 */
	@RequestMapping("/stuList")
	public String stuList(Map<String,Object> map){
		map.put("stuList", us.getAllStuInfo());
		return "stuList";
	}
	
	/**
	 * 提交方式POST
	 * 添加学生
	 * 跳转添加学生页面
	 * @param stu
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/stuManager", method=RequestMethod.POST)
	public String addStu(Student stu, Map<String,Object> map){
		us.addStu(stu);
		map.put("msg", "学生信息添加成功");
		return "addStu";
	}
	
	/**
	 * 提交方式DELETE
	 * 通过学生编号stuNo删除学生信息
	 * @param stuNo
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/stuManager/{stuNo}", method=RequestMethod.DELETE)
	public String delStu(@PathVariable("stuNo") String stuNo){
		us.delStu(stuNo);
		return "redirect:/stuList";
	}
	
	/**
	 * 提交方式GET
	 * 通过学生编号stuNo获得学生信息
	 * @param stuNo
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/stuManager/{stuNo}", method=RequestMethod.GET)
	public String getStuInfo(@PathVariable("stuNo") String stuNo, Map<String,Object> map){
		map.put("stu", us.getStuInfo(stuNo));
		return "queStu";
	}
	
	/**
	 * 提交方式PUT
	 * 修改学生信息
	 * @param stuNo
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/stuManager", method=RequestMethod.PUT)
	public String updateStu(Student stu){
		us.updateStu(stu);
		return "redirect:/stuList";
	}
}
