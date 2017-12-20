package com.xt.java.user.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
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
	 * 失败返回login页面
	 * 并返回msg登录信息
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,Map<String,Object> map){
		if(us.login(user) != null){ 
			map.put("userInfo", us.login(user));
			return "stuList";
		}
		map.put("msg", "用户名或密码不正确！");
		return "login";
	}
	
	/**
	 * 用户注册
	 * 将页面传递来的用户注册信息传送至Service层
	 * 由返回的值，判断成功与否
	 * 成功跳转stuList页面
	 * 失败返回register页面
	 * 并返回msg注册信息
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/register")
	public String register(User user,String password_confirm,Map<String,Object> map){
		System.out.println(password_confirm);
		return "";
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
}
