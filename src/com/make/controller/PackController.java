/**  
 * @Title: PackController.java
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

import com.make.bean.PackBean;
import com.make.bean.UserBean;
import com.make.service.IPackService;
import com.make.util.DateUtils;

/**
 * ClassName: PackController
 * 
 * @Description: 基础管理-包装信息管理controller
 * @author zhengjf
 * @date 2016-4-17
 */
@Controller
@RequestMapping("pack")
public class PackController {

	Logger log = Logger.getLogger(PackController.class);

	@Autowired
	IPackService packService;

	/**
	 * @Description: 查询包装信息
	 * @param @param req
	 * @param @param item
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-17
	 */
	@RequestMapping("list.do")
	public String loadPackInfo(HttpServletRequest req, PackBean item) {
		try {
			HttpSession session = req.getSession();
			List<PackBean> list = packService.loadPackInfo(item);
			session.setAttribute("list", list);
			session.setAttribute("item", null);
			return "base/packInfo";
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

			PackBean item = packService.linkPage(id);
			JSONObject json = JSONObject.fromObject(item);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 添加或者修改包装信息
	 * @param @param req
	 * @param @param item
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-17
	 */
	@RequestMapping("save.do")
	public String saveInfo(HttpServletRequest req, PackBean item) {
		try {
			int id = Integer.parseInt(req.getParameter("packId"));
			item.setId(id);
			if (id == 0) {
				HttpSession session = req.getSession();
				UserBean user = (UserBean) session.getAttribute("user");
				item.setOwner(user.getRealName());
				item.setCreatDate(DateUtils.date2String(new Date(), ""));
				if (item.getBulk() == null || "".equals(item.getBulk())) {
					item.setBulk("无限制");
				}
				packService.insertPack(item);
			} else {
				packService.updateInfo(item);
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
	public String deleteInfo(HttpServletRequest req) {
		try {
			PackBean item = new PackBean();
			int id = Integer.parseInt(req.getParameter("deleteId"));
			item.setId(id);
			item.setStatus(1);
			packService.updateInfo(item);
			return "redirect:list.do";
		} catch (Exception e) {
			e.printStackTrace();
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
	public String seachInfo(HttpServletRequest req) {
		String res = "error";
		try {
			String packName = req.getParameter("seachPackName");
			String count = req.getParameter("seachCount");
			String bulk = req.getParameter("seachBulk");

			PackBean item = new PackBean();
			item.setPackName(packName);
			item.setCount(count);
			item.setBulk(bulk);

			HttpSession session = req.getSession();
			List<PackBean> list = packService.loadPackInfo(item);

			session.setAttribute("item", item);
			session.setAttribute("list", list);
			return "base/packInfo";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return res;
	}

}
