/**  
 * @Title: ConsumerInfoController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-17
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

import com.make.bean.ConsumerInfoBean;
import com.make.bean.UserBean;
import com.make.service.IConsumerInfoService;
import com.make.util.DateUtils;

/**
 * ClassName: ConsumerInfoController
 * 
 * @Description: 信息管理-客户信息管理controller
 * @author zhengjf
 * @date 2016-4-17
 */
@Controller
@RequestMapping("consumer")
public class ConsumerInfoController {

	Logger log = Logger.getLogger(ConsumerInfoController.class);

	@Autowired
	IConsumerInfoService consumerService;

	/**
	 * @Description: 查询客户信息
	 * @param @param req
	 * @param @param item
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-17
	 */
	@RequestMapping("list.do")
	public String loadPackInfo(HttpServletRequest req, ConsumerInfoBean item) {
		try {
			HttpSession session = req.getSession();
			List<ConsumerInfoBean> list = consumerService.loadInfo(item);
			session.setAttribute("list", list);
			return "info/consumerInfo";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}

	/**
	 * @Description: 跳转到添加或者修改页面
	 * @param
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-17
	 */
	@RequestMapping("linkPage.do")
	public void linkPage(HttpServletResponse res, int id) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			ConsumerInfoBean item = consumerService.linkPage(id);
			JSONObject json = JSONObject.fromObject(item);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 添加或者修改客户信息
	 * @param @param req
	 * @param @param item
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-17
	 */
	@RequestMapping("save.do")
	public String saveInfo(HttpServletRequest req, ConsumerInfoBean item) {
		try {
			HttpSession session = req.getSession();
			UserBean user = (UserBean) session.getAttribute("user");
			item.setOwner(user.getRealName());
			item.setStatus(0);
			item.setCreatDate(DateUtils.date2String(new Date(), ""));

			consumerService.insertInfo(item);
			return "redirect:list.do";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}

}
