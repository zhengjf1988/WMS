/**  
 * @Title: ReceiveController.java
 * @Package com.make.controller
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-20
 */
package com.make.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
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

import com.make.bean.ReceiveBean;
import com.make.bean.TxmBean;
import com.make.service.IReceiveService;
import com.make.util.DateUtils;

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
			item.setConsumerName(seachKeyWord);
			item.setLjname(seachKeyWord);
			item.setPackName(seachKeyWord);

			item.setThDate(seachStartDate);
			item.setThMan(seachEndDate);

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
	public void linkPage(HttpServletResponse res, int id, int status) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			Map<String, Object> map = receiveService.linkPage(id, status);
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
			if (item.getId() == 0) {
				item.setStatus(1);
				if (item.getLink_id() > 0) {
					item.setBd_date(DateUtils.date2String(new Date()));
				}
				receiveService.insertInfo(item);
			} else {
				item.setStatus(1);
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

	/**
	 * @Description: 提货时修改信息
	 * @param @param req
	 * @param @param item
	 * @param @return
	 * @return String
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-25
	 */
	@RequestMapping("tihuo.do")
	public String tihuoInfo(HttpServletRequest req, ReceiveBean item) {
		try {
			int id = Integer.parseInt(req.getParameter("recId"));
			item.setId(id);
			item.setStatus(2);

			receiveService.updateInfo(item);
			return "redirect:list.do";
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
		return "error";
	}

	/**
	 * @Description: 通过提货ID查询条形码信息
	 * @param @param res
	 * @param @param recId
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-25
	 */
	@RequestMapping("loadTxm.do")
	public void loadTxmBy_ReceID(HttpServletResponse res, int recId) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			List<TxmBean> list = receiveService.loadTxmBy_ReceID(recId);
			JSONArray json = JSONArray.fromObject(list);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 添加条形码信息
	 * @param @param item
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-25
	 */
	@RequestMapping("saveTxm.do")
	public void upsertTxm(String data) {
		try {
			data = data.replaceAll("\"", "");
			JSONArray jsonArr = JSONArray.fromObject(data);
			List<TxmBean> list = jsonArr.toList(jsonArr, TxmBean.class);
			receiveService.upsertTxm(list);
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 验货
	 * @param @param recId
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-26
	 */
	@RequestMapping("yanhuo.do")
	public void yanhuo(int recId) {
		try {
			ReceiveBean item = new ReceiveBean();
			item.setId(recId);
			item.setStatus(3);
			receiveService.updateInfo(item);
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 分库查询
	 * @param
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-27
	 */
	@RequestMapping("fenkuList.do")
	public void fenkuLoad(HttpServletResponse res, int recId) {
		try {
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();

			Map<String, Object> map = receiveService.fenkuLoad(recId);
			JSONObject json = JSONObject.fromObject(map);
			out.print(json.toString());
			out.close();
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}

	/**
	 * @Description: 分库修改状态
	 * @param @param recId
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-26
	 */
	@RequestMapping("fenku.do")
	public void fenkuUpdate(int recId) {
		try {
			ReceiveBean item = new ReceiveBean();
			item.setId(recId);
			item.setStatus(4);
			receiveService.updateInfo(item);
		} catch (Exception e) {
			log.error("程序出错：" + e);
		}
	}
}
