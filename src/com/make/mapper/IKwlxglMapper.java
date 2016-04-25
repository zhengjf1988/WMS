package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.KwlxglBean;

public interface IKwlxglMapper {
	//库位类型管理接口
		//新增库位类型管理
	 @Insert("INSERT into t_kwlxgl (kwid,kwname,kwmeno,creDate,inputman) values (#{kwid},#{kwname},#{kwmeno},#{creDate},#{inputman});")
	 int addKwlxglBean(KwlxglBean kwlxglBean);
	//查询全部库位类型
	 @Select(value="select * from t_kwlxgl")
	 @Results(value = {@Result(id = true, property = "kwid", column = "kwid"),@Result(property = "iddelete", column = "iddelete"),@Result(property = "kwname", column = "kwname"),@Result(property = "kwmeno", column = "kwmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 List<KwlxglBean> selectKwlxglBeanall();
     //查询全部库位类型未删除
	 @Select(value="select * from t_kwlxgl where iddelete=0")
	 @Results(value = {@Result(id = true, property = "kwid", column = "kwid"),@Result(property = "iddelete", column = "iddelete"),@Result(property = "kwname", column = "kwname"),@Result(property = "kwmeno", column = "kwmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 List<KwlxglBean> selectKwlxglBeanalltotrue();
	 //根据id查询库位类型管理
	 @Select(value="select * from t_kwlxgl where kwid=#{kwid}")
	 @Results(value = {@Result(id = true, property = "kwid", column = "kwid"),@Result(property = "kwname", column = "kwname"),@Result(property = "iddelete", column = "iddelete"),@Result(property = "kwmeno", column = "kwmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 KwlxglBean selectKwlxglBeanbyid(String kwid);
	 //根据sql查询库位类型管理
	 @Select(value = "${sql}")
	 @Results(value = {@Result(id = true, property = "kwid", column = "kwid"),@Result(property = "kwname", column = "kwname"),@Result(property = "iddelete", column = "iddelete"),@Result(property = "kwmeno", column = "kwmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 List<KwlxglBean> selectKwlxglBeanbysql(@Param(value = "sql") String sql);
	 //删除库位类型管理
	 @Delete("DELETE FROM t_kwlxgl where kwid = #{kwid};")
	 int deleteone(String kwid);
	 //修改库位类型管理
	 @Update("update t_kwlxgl set kwname=#{kwname},kwname=#{kwname},kwmeno=#{kwmeno},creDate=#{creDate},inputman=#{inputman} where kwid=#{kwid}")
	 int updateKwlxglBean(KwlxglBean kwlxglBean);
	 
	//逻辑删除库位类型管理
	@Update("update t_kwlxgl set useTag=0 where kwid=#{kwid}")
	int deleteonebylo(String kwid);
}
