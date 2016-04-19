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
import com.make.bean.UserBean;
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

	/**
	 * @Description: 查询用户部门信息
	 * @param @param req
	 * @param @param depart
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	@RequestMapping("list.do")
	public String loadDepartInfo(HttpServletRequest req, DepartmentBean depart) {
		String res = "error";
		try {
			HttpSession session = req.getSession();
			List<DepartmentBean> list = departService.loadDepartment(depart);

			session.setAttribute("item", null);
			session.setAttribute("list", list);
			return "system/department";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return res;
	}

	/**
	 * @Description: 跳转到添加或者修改页面的数据查询
	 * @param @param req
	 * @param @param res
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	@RequestMapping("linkPage.do")
	public void linkPage_Depart(HttpServletResponse res, int id) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			PrintWriter out = res.getWriter();

			if (id == 0) {// 添加
				List<DepartmentBean> list = departService.loadDepartment(null);
				map.put("list", list);
			} else {// 修改
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

	/**
	 * @Description: 添加或者修改部门
	 * @param @param req
	 * @param @param item
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	@RequestMapping("save.do")
	public String upsertDepart(HttpServletRequest req, DepartmentBean item) {
		try {
			int id = Integer.parseInt(req.getParameter("departId"));
			item.setId(id);

			HttpSession session = req.getSession();
			UserBean user = (UserBean) session.getAttribute("user");
			if (id == 0) {// 添加
				item.setOwner(user.getRealName());
				item.setCreatDate(DateUtils.date2String(new Date(), ""));
				departService.insertDepart(item);
			} else {// 修改
				departService.updateInfo(item);
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
	public String deleteDptaetInfo(HttpServletRequest req) {
		try {
			DepartmentBean item = new DepartmentBean();
			int id = Integer.parseInt(req.getParameter("deleteId"));
			item.setId(id);
			item.setStatus(1);
			departService.updateInfo(item);
			return "redirect:list.do";
		} catch (Exception e) {
			log.error("程序出错：" + e);
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
	public String seachDepart(HttpServletRequest req) {
		try {
			String departName = req.getParameter("seachDepartName");
			int parentId = Integer.parseInt(req.getParameter("seachParentId"));

			DepartmentBean item = new DepartmentBean();
			item.setDepartmentName(departName);
			item.setParentId(parentId);

			HttpSession session = req.getSession();
			List<DepartmentBean> list = departService.loadDepartment(item);

			session.setAttribute("item", item);
			session.setAttribute("list", list);
			return "system/department";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}
}
