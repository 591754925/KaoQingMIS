package com.csmz.kaoqing.web;

import java.util.List;

/**
 * 部门实体类
 * @author yhj
 * @date 2018年12月28日 下午3:44:39
 *
 */
public class Dept {
	/**
	 * 部门编号
	 */
	private int d_no;
	/**
	 * 部门名称
	 */
	private String d_name;
	
	/**
	 * 学生列表
	 */
	private List<Student> student;
	
	public Dept() {
		
	}
	
	public Dept(int d_no, String d_name) {
		super();
		this.d_no = d_no;
		this.d_name = d_name;
	}

	public int getD_no() {
		return d_no;
	}

	public void setD_no(int d_no) {
		this.d_no = d_no;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Dept [d_no=" + d_no + ", d_name=" + d_name + "]";
	}
	
	
	
	
	
}
