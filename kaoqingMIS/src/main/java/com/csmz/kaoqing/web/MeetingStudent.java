package com.csmz.kaoqing.web;
/**
 * 会议成员实体类
 * @author yhj
 * @date 2018年12月28日 下午3:44:39
 *
 */
public class MeetingStudent {
	/**
	 * 会议编号
	 */
	private int m_no;
	/**
	 * 学生学号
	 */
	private Student student;
	/**
	 * 状态
	 */
	private String tagle;
	
	
	public MeetingStudent() {
		
	}
	
	

	public MeetingStudent(int m_no, Student student, String tagle) {
		super();
		this.m_no = m_no;
		this.student = student;
		this.tagle = tagle;
	}




	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}


	public String getTagle() {
		return tagle;
	}

	public void setTagle(String tagle) {
		this.tagle = tagle;
	}



	@Override
	public String toString() {
		return "MeetingStudent [m_no=" + m_no + ", student=" + student + ", tagle=" + tagle + "]";
	}

	
	
	
}
