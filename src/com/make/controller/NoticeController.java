/**  
 * @Title: NoticeController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.NoticeBean;
import com.make.service.INoticeService;
import com.make.util.DateUtils;

/**
 * ClassName: NoticeController
 * 
 * @Description: 系统公告
 * @author zhengjf
 * @date 2016-4-11
 */
@Controller
@RequestMapping("note")
public class NoticeController {

	@Autowired
	INoticeService noticeService;

	@RequestMapping("list")
	public String loadNotice() {

		return "";
	}

	@RequestMapping("add.do")
	public String insertNoticeInfo(NoticeBean item) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		item.setDbName("wms_10000");
		item.setCreatTime(new Date());
		item.setOwner("李四");
		item.setStatus(0);

		noticeService.insertNoticeInfo(item);
		return "";
	}
}
