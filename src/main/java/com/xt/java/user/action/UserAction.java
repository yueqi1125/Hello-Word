package com.xt.java.user.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xt.java.user.model.User;
import com.xt.java.user.service.UserService;

@Controller
@SessionAttributes("userInfo")
public class UserAction {

	@Autowired
	private UserService us;
	
	@RequestMapping("/login")
	public String login(User user,Map<String,Object> map){
		if(!us.login(user).getUserName().equals(null)){
			map.put("userInfo", us.login(user).getUserName());
			return "stuList";
		}
		return "login";
	}
}
