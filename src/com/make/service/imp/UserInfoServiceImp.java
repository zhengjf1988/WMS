/**  
 * @Title: UserInfoServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-14
 */
package com.make.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.DepartmentBean;
import com.make.bean.RolePermissionBean;
import com.make.bean.UserBean;
import com.make.mapper.IDepartmentMapper;
import com.make.mapper.IRolePermissionMapper;
import com.make.mapper.IUserInfoMapper;
import com.make.service.IUserInfoService;

/**
 * ClassName: UserInfoServiceImp
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-14
 */
@Service
public class UserInfoServiceImp implements IUserInfoService {

	@Autowired
	IUserInfoMapper userInfoDao;

	@Autowired
	IDepartmentMapper departDao;

	@Autowired
	IRolePermissionMapper roleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.IUserInfoService#loadUserInfo(com.make.bean.UserBean)
	 */
	public List<UserBean> loadUserInfo(UserBean item) {
		return userInfoDao.loadUserInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IUserInfoService#insertUser(com.make.bean.UserBean)
	 */
	public int insertUser(UserBean item) {
		return userInfoDao.insertUser(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IUserInfoService#linkUserPage(int)
	 */
	public Map<String, Object> linkUserPage(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserBean item = new UserBean();
		if (id > 0) {
			item.setId(id);
			item = userInfoDao.loadUserInfo(item).get(0);
		}
		List<DepartmentBean> depList = departDao.loadDepartment(null);
		List<RolePermissionBean> roleList = roleDao.loadRolePermission(null);
		map.put("item", item);
		map.put("depList", depList);
		map.put("roleList", roleList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IUserInfoService#checkUserInfo(java.lang.String)
	 */
	public boolean checkUserInfo(String username) {
		List<UserBean> list = userInfoDao.checkUserInfo(username);
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IUserInfoService#updateInfo(com.make.bean.UserBean)
	 */
	public int updateInfo(UserBean item) {
		return userInfoDao.updateInfo(item);
	}

}
