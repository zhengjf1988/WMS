package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.KhscplanBean;

public interface IKhscplanMapper {
	//新增客户生产计划
		@Insert("INSERT into t_khscplan (khscid,khid,ljid,ljsl,xqsj) values (#{khscid},#{khid},#{ljid},#{ljsl},#{xqsj});")
		 int addKhscplanBean(KhscplanBean khscplanBean);

		//查询全部有效客户生产计划
		 @Select(value="select * from t_khscplan where useTag=1")
		 @Results(value = {@Result(id = true, property = "khscid", column = "khscid"),@Result( property = "useTag", column = "useTag"),@Result(property = "khid", column = "khid"),@Result(property = "ljsl", column = "ljsl"),@Result(property = "ljid", column = "ljid"),@Result(property = "ispg", column = "ispg"),@Result(property = "xqsj", column = "xqsj")})
		 List<KhscplanBean> selectKhscplanBeanall();
		 //根据id查询客户生产计划
		 @Select(value="select * from t_khscplan where khscid=#{khscid}")
		 @Results(value = {@Result(id = true, property = "khscid", column = "khscid"),@Result( property = "useTag", column = "useTag"),@Result(property = "khid", column = "khid"),@Result(property = "ljsl", column = "ljsl"),@Result(property = "ljid", column = "ljid"),@Result(property = "ispg", column = "ispg"),@Result(property = "xqsj", column = "xqsj")})
		 KhscplanBean selectKhscplanBeanbyid(int khscid);
		 
		 //根据sql查询客户生产计划
		 @Select(value = "${sql}")
		 @Results(value = {@Result(id = true, property = "khscid", column = "khscid"),@Result( property = "useTag", column = "useTag"),@Result(property = "khid", column = "khid"),@Result(property = "ljsl", column = "ljsl"),@Result(property = "ljid", column = "ljid"),@Result(property = "ispg", column = "ispg"),@Result(property = "xqsj", column = "xqsj")})
		 List<KhscplanBean> selectKhscplanBeanbysql(@Param(value = "sql") String sql);
		 //删除客户生产计划
		 @Delete("DELETE FROM t_khscplan where khscid = #{khscid};")
		 int deleteone(int khscid);
		 //修改或者逻辑删除客户生产计划
		 @Update("update t_khscplan set khid=#{khid},ljid=#{ljid},ljsl=#{ljsl},ispg=#{ispg},xqsj=#{xqsj},useTag=#{useTag} where khscid=#{khscid}")
		 int updateKhscplanBean(KhscplanBean khscplanBean);
}
