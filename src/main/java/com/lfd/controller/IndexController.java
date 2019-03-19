package com.lfd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lfd.service.IndexService;

@Controller
public class IndexController {
	@Autowired
	IndexService service;
	//首页
	@RequestMapping(value="/")
	public String indexpage(HttpSession session) {
		//session.setAttribute("users", service.getUser());
		return "/front/HOMEPAGE"; 
	}
	@RequestMapping(value="/demo")
	public String indexpagebak(HttpSession session) {
		//session.setAttribute("users", service.getUser());
		return "/front/HOMEPAGE"; 
	}
	//**页
	@RequestMapping(value="/elements")
	public String elepage() {
		return "/front/elements";
	}
	//**页
	@RequestMapping(value="/generic")
	public String genpage() {
		return "/front/generic";
	}  
	//注册页
	@RequestMapping(value="/User")
	public String User() { 
		return "/front/User"; 
	}
	//用户中心页
	@RequestMapping(value="/UserCenter")
	public String UserCenter() {
		return "/front/UserCenter";
	}
}
 