package com.lfd.bean;

import java.io.Serializable;

public class S_Huif implements Serializable{
	private Integer s_tid;//当前帖子ID
	private Integer s_id;//回帖人ID
	private String s_htext;//回复内容
	private Integer s_hid;//回复ID
	private String s_name;//回复用户昵称
	private String s_date;//发帖日期
	private String s_txjpg;//头像地址
	
	
	public String getS_txjpg() {
		return s_txjpg;
	}
	public void setS_txjpg(String s_txjpg) {
		this.s_txjpg = s_txjpg;
	}
	public Integer getS_tid() {
		return s_tid;
	}
	public void setS_tid(Integer s_tid) {
		this.s_tid = s_tid;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public String getS_htext() {
		return s_htext;
	}
	public void setS_htext(String s_htext) {
		this.s_htext = s_htext;
	}
	public Integer getS_hid() {
		return s_hid;
	}
	public void setS_hid(Integer s_hid) {
		this.s_hid = s_hid;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	@Override
	public String toString() {
		return "S_Huif [s_tid=" + s_tid + ", s_id=" + s_id + ", s_htext=" + s_htext + ", s_hid=" + s_hid + ", s_name="
				+ s_name + ", s_date=" + s_date + "]";
	}
    
}
