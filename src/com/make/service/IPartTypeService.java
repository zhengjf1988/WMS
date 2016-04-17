/**  
 * @Title: IPartTypeService.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.service;

import java.util.List;

import com.make.bean.PartTypeBean;

/**
 * ClassName: IPartTypeService
 * 
 * @Description: 零件类型信息Service
 * @author zhengjf
 * @date 2016-4-16
 */
public interface IPartTypeService {

	/**
	 * @Description: 查询 零件类型信息
	 * @param @param item
	 * @param @return
	 * @return List<PartTypeBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	List<PartTypeBean> loadInfo(PartTypeBean item);

	/**
	 * @Description: 添加 零件类型信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	int insertInfo(PartTypeBean item);

	/**
	 * @Description: 根据ID查询零件类型信息
	 * @param @param id
	 * @param @return
	 * @return PartTypeBean
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-17
	 */
	public PartTypeBean linkPage(int id);
}
