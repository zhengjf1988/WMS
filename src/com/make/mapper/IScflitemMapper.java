package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.ScflitemBean;

public interface IScflitemMapper {
	//生产发料明细接口
	//新增生产发料明细
	@Insert("INSERT into t_scflitem (gdid,ljbid,kwid,ckstatus,fldate) values (#{gdid},#{ljbid},#{kwid},#{ckstatus},#{fldate});")
	int addScflitemBean(ScflitemBean scflitemBean);
	//查询全部生产发料明细
	@Select(value="select * from t_scflitem")
	@Results(value = {@Result(id = true, property = "flmxid", column = "flmxid"),@Result(property = "fldate", column = "fldate"),@Result(property = "gdid", column = "gdid"),@Result(property = "ljbid", column = "ljbid"),@Result(property = "kwid", column = "kwid"),@Result(property = "ckstatus", column = "ckstatus")})
	List<ScflitemBean> selectScflitemBeanall();
	//查询全部生产发料未删除
	@Select(value="select * from t_scflitem")
	@Results(value = {@Result(id = true, property = "flmxid", column = "flmxid"),@Result(property = "fldate", column = "fldate"),@Result(property = "gdid", column = "gdid"),@Result(property = "ljbid", column = "ljbid"),@Result(property = "kwid", column = "kwid"),@Result(property = "ckstatus", column = "ckstatus")})
	List<ScflitemBean> selectScflitemBeanalltotrue();
	//根据id查询生产发料明细
	@Select(value="select * from t_scflitem where flmxid=#{flmxid}")
	@Results(value = {@Result(id = true, property = "flmxid", column = "flmxid"),@Result(property = "fldate", column = "fldate"),@Result(property = "gdid", column = "gdid"),@Result(property = "ljbid", column = "ljbid"),@Result(property = "kwid", column = "kwid"),@Result(property = "ckstatus", column = "ckstatus")})
	ScflitemBean selectScflitemBeanbyid(String flmxid);
	//根据sql查询生产发料明细
	@Select(value = "${sql}")
	@Results(value = {@Result(id = true, property = "flmxid", column = "flmxid"),@Result(property = "fldate", column = "fldate"),@Result(property = "gdid", column = "gdid"),@Result(property = "ljbid", column = "ljbid"),@Result(property = "kwid", column = "kwid"),@Result(property = "ckstatus", column = "ckstatus")})
	List<ScflitemBean> selectScflitemBeanbysql(@Param(value = "sql") String sql);
	//删除生产发料明细
	@Delete("DELETE FROM t_scflitem where flmxid = #{flmxid};")
	int deleteone(String ljbid);
	//根据工单ID查询
	@Select(value="select * from t_scflitem where gdid=#{gdid}")
	@Results(value = {@Result(id = true, property = "flmxid", column = "flmxid"),@Result(property = "fldate", column = "fldate"),@Result(property = "gdid", column = "gdid"),@Result(property = "ljbid", column = "ljbid"),@Result(property = "kwid", column = "kwid"),@Result(property = "ckstatus", column = "ckstatus")})
	List<ScflitemBean> selectScflitemBeanbygdid(String gdid);
	//修改状态
	@Update(value = "${sql}")
	int upstu(@Param(value = "sql") String sql);

}
