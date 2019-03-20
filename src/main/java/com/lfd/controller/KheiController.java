package com.lfd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.lfd.annotation.MyAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.lfd.bean.PageBean;
import com.lfd.bean.S_Huif;
import com.lfd.bean.S_Khei;
import com.lfd.bean.S_User;
import com.lfd.bean.TzInformation;
import com.lfd.service.IndexService;
import com.lfd.service.TieziService;

@Controller
public class KheiController {
	@Autowired
	TieziService service;
	@Autowired
	IndexService iservice;
	static int currentPage = 1;//当前页
	static int pageSize = 4;//显示多少条数目
	
	static int currentPage1 = 1;//当前页
	static int pageSize1 = 6;//显示多少条数目
	static int tid = 0;
	
	//帖子分页
		@RequestMapping(value="/kh")
	    public String itemsPage(HttpSession session){
			int totalPage  = (int) Math.ceil((double)service.Countz()/ pageSize);//获取总页数
			List<TzInformation> list = service.findItemByPage(currentPage, pageSize);
			List<TzInformation> tzrm = service.Tzdesc();//热门贴-回复
			List<TzInformation> tzdj = service.TzDjl();//热门贴-点击
			session.setAttribute("Khei", list); 
			//session.setAttribute("EndDate", list.get(list.size()-1).getS_date());
			session.setAttribute("cpg", currentPage);//当前页
			session.setAttribute("zpg", totalPage);
			session.setAttribute("bsf", "qbf");//分区标识符
			if(!list.isEmpty()) {
				session.setAttribute("tzrm", tzrm.get(0));//热门贴-回复
				session.setAttribute("tzdjl", tzdj.get(0));//热门贴-点击
			}
			return "/front/Khei";
		}
	//帖子分页二·精品贴
		@RequestMapping(value="/khjp")
	    public String itemsPagejp(HttpSession session){
			int totalPage  = (int) Math.ceil((double)service.Countz()/ pageSize);//获取总页数
			List<TzInformation> list = service.findItemByPagejp(currentPage, pageSize);
			session.setAttribute("Khei", list); 
			session.setAttribute("cpg", currentPage);//当前页
			session.setAttribute("zpg", totalPage);
			session.setAttribute("bsf", "jpf");//分区标识符
			return "/front/Khei";
		}
	//帖子内容页面&&分页
		@RequestMapping(value="/{s_tid}")
		public String itemsPage(HttpSession session,@PathVariable("s_tid")Integer s_tid){
			List<S_Khei> list = service.LookTzid(s_tid);
			tid = s_tid;
			int s_id = list.get(0).getS_id(); //获取sid
			String S_name = iservice.sId(s_id).get(0).getS_name();//获取用户名
			session.setAttribute("tzzz", S_name);//帖子作者
			session.setAttribute("tzbt", list.get(0).getS_head());//帖子标题
			session.setAttribute("tznr", list.get(0).getS_text());//帖子内容
			session.setAttribute("tztx", iservice.sId(s_id).get(0).getS_txjpg());//帖子作者头像
			//---------------------------分页设置分割线-------------------------------
			int totalPage  = (int) Math.ceil((double)service.CounHf(s_tid)/ pageSize1);//获取总页数
			List<S_Huif> lists = service.HuiFPage(currentPage1, pageSize1, s_tid);
			session.setAttribute("HuiFu", lists);
			session.setAttribute("Khei", list);
			session.setAttribute("s_date", list.get(0).getS_date());
			session.setAttribute("cpg", currentPage1);//当前页
			if(totalPage<=0) {
				session.setAttribute("zpg", 1);
			}else {
			    session.setAttribute("zpg", totalPage);
			}
			System.out.println(service.CounHf(s_tid)+"---------------------------------");
			//------------------------------统计帖子访问量--------------------------------
			Integer s_djl = service.LookTzid(s_tid).get(0).getS_djl();
			s_djl++;
			service.TzDj(s_djl, s_tid);
			return "/front/Kheipg";
        }
		//用户发表帖子
	    @MyAnnotation
		@RequestMapping(value="/UserTz")
		public String UserTz(HttpSession session,String s_head,String s_text) { 
			@SuppressWarnings("unchecked")
			List<S_User> list = (List<S_User>) session.getAttribute("user");
			//当前时间
			Date date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
			String s_date = dateformat.format(date.getTime()).toString();
			//------------------
	        Integer result = service.UserTz(s_head,s_text,list.get(0).getS_id(),s_date);
	        list.get(0).setS_id(result);
	        if(result==1) {
	        	System.out.println("成功是1");
	        }else if(result==0) {
	        	System.out.println("失败是0");
	        }
			return "redirect:kh";
		}
		//用户回帖
	    @MyAnnotation
		@RequestMapping(value="/Huif")
		public String Huif(HttpSession session,String s_htext) {
			@SuppressWarnings("unchecked")
			List<S_User> list = (List<S_User>) session.getAttribute("user");
	        Integer s_id = list.get(0).getS_id();
	      //当前时间
			Date date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
			String s_date = dateformat.format(date.getTime()).toString();
			//------------------
			int result = service.HuiT(s_htext, s_id, tid,s_date);
			if(result==1) {
	        	System.out.println("成功是1");
	        }else if(result==0) {
	        	System.out.println("失败是0");
	        }
			return "redirect:"+tid;
		}
	    //帖子翻页(下
		@RequestMapping(value="/next")
		public String next() {
			int totalPage  = (int) Math.ceil((double)service.Countz()/ pageSize);//获取总页数
			if(currentPage >= totalPage) {
				return "redirect:kh";
			}else {
				currentPage++;
			}
			return "redirect:kh";
		}
		//帖子翻页(上
		@RequestMapping(value="/last")
		public String last() {
			int totalPage  = (int) Math.ceil((double)service.Countz()/ pageSize);//获取总页数
			if(currentPage<=totalPage&&currentPage>=2) {
				currentPage--;
			}else {
				currentPage=1;
			}
			return "redirect:kh";
		}
		
		/* ---------------------------------------------帖子内容分页-------------------------------------------- */
		//帖子翻页(下
		//首页
		@RequestMapping(value="/opg")
		public String opg() {
			//int totalPage  = (int) Math.ceil((double)service.CounHf(tid)/ pageSize1);//获取总页数
				currentPage1=1;
			return "redirect:"+tid;
		}
		//下一页
		@RequestMapping(value="/next1")
		public String next1() {
			int totalPage  = (int) Math.ceil((double)service.CounHf(tid)/ pageSize1);//获取总页数
			if(currentPage1 >= totalPage) {
				return "redirect:"+tid;
			}else {
				currentPage1++;
			}
				return "redirect:"+tid;
			}
		//上一页
		@RequestMapping(value="/last1")
		public String last1() {
			int totalPage  = (int) Math.ceil((double)service.CounHf(tid)/ pageSize1);//获取总页数
			if(currentPage1<=totalPage&&currentPage1>=2) {
				currentPage1--;
			}else {
				currentPage1=1;
			}
				return "redirect:"+tid;
			}
		//尾页
		//上一页
		@RequestMapping(value="/epg")
		public String epg() {
			int totalPage  = (int) Math.ceil((double)service.CounHf(tid)/ pageSize1);//获取总页数
				currentPage1=totalPage;
				return "redirect:"+tid;
			}
}
