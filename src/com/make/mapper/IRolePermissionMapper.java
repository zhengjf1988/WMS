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
}
