package com.csmz.kaoqing.web.service;
/**
 * 解析表格成一个个的对象
 * @author zoupan
 * @time 2019年3月11日 下午8:21:59
 */
public interface ImportParse {
	/**
	 * 解析xlsx表格
	 * @param pathname
	 */
	public boolean xlsxParse(String pathname);
	/**
	 * 解析xls表格
	 * @param pathname
	 */
	public boolean xlsParse(String pathname);
}
