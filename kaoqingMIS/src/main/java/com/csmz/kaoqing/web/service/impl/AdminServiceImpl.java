package com.csmz.kaoqing.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmz.kaoqing.web.Admin;
import com.csmz.kaoqing.web.mapper.AdminMapper;
import com.csmz.kaoqing.web.service.AdminService;

/**
 * 账号逻辑操作的实现类
 * 实现接口 AdminService
 * @author Charlene
 * 
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminmapper;
	
	/**
	 * 创建账号
	 */
	@Override
	public void save(Admin admin) throws Exception {
		if(adminmapper.loadByUserId(admin.getUserid()) == null) {
			adminmapper.save(admin.getUserid(), admin.getUsername());
		}else {
			throw new Exception();
		}
		
	}

	/**
	 * 修改账号
	 */
	@Override
	public void update(Admin admin) throws Exception {
		
		if(adminmapper.loadById(admin.getId()) != null) {
			adminmapper.setById(admin.getId(), admin.getUserid(), admin.getUsername());
		}else {
			throw new Exception();
		}
		
	}

	/**
	 * 注销账号
	 */
	@Override
	public void remove(Admin admin) throws Exception {
		
		if(adminmapper.loadById(admin.getId()) != null) {
			adminmapper.remove(admin.getId());
		}else {
			throw new Exception();
		}
	}
	
	
}
