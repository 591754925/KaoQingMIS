package com.csmz.kaoqing.web.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 几种密码的加密方式
 * @author Charlene
 *
 */
public class Password {
	
	/**
	 * MD5(消息摘要算法 5)
	 * @param password 任意长度
	 * @return 长度为 32 的十六进制的字符串
	 */
	public static String toMD5(String psd) {
		String md5 = null;
		try {
			
			byte[] hash = MessageDigest.getInstance("MD5").digest(psd.getBytes());
			md5 = new BigInteger(1,hash).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return md5;
	}
	/**
	 * 
	 * @param psd
	 * @return
	 */
	public static String toSHA256(String psd) {
		String md5 = null;
		try {
			
			byte[] hash = MessageDigest.getInstance("SHA-256").digest(psd.getBytes());
			md5 = new BigInteger(1,hash).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return md5;
	}
	
	/**
	 * 
	 * @param psd
	 * @return
	 */
	public static String toMD5(File file) {
		String md5 = null;
		byte[] strBuffer = null;
		int len = (int)file.length();
		try {
			InputStream in = new FileInputStream(file);
			strBuffer = new byte[len];
			in.read(strBuffer, 0, len);
			in.close();
			byte[] hash = MessageDigest.getInstance("MD5").digest(strBuffer);
			md5 = new BigInteger(1,hash).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return md5;
	}
	
	/**
	 * 
	 * @param psd
	 * @return
	 */
	public static String toSHA256(File file) {
		String md5 = null;
		//使用操作系统中的缓存
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file), 1024*32)){
			byte[] buf = new byte[1024*8];
			//内存中的可变数组
			ByteArrayOutputStream data = new ByteArrayOutputStream();
			int size;
			while(-1 != (size = in.read(buf))) {
				//脏数据
				//data.write(buf);
				data.write(buf, 0, size);
			}
			byte[] hash = MessageDigest.getInstance("SHA-256").digest(data.toByteArray());
			md5 = new BigInteger(1, hash).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return md5;
	}
	
//	public static void main(String[] args) {
//		File file = new File("G:\\3级英语.txt");
//		System.out.println(toMD5(""));
//		System.out.println(toSHA256(""));
//		System.out.println(toMD5(file));
//		System.out.println(toSHA256(file));
//	}
}
