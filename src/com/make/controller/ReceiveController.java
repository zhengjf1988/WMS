/**  
 * @Title: ReceiveController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-20
 */
package com.make.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.ReceiveBean;
import com.make.service.IReceiveService;

/**
 * ClassName: ReceiveController
 * 
 * @Description: 收货管理controller
 * @author zhengjf
 * @date 2016-4-21
 */
@Controller
@RequestMapping("receive")
public class ReceiveController {

	Logger log = Logger.getLogger(ReceiveController.class);
	@Autowired
	IReceiveService receiveService;

	/**
	 * @Description: 根据条件进行或者全部查询
	 * @param @param req
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	@RequestMapping("list.do")
	public String linkReceive() {
		return "receive/receive";
	}

	/**
	 * @Description: 根据条件进行或者全部查询
	 * @param @param req
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	@RequestMapping("receive.do")
	public void seachInfo(HttpServletRequest req, HttpServletResponse res) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			String seachKeyWord = req.getParameter("seachKeyWord");
			String seachStartDate = req.getParameter("seachStartDate");
			String seachEndDate = req.getParameter("seachEndDate");
			String status = req.getParameter("status");

			ReceiveBean item = new ReceiveBean();
			item.setKhName(seachKeyWord);
			item.setLjName(seachKeyWord);
			item.setBzType(seachKeyWord);

			item.setThDate(seachStartDate);
			item.setThCar(seachEndDate);
			if (status == null || !"".equals(status))
				item.setStatus(Integer.parseInt(status));

			List<ReceiveBean> list = receiveService.loadInfo(item);

			map.put("item", item);
			map.put("list", list);

			JSONObject json = JSONObject.fromObject(map);
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
	public void linkPage(HttpServletResponse res, int id) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			Map<String, Object> map = receiveService.linkPage(id);
			JSONObject json = JSONObject.fromObject(map);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 添加或者修改信息
	 * @param @param req
	 * @param @param item
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	@RequestMapping("save.do")
	public String saveInfo(HttpServletRequest req, ReceiveBean item) {
		try {
			int id = Integer.parseInt(req.getParameter("recId"));
			item.setId(id);
			if (id == 0) {
				item.setStatus(1);
				receiveService.insertInfo(item);
			} else {
				receiveService.updateInfo(item);
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
	 * @date 2016-4-21
	 */
	@RequestMapping("delete.do")
	public String deleteInfo(HttpServletRequest req) {
		try {
			ReceiveBean item = new ReceiveBean();
			int id = Integer.parseInt(req.getParameter("deleteId"));
			item.setId(id);
			item.setStatus(0);
			receiveService.updateInfo(item);
			return "redirect:list.do";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}

}
