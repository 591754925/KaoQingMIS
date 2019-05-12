package com.csmz.kaoqing.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmz.kaoqing.web.MeetingStudent;
import com.csmz.kaoqing.web.mapper.MeetingStudentMapper;
import com.csmz.kaoqing.web.service.MeetingStudentService;

/**
 * 会议成员逻辑操作的实现类
 * 实现接口 AdminService
 * @author Charlene
 * 
 */
@Service
public class MeetingStudentServiceImpl implements MeetingStudentService{

	
	@Autowired
	MeetingStudentMapper meetingstudentmapper;
	
	/**
	 * 添加会议成员
	 */
	@Override
	public void save(MeetingStudent ms) throws Exception {
		if(meetingstudentmapper.loadById(ms.getM_no(), ms.getStudent().getS_no()) == null) {
			meetingstudentmapper.save(ms.getM_no(), ms.getStudent().getS_no(), ms.getTagle());
			
		}else {
			throw new Exception();
		}
		
		
	}

	/**
	 * 修改会议成员
	 */
	@Override
	public void update(MeetingStudent ms) throws Exception {
		if(meetingstudentmapper.loadById(ms.getM_no(), ms.getStudent().getS_no()) != null) {
			meetingstudentmapper.update(ms.getM_no(), ms.getStudent().getS_no(), ms.getTagle());
		}else {
			throw new Exception();
		}
		
	}

	/**
	 * 删除会议成员
	 */
	@Override
	public void remove(MeetingStudent ms) throws Exception {
		if(meetingstudentmapper.loadById(ms.getM_no(), ms.getStudent().getS_no()) != null) {
			meetingstudentmapper.remove(ms.getM_no(), ms.getStudent().getS_no());
		}else {
			throw new Exception();
		}
		
	}

	
	
}
