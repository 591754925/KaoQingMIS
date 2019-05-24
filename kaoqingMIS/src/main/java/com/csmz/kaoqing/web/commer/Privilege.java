package com.csmz.kaoqing.web.commer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.csmz.kaoqing.web.mapper.AdminMapper;

public class Privilege {
	
	ServletRequestAttributes attributes =   (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
	HttpServletRequest request = attributes.getRequest();
	HttpSession session= request.getSession();
	
	@Autowired
	AdminMapper adminmapper;
	
	boolean Verification(){
		String user = (String) session.getAttribute("user"); 
		
		if (adminmapper.loadByUserId(user) != null)
		{
			return true;
		}
		
		return false;
	}

}
