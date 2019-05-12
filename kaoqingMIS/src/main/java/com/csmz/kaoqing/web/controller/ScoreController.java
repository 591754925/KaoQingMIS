package com.csmz.kaoqing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csmz.kaoqing.web.service.impl.ScoreUpdateServiceImpl;

/**
 * 审核记录控制器
 * @author Charlene
 *
 */
@RestController
@RequestMapping("/api/v2/score")
public class ScoreController {
	
	@Autowired
	ScoreUpdateServiceImpl scoreupdateimpl;
	
	/**
	 * 添加审核记录
	 * @param s_no		学号
	 * @param tagle		添加/减少
	 * @param score		更改分数
	 * @param cause		更改原因
	 * @param time		更改时间
	 * @return
	 */
	@PostMapping("/add")
	public boolean scoreupdate(String s_no, String tagle, int score, String cause, String time) {
		
		try {
			scoreupdateimpl.save(s_no, tagle, score, cause, time);
		} catch (Exception e) {
			System.out.println("没有该学生");
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 删除审核记录
	 * @param id
	 * @return
	 */
	@PostMapping("/remove")
	public boolean remove(int id) {
		try {
			scoreupdateimpl.remove(id);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
}
