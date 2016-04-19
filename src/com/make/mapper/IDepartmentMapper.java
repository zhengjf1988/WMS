/**  
 * @Title: IDepartmentMapper.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.make.bean.DepartmentBean;

/**
 * ClassName: IDepartmentMapper
 * 
 * @Description: 部门信息dao
 * @author zhengjf
 * @date 2016-4-11
 */
@Repository
public interface IDepartmentMapper {

	/**
	 * @Description: 查询部门信息
	 * @param @param depart
	 * @param @return
	 * @return List<DepartmentBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-11
	 */
	List<DepartmentBean> loadDepartment(DepartmentBean depart);

	/**
	 * @Description: 添加部门信息
	 * @param @param depart
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-11
	 */
	int insertDepart(DepartmentBean depart);

	/**
	 * @Description: 修改信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	int updateInfo(DepartmentBean item);
}
