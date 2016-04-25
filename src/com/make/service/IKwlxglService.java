package com.make.service;

import java.util.List;

import com.make.bean.KwlxglBean;
public interface IKwlxglService {
	//根据录单日期及关键字查询库位类型管理
	public List<KwlxglBean> selectKwlxglBeansbyse(String creDate,String endDate,String keys);
	//新增库位类型管理
	public int addKwlxglBean(KwlxglBean kwlxglBean);
	//删除库位类型管理
	public int deleKwlxglBeanbyid(String kwlxid);
	//根据id查询库位类型管理
	public KwlxglBean selectbyid(String id);
	//修改库位类型管理
	public int updatejlxglBean(KwlxglBean kwlxglBean);
	//全部库位类型管理
	public List<KwlxglBean> selectall();
	//全部库位类型管理未删除
	public List<KwlxglBean> selectalltotrue();
}
