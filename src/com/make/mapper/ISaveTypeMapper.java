/**  
 * @Title: ISaveTypeMapper.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.make.bean.SaveTypeBean;

/**
 * ClassName: ISaveTypeMapper
 * 
 * @Description: 存储信息DAO
 * @author zhengjf
 * @date 2016-4-16
 */
@Repository
public interface ISaveTypeMapper {
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
}
