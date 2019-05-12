package com.csmz.kaoqing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csmz.kaoqing.web.Meeting;
import com.csmz.kaoqing.web.MeetingStudent;
import com.csmz.kaoqing.web.RequestParma;
import com.csmz.kaoqing.web.Student;
import com.csmz.kaoqing.web.mapper.MeetingMapper;
import com.csmz.kaoqing.web.mapper.StudentMapper;
import com.csmz.kaoqing.web.service.impl.MeetingServiceImpl;
import com.csmz.kaoqing.web.service.impl.MeetingStudentServiceImpl;

/**
 * 
 * @author Charlene
 *
 */
@RestController
@RequestMapping("/api/v2/meeting")
public class MeetingController {
	
	@Autowired
	MeetingMapper meetingmapper;
	
	@Autowired
	StudentMapper studentmapper;
	
	@Autowired
	MeetingServiceImpl meetingserviceimpl;
	
	@Autowired
	MeetingStudentServiceImpl meetingstudentserviceimpl;
	
	/**
	 * 添加会议
	 * @param d_name
	 * @return
	 */
	@PostMapping("/add")
	@Transactional
	public boolean addMeeting(@RequestBody RequestParma rp) {
		
		Meeting meeting = new Meeting(rp.getTime(), rp.getName(), rp.getAddress());
		try {
			meetingserviceimpl.save(meeting);
			
			int id= meetingmapper.loadNew();
			System.out.println(id);
			//循环写入会议学生，默认状态为缺席
			for(int i = 0; i< rp.getStudents().length; i++) {
				Student stu = new Student();
				stu.setS_no(rp.getStudents()[i]);
				MeetingStudent mstu = new MeetingStudent(id, stu, "缺席");
				meetingstudentserviceimpl.save(mstu);
				studentmapper.outTimes(rp.getStudents()[i], 1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@PostMapping("/update")
	@Transactional
	public boolean updateDept(@RequestBody RequestParma rp) {
		
		
		Meeting meeting = new Meeting(rp.getTime(), rp.getName(), rp.getAddress());
		try {
			meetingserviceimpl.update(meeting);
			
			
			//meetingstudentserviceimpl.update(ms);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	
	public boolean removeDept(int no) {
		
		Meeting meeting = new Meeting();
		meeting.setNo(no);
		try {
			meetingserviceimpl.remove(meeting);
			
			//meetingstudentserviceimpl.update(ms);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
}
