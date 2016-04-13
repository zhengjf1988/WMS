package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.LjlxglBean;


public interface ILjlxglMapper {
//零件类型管理接口
	//新增零件类型管理
 @Insert("INSERT into t_ljlxgl (lxid,lxname,lxmeno,creDate,inputman) values (#{lxid},#{lxname},#{lxmeno},#{creDate},#{inputman});")
 int addljlxglBean(LjlxglBean ljlxglBean);
//查询全部零件类型
 @Select(value="select * from t_ljlxgl")
 @Results(value = {@Result(id = true, property = "lxid", column = "lxid"),@Result(property = "lxname", column = "lxname"),@Result(property = "lxmeno", column = "lxmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
 List<LjlxglBean> selectljlxglBeanall();
 //根据id查询零件类型管理
 @Select(value="select * from t_ljlxgl where lxid=#{lxid}")
 @Results(value = {@Result(id = true, property = "lxid", column = "lxid"),@Result(property = "lxname", column = "lxname"),@Result(property = "lxmeno", column = "lxmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
 LjlxglBean selectljlxglBeanbyid(String lxid);
 //根据sql查询零件类型管理
 @Select(value = "${sql}")
 @Results(value = {@Result(id = true, property = "lxid", column = "lxid"),@Result(property = "lxname", column = "lxname"),@Result(property = "lxmeno", column = "lxmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
 List<LjlxglBean> selectljlxglBeanbysql(@Param(value = "sql") String sql);
 //删除零件类型管理
 @Delete("DELETE FROM t_ljlxgl where lxid = #{lxid};")
 int deleteone(String lxid);
 //删除零件类型管理
 @Update("update t_ljlxgl set lxname=#{lxname},lxname=#{lxname},lxmeno=#{lxmeno},creDate=#{creDate},inputman=#{inputman} where lxid=#{lxid}")
 int updateljlxglBean(LjlxglBean ljlxglBean);
}

