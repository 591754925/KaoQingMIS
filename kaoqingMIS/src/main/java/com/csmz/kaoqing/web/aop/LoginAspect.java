package com.csmz.kaoqing.web.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Configuration
public class LoginAspect {
	
	
	
	@Before("execution(* com.csmz.kaoqing.web.controller.*.*() )")
	public void print() {
		ServletRequestAttributes s = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = s.getRequest().getSession();
		if(session.getAttribute("user") != null) {
			
			//System.out.println(session.getAttribute("user"));
		}else {
			
			HttpServletResponse response = s.getResponse();
			try {
				response.sendRedirect("login.html");
			} catch (IOException e) {
				
			}
			
		}
		
		
	}
}
