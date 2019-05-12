package com.csmz.kaoqing.web.service;


/**
 * 账号的逻辑操作接口
 * @author Charlene
 *
 */
public interface DeptService {
	
	/**
	 * 添加部门
	 * @param d_name
	 * @throws Exception
	 */
	void save(String d_name) throws Exception;
	
	
	/**
	 * 	修改部门
	 * @param d_no
	 * @param d_name
	 * @throws Exception
	 */
	void update(int d_no, String d_name) throws Exception;

	
	/**
	 * 删除部门
	 * @param d_no
	 * @throws Exception
	 */
	void remove(int d_no) throws Exception;
}
