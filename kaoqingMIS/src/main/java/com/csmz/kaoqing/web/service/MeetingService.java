package com.csmz.kaoqing.web.service;

import com.csmz.kaoqing.web.Meeting;

/**
 * 会议的逻辑操作接口
 * @author Charlene
 *
 */
public interface MeetingService {
	
	/**
	 * 添加会议
	 * @param meeting
	 * @throws Exception
	 */
	void save(Meeting meeting) throws Exception;
	
	
	/**
	 * 修改会议
	 * @param meeting
	 * @throws Exception
	 */
	void update(Meeting meeting) throws Exception;
	

	
	/**
	 * 删除会议
	 * @param admin
	 * @throws Exception
	 */
	void remove(Meeting meeting) throws Exception;
}
