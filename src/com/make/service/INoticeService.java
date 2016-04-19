/**  
 * @Title: INoticeService.java
 * @Package com.make.service
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.service;

import java.util.List;

import com.make.bean.NoticeBean;

/**
 * ClassName: INoticeService
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
public interface INoticeService {
	/**
	 * @Description: 查询通知信息
	 * @param @param notice
	 * @param @return
	 * @return List<NoticeBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-18
	 */
	List<NoticeBean> loadNoticeInfo(NoticeBean notice);

	/**
	 * @Description: 添加通知信息
	 * @param @param notice
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-18
	 */
	public int insertNoticeInfo(NoticeBean notice);

	/**
	 * @Description: 跳转页面时，需要的数据
	 * @param @param id
	 * @param @return
	 * @return NoticeBean
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-18
	 */
	public NoticeBean linkPage(int id);

	/**
	 * @Description: 修改公告信息
	 * @param @param notice
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-18
	 */
	int updateInfo(NoticeBean notice);
}
