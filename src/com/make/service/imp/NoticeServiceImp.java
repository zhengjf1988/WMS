/**  
 * @Title: NoticeServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.NoticeBean;
import com.make.mapper.INoticeMapper;
import com.make.service.INoticeService;

/**
 * ClassName: NoticeServiceImp
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
@Service
public class NoticeServiceImp implements INoticeService {

	@Autowired
	INoticeMapper noticeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.INoticeService#insertNoticeInfo(java.lang.String,
	 * com.make.bean.NoticeBean)
	 */
	public int insertNoticeInfo(NoticeBean notice) {
		noticeDao.insertNoticeInfo(notice);
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.make.service.INoticeService#loadNoticeInfo(com.make.bean.NoticeBean)
	 */
	public List<NoticeBean> loadNoticeInfo(NoticeBean notice) {
		// TODO Auto-generated method stub
		return null;
	}

}
