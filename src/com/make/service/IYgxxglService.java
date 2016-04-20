package com.make.service;

import java.util.List;

import com.make.bean.YgxxglBean;

public interface IYgxxglService {
	//根据录单日期及关键字查询员工信息管理
		public List<YgxxglBean> selectYgxxglBeanbyse(String creDate,String endDate,String keys);
		//新增员工信息管理
		public int addYgxxglBean(YgxxglBean YgxxglBean);
		//删除员工信息管理
		public int deleYgxxglBeanbyid(String ygid);
		//根据id 查询员工信息管理
		public YgxxglBean selectbyid(String id);
	   //修改员工信息根据id
		int updateYgxxglBean(YgxxglBean YgxxglBean);
}
