package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.LjxxglBean;


public interface ILjxxglMapper {
	//零件信息管理接口
		//新增零件信息管理
	 @Insert("INSERT into t_ljxxgl (ljbm,ljname,cctype,sjlj,gjsl,creDate,inputman) values (#{ljbm},#{ljname},#{cctype},#{sjlj},#{gjsl},#{creDate},#{inputman});")
	 int addLjxxglBean(LjxxglBean ljxxglBean);
	//查询全部零件信息
	 @Select(value="select * from t_ljxxgl")
	 @Results(value = {@Result(id = true, property = "ljid", column = "ljid"),@Result(property = "useTag", column = "useTag"),@Result(property = "ljname", column = "ljname"),@Result(property = "cctype", column = "cctype"),@Result(property = "sjlj", column = "sjlj"),@Result(property = "gjsl", column = "gjsl"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman"),@Result(property = "ljbm", column = "ljbm")})
	 List<LjxxglBean> selectljxxglBeanall();
	 //根据id查询零件信息管理
	 @Select(value="select * from t_ljxxgl where ljid=#{ljid}")
	 @Results(value = {@Result(id = true, property = "ljid", column = "ljid"),@Result(property = "useTag", column = "useTag"),@Result(property = "ljname", column = "ljname"),@Result(property = "cctype", column = "cctype"),@Result(property = "sjlj", column = "sjlj"),@Result(property = "gjsl", column = "gjsl"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman"),@Result(property = "ljbm", column = "ljbm")})
		LjxxglBean selectLjxxglBeanbyid(String ljid);
	 //根据sql查询零件信息管理
	 @Select(value = "${sql}")
	 @Results(value = {@Result(id = true, property = "ljid", column = "ljid"),@Result(property = "useTag", column = "useTag"),@Result(property = "ljname", column = "ljname"),@Result(property = "cctype", column = "cctype"),@Result(property = "sjlj", column = "sjlj"),@Result(property = "gjsl", column = "gjsl"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman"),@Result(property = "ljbm", column = "ljbm")})
		List<LjxxglBean> selectLjxxglBeanbysql(@Param(value = "sql") String sql);
	 //删除零件信息管理
	 @Delete("DELETE FROM t_ljxxgl where ljid = #{ljid};")
	 int deleteone(String ljid);
	 //修改零件信息管理
	 @Update("update t_ljxxgl set ljname=#{ljname},cctype=#{cctype},sjlj=#{sjlj},gjsl=#{gjsl} ,ljbm=#{ljbm} where ljid=#{ljid}")
	 int updateLjxxglBean(LjxxglBean ljxxglBean);
	 
	//逻辑删除零件信息管理
	@Update("update t_ljxxgl set useTag=0 where ljid=#{ljid}")
	int deleteonebylo(String ljid);
	}
