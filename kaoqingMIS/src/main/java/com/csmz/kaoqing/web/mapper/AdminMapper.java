package com.csmz.kaoqing.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.csmz.kaoqing.web.Admin;


/**
 * 
 * @author Charlene
 *
 */
@Mapper
public interface AdminMapper {
	
	/**
	 * 获取账号列表
	 * @return
	 */
	@Select("select * from admins")
	List<Admin> list();
	
	/**
	 * 根据账号获取
	 * @param userid
	 * @return
	 */
	@Select("select * from admins where userid = #{userid}")
	Admin loadByUserId(@Param("userid") String userid);
	
	
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	@Select("select * from admins where id = #{id}")
	Admin loadById(@Param("id") int id);
	
	
	
	/**
	 * 修改账号
	 * @param id
	 * @param userid
	 * @param username
	 * @return
	 */
	@Update("update admins set userid = #{userid}, username = #{username} where id = #{id}")
	boolean setById(@Param("id") int id, @Param("userid") String userid, @Param("username") String username);
	
	/**
	 * 根据id删除账号
	 * @param id
	 * @return
	 */
	@Delete("delete from admins where id = #{id} and id != 1")
	boolean remove(@Param("id") int id);
	
	
	/**
	 * 添加账号
	 * @param userid
	 * @param username
	 * @return
	 */
	@Insert("insert into admins(userid, username) values(#{userid}, #{username})")
	boolean save(@Param("userid") String userid, @Param("username") String username);
	
	
	
}
