package com.csmz.kaoqing.web;
/**
 * 账号实体类
 * @author yhj
 * @date 2018年12月28日 上午11:51:25
 *
 */
public class Admin {
	/**
	 * 账号编号
	 */
	private int id;
	/**
	 * 账号
	 */
	private String userid;
	/**
	 * 账号身份
	 */
	private String username;
	
	public Admin() {
		
	}
	
	/**
	 * @param id
	 * @param userid
	 * @param username
	 */
	public Admin(int id, String userid, String username) {
		super();
		this.id = id;
		this.userid = userid;
		this.username = username;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Admin [id=" + id + ", userid=" + userid + ", username=" + username + "]";
	}
	
	
	
}
