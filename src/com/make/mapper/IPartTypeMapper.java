/**  
 * @Title: IPartTypeMapper.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.make.bean.PartTypeBean;

/**
 * ClassName: IPartTypeMapper
 * 
 * @Description: 零件类型DAO
 * @author zhengjf
 * @date 2016-4-16
 */
@Repository
public interface IPartTypeMapper {
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
}
