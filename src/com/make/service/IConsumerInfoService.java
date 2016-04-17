/**  
 * @Title: IConsumerInfoService.java
 * @Package com.make.mapper
 * @Description: 客户信息service
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.service;

import java.util.List;

import com.make.bean.ConsumerInfoBean;

/**
 * ClassName: IConsumerInfoService
 * 
 * @Description: 存储类型信息Service
 * @author zhengjf
 * @date 2016-4-16
 */
public interface IConsumerInfoService {

	/**
	 * @Description: 查询 存储类型信息
	 * @param @param item
	 * @param @return
	 * @return List<ConsumerInfoBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	List<ConsumerInfoBean> loadInfo(ConsumerInfoBean item);

	/**
	 * @Description: 添加 存储类型信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	int insertInfo(ConsumerInfoBean item);

	/**
	 * @Description: 根据ID查询存储类型信息
	 * @param @param id
	 * @param @return
	 * @return ConsumerInfoBean
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-17
	 */
	public ConsumerInfoBean linkPage(int id);
}
