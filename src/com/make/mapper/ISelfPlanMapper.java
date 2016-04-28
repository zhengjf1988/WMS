/**  
 * @Title: SelfPlanMapper.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-28
 */
package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.make.bean.SelfPlanBean;

/**
 * ClassName: SelfPlanMapper
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-28
 */
public interface ISelfPlanMapper {

	/**
	 * @Description: 添加内部生产计划
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-28
	 */
	@Insert("INSERT INTO `t_selfPlan` (`fk_khId`,`fk_ljId`,`count`,`xqDate`,`status`) VALUES (#{fk_khId},#{fk_ljId},#{count},#{xqDate},#{status});")
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
}
