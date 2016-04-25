package com.make.service;

import java.util.List;

import com.make.bean.LjbBean;

public interface ILjbService {
	//根据录单日期及关键字查询零件包
		public List<LjbBean> selectLjbBeansbyse(String creDate,String endDate,String keys);
		//新增零件包
		public int addLjbBean(LjbBean ljbBean);
		//删除零件包
		public int deleLjbBeanbyid(String id);
		//根据id查询零件包
		public LjbBean selectbyid(int id);
		//修改零件包
		public int updateljbBean(LjbBean ljbBean);
		//全部零件包
		public List<LjbBean> selectall();
		//全部零件包未删除
		public List<LjbBean> selectalltotrue();
		
		//根据零件id查询
		public List<LjbBean> selectallbyljid(int ljid);
}
