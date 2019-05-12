package com.csmz.kaoqing.web.service;

import com.csmz.kaoqing.web.Student;

/**
 * 学生类的逻辑操作接口
 * @author Charlene
 *
 */
public interface StudentService {
	
	/**
	 * 添加学生
	 * @param stu
	 */
	void save(Student stu) throws Exception;
	
	/**
	 * 修改学生
	 * @param stu
	 * @throws Exception
	 */
	void update(Student stu) throws Exception;
	
	
	/**
	 * 考勤修改
	 * @param s_no
	 * @param name
	 * @param socre
	 * @throws Exception
	 */
	void updateScore(String s_no, String old ,String name) throws Exception;
	
	
	/**
	 * 删除学生
	 * @throws Exception
	 */
	void remove(String s_no) throws Exception;
	
}
