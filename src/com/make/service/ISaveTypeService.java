/**  
 * @Title: ISaveTypeService.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.service;

import java.util.List;

import com.make.bean.SaveTypeBean;

/**
 * ClassName: ISaveTypeService
 * 
 * @Description: 存储类型信息Service
 * @author zhengjf
 * @date 2016-4-16
 */
public interface ISaveTypeService {

	/**
	 * @Description: 查询 存储类型信息
	 * @param @param item
	 * @param @return
	 * @return List<SaveTypeBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	List<SaveTypeBean> loadInfo(SaveTypeBean item);

	/**
	 * @Description: 添加 存储类型信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	int insertInfo(SaveTypeBean item);

	/**
	 * @Description: 根据ID查询存储类型信息
	 * @param @param id
	 * @param @return
	 * @return SaveTypeBean
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-17
	 */
	public SaveTypeBean linkPage(int id);

	/**
	 * @Description: 修改存储类型
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	int updateInfo(SaveTypeBean item);
}
