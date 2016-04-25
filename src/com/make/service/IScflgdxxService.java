package com.make.service;

import java.util.List;

import com.make.bean.ScflgdxxBean;

public interface IScflgdxxService {
	//根据录单日期及关键字查询生产发料工单信息
	public List<ScflgdxxBean> selectScflgdxxBeansbyse(String creDate,String endDate,String keys,String flag);
	//新增生产发料工单信息
	public int addScflgdxxBean(ScflgdxxBean scflgdxxBean);
	//删除生产发料工单信息
	public int deleScflgdxxBeanbyid(String id);
	//根据id查询生产发料工单信息
	public ScflgdxxBean selectbyid(String id);
	//修改生产发料工单信息
	public int updatescflgdxxBean(ScflgdxxBean scflgdxxBean);
	//全部生产发料工单信息
	public List<ScflgdxxBean> selectall();
	//全部生产发料工单信息未删除
	public List<ScflgdxxBean> selectalltotrue();
	//修改状态
	public int updatestatus(String status,String id);
}
