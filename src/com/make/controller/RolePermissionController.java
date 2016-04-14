/**  
 * @Title: RolePermissionController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
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

import com.make.bean.RolePermissionBean;
import com.make.service.IRolePermissionService;
import com.make.util.DateUtils;

/**
 * ClassName: RolePermissionController
 * 
 * @Description: 角色权限Controller
 * @author zhengjf
 * @date 2016-4-12
 */
@Controller
@RequestMapping("role")
public class RolePermissionController {

	Logger log = Logger.getLogger(RolePermissionController.class);

	@Autowired
	IRolePermissionService rolePerService;

	@RequestMapping("list.do")
	public String loadRolePermission(HttpServletRequest req) {
		try {
			HttpSession session = req.getSession();
			List<RolePermissionBean> list = rolePerService.loadRolePermission();
			session.setAttribute("list", list);
			return "system/rolepermission";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}

	/**
	 * @Description: 跳转到添加或者修改角色权限页面
	 * @param @param res
	 * @param @param id
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-13
	 */
	@RequestMapping("linkPage.do")
	public void loadMenuBt(HttpServletResponse res, int id) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			Map<String, Object> map = rolePerService.linkPage(id);

			JSONObject json = JSONObject.fromObject(map);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 添加或者修改角色权限信息
	 * @param @param item
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-13
	 */
	@RequestMapping("save.do")
	public String upsertRolePermission(RolePermissionBean item) {
		try {
			if (item.getId() == 0) {// 添加
				item.setOwner("李四");
				item.setStatus(0);
				item.setCreatDate(DateUtils.date2String(new Date(), ""));
				rolePerService.insertRolePermission(item);
			}
			return "redirect:list.do";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}
}
