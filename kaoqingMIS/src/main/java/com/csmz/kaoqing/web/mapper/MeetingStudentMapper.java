package com.csmz.kaoqing.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.csmz.kaoqing.web.MeetingStudent;


/**
 * 
 * @author Charlene
 *
 */
@Mapper
public interface MeetingStudentMapper {
	
	/**
	 * 获取会议成员列表
	 * @param m_no
	 * @return
	 */
	@Select("select * from meeting_student where m_no = #{m_no}")
	@Results({
		@Result(column = "s_no", 
				property = "student",
				many=@Many(select="com.csmz.kaoqing.web.mapper.StudentMapper.loadById")),
	})
	List<MeetingStudent> list(@Param("m_no") int m_no);
	
	/**
	 * 根据id获取会议成员
	 * 
	 * @return
	 */
	@Select("select * from meeting_student where m_no = #{m_no} and s_no = #{s_no}")
	@Results({
		@Result(column = "s_no", 
				property = "student",
				many=@Many(select="com.csmz.kaoqing.web.mapper.StudentMapper.loadById")),
	})
	MeetingStudent loadById(@Param("m_no") int m_no, @Param("s_no") String s_no);
	
	/**
	 * 添加会议成员
	 * @param m_no
	 * @param s_no
	 * @param tagle
	 * @return
	 */
	@Insert("insert into meeting_student(m_no, s_no, tagle) values (#{m_no}, #{s_no}, #{tagle})")
	boolean save(@Param("m_no") int m_no, @Param("s_no") String s_no, @Param("tagle") String tagle);
	
	/**
	 * 修改会议成员状态
	 * @param m_no
	 * @param s_no
	 * @param tagle
	 * @return
	 */
	@Update("update meeting_student set tagle = #{tagle} where m_no = #{m_no} and s_no = #{s_no}")
	boolean update(@Param("m_no") int m_no, @Param("s_no") String s_no, @Param("tagle") String tagle);
	
	
	/**
	 * 删除会议成员
	 * @param m_no
	 * @param s_no
	 * @return
	 */
	@Delete("delete from meeting_student where m_no = #{m_no} and s_no = #{s_no}")
	boolean remove(@Param("m_no") int m_no, @Param("s_no") String s_no);
	
	
}
