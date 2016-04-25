package com.make.service;

import java.util.List;

import com.make.bean.LjdjglBean;

public interface ILjdjglService {
	//根据录单日期及关键字查询零件等级管理
			public List<LjdjglBean> selectLjdjglBeansbyse(String creDate,String endDate,String keys);
			//新增零件等级管理
			public int addLjdjglBean(LjdjglBean ljdjglBean);
			//删除零件等级管理
			public int deleLjdjglBeanbyid(String ljdjid);
			//根据id查询邻居等级管理
			public LjdjglBean selectbyid(String id);
			//修改邻居等级管理
			public int updateljdjglBean(LjdjglBean ljdjglBean);
}
