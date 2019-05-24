//package com.csmz.kaoqing.web.util;
//
//import java.sql.SQLException;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.HtmlEmail;
//
//import dao.AdminsDB;
//
///**
// * 邮箱验证
// * @author Charlene
// *
// */
//public class SendCode {
//	public static String code=null;
//	private long createTime=0; 
//	public String achieveCode() {
//		String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
//				"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
//				"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
//				"w", "x", "y", "z" };
//		List<String> list = Arrays.asList(beforeShuffle);
//		Collections.shuffle(list);
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < list.size(); i++) {
//			sb.append(list.get(i));
//		}
//		String afterShuffle = sb.toString();
//		String result = afterShuffle.substring(3, 9);
//		return result;
//	}
//
//
//	public boolean sendEamilCode() throws SQLException {
//		//接收者的邮箱
//		String eamil=AdminsDB.getAdmin("admin").getUserid();
//		System.out.println(AdminsDB.getAdmin("admin").getUserid());
//		//是否发送
//		boolean isOk=false;
//
//		HtmlEmail send = new HtmlEmail();
//		// 获取随机验证码
//		String resultCode = achieveCode(); 
//		try {
//			send.setHostName("smtp.qq.com");              
//			send.setSmtpPort(465);                                            //端口号
//			send.setSSLOnConnect(true);                                   //开启SSL加密
//			send.setCharset("utf-8");
//			send.addTo(eamil);                                                  //接收者的QQEamil
//			send.setFrom("1716115150@qq.com", "服务者");          //第一个参数是发送者的QQEamil   第二个参数是发送者QQ昵称
//			send.setAuthentication("1716115150@qq.com", "wbkexafppsblfccg");  //第一个参数是发送者的QQEamil   第二个参数是刚刚获取的授权码
//			send.setSubject("考勤系统验证码");            //Eamil的标题  第一个参数是我写的判断上下文，删掉即可
//			send.setMsg("来自未来的验证码: " + resultCode + "  请客官签收");//Eamil的内容
//			send.send();            //发送
//			createTime=System.currentTimeMillis();
//			isOk=true;
//		} catch (EmailException e) {
//			e.printStackTrace();
//		}
//		code=resultCode;
//		return isOk;
//	}
//	public String getCode(){
//		return code;
//	}
//
//	public long getCreateTime() {
//
//		return getCreateTime();
//
//	}
//
//}
