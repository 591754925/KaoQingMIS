package com.csmz.kaoqing.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmz.kaoqing.web.mapper.DeptMapper;
import com.csmz.kaoqing.web.service.DeptService;

/**
 * 部门逻辑操作的实现类
 * 实现接口 AdminService
 * @author Charlene
 * 
 */
@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	DeptMapper deptmapper;
	
	
	/**
	 * 添加部门
	 */
	@Override
	public void save(String d_name) throws Exception {
		deptmapper.save(d_name);
	}

	/**
	 * 修改部门
	 */
	@Override
	public void update(int d_no, String d_name) throws Exception {
		deptmapper.setDeptById(d_no, d_name);
	}

	
	/**
	 * 删除部门
	 */
	@Override
	public void remove(int d_no) throws Exception {
		deptmapper.remove(d_no);
	}
	
	
	
	
}
