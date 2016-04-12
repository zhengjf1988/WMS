/**  
 * @Title: RolePermissionController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
 */
package com.make.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.MenuBtBean;
import com.make.service.IRolePermissionService;

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

	@Autowired
	IRolePermissionService rolePerService;

	@RequestMapping(value = "list.do")
	public String loadRolePermission() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "system/rolepermission";
	}

	@RequestMapping(value = "menubt.do")
	public void loadMenuBt(HttpServletResponse res) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();
			List<MenuBtBean> list = rolePerService.loadMenuBt();

			JSONArray json = JSONArray.fromObject(list);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
