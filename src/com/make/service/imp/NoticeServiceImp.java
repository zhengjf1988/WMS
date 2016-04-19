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
		return noticeDao.insertNoticeInfo(notice);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.INoticeService#loadNoticeInfo(com.make.bean.NoticeBean)
	 */
	public List<NoticeBean> loadNoticeInfo(NoticeBean notice) {
		return noticeDao.loadNoticeInfo(notice);
	}

	/**
	 * @Description: 跳转页面时，需要的数据
	 * @param @param id
	 * @param @return
	 * @return NoticeBean
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-18
	 */
	public NoticeBean linkPage(int id) {
		NoticeBean item = new NoticeBean();
		item.setId(id);
		List<NoticeBean> list = noticeDao.loadNoticeInfo(item);
		if (id > 0) {
			return list.get(0);
		} else {
			return item;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.INoticeService#updateInfo(com.make.bean.NoticeBean)
	 */
	public int updateInfo(NoticeBean notice) {
		return noticeDao.updateInfo(notice);
	}

}
