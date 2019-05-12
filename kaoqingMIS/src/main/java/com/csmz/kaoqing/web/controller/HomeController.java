package com.csmz.kaoqing.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author Charlene
 *
 */
@Controller
public class HomeController {
	

	@GetMapping("/")
	public String login(){
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
	
	
}
