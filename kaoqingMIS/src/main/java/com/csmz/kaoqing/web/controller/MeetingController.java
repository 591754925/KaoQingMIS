package com.csmz.kaoqing.web.controller;

import java.util.List;

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
import com.csmz.kaoqing.web.mapper.MeetingStudentMapper;
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
	MeetingStudentMapper meetingstudentmapper;
	
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
			for(int i = 0; i < rp.getStudents().length; i++) {
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
	
	/**
	 * 修改会议
	 * @param rp
	 * @return
	 */
	@PostMapping("/update")
	@Transactional
	public boolean updateDept(@RequestBody RequestParma rp) {
		System.out.println(rp.toString());
		//获取原会议人员
		List<MeetingStudent> list = meetingstudentmapper.list(rp.getNo());
		
		Meeting meeting = new Meeting(rp.getNo(), rp.getTime(), rp.getName(), rp.getAddress());
		try {
			meetingserviceimpl.update(meeting);
			//循环确认会议学生，存在就不做修改，不存在就添加
			for(int i = 0; i < rp.getStudents().length; i++) {
				boolean tagle = false;
				for(int j = 0; j < list.size(); j++) {
					if(rp.getStudents()[i].equals(list.get(j).getStudent().getS_no())) {
						tagle = true;
						System.out.println(rp.getStudents()[i]+"存在");
					}
				}
				if(!tagle) {
					System.out.println(rp.getStudents()[i]+"添加");
					Student stu = new Student();
					stu.setS_no(rp.getStudents()[i]);
					MeetingStudent mstu = new MeetingStudent(rp.getNo(), stu, "缺席");
					meetingstudentserviceimpl.save(mstu);
					studentmapper.outTimes(rp.getStudents()[i], 1);
				}
				
			}
			//判断哪些会议成员被移除了
			for(int j = 0; j < list.size(); j++) {
				boolean tagle = true;
				for(int i = 0; i < rp.getStudents().length; i++) {
					if(list.get(j).getStudent().getS_no().equals(rp.getStudents()[i])) {
						tagle = false;
					}
				}
				if(tagle) {
					if("已签到".equals(list.get(j).getTagle())) {
						studentmapper.onTimes(list.get(j).getStudent().getS_no(), -1);
						System.out.println(list.get(j).getStudent().getS_no()+"已签到 -1");
					}else if("迟到".equals(list.get(j).getTagle())) {
						studentmapper.lateTimes(list.get(j).getStudent().getS_no(), -1);
						System.out.println(list.get(j).getStudent().getS_no()+"迟到 -1");
					}else if("请假".equals(list.get(j).getTagle())) {
						studentmapper.leaveTimes(list.get(j).getStudent().getS_no(), -1);
						System.out.println(list.get(j).getStudent().getS_no()+"请假 -1");
					}else if("缺席".equals(list.get(j).getTagle())) {
						studentmapper.outTimes(list.get(j).getStudent().getS_no(), -1);
						System.out.println(list.get(j).getStudent().getS_no()+"缺席 -1");
					}
					
					meetingstudentserviceimpl.remove(list.get(j));
					
				}
			}
			//meetingstudentserviceimpl.update(ms);
		} catch (Exception e) {
			e.printStackTrace();
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
