package com.csmz.kaoqing.web.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.csmz.kaoqing.web.mapper.AdminMapper;

@Service
public class QQEmail {
	
	@Value("${spring.mail.username}")
    private String from;
	
    @Autowired
    private JavaMailSender mailSender;
 
    @Autowired
    private AdminMapper adminmapper;
 
    /**
     *	发送邮件
     * @param to
     * @param title
     * @param content
     */
    public String sendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(adminmapper.loadById(1).getUserid());
        message.setSubject("csmz-学生考勤系统登录验证码");
        // 获取随机验证码
        String resultCode = achieveCode(); 
        message.setText("验证码："+resultCode);
        
        mailSender.send(message);
        System.out.println("验证码："+resultCode);
        return resultCode;
    }
	
	/**
	 * 获取随机验证码
	 * @return
	 */
	public String achieveCode() {
		String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
				"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
				"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z" };
		List<String> list = Arrays.asList(beforeShuffle);
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		String afterShuffle = sb.toString();
		String result = afterShuffle.substring(3, 9);
		return result;
	}
	
	

}
