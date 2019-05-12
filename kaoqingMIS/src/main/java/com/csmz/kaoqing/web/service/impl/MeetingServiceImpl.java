package com.csmz.kaoqing.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmz.kaoqing.web.Meeting;
import com.csmz.kaoqing.web.mapper.MeetingMapper;
import com.csmz.kaoqing.web.service.MeetingService;

/**
 * 会议逻辑操作的实现类
 * 实现接口 AdminService
 * @author Charlene
 * 
 */
@Service
public class MeetingServiceImpl implements MeetingService{

	
	@Autowired
	MeetingMapper meetingmapper;
	
	/**
	 * 添加会议
	 */
	@Override
	public void save(Meeting meeting) throws Exception {
		if(meetingmapper.loadById(meeting.getNo()) == null) {
			meetingmapper.save(meeting.getTime(), meeting.getName(), meeting.getAddress());
		}else {
			throw new Exception();
		}
		
		
	}

	/**
	 * 修改会议
	 */
	@Override
	public void update(Meeting meeting) throws Exception {
		if(meetingmapper.loadById(meeting.getNo()) != null) {
			meetingmapper.update(meeting.getNo() ,meeting.getTime(), meeting.getName(), meeting.getAddress());
		}else {
			throw new Exception();
		}
		
	}

	/**
	 * 删除会议
	 */
	@Override
	public void remove(Meeting meeting) throws Exception {
		if(meetingmapper.loadById(meeting.getNo()) != null) {
			meetingmapper.remove(meeting.getNo());
		}else {
			throw new Exception();
		}
		
	}

	
	
}
