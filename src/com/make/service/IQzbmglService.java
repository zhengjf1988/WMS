package com.make.service;

import java.util.List;

import com.make.bean.QzbmglBean;

public interface IQzbmglService {

	
	//根据id查询条码编号

	public QzbmglBean selectbyid(int id);
   //修改条码编号根据id
	int updateQzbmglBean(QzbmglBean qzbmglBean);
	//获取编码
	public String getbm(int id);
}
