/**  
 * @Title: IConsumerInfoMapper.java
 * @Package com.make.mapper
 * @Description: 客户信息Dao
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.make.bean.ConsumerInfoBean;

/**
 * ClassName: IConsumerInfoMapper
 * 
 * @Description: 客户信息Dao
 * @author zhengjf
 * @date 2016-4-16
 */
@Repository
public interface IConsumerInfoMapper {
	/**
	 * @Description: 查询 客户信息
	 * @param @param item
	 * @param @return
	 * @return List<ConsumerInfoBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	List<ConsumerInfoBean> loadInfo(ConsumerInfoBean item);

	/**
	 * @Description: 添加 客户信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-16
	 */
	int insertInfo(ConsumerInfoBean item);

	/**
	 * @Description: 修改客户信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	int updateInfo(ConsumerInfoBean item);
}
