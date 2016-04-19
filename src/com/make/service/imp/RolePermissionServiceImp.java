/**  
 * @Title: RolePermissionServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
 */
package com.make.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * @see com.make.service.IRolePermissionService#linkPage()
	 */
	public Map<String, Object> linkPage(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		RolePermissionBean item = new RolePermissionBean();
		item.setId(id);

		List<MenuBtBean> list = rolePermDao.loadMenuBt();

		if (item.getId() > 0) {// 编辑的时候走这里
			List<RolePermissionBean> roleList = rolePermDao.loadRolePermission(item);
			item = roleList.get(0);

			for (MenuBtBean menuBtBean : list) {
				if (item.getPermission().indexOf(";" + menuBtBean.getId() + ";") > -1) {
					menuBtBean.setChecked(true);
				}
			}
		}
		map.put("item", item);// 添加的时候里面是空值
		map.put("list", list);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IRolePermissionService#loadRolePermission()
	 */
	public List<RolePermissionBean> loadRolePermission(RolePermissionBean item) {
		return rolePermDao.loadRolePermission(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.IRolePermissionService#insertRolePermission(com.make
	 * .bean.RolePermissionBean)
	 */
	public int insertRolePermission(RolePermissionBean item) {
		return rolePermDao.insertRolePermission(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IRolePermissionService#updateInfo(com.make.bean.
	 * RolePermissionBean)
	 */
	public int updateInfo(RolePermissionBean item) {
		return rolePermDao.updateInfo(item);
	}
}
