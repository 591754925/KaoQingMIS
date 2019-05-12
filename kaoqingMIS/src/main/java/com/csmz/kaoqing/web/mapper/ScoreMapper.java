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

import com.csmz.kaoqing.web.ScoreUpdate;


/**
 * 
 * @author Charlene
 *
 */
@Mapper
public interface ScoreMapper {
	
	/**
	 * 获取审核记录列表
	 * @return
	 */
	@Select("select * from scoreupdate order by id desc")
	@Results({
		@Result(column = "s_no", 
				property = "student",
				one=@One(select="com.csmz.kaoqing.web.mapper.StudentMapper.loadById")),
	})
	List<ScoreUpdate> list();
	
	/**
	 * 添加审核记录
	 * @return
	 */
	@Insert("insert into scoreupdate(s_no, score, addScore, addCause, delScore, delCause, time) values(#{s_no}, #{score}, #{addScore}, #{addCause}, #{delScore}, #{delCause}, #{time})")
	boolean save(@Param("s_no") String s_no, @Param("score") int score, @Param("addScore") int addScore,
			@Param("addCause") String addCause, @Param("delScore") int delScore, @Param("delCause") String delCause, @Param("time") String time);
	
	/**
	 * 删除审核记录
	 * @param id
	 * @return
	 */
	@Delete("delete from scoreupdate where id = #{id}")
	boolean remove(@Param("id") int id);
	
}
