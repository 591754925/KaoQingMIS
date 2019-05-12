package com.csmz.kaoqing.web.service;

/**
 * 文件导出。生成表格
 * @author zoupan
 * @time 2019年3月11日 上午9:24:16
 */
public interface ExportService {

	/**
	 * 创建.xls文件
	 */
	public boolean createXlsFile();
	/**
	 *  创建.xlsx文件
	 */
	public boolean createXlsxFile();
}
