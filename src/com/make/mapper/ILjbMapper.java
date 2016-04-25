package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.LjbBean;
import com.make.bean.LjbBean;

public interface ILjbMapper {
	//新增零件包
			@Insert("INSERT into t_ljb (kwid,ljid,tmbh,rksj,kcl) values (#{kwid},#{ljid},#{tmbh},#{rksj},#{kcl});")
			 int addLjbBean(LjbBean LjbBean);

			//查询全部有效零件包
			 @Select(value="select * from t_ljb ")
			 @Results(value = {@Result(id = true, property = "ljbid", column = "ljbid"),@Result(property = "kwid", column = "kwid"),@Result(property = "ljid", column = "ljid"),@Result(property = "tmbh", column = "tmbh"),@Result(property = "rksj", column = "rksj"),@Result(property = "kcl", column = "kcl")})
			 List<LjbBean> selectLjbBeanall();
			 //根据id查询零件包
			 @Select(value="select * from t_ljb where ljbid=#{ljbid}")
			 @Results(value = {@Result(id = true, property = "ljbid", column = "ljbid"),@Result(property = "kwid", column = "kwid"),@Result(property = "ljid", column = "ljid"),@Result(property = "tmbh", column = "tmbh"),@Result(property = "rksj", column = "rksj"),@Result(property = "kcl", column = "kcl")})
			  LjbBean selectLjbBeanbyid(int ljbid);
			 //根据零件id查询
			 @Select(value="select * from t_ljb where ljid=#{ljid}")
			 @Results(value = {@Result(id = true, property = "ljbid", column = "ljbid"),@Result(property = "kwid", column = "kwid"),@Result(property = "ljid", column = "ljid"),@Result(property = "tmbh", column = "tmbh"),@Result(property = "rksj", column = "rksj"),@Result(property = "kcl", column = "kcl")})
			 List<LjbBean> selectLjbBeanbyljid(int ljid);
			 
			 //根据sql查询零件包
			 @Select(value = "${sql}")
			 @Results(value = {@Result(id = true, property = "ljbid", column = "ljbid"),@Result(property = "kwid", column = "kwid"),@Result(property = "ljid", column = "ljid"),@Result(property = "tmbh", column = "tmbh"),@Result(property = "rksj", column = "rksj"),@Result(property = "kcl", column = "kcl")})
			 List<LjbBean> selectLjbBeanbysql(@Param(value = "sql") String sql);
			 //删除零件包
			 @Delete("DELETE FROM t_ljb where ljbid = #{ljbid};")
			 int deleteone(int ljbid);
			 //修改或者逻辑删除零件包
			 @Update("update t_ljb set kwid=#{kwid},ljid=#{ljid},tmbh=#{tmbh},rksj=#{rksj},kcl=#{kcl} where ljbid=#{ljbid}")
			 int updateLjbBean(LjbBean LjbBean);
			 
		
}
