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

			session.setAttribute("item", null);
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
			int id = Integer.parseInt(req.getParameter("userId"));
			item.setId(id);

			HttpSession session = req.getSession();
			UserBean user = (UserBean) session.getAttribute("user");

			if (id == 0) {// /添加
				item.setOwner(user.getRealName());
				item.setCreatDate(DateUtils.date2String(new Date(), ""));
				userInfoService.insertUser(item);
			} else {// 修改
				userInfoService.updateInfo(item);
			}

			return "redirect:list.do";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}

	/**
	 * @Description: 删除信息-------逻辑删除
	 * @param @param req
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	@RequestMapping("delete.do")
	public String deleteUserInfo(HttpServletRequest req) {
		try {
			UserBean item = new UserBean();
			int id = Integer.parseInt(req.getParameter("deleteId"));
			item.setId(id);
			item.setStatus(1);
			userInfoService.updateInfo(item);
			return "redirect:list.do";
		} catch (Exception e) {
			e.printStackTrace();
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
			String username = req.getParameter("seachUserName");
			String realName = req.getParameter("seachRealName");
			int dpId = Integer.parseInt(req.getParameter("seachDeptart"));
			int roleId = Integer.parseInt(req.getParameter("seachRoleName"));

			UserBean item = new UserBean();
			item.setUsername(username);
			item.setRealName(realName);
			item.setFk_departmentId(dpId);
			item.setFk_roleId(roleId);

			HttpSession session = req.getSession();
			List<UserBean> list = userInfoService.loadUserInfo(item);

			session.setAttribute("item", item);
			session.setAttribute("list", list);
			return "system/userInfo";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return res;
	}
}
