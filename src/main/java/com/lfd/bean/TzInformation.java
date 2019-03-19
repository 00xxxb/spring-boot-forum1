package com.lfd.bean;

public class TzInformation {
	private int s_id;//唯一ID
	private String s_name;//昵称
	private String s_password;//密码
	private String s_pnum;//电话号码
	private String s_pemail;//电子邮箱
	private int s_tid;//帖子ID
	private String s_head;//标题
	private String s_text;//内容
	private String s_date;//发帖时间
	private Integer s_jp;//是否精品
	private Integer sl;//回复数统计量
	private Integer s_djl;//帖子点击量
	private String s_txjpg;//头像
	private String edate;//最后回复时间
	
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getS_txjpg() {
		return s_txjpg;
	}
	public void setS_txjpg(String s_txjpg) {
		this.s_txjpg = s_txjpg;
	}
	public Integer getS_djl() {
		return s_djl;
	}
	public void setS_djl(Integer s_djl) {
		this.s_djl = s_djl;
	}
	public Integer getSl() {
		return sl;
	}
	public void setSl(Integer sl) {
		this.sl = sl;
	}
	public Integer getS_jp() {
		return s_jp;
	}
	public void setS_jp(Integer s_jp) {
		this.s_jp = s_jp;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_password() {
		return s_password;
	}
	public void setS_password(String s_password) {
		this.s_password = s_password;
	}
	public String getS_pnum() {
		return s_pnum;
	}
	public void setS_pnum(String s_pnum) {
		this.s_pnum = s_pnum;
	}
	public String getS_pemail() {
		return s_pemail;
	}
	public void setS_pemail(String s_pemail) {
		this.s_pemail = s_pemail;
	}
	public int getS_tid() {
		return s_tid;
	}
	public void setS_tid(int s_tid) {
		this.s_tid = s_tid;
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
		return "TzInformation [s_id=" + s_id + ", s_name=" + s_name + ", s_password=" + s_password + ", s_pnum="
				+ s_pnum + ", s_pemail=" + s_pemail + ", s_tid=" + s_tid + ", s_head=" + s_head + ", s_text=" + s_text
				+ ", s_date=" + s_date + ", s_jp=" + s_jp + ", sl=" + sl + ", s_djl=" + s_djl + "]";
	}
	
    
}
