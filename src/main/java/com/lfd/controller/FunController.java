package com.lfd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lfd.bean.S_User;
import com.lfd.service.IndexService;

@Controller
public class FunController {
	@Autowired
	IndexService service;
	
	//用户注册
	@RequestMapping(value="/zhuce")
	public String IntZc(S_User user) {
		int result = service.intZc(user);
		System.out.println(result+"---------------------------");
		if(result==1) {
			return "/front/Kher";
		}else {
			return "redirect:/Kh";
		}
	}
	
	//用户登陆
	@RequestMapping(value="/login")
	@ResponseBody
	public String Login(String s_name,String s_password,HttpSession session) {
		List<S_User> list =  service.login(s_name, s_password);
		if(list!=null&&!list.isEmpty()) {
		if(s_name.equals(list.get(0).getS_name())&&s_password.equals(list.get(0).getS_password())) {
			session.setAttribute("s_name",s_name );
			session.setAttribute("user", list);
			session.setAttribute("s_isadmin",list.get(0).getS_isadmin());
			session.setAttribute("s_status",list.get(0).getS_status());
			session.setAttribute("s_txjpg",list.get(0).getS_txjpg());
			return "true";
		}
		return "false";
	  }else {
		return "false";
	}
  }

	
	//用户退出登录
	@RequestMapping(value="/logout")
	public String Logout(HttpSession session) {
		session.setAttribute("s_name",null);
		return "redirect:/demo"; 
	}
	
	//查询用户注册是否重复
	@RequestMapping(value="/sName")
	@ResponseBody
	public String sName(String s_name,HttpSession session) {
		List<S_User> list = service.sName(s_name);
		if(list!=null&&!list.isEmpty()) {
			if(s_name.equals(list.get(0).getS_name())) {
				return "true";
		  }else {
			return "false";
		 }
 	  }
		return "false";
   }
	
	//查询用户邮箱注册是否重复
		@RequestMapping(value="/sEmail")
		@ResponseBody
		public String sEmail(String s_pemail,HttpSession session) {
			List<S_User> list = service.sEmail(s_pemail);
			if(list!=null&&!list.isEmpty()) {
				if(s_pemail.equals(list.get(0).getS_pemail())) {
					return "true";
			  }else {
				return "false";
			 }
	 	  }
			return "false";
	   }
	
	//用户账户数据更新操作
	@RequestMapping(value="/userUpdate")
	public String usUpdate(S_User user,HttpSession session) {
		int result = service.intUp(user);
		List<S_User> list = service.sId(user.getS_id());
		if(result==0) {
			return "redirect:UserCenter";  
		}else {
			//更新用户最新数据
			session.setAttribute("s_name",user.getS_name());
			session.setAttribute("user", list);
			return "redirect:/demo";
		}
	}
}
