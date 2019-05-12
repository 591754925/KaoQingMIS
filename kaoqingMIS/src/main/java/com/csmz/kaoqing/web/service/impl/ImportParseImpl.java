package com.csmz.kaoqing.web.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmz.kaoqing.web.Dept;
import com.csmz.kaoqing.web.Student;
import com.csmz.kaoqing.web.mapper.StudentMapper;
import com.csmz.kaoqing.web.service.ImportParse;
/**
 * excel数据写入
 * @author Charlene
 *
 */
@Service
public class ImportParseImpl implements ImportParse {
	
	@Autowired
	StudentMapper studentmapper;

	@SuppressWarnings("deprecation")
	@Override
	public boolean xlsxParse(String pathname) {
		File file = new File(pathname);
		// 字节输出流
		try {
			InputStream is = new FileInputStream(file);
			// 一个Excel文件对应于一个workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(is);
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				// 一个workbook可以有多个sheet组成
				XSSFSheet sheet = wb.getSheetAt(i);
				if (sheet != null) {
					for (int j = 1; j <= sheet.getLastRowNum(); j++) {
						// 一个sheet是由多个row组成
						XSSFRow row = sheet.getRow(j);
						if (row != null) {
							Student st = new Student();
							for (int k = 0; k <= row.getLastCellNum(); k++) {
								// 一个row是由多个cell组成
								XSSFCell cell = row.getCell(k);
								if (cell != null) {
									// 虽然excel中设置的都是文本，但是数字文本还被读错，如“1”取成“1.0”，加上 cell.CELL_TYPE_STRING，临时把它当做文本来读取。
									cell.setCellType(Cell.CELL_TYPE_STRING);
									switch (k) {
									case 0:
										st.setS_no(getValue(cell));
										break;
									case 1:
										st.setS_name(getValue(cell));
										break;
									case 2:
										st.setS_class(getValue(cell));
										break;
									case 3:
										Dept d = new Dept();
										double c = Double.parseDouble(getValue(cell));
										d.setD_no((int) c);
										st.setDept(d);
										break;
									case 4:
										double b = Double.parseDouble(getValue(cell));
										st.setS_greed((int) b);
										// st.setS_d_greed(Integer.parseInt(getValue(cell)));
										break;
									case 5:
										st.setGreed_name(getValue(cell));
										break;
									case 6:
										st.setTelephone(getValue(cell));
										break;
									case 7:
										double c1 = Double.parseDouble(getValue(cell));
										st.setScore((int) c1);
										break;
									case 8:
										double d1 = Double.parseDouble(getValue(cell));
										st.setOnTimes((int) d1);
										break;
									case 9:
										double e = Double.parseDouble(getValue(cell));
										st.setLateTimes((int) e);
										break;
									case 10:
										double f = Double.parseDouble(getValue(cell));
										st.setOutTimes((int) f);
										break;
									case 11:
										double g = Double.parseDouble(getValue(cell));
										st.setLeaveTimes((int) g);
										break;
									}
								}
							}
							if(st.getS_no()!=null) {
								
								studentmapper.updateStudent(st);
								System.out.println(st.toString()+" -------> 写入成功");
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
		}
		// 一个Excel文件对应于一个workbook
		return true;

	}

	/**
	 * 获取值的方法
	 * 
	 * @param xcell
	 * @return针对于xlsx表格,输出的时候，一定要注意格式，否则会报格式错误异常
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public static String getValue(XSSFCell xcell) {
		if (xcell.getCellType() == xcell.CELL_TYPE_NUMERIC) {
			@SuppressWarnings("unused")
			DecimalFormat df = new DecimalFormat("0");
			// String content=String.valueOf(xcell.getNumericCellValue());
			return String.valueOf(xcell.getNumericCellValue());
		} else {
			return String.valueOf(xcell.getStringCellValue()).toString();
		}
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	@Override
	public boolean xlsParse(String pathname) {
		try {
			File file = new File(pathname);
			InputStream is = new FileInputStream(file);
			//一个Excel文件对应于一个workbook(HSSFWorkbook)
			@SuppressWarnings("resource")
			HSSFWorkbook wb = new HSSFWorkbook(is);
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				//一个workbook可以有多个sheet（HSSFSheet）组成
				HSSFSheet sheet = wb.getSheetAt(i);
				if (sheet != null) {
					for (int j = 0; j <= sheet.getLastRowNum(); j++) {
						//一个sheet是由多个row（HSSFRow）组成
						HSSFRow row = sheet.getRow(j);
						if (row != null) {
							Student st = new Student();
							for (int k = 0; k <= row.getLastCellNum(); k++) {
								//一个row是由多个cell（HSSFCell）组成
								HSSFCell cell = row.getCell(k);
								
								if (cell != null) {
									
									//虽然excel中设置的都是文本，但是数字文本还被读错，如“1”取成“1.0”，加上 cell.CELL_TYPE_STRING，临时把它当做文本来读取。								
									cell.setCellType(cell.CELL_TYPE_STRING);
									
									switch (k) {
									case 0:
										st.setS_no(getValue1(cell));
										break;
									case 1:
										st.setS_name(getValue1(cell));
										break;
									case 2:
										st.setS_class(getValue1(cell));
										break;
									case 3:
										Dept d = new Dept();
										double c = Double.parseDouble(getValue1(cell));
										d.setD_no((int) c);
										st.setDept(d);
										break;
									case 4:
										double b = Double.parseDouble(getValue1(cell));
										st.setS_greed((int) b);
										// st.setS_d_greed(Integer.parseInt(getValue(cell)));
										break;
									case 5:
										st.setGreed_name(getValue1(cell));
										break;
									case 6:
										st.setTelephone(getValue1(cell));
										break;
									case 7:
										double c1 = Double.parseDouble(getValue1(cell));
										st.setScore((int) c1);
										break;
									case 8:
										double d1 = Double.parseDouble(getValue1(cell));
										st.setOnTimes((int) d1);
										break;
									case 9:
										double e = Double.parseDouble(getValue1(cell));
										st.setLateTimes((int) e);
										break;
									case 10:
										double f = Double.parseDouble(getValue1(cell));
										st.setOutTimes((int) f);
										break;
									}
								}
							}
							if(st.getS_no()!=null) {
						
							System.out.println(st.toString());
							}
						}

					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	
	/**
	 * 获取值的方法，针对于xls表格
	 * 
	 * @param cell输出的时候，一定要注意格式，否则会报格式错误异常
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public static String getValue1(HSSFCell cell) {
		if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else {
			return String.valueOf(cell.getStringCellValue()).toString();
		}
	}


}
