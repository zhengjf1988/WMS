/**  
 * @Title: ISelfPlanService.java
 * @Package com.make.service
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-28
 */
package com.make.service;

import java.util.List;
import java.util.Map;

import com.make.bean.SelfPlanBean;

/**
 * ClassName: ISelfPlanService
 * 
 * @Description: 内部生产计划Service
 * @author zhengjf
 * @date 2016-4-28
 */
public interface ISelfPlanService {

	/**
	 * @Description: 打开弹出框时进行的查询
	 * @param @param id
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-28
	 */
	public Map<String, Object> linkPage(int id);

	/**
	 * @Description: 添加内部生产计划
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-28
	 */
	int insertSelfInfo(SelfPlanBean item);

	/**
	 * @Description: 查询内部生产计划信息
	 * @param @param item
	 * @param @return
	 * @return List<SelfPlanBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-28
	 */
	List<SelfPlanBean> loadInfo(SelfPlanBean item);

	/**
	 * @Description: 修改内部计划
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-5-2
	 */
	int updateInfo(SelfPlanBean item);
}
