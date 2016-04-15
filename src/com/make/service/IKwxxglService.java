package com.make.service;

import java.util.List;

import com.make.bean.KwxxglBean;

public interface IKwxxglService {
	//根据录单日期及关键字查询库位信息管理
		public List<KwxxglBean> selectKwxxglBeanbyse(String creDate,String endDate,String keys);
		//新增库位信息管理
		public int addKwxxglBean(KwxxglBean kwxxglBean);
		//删除库位信息管理
		public int deleKwxxglBeanbyid(int ccid);
		//根据id 查询库位信息管理
		public KwxxglBean selectbyid(int id);
	   //修改库位信息根据id
		int updateKwxxglBean(KwxxglBean kwxxglBean);
}
