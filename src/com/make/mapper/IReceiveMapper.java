/**  
 * @Title: IReceivevMapper.java
 * @Package com.make.mapper
 * @Description: 收货信息Dao
 * @author zhengjf
 * @date 2016-4-21
 */
package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.make.bean.ReceiveBean;

/**
 * ClassName: IReceivevMapper
 * 
 * @Description: 收货信息Dao
 * @author zhengjf
 * @date 2016-4-21
 */
@Repository
public interface IReceiveMapper {
	/**
	 * @Description: 查询收货信息
	 * @param @param item
	 * @param @return
	 * @return List<ReceiveBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	List<ReceiveBean> loadInfo(ReceiveBean item);

	/**
	 * @Description: 添加 提货信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	@Insert("INSERT INTO `t_receive` (`fk_LJId`, `count`, `fk_BZId`, `thDate`, `status`) VALUES (#{fk_LJId}, #{count}, #{fk_BZId}, #{thDate}, #{status})")
	int insertInfo(ReceiveBean item);

	/**
	 * @Description: 修改收货信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	int updateInfo(ReceiveBean item);
}
