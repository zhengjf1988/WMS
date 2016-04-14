/**  
 * @Title: IUserInfoService.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-7
 */
package com.make.service;

import java.util.List;
import java.util.Map;

import com.make.bean.UserBean;

/**
 * ClassName: IUserInfoService
 * 
 * @Description: 用户信息的Dao
 * @author zhengjf
 * @date 2016-4-7
 */
public interface IUserInfoService {
	/**
	 * @Description: 查询用户信息
	 * @param @param item
	 * @param @return
	 * @return List<UserBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-14
	 */
	List<UserBean> loadUserInfo(UserBean item);

	/**
	 * @Description: 添加用户信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-14
	 */
	int insertUser(UserBean item);

	/**
	 * @Description: 跳转到添加或者修改用户信息页面
	 * @param @param id
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-14
	 */
	Map<String, Object> linkUserPage(int id);

	/**
	 * @Description: 检查用户添加或者修改的登录名是否存在
	 * @param @param username
	 * @param @return
	 * @return List<UserBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-15
	 */
	boolean checkUserInfo(String username);
}
