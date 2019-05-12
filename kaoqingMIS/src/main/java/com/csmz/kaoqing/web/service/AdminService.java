package com.csmz.kaoqing.web.service;

import com.csmz.kaoqing.web.Admin;

/**
 * 账号的逻辑操作接口
 * @author Charlene
 *
 */
public interface AdminService {
	
	/**
	 * 创建账号
	 * @param admin
	 * @throws Exception
	 */
	void save(Admin admin) throws Exception;
	
	
	/**
	 * 修改账号
	 * @param admin
	 * @throws Exception
	 */
	void update(Admin admin) throws Exception;
	

	
	/**
	 * 注销账号
	 * @param admin
	 * @throws Exception
	 */
	void remove(Admin admin) throws Exception;
}
