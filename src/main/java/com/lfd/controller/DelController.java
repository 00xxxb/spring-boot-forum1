package com.lfd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lfd.service.TieziService;

@Controller
public class DelController { 
	 @Autowired
	 TieziService service;
	 
	 @RequestMapping(value="/Deltz")
	 public String Deltz() {
		 int result = service.DeTz(KheiController.tid);
		 if(result==1) {
			 System.out.println("删除成功");
		 }else {
			 System.out.println("删除异常");
		 }
		 return "redirect:kh";
	 }
	 
	 @RequestMapping(value="/DeHf")
	 public String DeHf(Integer s_hid) {
		 int result = service.DeHf(s_hid);
		 if(result==1) {
			 System.out.println("删除成功");
		 }else {
			 System.out.println("删除异常");
		 }
		 return "redirect:"+KheiController.tid;
	 }
}
