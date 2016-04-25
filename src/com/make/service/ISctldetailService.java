package com.make.service;

import java.util.List;

import com.make.bean.SctldetailBean;

public interface ISctldetailService {
	//根据录单日期及关键字查询生产退料工单信息
		public List<SctldetailBean> selectSctldetailBeansbyse(String creDate,String endDate,String keys,String flag);
		//新增生产退料明细
		public int addSctldetailBean(SctldetailBean SctldetailBean);
		//删除生产退料明细
		public int deleSctldetailBeanbyid(int id);
		//根据id 查询生产退料明细
		public SctldetailBean selectbyid(String id);
	   //状态位
		int updateSctldetailBean(String st,String id);
	}

