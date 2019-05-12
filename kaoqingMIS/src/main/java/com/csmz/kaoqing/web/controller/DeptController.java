package com.csmz.kaoqing.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csmz.kaoqing.web.service.impl.DeptServiceImpl;

/**
 * 
 * @author Charlene
 *
 */
@RestController
@RequestMapping("/api/v2/dept")
public class DeptController {
	
	@Autowired
	DeptServiceImpl deptserviceimpl;
	
	/**
	 * 添加部门
	 * @param d_name
	 * @return
	 */
	@PostMapping("/add")
	public boolean addDept(String d_name) {
		try {
			deptserviceimpl.save(d_name);
		} catch (Exception e) {
			System.out.println("error");
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 修改部门
	 * @param d_no
	 * @param d_name
	 * @return
	 */
	@PostMapping("/update")
	public boolean updateDept(int d_no, String d_name) {
		try {
			deptserviceimpl.update(d_no, d_name);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 删除部门
	 * @param d_no
	 * @return
	 */
	@PostMapping("/remove")
	public boolean removeDept(int d_no) {
		try {
			deptserviceimpl.remove(d_no);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
