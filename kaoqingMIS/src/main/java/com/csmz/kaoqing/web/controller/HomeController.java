package com.csmz.kaoqing.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.csmz.kaoqing.web.Admin;
import com.csmz.kaoqing.web.Email;
import com.csmz.kaoqing.web.mapper.AdminMapper;
import com.csmz.kaoqing.web.mapper.EmailMapper;
import com.csmz.kaoqing.web.util.QQEmail;

/**
 * 
 * @author Charlene
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	EmailMapper emailmapper;
	
	@Autowired
	QQEmail qqemail;
	
	@Autowired
	AdminMapper adminmapper;

	@GetMapping("/")
	public String login_(){
		return "login.html";
	}
	
	@GetMapping("/index")
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/index_admin")
	public String admin() {
		return "index_admin.html";
	}
	
	/**
	 * 发送验证码并记录
	 * @param userid
	 * @return
	 */
	@PostMapping("/send")
	@ResponseBody
	public String send(String userid) {
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		java.util.Date time = new java.util.Date();
		
		//发送邮件并获取验证码
		String text = qqemail.sendSimpleMail();
		//写入验证码记录
		if(adminmapper.loadByUserId(userid) != null && emailmapper.save(userid, text, time)) {
			return "1";
		}
		
		return null;
	}
	
	
	/**
	 * 登录验证
	 * @param userid
	 * @param text
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	public String login(String userid, String text) {
		
		java.util.Date date = new java.util.Date();
		
		Email m = emailmapper.login(userid, text, date);
		
		ServletRequestAttributes s = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = s.getRequest().getSession();
		
		if(m != null && m.getAdmin().getId() == 1) {
			System.out.println(m.toString());
			session.setAttribute("user", userid);
			return "index_admin.html";
		}else if(m != null && m.getAdmin().getId() != 1){
			System.out.println(m.toString());
			session.setAttribute("user", userid);
			return "index.html";
		}
		return null;
	}
	
	
	@GetMapping("/tagle")
	@ResponseBody
	public Admin tagle() {
		ServletRequestAttributes s = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = s.getRequest().getSession();
		
		if((String)session.getAttribute("user") != null) {
			
			System.out.println((String)session.getAttribute("user")+" true");
			Admin admin = adminmapper.loadByUserId((String)session.getAttribute("user"));
			return admin;
		}
		
		System.out.println((String)session.getAttribute("user")+" false");
		return null;
	}
	
	@GetMapping("/outlogin")
	@ResponseBody
	public String outLogin() {
		ServletRequestAttributes s = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = s.getRequest().getSession();
		
		if(adminmapper.loadByUserId((String)session.getAttribute("user")) != null) {
			session.setAttribute("user", null);
			return "login.html";
		}
		
		return null;
	}
	
	
}
