package com.make.service;

import java.util.List;

import com.make.bean.ScflgdxxBean;
import com.make.bean.ScflitemBean;

public interface IScflitemService {
	//根据录单日期及关键字查询生产发料工单信息
	public List<ScflitemBean> selectScflitemBeansbyse(String creDate,String endDate,String keys,String flag);
	//新增生产发料明细
	public int addScflitemBean(ScflitemBean scflitemBean);
	//删除生产发料明细
	public int deleScflitemBeanbyid(int id);
	//根据id 查询生产发料明细
	public ScflitemBean selectbyid(String id);
   //状态位
	int updateScflitemBean(String kwid,String id);
}
