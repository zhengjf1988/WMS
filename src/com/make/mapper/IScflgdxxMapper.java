package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.ScflgdxxBean;

public interface IScflgdxxMapper {
	//生产发料工单管理接口
			//新增生产发料工单管理
		 @Insert("INSERT into t_scflgdxx (gdid,gdbh,ljmcid,creDate,inputman,scbzid,jhsj,fk_khid,ljsl,sxsj,flstatus) values (#{gdid},#{gdbh},#{ljmcid},#{creDate},#{inputman},#{scbzid},#{jhsj},#{fk_khid},#{ljsl},#{sxsj},#{flstatus});")
		 int addScflgdxxBean(ScflgdxxBean scflgdxxBean);
		//查询全部生产发料工单
		 @Select(value="select * from t_scflgdxx")
		 @Results(value = {@Result(id = true, property = "gdid", column = "gdid"),@Result(property = "scbzid", column = "scbzid"),@Result(property = "useTag", column = "useTag"),@Result(property = "gdbh", column = "gdbh"),@Result(property = "jhsj", column = "jhsj"),@Result(property = "fk_khid", column = "fk_khid"),@Result(property = "ljsl", column = "ljsl"),@Result(property = "sxsj", column = "sxsj"),@Result(property = "flstatus", column = "flstatus"),@Result(property = "ljmcid", column = "ljmcid"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		 List<ScflgdxxBean> selectScflgdxxBeanall();
		 //查询全部生产发料工单未删除
		 @Select(value="select * from t_scflgdxx where useTag=1")
		 @Results(value = {@Result(id = true, property = "gdid", column = "gdid"),@Result(property = "scbzid", column = "scbzid"),@Result(property = "useTag", column = "useTag"),@Result(property = "gdbh", column = "gdbh"),@Result(property = "jhsj", column = "jhsj"),@Result(property = "fk_khid", column = "fk_khid"),@Result(property = "ljsl", column = "ljsl"),@Result(property = "sxsj", column = "sxsj"),@Result(property = "flstatus", column = "flstatus"),@Result(property = "ljmcid", column = "ljmcid"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		 List<ScflgdxxBean> selectScflgdxxBeantotrue();
		 //根据id查询生产发料工单管理
		 @Select(value="select * from t_scflgdxx where gdid=#{gdid}")
		 @Results(value = {@Result(id = true, property = "gdid", column = "gdid"),@Result(property = "scbzid", column = "scbzid"),@Result(property = "useTag", column = "useTag"),@Result(property = "gdbh", column = "gdbh"),@Result(property = "jhsj", column = "jhsj"),@Result(property = "fk_khid", column = "fk_khid"),@Result(property = "ljsl", column = "ljsl"),@Result(property = "sxsj", column = "sxsj"),@Result(property = "flstatus", column = "flstatus"),@Result(property = "ljmcid", column = "ljmcid"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		 ScflgdxxBean selectScflgdxxBeanbyid(String gdid);
		 //根据sql查询生产发料工单管理
		 @Select(value = "${sql}")
		 @Results(value = {@Result(id = true, property = "gdid", column = "gdid"),@Result(property = "scbzid", column = "scbzid"),@Result(property = "useTag", column = "useTag"),@Result(property = "gdbh", column = "gdbh"),@Result(property = "jhsj", column = "jhsj"),@Result(property = "fk_khid", column = "fk_khid"),@Result(property = "ljsl", column = "ljsl"),@Result(property = "sxsj", column = "sxsj"),@Result(property = "flstatus", column = "flstatus"),@Result(property = "ljmcid", column = "ljmcid"),@Result(property = "creDate", column = "creDate"),@Result(property = "inputman", column = "inputman")})
		 List<ScflgdxxBean> selectScflgdxxBeanbysql(@Param(value = "sql") String sql);
		 //删除生产发料工单管理
		 @Delete("DELETE FROM t_scflgdxx where gdid = #{gdid};")
		 int deleteone(String gdid);
		 //修改生产发料工单管理
		 @Update("update t_scflgdxx set scbzid=#{scbzid},gdbh=#{gdbh},ljmcid=#{ljmcid},creDate=#{creDate},jhsj=#{jhsj},fk_khid=#{fk_khid},ljsl=#{ljsl},sxsj=#{sxsj},flstatus=#{flstatus},inputman=#{inputman} where gdid=#{gdid}")
		 int updateScflgdxxBean(ScflgdxxBean ScflgdxxBean);
		 
		//逻辑删除生产发料工单管理
		@Update("update t_scflgdxx set useTag=0 where gdid=#{gdid}")
		int deleteonebylo(String gdid);
		
		//生产发料工单管理修改状态
		@Update(value = "${sql}")
		int upflstatusonebylo(@Param(value = "sql") String sql);
}
