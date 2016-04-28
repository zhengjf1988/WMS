/**  
 * @Title: NoticeController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.NoticeBean;
import com.make.bean.UserBean;
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

	Logger log = Logger.getLogger(NoticeController.class);

	@Autowired
	INoticeService noticeService;

	@RequestMapping("list.do")
	public String loadNotice(HttpServletRequest req) {
		String res = "error";
		try {
			NoticeBean item=new NoticeBean();
			HttpSession session = req.getSession();
			item.setDbName("wms_10000");
			List<NoticeBean> list = noticeService.loadNoticeInfo(item);
			session.setAttribute("list", list);
			return "system/notice";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return res;
	}

	@RequestMapping("add.do")
	public String insertNoticeInfo(HttpServletRequest req, NoticeBean item) {
		try {
			HttpSession session = req.getSession();
			UserBean user = (UserBean) session.getAttribute("user");
			item.setOwner(user.getRealName());
			item.setStatus(0);
			item.setCreatTime(DateUtils.date2String(new Date(), ""));

			noticeService.insertNoticeInfo(item);
			return "redirect:list.do";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
