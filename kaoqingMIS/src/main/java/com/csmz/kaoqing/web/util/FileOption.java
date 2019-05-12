package com.csmz.kaoqing.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.csmz.kaoqing.web.service.impl.ExportServiceImpl;
import com.csmz.kaoqing.web.service.impl.ImportParseImpl;

@Controller
@RequestMapping("/api/v2/file")
@CrossOrigin
public class FileOption{

	@Autowired
	ExportServiceImpl exportserviceimpl;

	@Autowired
	ImportParseImpl importparseimpl;
	
	@GetMapping("/list")
	@ResponseBody
	public List<String> file() {
		List<String> pathList=new ArrayList<String>();
		try {
			File file = new File(new File("").getCanonicalPath()+"\\File");
			System.out.println(new File("").getCanonicalPath()+"\\File");
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

	/**
	 * 封装文件流
	 * @param file
	 * @param name
	 * @return
	 */
	public ResponseEntity<FileSystemResource> export(File file, String name) { 
		if (file == null) { 
			return null;
		} 
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Content-Disposition", "attachment; filename=" + name);
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.add("Last-Modified", new Date().toString());
		headers.add("ETag", String.valueOf(System.currentTimeMillis()));

		return ResponseEntity.ok().headers(headers).contentLength(file.length()) .contentType(MediaType.parseMediaType("application/octet-stream")) .body(new FileSystemResource(file));
	}


	/**
	 * 文件下载
	 * @param name
	 * @return
	 */
	@GetMapping("/dowlond")
	public ResponseEntity<FileSystemResource> find(@RequestParam("name") String name) {
		File dow = null;
		//name = name.substring(0,name.length() - 1);
		System.out.println(name);
		try {
			dow = new File(new File("").getCanonicalPath()+"\\File\\"+name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return export(dow, name);
	}

	/**
	 * 文件数据写入
	 * @return
	 */
	@PostMapping("/write")
	@ResponseBody
	public boolean write(@RequestBody String name) {
		
		name = name.substring(0,name.length() - 1);
		try {
			if(importparseimpl.xlsxParse(new File("").getCanonicalPath() + "\\File\\" + name)) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;

	}
	/**
	 * 生成excel文件
	 * @return
	 */
	@GetMapping("/excel")
	@ResponseBody
	public boolean GenerateExcel() {
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
			path = new File("").getCanonicalPath()+"\\File";
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
	
	/**
	 * remove excel文件
	 * @return
	 */
	@PostMapping("/remove")
	@ResponseBody
	public boolean removeExcel(@RequestBody String name) {
		name = name.substring(0,name.length() - 1);
		try {
			File file = new File(new File("").getCanonicalPath() + "\\File\\" + name);
			if(file.exists()&&file.isFile()) {
	            file.delete();
	        }
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}