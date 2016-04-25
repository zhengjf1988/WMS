package com.make.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.make.bean.QzbmglBean;

public interface IQzbmglMapper {
	 //根据id查询存储期限管理
	 @Select(value="select * from t_qzbmgl where id=#{id}")
	 @Results(value = {@Result(id = true, property = "id", column = "id"),@Result( property = "qianzhui", column = "qianzhui"),@Result(property = "dqvalue", column = "dqvalue"),@Result(property = "beizhu", column = "beizhu")})
	 QzbmglBean selectQzbmglBeanbyid(int id);
	 int deleteone(int ccid);
	 //修改或者逻辑删除存储期限管理
	 @Update("update t_qzbmgl set dqvalue=#{dqvalue} where id=#{id}")
	 int updateQzbmglBean(QzbmglBean qzbmglBean);

}
