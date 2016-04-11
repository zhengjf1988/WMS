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
	List<NoticeBean> loadNoticeInfo(NoticeBean notice);

	public int insertNoticeInfo(NoticeBean notice);
}
