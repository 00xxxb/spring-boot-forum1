package com.fxb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxb.bean.S_User;
import com.fxb.mapper.IndexMapper;

@Service
public class IndexService {
	@Autowired
	IndexMapper mapper;

	//查询用户的id,姓名,状态 ；管理员用于修改的
	public List getPermission(){
		List list =  mapper.getPermission();
		return  list;
	}
	//禁言用户
	public void banned(Integer s_tid){
		mapper.banned(s_tid);
	}
	//解除禁言
	public void belease(Integer s_tid){
		mapper.belease(s_tid);
	}

	//获取用户注册信息
	public List<S_User> getUser(){
	    List<S_User> list = mapper.getUser();
		return list;
	}
	//新用户注册
	public int intZc(S_User user){
		return mapper.intZc(user); 
	}
	//用户登陆
	public List<S_User> login(String s_name,String s_password) {
		List<S_User> list = mapper.login(s_name,s_password);
		return list; 
	}
	//根据用户名查询
	public List<S_User> sName(String s_name){
		List<S_User> list = mapper.sName(s_name);
		return list;
	}
	//根据邮箱查询
	public List<S_User> sEmail(String s_pemail){
		List<S_User> list = mapper.sEmail(s_pemail);
		return list;
	}
	//根据唯一ID查询用户信息
	public List<S_User> sId(int s_id){
		List<S_User> list = mapper.sId(s_id);
		return list;
	}
	//用户更新
	public int intUp(S_User user) {
		int result = mapper.intUp(user);
		return result;
	}
	//头像更新
	public int intjpg(String s_txjpg,int s_id) {
		int result = mapper.intjpg(s_txjpg,s_id);
		return result;
	}
}