package com.csmz.kaoqing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csmz.kaoqing.web.Dept;
import com.csmz.kaoqing.web.MeetingStudent;
import com.csmz.kaoqing.web.Student;
import com.csmz.kaoqing.web.mapper.MeetingStudentMapper;
import com.csmz.kaoqing.web.service.impl.MeetingStudentServiceImpl;
import com.csmz.kaoqing.web.service.impl.StudentServiceImpl;

/**
 * 学生控制器
 * @author Charlene
 *
 */
@RestController
@RequestMapping("/api/v2/student")
public class StudentController {
	
	
	
	@Autowired
	StudentServiceImpl studentimpl;
	
	@Autowired
	MeetingStudentServiceImpl meetingstuserimpl;
	
	@Autowired
	MeetingStudentMapper meetingstumapper;
	
	/**
	 * 添加学生
	 * @param s_no
	 * @param s_name
	 * @param s_class
	 * @param dept
	 * @param s_greed
	 * @param greed_name
	 * @param telephone
	 * @param score
	 * @param onTimes
	 * @param lateTimes
	 * @param outTimes
	 * @param leaveTimes
	 * @return
	 */
	@PostMapping("/add")
	public boolean add(String s_no, String s_name, String s_class, int dept, int s_greed, String greed_name, String telephone, int score, int onTimes, int lateTimes, int outTimes, int leaveTimes) {
		try {
			Dept d = new Dept();
			d.setD_no(dept);
			Student stu = new Student(s_no, s_name, s_class, d, s_greed, greed_name, telephone, score, onTimes, lateTimes, outTimes, leaveTimes);
			studentimpl.save(stu);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 修改学生
	 * @return
	 */
	@PostMapping("/update")
	public boolean update(@RequestBody Student s) {
		try {
			//int score = Integer.parseInt(score_);
			System.out.println(s.toString());
			
			studentimpl.update(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 考勤修改
	 * @param s_no
	 * @param name
	 * @param score
	 * @return
	 */
	
	@PostMapping("/updateScore")
	@Transactional
	public boolean updateScore(int m_no, String s_no, String tagle, String name) {
		try {
			//保存原状态
			MeetingStudent ms = meetingstumapper.loadById(m_no, s_no);
			String old = "";
			
			if("已签到".equals(ms.getTagle())) {
				old = "onTimes";
			}else if("请假".equals(ms.getTagle())) {
				old = "leaveTimes";
			}else if("迟到".equals(ms.getTagle())) {
				old = "lateTimes";
			}else if("缺席".equals(ms.getTagle())) {
				old = "outTimes";
			}
			System.out.println(old);
			ms.setTagle(tagle);
			//更新状态
			meetingstuserimpl.update(ms);
			System.out.println("跟新状态"+s_no+old+name);
			//更新分数
			studentimpl.updateScore(s_no, old, name);
			System.out.println("跟新分数");
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 删除学生
	 * @param s_no
	 * @return
	 */
	@GetMapping("/remove")
	public boolean remove(@RequestParam("s_no") String s_no) {
		System.out.println(s_no);
		try {
			studentimpl.remove(s_no);
			System.out.println("true");
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
}
