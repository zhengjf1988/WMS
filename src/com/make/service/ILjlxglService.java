package com.make.service;

import java.util.List;

import com.make.bean.LjlxglBean;

public interface ILjlxglService {
	//根据录单日期及关键字查询零件类型管理
		public List<LjlxglBean> selectLjlxglBeansbyse(String creDate,String endDate,String keys);
		//新增零件类型管理
		public int addLjlxglBean(LjlxglBean ljlxglBean);
		//删除零件类型管理
		public int deleLjlxglBeanbyid(String ljlxid);
		//根据id查询邻居类型管理
		public LjlxglBean selectbyid(String id);
		//修改邻居类型管理
		public int updatejlxglBean(LjlxglBean ljlxglBean);


}
