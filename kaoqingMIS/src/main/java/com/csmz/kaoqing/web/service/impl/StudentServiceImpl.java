package com.csmz.kaoqing.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmz.kaoqing.web.Student;
import com.csmz.kaoqing.web.mapper.StudentMapper;
import com.csmz.kaoqing.web.service.StudentService;

/**
 * 学生逻辑操作的实现类
 * 实现接口 StudentService
 * @author Charlene
 * 
 */
@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentMapper studentmapper;
	
	
	/**
	 * 添加学生
	 */
	@Override
	public void save(Student stu) throws Exception {
		
		if(studentmapper.loadById(stu.getS_no()) == null) {
			studentmapper.save(stu);
		}else{
			throw new Exception();
		}
		
	}

	/**
	 * 修改学生
	 */
	@Override
	public void update(Student stu) throws Exception {
		if(studentmapper.loadById(stu.getS_no()) != null) {
			studentmapper.updateStudent(stu);
		}else{
			throw new Exception();
		}
		
	}
	
	
	/**
	 * 删除学生
	 */
	@Override
	public void remove(String s_no) throws Exception {
		
		if(studentmapper.loadById(s_no) != null) {
			studentmapper.remove(s_no);
		}else{
			throw new Exception();
		}
	}

	
	/**
	 * 考勤修改
	 */
	@Override
	public void updateScore(String s_no, String old, String name) throws Exception {
		
		if(studentmapper.loadById(s_no) != null) {
			System.out.println(s_no);
			
			//新状态修改
			if("onTimes".equals(name)) {
				studentmapper.onTimes(s_no, 1);
			}else if("leaveTimes".equals(name)) {
				studentmapper.leaveTimes(s_no, 1);
			}else if("lateTimes".equals(name)) {
				studentmapper.lateTimes(s_no, 1);
			}else if("outTimes".equals(name)) {
				studentmapper.outTimes(s_no, 1);
			}
			
			//原状态撤回
			if("onTimes".equals(old)) {
				studentmapper.onTimes(s_no, -1);
			}else if("leaveTimes".equals(old)) {
				studentmapper.leaveTimes(s_no, -1);
			}else if("lateTimes".equals(old)) {
				studentmapper.lateTimes(s_no, -1);
			}else if("outTimes".equals(old)) {
				studentmapper.outTimes(s_no, -1);
			}
			
//			//新字段增加
//			studentmapper.updateScore(s_no, name, 1);
//			
//			//原状态撤回
//			System.out.println(old);
//			studentmapper.updateScore(s_no, old, -1);
			
			
		}else{
			throw new Exception();
		}
	}
	
	
	
	
}
