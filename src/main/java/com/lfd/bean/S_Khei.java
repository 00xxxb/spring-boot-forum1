package com.lfd.bean;

import java.io.Serializable;

public class S_Khei implements Serializable{
	private int s_tid;//帖子ID
	private int s_id;//用户ID
	private String s_head;//标题
	private String s_text;//内容
	private String s_date;//发帖日期
	private Integer s_djl;//点击量
	
	public Integer getS_djl() {
		return s_djl;
	}
	public void setS_djl(Integer s_djl) {
		this.s_djl = s_djl;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public int getS_tid() {
		return s_tid;
	}
	public void setS_tid(int s_tid) {
		this.s_tid = s_tid;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_head() {
		return s_head;
	}
	public void setS_head(String s_head) {
		this.s_head = s_head;
	}
	public String getS_text() {
		return s_text;
	}
	public void setS_text(String s_text) {
		this.s_text = s_text;
	}
	@Override
	public String toString() {
		return "S_Khei [s_tid=" + s_tid + ", s_id=" + s_id + ", s_head=" + s_head + ", s_text=" + s_text + ", s_date="
				+ s_date + "]";
	}
}
