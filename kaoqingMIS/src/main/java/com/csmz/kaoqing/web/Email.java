package com.csmz.kaoqing.web;

import java.util.Date;

public class Email {
	
	/**
	 * 序号
	 */
	private int no;
	
	/**
	 * 账号编号
	 */
	private Admin admin;
	
	/**
	 * 验证码内容
	 */
	private String text;
	
	/**
	 * 时间
	 */
	private Date time;

	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Email [no=" + no + ", admin=" + admin + ", text=" + text + ", time=" + time + "]";
	}
	
	
	
}
