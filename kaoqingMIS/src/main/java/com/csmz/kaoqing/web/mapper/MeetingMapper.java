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

import com.csmz.kaoqing.web.Meeting;


/**
 * 
 * @author Charlene
 *
 */
@Mapper
public interface MeetingMapper {
	
	/**
	 * 获取会议列表
	 * @return
	 */
	@Select("select * from meetings order by m_no desc")
	@Results({
		@Result(column = "m_no", property = "no"),
		@Result(column = "m_time", property = "time"),
		@Result(column = "m_name", property = "name"),
		@Result(column = "m_address", property = "address"),
		@Result(column = "m_no", 
				property = "students",
				one=@One(select="com.csmz.kaoqing.web.mapper.MeetingStudentMapper.list")),
	})
	List<Meeting> list();
	
	
	/**
	 * 根据会议编号查会议
	 * @param d_no
	 * @return
	 */
	@Select("select * from meetings where m_no = #{m_no}")
	@Results({
		@Result(column = "m_no", property = "no"),
		@Result(column = "m_time", property = "time"),
		@Result(column = "m_name", property = "name"),
		@Result(column = "m_address", property = "address"),
		@Result(column = "m_no", 
				property = "students",
				one=@One(select="com.csmz.kaoqing.web.mapper.MeetingStudentMapper.list")),
	})
	Meeting loadById(@Param("m_no") int m_no);
	
	
	/**
	 * 添加会议
	 * @param m_time
	 * @param m_name
	 * @param m_address
	 * @return
	 */
	@Insert("insert into meetings(m_time, m_name, m_address) values(#{m_time}, #{m_name}, #{m_address})")
	boolean save(@Param("m_time") String m_time, @Param("m_name") String m_name, @Param("m_address") String m_address);
	
	
	
	@Select("select LAST_INSERT_ID()")
	int loadNew();
	
	
	/**
	 * 修改会议
	 * @param m_no
	 * @param m_time
	 * @param m_name
	 * @param m_address
	 * @return
	 */
	@Update("update meetings set m_time = #{m_time}, m_name = #{m_name}, m_address = #{m_address} where m_no =#{m_no}")
	boolean update(@Param("m_no") int m_no, @Param("m_time") String m_time, @Param("m_name") String m_name, @Param("m_address") String m_address);
	
	
	/**
	 * 删除会议
	 * @param m_no
	 * @return
	 */
	@Delete("delete from meetings where m_no = #{m_no}")
	boolean remove(@Param("m_no") int m_no);
}
