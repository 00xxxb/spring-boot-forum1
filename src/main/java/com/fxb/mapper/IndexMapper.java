package com.fxb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fxb.bean.S_User;

@Repository
@Transactional
public interface IndexMapper {

	//查询用户的id,姓名,状态 ；管理员用于修改的
	public List getPermission();
	//禁言用户
	public void banned(Integer s_id);
	//解除禁言
	public void belease(Integer s_id);

	//查询所有用户注册信息
	public List<S_User> getUser();
    //新用户注册
	public int intZc(S_User user);
	//用户登陆
	public List<S_User> login(@Param("s_name") String s_name,@Param("s_password") String s_password);
	//根据用户名查询是否重复
	public List<S_User> sName(String s_name);
	//根据邮箱查询是否重复
	public List<S_User> sEmail(String s_pemail);
	//根据唯一ID查询用户信息
	public List<S_User> sId(int s_id); 
	//用户更新
	public int intUp(S_User user);
	//头像更新
	public int intjpg(@Param("s_txjpg") String s_txjpg,@Param("s_id") int s_id);
}
