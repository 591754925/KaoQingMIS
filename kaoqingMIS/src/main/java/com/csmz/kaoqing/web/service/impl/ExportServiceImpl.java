package com.csmz.kaoqing.web.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmz.kaoqing.web.Student;
import com.csmz.kaoqing.web.mapper.StudentMapper;
import com.csmz.kaoqing.web.service.ExportService;

/**
 * 生成表格
 * @author zoupan
 * @time 2019年3月11日 上午9:27:46
 */
@Service
public class ExportServiceImpl  implements ExportService{

	@Autowired
	StudentMapper studentmapper;
	
	

	@Override
	public boolean createXlsFile() {
		//第一步，创建一个workbook对应一个excel文件
				@SuppressWarnings("resource")
				HSSFWorkbook workbook = new HSSFWorkbook();
				//第二部，在workbook中创建一个sheet对应excel中的sheet
				HSSFSheet sheet = workbook.createSheet("学生考勤表");
				//第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
				HSSFRow row = sheet.createRow(0);
				//第四步，创建单元格，设置表头
				HSSFCell cell = row.createCell(0);
				cell.setCellValue("学号");
				cell = row.createCell(1);
				cell.setCellValue("姓名");
				cell = row.createCell(2);
				cell.setCellValue("班级");
				cell = row.createCell(3);
				cell.setCellValue("部门编号");
				cell = row.createCell(4);
				cell.setCellValue("部门级别");
				cell = row.createCell(5);
				cell.setCellValue("部门职位");     
				cell = row.createCell(6);
				cell.setCellValue("电话号码");
				cell = row.createCell(7);
				cell.setCellValue("考核分数");
				cell = row.createCell(8);
				cell.setCellValue("签到次数");
				cell = row.createCell(9);
				cell.setCellValue("迟到次数");
				cell = row.createCell(10);
				cell.setCellValue("缺勤次数");
				cell = row.createCell(11);
				cell.setCellValue("请假次数");

				//第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
				List<Student> users = studentmapper.listAll();
				for (int i = 0; i < users.size(); i++) {
					HSSFRow row1 = sheet.createRow(i + 1);
					Student stu = users.get(i);
					//创建单元格设值
					row1.createCell(0).setCellValue(stu.getS_no());
					row1.createCell(1).setCellValue(stu.getS_name());
					row1.createCell(2).setCellValue(stu.getS_class());
					row1.createCell(3).setCellValue(stu.getDept().getD_no());
					row1.createCell(4).setCellValue(stu.getS_greed());
					row1.createCell(5).setCellValue(stu.getGreed_name());
					row1.createCell(6).setCellValue(stu.getTelephone());
					row1.createCell(7).setCellValue(stu.getScore());
					row1.createCell(8).setCellValue(stu.getOnTimes());
					row1.createCell(9).setCellValue(stu.getLateTimes());
					row1.createCell(10).setCellValue(stu.getOutTimes());
					row1.createCell(11).setCellValue(stu.getLeaveTimes());
				}

				//将文件保存到指定的位置
				try {
					FileOutputStream fos = new FileOutputStream(new File("").getCanonicalPath()+"/File/students.xls");
					workbook.write(fos);
					System.out.println("写入成功");
					fos.close();
				} catch (IOException e) {
					return false;
				}

		return true;
	}

	@Override
	public boolean createXlsxFile() {
		//第一步，创建一个workbook对应一个excel文件
				@SuppressWarnings("resource")
				XSSFWorkbook workbook=new XSSFWorkbook();
				XSSFSheet sheet=workbook.createSheet("学生考勤表");
				//第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
				XSSFRow row=sheet.createRow(0);
				//第四步，创建单元格，设置表头
				XSSFCell cell=row.createCell(0);
				cell.setCellValue("学号");
				cell = row.createCell(1);
				cell.setCellValue("姓名");
				cell = row.createCell(2);
				cell.setCellValue("班级");
				cell = row.createCell(3);
				cell.setCellValue("部门编号");
				cell = row.createCell(4);
				cell.setCellValue("部门级别");
				cell = row.createCell(5);
				cell.setCellValue("部门职位");     
				cell = row.createCell(6);
				cell.setCellValue("电话号码");
				cell = row.createCell(7);
				cell.setCellValue("考核分数");
				cell = row.createCell(8);
				cell.setCellValue("签到次数");
				cell = row.createCell(9);
				cell.setCellValue("迟到次数");
				cell = row.createCell(10);
				cell.setCellValue("缺勤次数");
				cell = row.createCell(11);
				cell.setCellValue("请假次数");
				
				
				List<Student> users = studentmapper.listAll();
				for (int i = 0; i < users.size(); i++) {
					XSSFRow row1=sheet.createRow(i+1); 
					Student stu = users.get(i);
					//创建单元格设值
					row1.createCell(0).setCellValue(stu.getS_no());
					row1.createCell(1).setCellValue(stu.getS_name());
					row1.createCell(2).setCellValue(stu.getS_class());
					row1.createCell(3).setCellValue(stu.getDept().getD_no());
					row1.createCell(4).setCellValue(stu.getS_greed());
					row1.createCell(5).setCellValue(stu.getGreed_name());
					row1.createCell(6).setCellValue(stu.getTelephone());
					row1.createCell(7).setCellValue(stu.getScore());
					row1.createCell(8).setCellValue(stu.getOnTimes());
					row1.createCell(9).setCellValue(stu.getLateTimes());
					row1.createCell(10).setCellValue(stu.getOutTimes());
					row1.createCell(11).setCellValue(stu.getLeaveTimes());
					
				}
				try {
					FileOutputStream fos = new FileOutputStream(new File("").getCanonicalPath()+"/File/students.xlsx");
					workbook.write(fos);
					System.out.println(new File("").getCanonicalPath()+"/File/students.xlsx");
					fos.close();
				} catch (IOException e) {
					return false;
				}
			return true;
		
	}

}
