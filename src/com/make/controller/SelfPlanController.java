/**  
 * @Title: SelfPlanController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-28
 */
package com.make.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.SelfPlanBean;
import com.make.service.ISelfPlanService;

/**
 * ClassName: SelfPlanController
 * 
 * @Description: 内部生产计划
 * @author zhengjf
 * @date 2016-4-28
 */
@Controller
@RequestMapping("self")
public class SelfPlanController {
	Logger log = Logger.getLogger(SelfPlanController.class);

	@Autowired
	ISelfPlanService selfPlanService;

	/**
	 * @Description: 跳转到生产计划页面
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-28
	 */
	@RequestMapping("plan.do")
	public String hrefSelfPage() {
		return "plan/selfPlan";
	}

	@RequestMapping("list.do")
	public void loadInfo(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();
			SelfPlanBean item = new SelfPlanBean();
			List<SelfPlanBean> list = selfPlanService.loadInfo(item);
			JSONArray json = JSONArray.fromObject(list);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 跳转到添加或者修改页面
	 * @param @param res
	 * @param @param id
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	@RequestMapping("linkPage.do")
	public void linkPage(HttpServletRequest req, HttpServletResponse res) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			Map<String, Object> map = selfPlanService.linkPage(id);
			JSONObject json = JSONObject.fromObject(map);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 添加或者修改内部计划信息
	 * @param
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-28
	 */
	@RequestMapping("save.do")
	public void upsertInfo(SelfPlanBean item) {
		if (item.getId() > 0) {// 修改

		} else {// 添加
			selfPlanService.insertSelfInfo(item);
		}
	}
}
