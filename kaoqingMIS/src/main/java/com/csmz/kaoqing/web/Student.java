package com.csmz.kaoqing.web;
/**
 * 学生实体类
 * @author yhj
 * @date 2018年12月28日 下午3:42:47
 *
 */
public class Student {
	/**
	 * 学号
	 */
	private String s_no;
	/**
	 * 姓名
	 */
	private String s_name;
	/**
	 * 班级
	 */
	private String s_class;
	/**
	 * 部门
	 */
	private Dept dept;
	/**
	 * 部门职位
	 */
	private int s_greed;
	/**
	 * 职位名称
	 */
	private String greed_name;
	
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 分数
	 */
	private int score;
	
	/**
	 * 签到次数
	 */
	private int onTimes;
	/**
	 * 迟到次数
	 */
	private int lateTimes;
	/**
	 * 缺勤次数
	 */
	private int outTimes;
	/**
	 * 请假次数
	 */
	private int leaveTimes;
	
	public Student() {
		
	}
	
	

	public Student(String s_no, String s_name, String s_class, Dept dept, int s_greed, String greed_name,
			String telephone, int score, int onTimes, int lateTimes, int outTimes, int leaveTimes) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_class = s_class;
		this.dept = dept;
		this.s_greed = s_greed;
		this.greed_name = greed_name;
		this.telephone = telephone;
		this.score = score;
		this.onTimes = onTimes;
		this.lateTimes = lateTimes;
		this.outTimes = outTimes;
		this.leaveTimes = leaveTimes;
	}



	public String getGreed_name() {
		return greed_name;
	}

	public void setGreed_name(String greed_name) {
		this.greed_name = greed_name;
	}

	public String getS_no() {
		return s_no;
	}

	public void setS_no(String s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_class() {
		return s_class;
	}

	public void setS_class(String s_class) {
		this.s_class = s_class;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public int getS_greed() {
		return s_greed;
	}

	public void setS_greed(int s_greed) {
		this.s_greed = s_greed;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getOnTimes() {
		return onTimes;
	}

	public void setOnTimes(int onTimes) {
		this.onTimes = onTimes;
	}

	public int getLateTimes() {
		return lateTimes;
	}

	public void setLateTimes(int lateTimes) {
		this.lateTimes = lateTimes;
	}

	public int getOutTimes() {
		return outTimes;
	}

	public void setOutTimes(int outTimes) {
		this.outTimes = outTimes;
	}

	public int getLeaveTimes() {
		return leaveTimes;
	}

	public void setLeaveTimes(int leaveTimes) {
		this.leaveTimes = leaveTimes;
	}

	@Override
	public String toString() {
		return "Student [s_no=" + s_no + ", s_name=" + s_name + ", s_class=" + s_class + ", dept=" + dept + ", s_greed="
				+ s_greed + ", telephone=" + telephone + ", score=" + score + ", onTimes=" + onTimes + ", lateTimes="
				+ lateTimes + ", outTimes=" + outTimes + ", leaveTimes=" + leaveTimes + "]";
	}
	
	
	
	
}
