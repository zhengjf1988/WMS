/**  
 * @Title: DepartmentController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
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

import com.make.bean.DepartmentBean;
import com.make.service.IDepartmentService;
import com.make.util.DateUtils;

/**
 * ClassName: DepartmentController
 * 
 * @Description: 部门管理Controller
 * @author zhengjf
 * @date 2016-4-11
 */
@Controller
@RequestMapping("depart")
public class DepartmentController {

	Logger log = Logger.getLogger(DepartmentController.class);

	@Autowired
	IDepartmentService departService;

	@RequestMapping("list.do")
	public String loadDepartInfo(HttpServletRequest req, DepartmentBean depart) {
		String res = "error";
		try {
			HttpSession session = req.getSession();
			List<DepartmentBean> list = departService.loadDepartment(depart);
			session.setAttribute("list", list);
			return "system/department";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return res;
	}

	@RequestMapping("linkPage.do")
	public void linkPage_Depart(HttpServletRequest req, HttpServletResponse res) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			PrintWriter out = res.getWriter();

			int id = Integer.parseInt(req.getParameter("id"));
			if (id == 0) {
				List<DepartmentBean> list = departService.loadDepartment(null);
				map.put("list", list);
			} else {
				List<DepartmentBean> list = departService.loadDepartment(null);
				map.put("list", list);
				for (DepartmentBean item : list) {
					if (id == item.getId()) {
						map.put("item", item);
						break;
					}
				}
			}
			JSONObject json = JSONObject.fromObject(map);
			out.print(json.toString());
			out.close();

		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	@RequestMapping("add.do")
	public String insertDepart(HttpServletRequest req, DepartmentBean depart) {
		String res = "error";
		try {
			int parentId = Integer.parseInt(req.getParameter("parent"));
			// depart.setDepartmentName("开发部");
			// depart.setComments("备注信息");
			depart.setOwner("李四");
			// depart.setParentName("");
			depart.setParentId(parentId);
			depart.setStatus(0);
			depart.setCreatDate(DateUtils.date2String(new Date(), ""));
			departService.insertDepart(depart);
			res = "redirect:list.do";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return res;
	}
}
