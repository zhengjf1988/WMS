/**  
 * @Title: IUserInfoMapper.java
 * @Package com.make.mapper
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-7
 */
package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.make.bean.UserBean;

/**
 * ClassName: IUserInfoMapper
 * 
 * @Description: 用户信息的Dao
 * @author zhengjf
 * @date 2016-4-7
 */
@Repository
public interface IUserInfoMapper {
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
	 * @Description: 检查用户添加或者修改的登录名是否存在
	 * @param @param username
	 * @param @return
	 * @return List<UserBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-15
	 */
	@Select("select * from t_user where username=#{username} and `status`=0")
	List<UserBean> checkUserInfo(@Param("username") String username);

	/**
	 * @Description: 修改用户信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	int updateInfo(UserBean item);
}
