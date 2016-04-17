/**  
 * @Title: UserInfoController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-14
 */
package com.make.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.UserBean;
import com.make.service.IUserInfoService;
import com.make.util.DateUtils;

/**
 * ClassName: UserInfoController
 * 
 * @Description: 用户信息Controller
 * @author zhengjf
 * @date 2016-4-14
 */
@Controller
@RequestMapping("user")
public class UserInfoController {

	Logger log = Logger.getLogger(UserInfoController.class);

	@Autowired
	IUserInfoService userInfoService;

	@RequestMapping("list.do")
	public String loadUserInfo(UserBean item, HttpServletRequest req) {
		try {
			HttpSession session = req.getSession();
			List<UserBean> list = userInfoService.loadUserInfo(item);
			session.setAttribute("list", list);
			return "system/userInfo";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}

	/**
	 * @Description: 添加或者修改
	 * @param @param item
	 * @param @param req
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-15
	 */
	@RequestMapping("save.do")
	public String upsertUser(UserBean item, HttpServletRequest req) {
		try {
			HttpSession session = req.getSession();
			UserBean user = (UserBean) session.getAttribute("user");
			item.setOwner(user.getRealName());
			item.setStatus(0);
			item.setCreatDate(DateUtils.date2String(new Date(), ""));
			userInfoService.insertUser(item);
			return "redirect:list.do";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}

	/**
	 * @Description: 跳转到添加或者修改页面
	 * @param @param res
	 * @param @param id
	 * @param @param username
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-15
	 */
	@RequestMapping("linkPage.do")
	public void linkUserPage(HttpServletResponse res, int id) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			Map<String, Object> map = userInfoService.linkUserPage(id);

			JSONObject json = JSONObject.fromObject(map);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 检查用户名是否已存在
	 * @param @param res
	 * @param @param username
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-15
	 */
	@RequestMapping("checkUserName.do")
	public void checkUserInfo(HttpServletResponse res, String username) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			boolean result = userInfoService.checkUserInfo(username);

			JSONObject json = JSONObject.fromObject("{result:" + result + "}");
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}
}
