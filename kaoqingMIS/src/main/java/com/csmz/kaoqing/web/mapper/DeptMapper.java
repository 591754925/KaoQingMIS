package com.csmz.kaoqing.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.csmz.kaoqing.web.Dept;



/**
 * 
 * @author Charlene
 *
 */
@Mapper
public interface DeptMapper {
	
	/**
	 * 获取部门列表
	 * @return
	 */
	@Select("select * from dept")
	@Results({
		@Result(column = "d_no", property = "d_no"),
		@Result(column = "d_no", 
				property = "student",
				one=@One(select="com.csmz.kaoqing.web.mapper.StudentMapper.list")),
	})
	List<Dept> list ();
	
	/**
	 * 根据部门编号查部门
	 * @param d_no
	 * @return
	 */
	@Select("select * from dept where d_no = #{d_no}")
	Dept loadById(@Param("d_no") int d_no);
	
	
	/**
	 * 根据部门编号修改部门名称
	 * @param d_no
	 * @param d_name
	 * @return
	 */
	@Update("update dept set d_name = #{d_name} where d_no = #{d_no}")
	boolean setDeptById(@Param("d_no") int d_no, @Param("d_name") String d_name);
	
	
	/**
	 * 添加部门
	 * @param d_name
	 * @return
	 */
	@Insert("insert into dept (d_name) values (#{d_name})")
	boolean save(@Param("d_name") String d_name);
	
	
	/**
	 * 删除部门
	 * @param d_no
	 * @return
	 */
	@Delete("delete from dept where d_no = #{d_no}")
	boolean remove(@Param("d_no") int d_no);
	
}
