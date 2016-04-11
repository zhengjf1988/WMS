/**  
 * @Title: Login.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-7
 */
package com.make.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.UserBean;

/**
 * ClassName: Login
 * 
 * @Description: 用户登录
 * @author zhengjf
 * @date 2016-4-7
 */
@Controller
public class Login {

	Logger log = Logger.getLogger(Login.class);

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
			if (user.getUsername().equals("admin") && user.getPsw().equals("111111")) {
				session.setAttribute("user", user);
				req.setAttribute("user", user);
				res = "main";
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
