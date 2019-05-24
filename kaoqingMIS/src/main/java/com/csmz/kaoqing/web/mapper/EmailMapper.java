package com.csmz.kaoqing.web.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.csmz.kaoqing.web.Email;


/**
 * 邮箱mapper
 * @author Charlene
 *
 */
@Mapper
public interface EmailMapper {
	
	/**
	 * 获取邮箱验证码记录列表
	 * @return
	 */
	@Select("select * from email order by no desc")
	@Results({
		@Result(column = "id", 
				property = "admin",
				one=@One(select="com.csmz.kaoqing.web.mapper.AdminMapper.loadById")),
	})
	List<Email> list();
	
	/**
	 * 验证码登录
	 * @param userid
	 * @param text
	 * @param time
	 * @return
	 */
	@Select("select * from email where id = (select id from admins where userid = #{userid}) and text = #{text} and time > date_add(#{time}, interval -30 minute)")
	@Results({
		@Result(column = "id", 
				property = "admin",
				one=@One(select="com.csmz.kaoqing.web.mapper.AdminMapper.loadById")),
	})
	Email login(@Param("userid") String userid, @Param("text") String text, @Param("time") Date time);
	
	/**
	 * 添加验证码记录
	 * @param userid
	 * @param text
	 * @param time
	 * @return
	 */
	@Insert("insert into email(id, text, time) values((select id from admins where userid = #{userid}), #{text}, #{time})")
	boolean save(@Param("userid") String userid, @Param("text") String text, @Param("time") Date time);
}
