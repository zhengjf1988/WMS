package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.LjdjglBean;

public interface ILjdjglMapper {
	//零件等级管理接口
		//新增零件等级管理
	 @Insert("INSERT into t_ljdjgl (djid,djname,djmeno,creDate,inputman) values (#{djid},#{djname},#{djmeno},#{creDate},#{inputman});")
	 int addLjdjglBean(LjdjglBean ljdjglBean);
	//查询全部零件等级
	 @Select(value="select * from t_ljdjgl")
	 @Results(value = {@Result(id = true, property = "djid", column = "djid"),@Result(property = "iddelete", column = "iddelete"),@Result(property = "djname", column = "djname"),@Result(property = "djmeno", column = "djmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 List<LjdjglBean> selectLjdjglBeanall();
	 //根据id查询零件等级管理
	 @Select(value="select * from t_ljdjgl where djid=#{djid}")
	 @Results(value = {@Result(id = true, property = "djid", column = "djid"),@Result(property = "djname", column = "djname"),@Result(property = "iddelete", column = "iddelete"),@Result(property = "djmeno", column = "djmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 LjdjglBean selectLjdjglBeanbyid(String djid);
	 //根据sql查询零件等级管理
	 @Select(value = "${sql}")
	 @Results(value = {@Result(id = true, property = "djid", column = "djid"),@Result(property = "djname", column = "djname"),@Result(property = "iddelete", column = "iddelete"),@Result(property = "djmeno", column = "djmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 List<LjdjglBean> selectLjdjglBeanbysql(@Param(value = "sql") String sql);
	 //删除零件等级管理
	 @Delete("DELETE FROM t_ljdjgl where djid = #{djid};")
	 int deleteone(String djid);
	 //修改零件等级管理
	 @Update("update t_ljdjgl set djname=#{djname},djname=#{djname},djmeno=#{djmeno},creDate=#{creDate},inputman=#{inputman} where djid=#{djid}")
	 int updateLjdjglBean(LjdjglBean ljdjglBean);
	 
	//逻辑删除零件等级管理
	@Update("update t_ljdjgl set iddelete=1 where djid=#{djid}")
	int deleteonebylo(String djid);
}
