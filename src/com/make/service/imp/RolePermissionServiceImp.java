/**  
 * @Title: RolePermissionServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
 */
package com.make.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.MenuBtBean;
import com.make.bean.RolePermissionBean;
import com.make.mapper.IRolePermissionMapper;
import com.make.service.IRolePermissionService;

/**
 * ClassName: RolePermissionServiceImp
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
 */
@Service
public class RolePermissionServiceImp implements IRolePermissionService {

	@Autowired
	IRolePermissionMapper rolePermDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IRolePermissionService#loadMenuBt()
	 */
	public List<MenuBtBean> loadMenuBt() {
		List<MenuBtBean> list = rolePermDao.loadMenuBt();

		// List<MenuBtBean> resultList = new ArrayList<MenuBtBean>();
		//
		// for (MenuBtBean item : list) {
		// if (item.getType() == 1 || item.getType() == 2) {
		// for (MenuBtBean tmp : list) {
		// if (tmp.getParentId() == item.getId()) {
		// item.getChildList().add(tmp);
		// }
		// }
		// }
		// }
		// for (MenuBtBean item : list) {
		// if (item.getType() == 1) {
		// resultList.add(item);
		// }
		// }
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IRolePermissionService#loadRolePermission()
	 */
	public List<RolePermissionBean> loadRolePermission() {
		return rolePermDao.loadRolePermission();
	}
}
