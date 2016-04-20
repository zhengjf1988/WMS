package com.make.service;

import java.util.List;

import com.make.bean.LjxxglBean;

public interface ILjxxglService {
	//根据录单日期及关键字查询零件信息管理
			public List<LjxxglBean> selectLjxxglBeansbyse(String creDate,String endDate,String keys);
			//新增零件信息管理
			public int addLjxxglBean(LjxxglBean LjxxglBean);
			//删除零件信息管理
			public int deleLjxxglBeanbyid(String ljxxid);
			//根据id查询零件信息管理
			public LjxxglBean selectbyid(String id);
			//修改邻居信息管理
			public int updateLjxxglBean(LjxxglBean LjxxglBean);
}
