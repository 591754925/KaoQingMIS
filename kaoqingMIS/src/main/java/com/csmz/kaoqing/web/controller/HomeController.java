package com.csmz.kaoqing.web.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("/")
	public String login_(){
		return "login.html";
	}
	
	@GetMapping("/index")
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "index_admin.html";
	}
	
	@PostMapping("/send")
	@ResponseBody
	public String send(String userid) {
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.sql.Date time = new java.sql.Date(new java.util.Date().getTime());
		
		//发送邮件并获取验证码
		String text = qqemail.sendSimpleMail();
		
		//写入验证码记录
		if(emailmapper.save(userid, text, time)) {
			return "1";
		}
		return "";
	}
	
	
	
	@PostMapping("/login")
	@ResponseBody
	public String login(String userid, String text) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.sql.Date time = new java.sql.Date(new java.util.Date().getTime());
		
		System.out.println(df.format(time));
		if(emailmapper.login(userid, text, time) != null && emailmapper.login(userid, text, time).getAdmin().getId() == 1) {
			System.out.println(emailmapper.login(userid, text, time).toString());
			return "index.html";
		}else if(emailmapper.login(userid, text, time) != null && emailmapper.login(userid, text, time).getAdmin().getId() != 1){
			
		}
		return null;
	}
	
	
}
