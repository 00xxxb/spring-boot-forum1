package com.fxb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fxb.bean.S_HuiFuLzl;
import com.fxb.bean.S_User;
import com.fxb.service.LzlService;

@Controller
@SuppressWarnings("unchecked")
public class LzlController {
	@Autowired
	LzlService service;
	
	
	@ResponseBody
	@RequestMapping("/lzlhf")
	/*
	 * s_id:当前用户的唯一标识符
	 * s_tid:当前帖子的唯一标识符
	 * s_hid:当前帖子回复楼层的唯一标识符
	 * */
	public List<S_HuiFuLzl> Lzlhf(HttpSession session,@RequestParam("s_ltext")String s_ltext,@RequestParam("s_hid")Integer s_hid) {
		//获取当前时间
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		String s_date = dateformat.format(date.getTime()).toString();
		//获取当前用户的唯一标识符
		List<S_User> list = (List<S_User>) session.getAttribute("user");
        Integer s_id = list.get(0).getS_id();
        //用户楼中楼回帖方法
		service.LzlHf(s_ltext,s_id,KheiController.tid,s_hid,s_date);
		List<S_HuiFuLzl> lists = service.LzlCx(KheiController.tid,s_hid);
		return lists;
	}
	
	@RequestMapping(value = "/lzlcx",method = { RequestMethod.GET })
	@ResponseBody
	public List<S_HuiFuLzl> Lzlcx(HttpSession session,@RequestParam("s_hid")Integer s_hid) {
        //查询楼中楼回复
		List<S_HuiFuLzl> lists = service.LzlCx(KheiController.tid,s_hid);
		session.setAttribute("lzlcx", lists);
		session.setAttribute("lzlsl", lists.size());
		return lists;
	}
}
