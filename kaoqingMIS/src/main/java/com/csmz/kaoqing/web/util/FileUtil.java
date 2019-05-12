package com.csmz.kaoqing.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.csmz.kaoqing.web.commer.Params;

   
/**
 * 文件工具类
 * @author Charlene
 *
 */
public class FileUtil {
	String filepPath=null;//文件保存地址ַ
	
	String imgPath=null;//图片保存地址ַ
	
	HttpServletRequest request=null;//HttpServletRequest 对象
	/**
	 * Description: (构造函数，初始化参数) 
	 * @param request
	 */
	public FileUtil(HttpServletRequest request) {
		this.request=request;
		this.filepPath = Params.FILE_PATH;
		this.imgPath= Params.Img_PATH;
		File f = new File(filepPath);
		File f1 = new File(imgPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		if (!f1.exists()) {
			f1.mkdir();
		}
	}
	
	/**
	 * 
	 * Title: upload
	 * Description: (文件上传的方法) 
	 * @return boolean 返回false或者true ，true上传文件成功，false上传文件失败(文件格式不符合规定)
	 * @throws Exception
	 */
	public int upload() throws Exception{
		Part part=request.getPart("file");
		String savePath=this.filepPath;
		int isOk=0;
	    String header=part.getHeader("content-disposition");
	    String fileName=getFileName(header);
	    String fileType=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
	    if (opFileType(fileType)==1) {
	    	if ("jpg".equals(fileType)||"png".equals(fileType)) {
		    	savePath=this.imgPath;
		    	isOk = 1;
			}else if ("xls".equals(fileType)||"xlsx".equals(fileType)) {
				savePath=this.filepPath;
				isOk = 2;
			}
		    part.write(savePath+File.separator+fileName);
			
		}
	    return isOk;
	}
	/**
	 * 
	 * Title: opFileType
	 * Description: (判断文件类型是否符合规定) 
	 * @param type
	 * @return
	 */
	private int opFileType(String type) {
		int op=0;
		String typeStr="xls-xlsx-jpg-png";
		if (typeStr.contains(type)) {
			op=1;
		}
		return op;
	}
	/**
	 * 
	 * Title: getFileName
	 * Description: (获得文件的文件名) 
	 * @param header Part的http头
	 * @return String 返回文件名
	 */
	private String getFileName(String header) {
		String name=null;
		header=header.substring(header.lastIndexOf("=")+2, header.length()-1);
		name=header.substring(header.lastIndexOf("\\")+1, header.length());
		return name;
	}
	/**
	 * 
	 * Title: showAllFile
	 * Description: (返回目录下所有文件的文件名，用于显示所有文件) 
	 * @return List<String> 返回一个储存文件名的list集合
	 */
	public List<String> showAllFile() {
		File file=new File(filepPath);
		File[] f=file.listFiles();
		List<String> pathList=new ArrayList<String>();
		if (f.length>0) {
			for (int i = 0; i < f.length; i++) {
				if (f[i].isFile()) {
					pathList.add(f[i].getName());
				}
			}
		}
		return pathList;
		
	}
	
	public List<String> showAllImg() {
		File file=new File(imgPath);
		File[] f=file.listFiles();
		List<String> pathList=new ArrayList<String>();
		if (f.length>0) {
			for (int i = 0; i < f.length; i++) {
				if (f[i].isFile()) {
					pathList.add(f[i].getName());
				}
			}
		}
		return pathList;
		
	}
	/**
	 * 
	 * Title: down
	 * Description: (用于文件的下载的方法) 
	 * @param response HttpServletResponse对象
	 * @param fileName 要下载文件的文件名
	 * @throws Exception
	 */
	public void down(HttpServletResponse response,String fileName) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		OutputStream out= response.getOutputStream();
		InputStream in=new FileInputStream(filepPath+File.separator+fileName);
		byte[] buffer=new byte[1024];
		int len=in.read(buffer);
		while(len!=-1) {
			out.write(buffer, 0, len);
			len=in.read(buffer);
		}
		in.close();
		
	}
	
	/**
	 * 
	 * Title: downImg
	 * Description: (用于图片的下载的方法) 
	 * @param response HttpServletResponse对象
	 * @param fileName 要下载文件的文件名
	 * @throws Exception
	 */
	public void downImg(HttpServletResponse response,String fileName) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		OutputStream out= response.getOutputStream();
		InputStream in=new FileInputStream(imgPath+File.separator+fileName);
		byte[] buffer=new byte[1024];
		int len=in.read(buffer);
		while(len!=-1) {
			out.write(buffer, 0, len);
			len=in.read(buffer);
		}
		in.close();
		
	}
	
	public String getPath(int i) {
		String path = "";
		if(i == 1) {
			path = filepPath;
		}else if(i == 2) {
			path = imgPath;
		}
		
		return path; 
	}
	/**
	 * 删除图片
	 * @param filename
	 * @return
	 */
	public boolean deleteImg(String filename){
		//图片路径
		File file = new File(imgPath+File.separator+filename);
		if(!file.exists()){
			return false;
		}else if(file.exists()){
			boolean delete = file.delete();
			if(delete){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	/**
	 * 删除文件
	 * @param filename
	 * @return
	 */
	public boolean deleteFile(String filename){
		//文件路径
		File file = new File(filepPath+File.separator+filename);
		if(!file.exists()){
			return false;
		}else if(file.exists()){
			boolean delete = file.delete();
			if(delete){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}


}
