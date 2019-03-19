package com.lfd.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lfd.bean.S_User;
import com.lfd.service.IndexService;

/*
 * 头像与类似图片等文件上传
 * */
@Controller
public class FileTxjpgController {
	@Autowired
	IndexService service;
	
	// 上传文件会自动绑定到MultipartFile中
	@SuppressWarnings({ "unchecked"})
	@RequestMapping(value="/headpg")
	public String upload(HttpSession session,HttpServletRequest request,@RequestParam("file") MultipartFile file) throws Exception{
	System.out.println("----------------------------------------------------------------------");
	// 如果文件不为空，写入上传路径
	if(!file.isEmpty()){
	// 上传文件路径
/*	String path = request.getServletContext().getRealPath(
	"/upload/");*/
	String path = "D:/IDEAProject/SZKY/src/main/resources/static/";
	System.out.println("path = " + path);
	// 上传文件名
	String filename = "images/"+file.getOriginalFilename();
	System.out.println(filename);
	File filepath = new File(path,"images/"+filename);
	// 判断路径是否存在，如果不存在就创建一个
	if (!filepath.getParentFile().exists()) {
	filepath.getParentFile().mkdirs();
	}
	// 将上传文件保存到一个目标文件当中
	file.transferTo(new File(path+File.separator+ filename));
	// 将用户头像更新为上传头像
	List<S_User> list = (List<S_User>) session.getAttribute("user");
    Integer s_id = list.get(0).getS_id();
    System.out.println(s_id+"---------------------");
	service.intjpg(filename,s_id);
	return "redirect:UserCenter";
	}else{
	return "redirect:/demo";
	}
  }
}
