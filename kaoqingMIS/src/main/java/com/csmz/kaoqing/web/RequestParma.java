package com.csmz.kaoqing.web;

import java.util.Arrays;

public class RequestParma {
	
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
		return "RequestParma [time=" + time + ", name=" + name + ", address=" + address + ", students="
				+ Arrays.toString(students) + "]";
	}
	
	
	
}
