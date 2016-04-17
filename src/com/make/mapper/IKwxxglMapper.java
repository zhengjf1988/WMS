package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.KwxxglBean;


public interface IKwxxglMapper {
	//新增库位信息管理
		@Insert("INSERT into t_kwxxgl (kwname,kwtype,cctype,kwrl,kwbm,kwaddress,creDate,inputman,useTag) values (#{kwname},#{kwtype},#{cctype},#{kwrl},#{kwbm},#{kwaddress},#{creDate},#{inputman},#{useTag});")
		 int addkwxxglBean(KwxxglBean kwxxglBean);

		//查询全部有效库位信息管理
		 @Select(value="select * from t_kwxxgl where useTag=1")
		 @Results(value = {@Result(id = true, property = "kwid", column = "kwid"),@Result( property = "useTag", column = "useTag"),@Result(property = "kwname", column = "kwname"),@Result(property = "kwtype", column = "kwtype"),@Result(property = "cctype", column = "cctype"),@Result(property = "kwrl", column = "kwrl"),@Result(property = "kwbm", column = "kwbm"),@Result(property = "kwaddress", column = "kwaddress"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		 List<KwxxglBean> selectKwxxglBeanall();
		 //根据id查询库位信息管理
		 @Select(value="select * from t_kwxxgl where kwid=#{kwid}")
		 @Results(value = {@Result(id = true, property = "kwid", column = "kwid"),@Result( property = "useTag", column = "useTag"),@Result(property = "kwname", column = "kwname"),@Result(property = "kwtype", column = "kwtype"),@Result(property = "cctype", column = "cctype"),@Result(property = "kwrl", column = "kwrl"),@Result(property = "kwbm", column = "kwbm"),@Result(property = "kwaddress", column = "kwaddress"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		  KwxxglBean selectkwxxglBeanbyid(int kwid);
		 
		 //根据sql查询库位信息管理
		 @Select(value = "${sql}")
		 @Results(value = {@Result(id = true, property = "kwid", column = "kwid"),@Result( property = "useTag", column = "useTag"),@Result(property = "kwname", column = "kwname"),@Result(property = "kwtype", column = "kwtype"),@Result(property = "cctype", column = "cctype"),@Result(property = "kwrl", column = "kwrl"),@Result(property = "kwbm", column = "kwbm"),@Result(property = "kwaddress", column = "kwaddress"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		 List<KwxxglBean> selectkwxxglBeanbysql(@Param(value = "sql") String sql);
		 //删除库位信息管理
		 @Delete("DELETE FROM t_kwxxgl where kwid = #{kwid};")
		 int deleteone(int kwid);
		 //修改或者逻辑删除库位信息管理
		 @Update("update t_kwxxgl set kwname=#{kwname},kwtype=#{kwtype},cctype=#{cctype},kwrl=#{kwrl},kwbm=#{kwbm},kwaddress=#{kwaddress},creDate=#{creDate},inputman=#{inputman},useTag=#{useTag} where kwid=#{kwid}")
		 int updatekwxxglBean(KwxxglBean kwxxglBean);
	}
