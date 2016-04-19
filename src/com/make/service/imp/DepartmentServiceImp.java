/**  
 * @Title: DepartmentServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.DepartmentBean;
import com.make.mapper.IDepartmentMapper;
import com.make.service.IDepartmentService;

/**
 * ClassName: DepartmentServiceImp
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
@Service
public class DepartmentServiceImp implements IDepartmentService {

	@Autowired
	IDepartmentMapper departDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IDepartmentService#loadDepartment(com.make.bean.
	 * DepartmentBean)
	 */
	public List<DepartmentBean> loadDepartment(DepartmentBean depart) {
		// TODO Auto-generated method stub
		return departDao.loadDepartment(depart);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.IDepartmentService#insertDepart(com.make.bean.DepartmentBean
	 * )
	 */
	public int insertDepart(DepartmentBean depart) {
		return departDao.insertDepart(depart);
	}

	/* (non-Javadoc)
	 * @see com.make.service.IDepartmentService#updateInfo(com.make.bean.DepartmentBean)
	 */
	public int updateInfo(DepartmentBean item) {
		return departDao.updateInfo(item);
	}

}
