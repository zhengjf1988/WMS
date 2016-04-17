package com.make.service;

import java.util.List;

import com.make.bean.CcqxglBean;



public interface ICcqxglService {
	//根据录单日期及关键字查询存储期限管理
	public List<CcqxglBean> selectCcqxglBeanbyse(String creDate,String endDate,String keys);
	//新增存储期限管理
	public int addCcqxglBean(CcqxglBean ccqxglBean);
	//删除存储期限管理
	public int deleCcqxglBeanbyid(int ccid);
	//根据id 查询存储期限管理
	public CcqxglBean selectbyid(int id);
   //修改存储期限根据id
	int updateCcqxglBean(CcqxglBean ccqxglBean);
}
