package com.csmz.kaoqing.web;

import java.util.Arrays;

public class RequestParma {
	
	int no;
	String time;
	String name; 
	String address;
	String [] students;
	public RequestParma() {
		
	}
	
	public RequestParma(String time, String name, String address, String[] students) {
		super();
		this.time = time;
		this.name = name;
		this.address = address;
		this.students = students;
	}

	public RequestParma(int no, String time, String name, String address, String[] students) {
		super();
		this.no = no;
		this.time = time;
		this.name = name;
		this.address = address;
		this.students = students;
	}
	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getStudents() {
		return students;
	}

	public void setStudents(String[] students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "RequestParma [no=" + no + ", time=" + time + ", name=" + name + ", address=" + address + ", students="
				+ Arrays.toString(students) + "]";
	}

	
	
	
}
