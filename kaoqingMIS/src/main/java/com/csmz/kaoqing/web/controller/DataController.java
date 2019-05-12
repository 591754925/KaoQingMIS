package com.csmz.kaoqing.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csmz.kaoqing.web.Admin;
import com.csmz.kaoqing.web.Dept;
import com.csmz.kaoqing.web.Meeting;
import com.csmz.kaoqing.web.ScoreUpdate;
import com.csmz.kaoqing.web.mapper.AdminMapper;
import com.csmz.kaoqing.web.mapper.DeptMapper;
import com.csmz.kaoqing.web.mapper.MeetingMapper;
import com.csmz.kaoqing.web.mapper.ScoreMapper;

/**
 * 数据获取控制器
 * @author Charlene
 *
 */
@RestController
@RequestMapping("/api/v2/data")
public class DataController {
	
	@Autowired
	DeptMapper deptmapper;
	
	@Autowired
	ScoreMapper scoremapper;
	
	@Autowired
	MeetingMapper meetingmapper;
	
	@Autowired
	AdminMapper adminmapper;
	
	/**
	 * 获取部门列表
	 * @return
	 */
	@GetMapping("/deptlist")
	public List<Dept> deptlist() {
		
		return deptmapper.list();
	}
	
	/**
	 * 获取审核记录列表
	 * @return
	 */
	@GetMapping("/scorelist")
	public List<ScoreUpdate> scorelist() {
		
		return scoremapper.list();
	}
	
	
	/**
	 * 获取会议列表
	 * @return
	 */
	@GetMapping("/meetinglist")
	public List<Meeting> meetinglist() {
		
		return meetingmapper.list();
	}
	
	/**
	 * 获取账号列表
	 * @return
	 */
	@GetMapping("/adminlist")
	public List<Admin> adminlist(){
		
		return adminmapper.list();
	}
	
	
	
	
	
}
