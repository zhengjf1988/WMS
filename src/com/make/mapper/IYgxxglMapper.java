package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.make.bean.YgxxglBean;

public interface IYgxxglMapper {
	//新增员工信息管理
		@Insert("INSERT into t_ygxxgl (ygbh,ygxm,zwmc,bmmc,inputman,creDate,lxfs,sxnl,photoAddr) values (#{ygbh},#{ygxm},#{zwmc},#{bmmc},#{inputman},#{creDate},#{lxfs},#{sxnl},#{photoAddr});")
		 int addYgxxglBean(YgxxglBean ygxxglBean);

		//查询全部有效员工信息管理
		 @Select(value="select * from t_ygxxgl where useTag=1")
		 @Results(value = {@Result(id = true, property = "ygid", column = "ygid"),@Result( property = "sxnl", column = "sxnl"),@Result( property = "photoAddr", column = "photoAddr"),@Result( property = "useTag", column = "useTag"),@Result(property = "ygxm", column = "ygxm"),@Result(property = "bmmc", column = "bmmc"),@Result(property = "lxfs", column = "lxfs"),@Result(property = "zwmc", column = "zwmc"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		 List<YgxxglBean> selectYgxxglBeanall();
		 //根据id查询员工信息管理
		 @Select(value="select * from t_ygxxgl where ygid=#{ygid}")
		 @Results(value = {@Result(id = true, property = "ygid", column = "ygid"),@Result( property = "sxnl", column = "sxnl"),@Result( property = "photoAddr", column = "photoAddr"),@Result( property = "useTag", column = "useTag"),@Result(property = "ygxm", column = "ygxm"),@Result(property = "bmmc", column = "bmmc"),@Result(property = "lxfs", column = "lxfs"),@Result(property = "zwmc", column = "zwmc"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		 YgxxglBean selectYgxxglBeanbyid(String ygid);
		 
		 //根据sql查询员工信息管理
		 @Select(value = "${sql}")
		 @Results(value = {@Result(id = true, property = "ygid", column = "ygid"),@Result( property = "sxnl", column = "sxnl"),@Result( property = "photoAddr", column = "photoAddr"),@Result(property = "useTag", column = "useTag"),@Result(property = "ygxm", column = "ygxm"),@Result(property = "bmmc", column = "bmmc"),@Result(property = "lxfs", column = "lxfs"),@Result(property = "zwmc", column = "zwmc"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		 List<YgxxglBean> selectYgxxglBeanbysql(@Param(value = "sql") String sql);
		 //删除员工信息管理
		 @Delete("DELETE FROM t_ygxxgl where ygid = #{ygid};")
		 int deleteone(String ygid);
		 //修改或者逻辑删除员工信息管理
		 @Update("update t_ygxxgl set ygxm=#{ygxm},ygbh=#{ygbh},zwmc=#{zwmc},bmmc=#{bmmc},lxfs=#{lxfs},creDate=#{creDate},inputman=#{inputman},useTag=#{useTag},sxnl=#{sxnl},photoAddr=#{photoAddr} where ygid=#{ygid}")
		 int updateYgxxglBean(YgxxglBean ygxxglBean);
	}


