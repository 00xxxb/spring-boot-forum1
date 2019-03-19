package com.lfd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lfd.bean.PageBean;
import com.lfd.bean.S_Huif;
import com.lfd.bean.S_Khei;
import com.lfd.bean.S_User;
import com.lfd.bean.TzInformation;
import com.lfd.mapper.TieziMapper;

@Service
public class TieziService {
	@Autowired
	TieziMapper mapper;

	//所有帖子&内容
    public List<S_Khei> LookTz(){
    	List<S_Khei> list = mapper.LookTz();
    	return list;
    }
    //查询所有帖子数量
    public Integer Countz() {
    	Integer result = mapper.ConutTz();
    	return result;
    }
  //查询当前帖子回复数量
    public Integer CounHf(Integer s_tid) {
    	Integer result = mapper.CountHf(s_tid);
    	return result;
    }
    //根据帖子ID查询帖子所有信息
    public List<S_Khei> LookTzid(Integer s_tid){
    	List<S_Khei> list = mapper.LookTzid(s_tid);
    	return list;
    }
    //查询帖子所有信息
    public List<TzInformation> Tzif(){
    	List<TzInformation> list = mapper.Tzif();
    	return list; 
    } 
    //热门排序-回复
    public List<TzInformation>  Tzdesc(){
    	List<TzInformation> list = mapper.Tzdesc();
    	return list;
    }
    //热门排序-点击
    public List<TzInformation>  TzDjl(){
    	List<TzInformation> list = mapper.TzDjl();
    	return list;
    }
    //查询精品帖子所有信息
    public List<TzInformation> tzjp(){
    	List<TzInformation> list = mapper.Tzif();
    	return list;
    }
    //用户发表帖子
    public Integer UserTz(String s_head,String s_text,Integer s_id,String s_date) {
    	int result = mapper.UserTz(s_head,s_text,s_id,s_date);
    	return result;
    }
    //查询单个帖子所有回复
    public List<S_Huif> LookHf(int s_tid){
    	List<S_Huif> list = mapper.LookHf(s_tid);
    	return list;
    }
    //回复帖子
    public Integer HuiT(String s_htext,Integer s_id,Integer s_tid,String s_date){
    	int result = mapper.HuiT(s_htext, s_id, s_tid,s_date);
    	return result;
    }
    //用户删帖帖子
    public Integer DeTz(Integer s_tid) {
    	int result = mapper.DeTz(s_tid);
    	//当前回复一并删除
    	mapper.Detzh(s_tid);
    	return result;
    }
    //用户删除帖子回复 
    public Integer DeHf(Integer s_hid) {
    	int result = mapper.DeHf(s_hid);
    	return result;
    }
    //更新帖子点击量
    public Integer TzDj(Integer s_djl,Integer s_tid) {
    	int result = mapper.TzDj(s_djl, s_tid);
    	return result;
    }
    //PageHelper分页-主贴界面分页
	public List<TzInformation> findItemByPage(int currentPage,int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数<记住：必须在mapper接口中的方法执行之前设置该分页信息>
        PageHelper.startPage(currentPage, pageSize);//(开始的页面，一页显示多少列)
        List<TzInformation> allItems = mapper.Tzif();  //全部帖子
        int countNums = mapper.ConutTz();        //总记录数
        PageBean<TzInformation> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);
        return pageData.getItems(); 
    }
	//PageHelper分页-主贴界面分页二-精品贴
		public List<TzInformation> findItemByPagejp(int currentPage,int pageSize) {
	        //设置分页信息，分别是当前页数和每页显示的总记录数<记住：必须在mapper接口中的方法执行之前设置该分页信息>
	        PageHelper.startPage(currentPage, pageSize);//(开始的页面，一页显示多少列)
	        List<TzInformation> allItems = mapper.tzjp();  //全部帖子
	        int countNums = mapper.ConutTz();        //总记录数
	        PageBean<TzInformation> pageData = new PageBean<>(currentPage, pageSize, countNums);
	        pageData.setItems(allItems);
	        return pageData.getItems(); 
	    }
	 //PageHelper分页-回复量分页
		public List<S_Huif> HuiFPage(int currentPage,int pageSize,int s_tid) {
	        //设置分页信息，分别是当前页数和每页显示的总记录数<记住：必须在mapper接口中的方法执行之前设置该分页信息>
	        PageHelper.startPage(currentPage, pageSize);//(开始的页面，一页显示多少列)
	        List<S_Huif> allItems = mapper.LookHf(s_tid);  //全部帖子
	        int countNums = mapper.CountHf(s_tid);        //总记录数
	        PageBean<S_Huif> pageData = new PageBean<>(currentPage, pageSize, countNums);
	        pageData.setItems(allItems);
	        return pageData.getItems(); 
	    }
}
