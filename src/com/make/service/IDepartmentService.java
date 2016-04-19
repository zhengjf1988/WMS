/**  
 * @Title: IDepartmentService.java
 * @Package com.make.service
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.service;

import java.util.List;

import com.make.bean.DepartmentBean;

/**
 * ClassName: IDepartmentService
 * 
 * @Description: 部门信息Service
 * @author zhengjf
 * @date 2016-4-11
 */
public interface IDepartmentService {
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
