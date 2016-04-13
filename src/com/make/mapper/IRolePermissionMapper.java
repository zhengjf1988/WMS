/**  
 * @Title: IRolePermissionMapper.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
 */
package com.make.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.make.bean.MenuBtBean;
import com.make.bean.RolePermissionBean;

/**
 * ClassName: IRolePermissionMapper
 * 
 * @Description: 角色权限Dao
 * @author zhengjf
 * @date 2016-4-12
 */
@Repository
public interface IRolePermissionMapper {
	/**
	 * @Description: 查询菜单按钮信息
	 * @param @return
	 * @return List<MenuBtBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-12
	 */
	List<MenuBtBean> loadMenuBt();

	/**
	 * @Description: 查询角色信息
	 * @param @return
	 * @return List<RolePermissionBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-12
	 */
	public List<RolePermissionBean> loadRolePermission();

	/**
	 * @Description: 添加角色权限信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-13
	 */
	int insertRolePermission(RolePermissionBean item);
}
