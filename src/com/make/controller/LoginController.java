/**  
 * @Title: LoginController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-7
 */
package com.make.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.UserBean;
import com.make.service.IUserInfoService;

/**
 * ClassName: LoginController
 * 
 * @Description: 用户登录
 * @author zhengjf
 * @date 2016-4-7
 */
@Controller
public class LoginController {

	Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	IUserInfoService userServicec;

	/**
	 * 
	 * @Description: 用户登录方法
	 * @param @param user
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-7
	 */
	@RequestMapping("login.do")
	public String userLogin(UserBean user, HttpServletRequest req) {
		String res = "error";
		try {
			HttpSession session = req.getSession();

			List<UserBean> list = userServicec.loadUserInfo(user);

			if (list.size() > 0) {
				user = list.get(0);
				session.setAttribute("user", user);
				req.setAttribute("user", user);
				res = "redirect:note/list.do";
			} else {
				session.setAttribute("user", null);
				req.setAttribute("user", "");
				res = "login";
			}
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return res;
	}

}
