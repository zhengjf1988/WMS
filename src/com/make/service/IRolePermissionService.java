/**  
 * @Title: IRolePermissionService.java
 * @Package com.make.service
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
 */
package com.make.service;

import java.util.List;

import com.make.bean.MenuBtBean;

/**
 * ClassName: IRolePermissionService
 * 
 * @Description: 角色权限Service
 * @author zhengjf
 * @date 2016-4-12
 */
public interface IRolePermissionService {

	/**
	 * @Description: 查询菜单按钮信息
	 * @param @return
	 * @return List<MenuBtBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-12
	 */
	public List<MenuBtBean> loadMenuBt();
}
