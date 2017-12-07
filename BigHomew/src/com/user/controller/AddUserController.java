package com.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.LoginUser;
import com.user.service.AddUserService;

@Controller
@RequestMapping("/adduser")
public class AddUserController {
@Resource
private AddUserService addUserService;
@RequestMapping("/add")
	public String adduser(LoginUser loginUser){
		System.out.println(111111);
		addUserService.adduser(loginUser);
		return "index";
	}
@RequestMapping("/login")
public String login(LoginUser loginUser,HttpSession session){
	String name = loginUser.getName();
	List<LoginUser> list=addUserService.findName(name);
	if(list.get(0).getPassword().equals(loginUser.getPassword())){
		System.out.print("登陆成功");
		System.out.println(loginUser.getName());
		System.out.println(loginUser.getPassword());
		session.setAttribute("name",loginUser.getName());
		System.out.println(session.getAttribute("name"));
		return "index2";
	}else{
		System.out.print("登陆失败");
		return "regster";
	}
	
}
}
