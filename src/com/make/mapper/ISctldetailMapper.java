package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.SctldetailBean;

public interface ISctldetailMapper {
	//生产退料明细接口
		//新增生产退料明细
		@Insert("INSERT into t_sctldetail (flmxid,tmbh,tlsl,tlsj,rksj,inputman,ljid) values (#{flmxid},#{tmbh},#{tlsl},#{tlsj},#{rksj},#{inputman},#{ljid});")
		int addSctldetailBean(SctldetailBean sctldetailBean);
		//查询全部生产退料明细
		@Select(value="select * from t_sctldetail")
		@Results(value = {@Result(id = true, property = "tlmxid", column = "tlmxid"),@Result(property = "flmxid", column = "flmxid"),@Result(property = "inputman", column = "inputman"),@Result(property = "ljid", column = "ljid"),@Result(property = "tmbh", column = "tmbh"),@Result(property = "tlsl", column = "tlsl"),@Result(property = "tlsj", column = "tlsj"),@Result(property = "rksj", column = "rksj"),@Result(property = "tlstatus", column = "tlstatus"),@Result(property = "useTag", column = "useTag")})
		List<SctldetailBean> selectSctldetailBeanall();

		//根据id查询生产退料明细
		@Select(value="select * from t_sctldetail where tlmxid=#{tlmxid}")
		@Results(value = {@Result(id = true, property = "tlmxid", column = "tlmxid"),@Result(property = "flmxid", column = "flmxid"),@Result(property = "inputman", column = "inputman"),@Result(property = "ljid", column = "ljid"),@Result(property = "tmbh", column = "tmbh"),@Result(property = "tlsl", column = "tlsl"),@Result(property = "tlsj", column = "tlsj"),@Result(property = "rksj", column = "rksj"),@Result(property = "tlstatus", column = "tlstatus"),@Result(property = "useTag", column = "useTag")})
		SctldetailBean selectSctldetailBeanbyid(String tlmxid);
		//根据sql查询生产退料明细
		@Select(value = "${sql}")
		@Results(value = {@Result(id = true, property = "tlmxid", column = "tlmxid"),@Result(property = "flmxid", column = "flmxid"),@Result(property = "inputman", column = "inputman"),@Result(property = "ljid", column = "ljid"),@Result(property = "tmbh", column = "tmbh"),@Result(property = "tlsl", column = "tlsl"),@Result(property = "tlsj", column = "tlsj"),@Result(property = "rksj", column = "rksj"),@Result(property = "tlstatus", column = "tlstatus"),@Result(property = "useTag", column = "useTag")})
		List<SctldetailBean> selectSctldetailBeanbysql(@Param(value = "sql") String sql);
		//删除生产退料明细
		@Delete("DELETE FROM t_sctldetail where tlmxid = #{tlmxid};")
		int deleteone(String tlmxid);

		//修改状态
		@Update(value = "${sql}")
		int upstu(@Param(value = "sql") String sql);
}
