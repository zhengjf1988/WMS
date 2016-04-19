/**  
 * @Title: NoticeController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

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
	public String loadNotice(HttpServletRequest req, NoticeBean item) {
		String res = "error";
		try {
			HttpSession session = req.getSession();
			List<NoticeBean> list = noticeService.loadNoticeInfo(item);
			session.setAttribute("item", null);
			session.setAttribute("list", list);
			return "system/notice";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return res;
	}

	/**
	 * @Description: 跳转到添加或者修改页面
	 * @param @param res
	 * @param @param id
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-18
	 */
	@RequestMapping("linkPage.do")
	public void linkPage(HttpServletResponse res, int id) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			NoticeBean item = noticeService.linkPage(id);
			JSONObject json = JSONObject.fromObject(item);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 根据传递的参数，调用添加或者修改的方法
	 * @param @param req
	 * @param @param item
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-18
	 */
	@RequestMapping("save.do")
	public String upsertNoticeInfo(HttpServletRequest req, NoticeBean item) {
		try {
			int id = Integer.parseInt(req.getParameter("noteId"));
			item.setId(id);
			HttpSession session = req.getSession();
			UserBean user = (UserBean) session.getAttribute("user");
			if (id == 0) {// 添加
				item.setOwner(user.getRealName());
				item.setCreatTime(DateUtils.date2String(new Date(), ""));
				noticeService.insertNoticeInfo(item);
			} else {// 修改
				noticeService.updateInfo(item);
			}
			return "redirect:list.do";
		} catch (Exception e) {
			log.error(e);
		}
		return "error";
	}

	/**
	 * @Description: 删除公告信息-------逻辑删除
	 * @param @param req
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	@RequestMapping("delete.do")
	public String deleteNoticeInfo(HttpServletRequest req) {
		try {
			NoticeBean item = new NoticeBean();
			int id = Integer.parseInt(req.getParameter("deleteId"));
			item.setId(id);
			item.setStatus(1);
			noticeService.updateInfo(item);
			return "redirect:list.do";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	/**
	 * @Description: 根据条件进行查询
	 * @param @param req
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	@RequestMapping("seach.do")
	public String seachNotice(HttpServletRequest req) {
		String res = "error";
		try {
			String title = req.getParameter("seachTitle");
			String content = req.getParameter("seachContent");
			String dateFrom = req.getParameter("dateFrom");
			String dateTo = req.getParameter("dateTo");

			NoticeBean item = new NoticeBean();
			item.setTitle(title);
			item.setContent(content);
			item.setCreatTime(dateFrom);
			item.setOwner(dateTo);// 这里就暂存结束时间

			HttpSession session = req.getSession();
			List<NoticeBean> list = noticeService.loadNoticeInfo(item);

			session.setAttribute("item", item);
			session.setAttribute("list", list);
			return "system/notice";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return res;
	}
}
