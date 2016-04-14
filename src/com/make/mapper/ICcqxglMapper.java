package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.CcqxglBean;
import com.make.bean.LjlxglBean;

public interface ICcqxglMapper {
	
	//新增存储期限管理
	@Insert("INSERT into t_ccqxgl (ccid,ccname,kwmeno,issx,inputman,creDate,sxqx,useTag) values (#{ccid},#{ccname},#{kwmeno},#{issx},#{inputman},#{creDate},#{sxqx},#{useTag});")
	 int addccqxglBean(CcqxglBean ccqxglBean);

	//查询全部有效存储期限管理
	 @Select(value="select * from t_ccqxgl where useTag=1")
	 @Results(value = {@Result(id = true, property = "ccid", column = "ccid"),@Result( property = "useTag", column = "useTag"),@Result(property = "ccname", column = "ccname"),@Result(property = "issx", column = "issx"),@Result(property = "sxqx", column = "sxqx"),@Result(property = "kwmeno", column = "kwmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 List<CcqxglBean> selectccqxglBeanall();
	 //根据id查询存储期限管理
	 @Select(value="select * from t_ccqxgl where ccid=#{ccid}")
	 @Results(value = {@Result(id = true, property = "ccid", column = "ccid"),@Result( property = "useTag", column = "useTag"),@Result(property = "ccname", column = "ccname"),@Result(property = "issx", column = "issx"),@Result(property = "sxqx", column = "sxqx"),@Result(property = "kwmeno", column = "kwmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 CcqxglBean selectccqxglBeanbyid(int ccid);
	 
	 //根据sql查询存储期限管理
	 @Select(value = "${sql}")
	 @Results(value = {@Result(id = true, property = "ccid", column = "ccid"),@Result(property = "useTag", column = "useTag"),@Result(property = "ccname", column = "ccname"),@Result(property = "issx", column = "issx"),@Result(property = "sxqx", column = "sxqx"),@Result(property = "kwmeno", column = "kwmeno"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
	 List<CcqxglBean> selectccqxglBeanbysql(@Param(value = "sql") String sql);
	 //删除存储期限管理
	 @Delete("DELETE FROM t_ccqxgl where ccid = #{ccid};")
	 int deleteone(int ccid);
	 //修改或者逻辑删除存储期限管理
	 @Update("update t_ccqxgl set ccname=#{ccname},kwmeno=#{kwmeno},issx=#{issx},sxqx=#{sxqx},creDate=#{creDate},inputman=#{inputman},useTag=#{useTag} where ccid=#{ccid}")
	 int updateccqxglBean(CcqxglBean ccqxglBean);
}
