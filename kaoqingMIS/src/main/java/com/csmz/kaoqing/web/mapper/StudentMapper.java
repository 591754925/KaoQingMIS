package com.csmz.kaoqing.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.csmz.kaoqing.web.Student;


/**
 * 
 * @author Charlene
 *
 */
@Mapper
public interface StudentMapper {
	
	/**
	 * 查找某个部门的学生
	 * @param d_no
	 * @return
	 */
	@Select("select * from students where d_no = #{d_no} order by s_greed desc")
	@Results({
		@Result(column = "d_no", 
				property = "dept",
				many=@Many(select="com.csmz.kaoqing.web.mapper.DeptMapper.loadById")),
	})
	List<Student> list(@Param("d_no") int d_no);
	
	
	/**
	 * 查找所有学生
	 * @param d_no
	 * @return
	 */
	@Select("select * from students")
	@Results({
		@Result(column = "d_no", 
				property = "dept",
				many=@Many(select="com.csmz.kaoqing.web.mapper.DeptMapper.loadById")),
	})
	List<Student> listAll();
	
	
	
	/**
	 * 根据学号获取单个学生
	 * @param s_no
	 * @return
	 */
	@Select("select * from students where s_no = #{s_no}")
	@Results({
		@Result(column = "d_no", 
				property = "dept",
				many=@Many(select="com.csmz.kaoqing.web.mapper.DeptMapper.loadById")),
	})
	Student loadById (@Param("s_no") String s_no);
	
	
	/**
	 * 修改分数
	 * @param s_no
	 * @param change
	 */
	@Update("update students set score = score + #{c} where s_no = #{s_no}")
	void updateScoreById(@Param("s_no") String s_no, @Param("c") int change); 
	
	
	/**
	 * 添加学生
	 * @param stu
	 */
	@Insert("insert into students(s_no, s_name, s_class, d_no, s_greed, greed_name,"
			+ " telephone, score, onTimes, lateTimes, outTimes, leaveTimes) "
			+ "values(#{s_no}, #{s_name}, #{s_class}, #{dept.d_no}, #{s_greed}, #{greed_name}, #{telephone}, #{score}, #{onTimes}, #{lateTimes}, #{outTimes}, #{leaveTimes})")
	void save(Student stu);
	
	
	/**
	 * 修改学生
	 * @param stu
	 */
	@Update("update students set s_name = #{s_name}, s_class=#{s_class}, d_no=#{dept.d_no}, s_greed=#{s_greed}, greed_name=#{greed_name}, telephone=#{telephone}, score=#{score}, onTimes=#{onTimes}, lateTimes=#{lateTimes}, outTimes=#{outTimes}, leaveTimes=#{leaveTimes} where s_no =#{s_no};")
	void updateStudent(Student stu);
	
	
	/**
	 * 考勤
	 * @param s_no	学号
	 * @param name	字段名
	 * @param socre	分数
	 */
	@Update("update students set #{name} = #{name} + #{score} where s_no = #{s_no}")
	void updateScore(@Param("s_no") String s_no, @Param("name") String name, @Param("score") int score);
	
	/**
	 * 考勤
	 */
	
	@Update("update students set onTimes = onTimes + #{score} where s_no = #{s_no}")
	void onTimes(@Param("s_no") String s_no, @Param("score") int score);
	
	@Update("update students set outTimes = outTimes + #{score} where s_no = #{s_no}")
	void outTimes(@Param("s_no") String s_no, @Param("score") int score);
	
	@Update("update students set leaveTimes = leaveTimes + #{score} where s_no = #{s_no}")
	void leaveTimes(@Param("s_no") String s_no, @Param("score") int score);
	
	@Update("update students set lateTimes = lateTimes + #{score} where s_no = #{s_no}")
	void lateTimes(@Param("s_no") String s_no, @Param("score") int score);
	
	/**
	 * 删除学生
	 * @param s_no
	 */
	@Select("delete from students where s_no = #{s_no}")
	void remove(@Param("s_no") String s_no);
	
}
