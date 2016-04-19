/**  
 * @Title: IPackMapper.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.make.bean.PackBean;

/**
 * ClassName: IPackMapper
 * 
 * @Description: 包装信息DAO
 * @author zhengjf
 * @date 2016-4-16
 */
@Repository
public interface IPackMapper {

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
	 * @Description: 修改包装信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	int updateInfo(PackBean item);
}
