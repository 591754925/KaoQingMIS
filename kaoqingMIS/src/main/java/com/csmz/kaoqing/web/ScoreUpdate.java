package com.csmz.kaoqing.web;
/**
 * 审核记录实体类
 * @author yhj
 * @date 2018年12月28日 下午3:45:04
 *
 */
public class ScoreUpdate {
	
	/**
	 * 编号
	 */
	private int id;
	/**
	 * 学号
	 */
	private Student student;
	/**
	 * 分数
	 */
	private int score;
	/**
	 * 加分
	 */
	private int addScore;
	/**
	 * 加分原因
	 */
	private String addCause;
	/**
	 * 减分
	 */
	private int delScore;
	/**
	 * 减分原因
	 */
	private String delCause;
	/**
	 * 时间
	 */
	private String time;
	
	
	public ScoreUpdate() {
		
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param 
	 */
	public void setId(int id) {
		this.id = id;
	}
	

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}


	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}


	/**
	 * @return the addScore
	 */
	public int getAddScore() {
		return addScore;
	}


	/**
	 * @param addScore the addScore to set
	 */
	public void setAddScore(int addScore) {
		this.addScore = addScore;
	}


	/**
	 * @return the addCause
	 */
	public String getAddCause() {
		return addCause;
	}


	/**
	 * @param addCause the addCause to set
	 */
	public void setAddCause(String addCause) {
		this.addCause = addCause;
	}


	/**
	 * @return the delScore
	 */
	public int getDelScore() {
		return delScore;
	}


	/**
	 * @param delScore the delScore to set
	 */
	public void setDelScore(int delScore) {
		this.delScore = delScore;
	}


	/**
	 * @return the delCause
	 */
	public String getDelCause() {
		return delCause;
	}


	/**
	 * @param delCause the delCause to set
	 */
	public void setDelCause(String delCause) {
		this.delCause = delCause;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ScoreUpdate [student=" + student + ", score=" + score + ", addScore=" + addScore + ", addCause=" + addCause
				+ ", delScore=" + delScore + ", delCause=" + delCause + ", time=" + time + "]";
	}
	
	
	
	
}
