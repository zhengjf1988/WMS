package com.make.service;

import java.util.List;

import com.make.bean.KhscplanBean;

public interface IKhscplanService {
	//根据录单日期及关键字查询客户生产计划
	public List<KhscplanBean> selectKhscplanBeanbyse(String creDate,String endDate,String keys);
	//新增客户生产计划
	public int addKhscplanBean(KhscplanBean khscplanBean);
	//删除客户生产计划
	public int deleKhscplanBeanbyid(int id);
	//根据id 查询客户生产计划
	public KhscplanBean selectbyid(int id);
   //修改存储期限根据id
	int updateKhscplanBean(KhscplanBean khscplanBean);
}
