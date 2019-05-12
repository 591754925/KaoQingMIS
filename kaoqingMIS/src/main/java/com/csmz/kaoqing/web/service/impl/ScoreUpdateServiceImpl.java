package com.csmz.kaoqing.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csmz.kaoqing.web.Student;
import com.csmz.kaoqing.web.mapper.ScoreMapper;
import com.csmz.kaoqing.web.mapper.StudentMapper;
import com.csmz.kaoqing.web.service.ScoreUpdateService;

/**
 * 审核记录逻辑操作的实现类
 * 实现接口 AdminService
 * @author Charlene
 * 
 */
@Service
public class ScoreUpdateServiceImpl implements ScoreUpdateService{

	@Autowired
	ScoreMapper scoremapper;
	
	@Autowired
	StudentMapper studentmapper;
	
	/**
	 * 添加审核记录
	 * @throws Exception 
	 */
	@Override
	@Transactional
	public void save(String s_no, String tagle, int score, String cause, String time) throws Exception {
		
		Student stu  = studentmapper.loadById(s_no);
		
		if(stu == null) {	//判断该学生是否存在
			throw new Exception();
		}else{
			if(tagle.equals("add")) {	//添加分数记录
				scoremapper.save(s_no, stu.getScore(), score, cause, 0, null, time);
				studentmapper.updateScoreById(s_no, score);
			}else if(tagle.equals("del")) {		//减少分数记录
				scoremapper.save(s_no, stu.getScore(), 0, null, score, cause, time);
				studentmapper.updateScoreById(s_no, -score);
			}
		}
		
	}

	/**
	 * 删除审核记录
	 */
	@Override
	public void remove(int id) throws Exception {
		if(scoremapper.remove(id)) {
			
		}else {
			throw new Exception();
		}
		
		
	}
	
	
}
