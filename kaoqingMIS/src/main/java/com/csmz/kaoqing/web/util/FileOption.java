package com.csmz.kaoqing.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.csmz.kaoqing.web.service.impl.ExportServiceImpl;

@Controller
@RequestMapping("/api/v2/file")
@CrossOrigin
public class FileOption{

	@Autowired
	ExportServiceImpl exportserviceimpl;
	
	@GetMapping("/list")
	@ResponseBody
	public List<String> file() {
		List<String> pathList=new ArrayList<String>();
		try {
			File file = new File(new File("").getCanonicalPath()+"/File");
			File[] f=file.listFiles();
			if (f.length>0) {
				for (int i = 0; i < f.length; i++) {
					if (f[i].isFile()) {
						pathList.add(f[i].getName());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pathList;
	}
	
	
	@GetMapping("/dowlond")
	
	public String find(@RequestParam("file") String file) {
		String fileName = "";
		try {
			fileName = new File("").getCanonicalPath()+"\\File\\"+file;
			System.out.println(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	
	@GetMapping("/write")
	@ResponseBody
	public boolean write() {
		
		if(exportserviceimpl.createXlsxFile()) {
			return true;
		}
		
		return false;
		
	}
	
	
	/**
	 * 文件上传
	 * @param file
	 * @return
	 * @throws  
	 */
	@PostMapping("/fileUpload")
	@ResponseBody
	public String readFile(@RequestParam("file")MultipartFile file){
		if(file.isEmpty()) {
			return "false";
		}
		//得到文件上传时的文件名（用户可修改）
		String fileName = file.getOriginalFilename();
		//获取文件大小
		long size = file.getSize();
		System.out.println(fileName+"-------->"+size);
		//定义文件上传路径
		String path = "";
		try {
			path = new File("").getCanonicalPath()+"/File";
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//创建文件对象
		File dest = new File(path+File.separator+fileName);
		//如果父文件不存在就创建
		if(!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		try {
			//保存文件
			file.transferTo(dest);
			return "true";
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return "false";
		}
	}

}