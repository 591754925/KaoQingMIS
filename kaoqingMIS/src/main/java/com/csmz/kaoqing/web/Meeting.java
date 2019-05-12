package com.csmz.kaoqing.web;

import java.util.List;

/**
 * 会议实体类
 * @author yhj
 * @date 2018年12月28日 下午3:45:33
 *
 */
public class Meeting {
	/**
	 * 会议编号
	 */
	private int no;
	/**
	 * 会议时间
	 */
	private String time;
	/**
	 * 会议名称
	 */
	private String name;
	/**
	 * 会议地点
	 */
	private String address;
	
	private List<MeetingStudent> students;
	
	public Meeting() {
		
	}

	
	

	public Meeting(String time, String name, String address) {
		super();
		this.time = time;
		this.name = name;
		this.address = address;
	}




	public List<MeetingStudent> getStudents() {
		return students;
	}


	public void setStudents(List<MeetingStudent> students) {
		this.students = students;
	}


	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Meeting [no=" + no + ", time=" + time + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
}
