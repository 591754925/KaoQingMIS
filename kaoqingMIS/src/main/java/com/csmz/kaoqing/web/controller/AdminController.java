package com.csmz.kaoqing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csmz.kaoqing.web.Admin;
import com.csmz.kaoqing.web.service.impl.AdminServiceImpl;

/**
 * 账号控制器
 * @author Charlene
 *
 */
@RestController
@RequestMapping("/api/v2/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminserviceimpl;
	
	/**
	 * 添加账号
	 * @param userid
	 * @param username
	 * @return
	 */
	@PostMapping("/add")
	public boolean add(String userid, String username) {
		Admin admin = new Admin();
		admin.setUserid(userid);
		admin.setUsername(username);
		try {
			adminserviceimpl.save(admin);
		} catch (Exception e) {
			System.out.println("error");
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 修改账号
	 * @param id
	 * @param userid
	 * @param username
	 * @return
	 */
	@PostMapping("/update")
	public boolean update(int id, String userid, String username) {
		Admin admin = new Admin();
		admin.setId(id);
		admin.setUserid(userid);
		admin.setUsername(username);
		try {
			adminserviceimpl.update(admin);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 删除账号
	 * @param id
	 * @return
	 */
	@PostMapping("/remove")
	public boolean remove(int id) {
		Admin admin = new Admin();
		admin.setId(id);
		try {
			adminserviceimpl.remove(admin);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
