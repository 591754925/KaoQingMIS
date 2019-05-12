package com.csmz.kaoqing.web.service;

import com.csmz.kaoqing.web.MeetingStudent;

/**
 * 会议成员的逻辑操作接口
 * @author Charlene
 *
 */
public interface MeetingStudentService {
	
	/**
	 * 添加会议成员
	 * @param mstudent
	 * @throws Exception
	 */
	void save(MeetingStudent mstudent) throws Exception;
	
	
	/**
	 * 修改会议成员
	 * @param mstudent
	 * @throws Exception
	 */
	void update(MeetingStudent mstudent) throws Exception;
	

	
	/**
	 * 删除会议成员
	 * @param mstudent
	 * @throws Exception
	 */
	void remove(MeetingStudent mstudent) throws Exception;
}
