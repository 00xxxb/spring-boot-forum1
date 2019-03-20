package com.lfd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lfd.bean.S_Huif;
import com.lfd.bean.S_Khei;
import com.lfd.bean.S_User;
import com.lfd.bean.TzInformation;

@Repository
@Transactional
public interface TieziMapper {



    //查询所有帖子
	public List<S_Khei> LookTz(); 
	//查询共有多少个帖子  
	public Integer ConutTz();
	//查询共有多少个回复贴 
	public Integer CountHf(Integer s_tid);
	//根据帖子ID查询帖子所有信息
	public List<S_Khei> LookTzid(Integer s_tid); 
	//查询帖子所有信息 
	public List<TzInformation> Tzif();
	//查询所有精品帖子
	public List<TzInformation> tzjp();
	//用户发布帖子
	public Integer UserTz(@Param("s_head") String s_head, @Param("s_text") String s_text,@Param("s_id") Integer s_id, @Param("s_date") String s_date);
	//查询当前帖子所有回复内容
	public List<S_Huif> LookHf(int s_tid);
	//回复帖子
	public Integer HuiT(@Param("s_htext") String s_htext,@Param("s_id") Integer s_id,@Param("s_tid") Integer s_tid,@Param("s_date") String s_date);
	//用户删除自己的帖子
	public Integer DeTz(Integer s_tid);
	//楼主删除主帖时所有回复一并删除
	public Integer Detzh(Integer s_tid);
	//用户删除自己的回复
	public Integer DeHf(Integer s_hid);
	//热门排序-回复
	public List<TzInformation> Tzdesc();
	//热门排序-点击
    public List<TzInformation> TzDjl();
	//更新帖子点击量
	public Integer TzDj(@Param("s_djl") Integer s_djl,@Param("s_tid") Integer s_tid);
}
