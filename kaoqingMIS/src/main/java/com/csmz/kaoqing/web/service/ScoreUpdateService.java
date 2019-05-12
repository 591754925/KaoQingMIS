package com.csmz.kaoqing.web.service;

/**
 * 审核记录的逻辑操作接口
 * @author Charlene
 *
 */
public interface ScoreUpdateService {
	
	/**
	 * 添加审核记录
	 * @param s_no		学号
	 * @param tagle		添加/减少
	 * @param score		更改分数
	 * @param cause		更改原因
	 * @param time		更改时间
	 * @return
	 */
	void save(
			String s_no, 
			String tagle, 
			int score, 
			String cause, 
			String time) throws Exception;
	
	
	/**
	 * 删除审核记录
	 * @param id
	 * @throws Exception
	 */
	void remove(int id) throws Exception;
}
