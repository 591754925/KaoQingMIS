//package com.csmz.kaoqing.web.security;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		//允许所有用户访问"/"和"/login.html"
//		http.authorizeRequests()
//		.antMatchers("/", "/login.html", "/index.html").permitAll()
//		.anyRequest().authenticated()   // 其他地址的访问均需验证权限
//		.and()
//		.formLogin()
//		.loginPage("/login.html")   //  登录页
//		.failureUrl("/login-error.html").permitAll()
//		.and()
//		.logout();
//	}
//}
