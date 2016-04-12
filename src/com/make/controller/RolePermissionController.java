/**  
 * @Title: RolePermissionController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
 */
package com.make.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.MenuBtBean;
import com.make.bean.RolePermissionBean;
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

	@RequestMapping("menubt.do")
	public void loadMenuBt(HttpServletResponse res) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();
			List<MenuBtBean> list = rolePerService.loadMenuBt();

			JSONArray json = JSONArray.fromObject(list);
			out.print(json.toString());

			System.out.println(json.toString());
//			String s1 = "{id:1, pId:0, name:\"test1\" , open:true}";
//			String s2 = "{id:2, pId:1, name:\"test2\" , open:true}";
//			String s3 = "{id:3, pId:1, name:\"test3\" , open:true}";
//			String s4 = "{id:4, pId:2, name:\"test4\" , open:true}";
//			List<String> lstTree = new ArrayList<String>();
//			lstTree.add(s1);
//			lstTree.add(s2);
//			lstTree.add(s3);
//			lstTree.add(s4);
//			// 利用Json插件将Array转换成Json格式
//			System.out.println(JSONArray.fromObject(lstTree).toString());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
