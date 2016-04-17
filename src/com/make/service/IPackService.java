/**  
 * @Title: IPackService.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.service;

import java.util.List;

import com.make.bean.PackBean;

/**
 * ClassName: IPackService
 * 
 * @Description: 包装信息Service
 * @author zhengjf
 * @date 2016-4-16
 */
public interface IPackService {

	/**
	 * @Description: 查询包装信息
	 * @param @param item
	 * @param @return
	 * @return List<PackBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	List<PackBean> loadPackInfo(PackBean item);

	/**
	 * @Description: 添加包装信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	int insertPack(PackBean item);

	/**
	 * @Description: 根据ID查询包装信息
	 * @param @param id
	 * @param @return
	 * @return PackBean
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-17
	 */
	public PackBean linkPage(int id);
}
