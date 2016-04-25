package com.make.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.LjbBean;
import com.make.bean.LjxxglBean;
import com.make.bean.QzbmglBean;
import com.make.bean.ScflgdxxBean;
import com.make.bean.ScflitemBean;
import com.make.bean.SctldetailBean;
import com.make.bean.UserBean;
import com.make.service.ILjbService;
import com.make.service.ILjxxglService;
import com.make.service.IQzbmglService;
import com.make.service.IScflgdxxService;
import com.make.service.IScflitemService;
import com.make.service.ISctldetailService;

@Controller
@RequestMapping("Scflgdxx")
public class ScflgdxxController {

	@Autowired
	private IScflgdxxService iScflgdxxService;
	@Autowired
	private ILjbService ljbService;
	@Autowired
	private IScflitemService iScflitemService;
	@Autowired
	private ILjxxglService iLjxxglService;
	@Autowired
	private ISctldetailService iSctldetailService;
	@Autowired
	private IQzbmglService iQzbmglService;

	//进入生产发料管理信息
	@RequestMapping("Scflgdxx.view")
	public String view(String startDate,String endDate,String keys,String flag, HttpServletRequest req) {
		if (flag==null||"".equals(flag)) {
			flag="0";
		}

		List<ScflgdxxBean> scflgdxxBeans=new ArrayList<ScflgdxxBean>();
		try {
			scflgdxxBeans=iScflgdxxService.selectScflgdxxBeansbyse(startDate, endDate, keys, flag);
		} catch (Exception e) {
		}
		req.setAttribute("scflgdxxBeans", scflgdxxBeans);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate",endDate);
		req.setAttribute("keys", keys);
		req.setAttribute("flag", flag);
		return "ckgl/scflgdxx";
	}

	//进入生产发料管理信息
	@RequestMapping("Scflgdxx.getljbxx")
	public void  getljbxx(int scflxxid, HttpServletRequest req,HttpServletResponse response) {
		
		   try {
			req.setCharacterEncoding( "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           response.setCharacterEncoding( "UTF-8");
           response.setContentType( "application/json;charset=utf-8" );
           PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

           List<LjbBean> ljbBeans=ljbService.selectallbyljid(scflxxid);

           JSONArray json = JSONArray. fromObject(ljbBeans);
           out.print(json.toString());

	
	}


	//入库提交
	@RequestMapping("Scflgdxx.rukusave")
	public String  rukusave(String scflxxid,String ljbids, HttpServletRequest req,HttpServletResponse response) {
		this.iScflgdxxService.updatestatus("1", scflxxid);
		Date date =new Date();
		String[] strings =ljbids.split(",");
		for (int i = 0; i < strings.length; i++) {
			ScflitemBean scflitemBean=new ScflitemBean();
			scflitemBean.setCkstatus(0);
			scflitemBean.setGdid(scflxxid);
			scflitemBean.setLjbid(strings[i]);
			scflitemBean.setFldate(date);
			iScflitemService.addScflitemBean(scflitemBean);
			
		}
		
		return "redirect:Scflgdxx.view";
	
	}
	
	//进入生产发料明细 未出库
		@RequestMapping("Scflgdxx.mxview")
		public String mxview(String startDate,String endDate,String keys, HttpServletRequest req) {


			List<ScflitemBean> scflitemBeans=new ArrayList<ScflitemBean>();
			List<LjbBean>ljbBeans=ljbService.selectall();
			Map<String,LjbBean>ljbMap=new HashMap<String, LjbBean>();
			for (int i = 0; i <ljbBeans.size(); i++) {
				ljbMap.put(ljbBeans.get(i).getLjbid()+"",ljbBeans.get(i));
			}
			List<LjxxglBean> ljBeans=iLjxxglService.selectLjxxglBeansall();
			Map<String, LjxxglBean>ljxxMap=new HashMap<String, LjxxglBean>();
			for (int i = 0; i < ljBeans.size(); i++) {
				ljxxMap.put(ljBeans.get(i).getLjid(), ljBeans.get(i));
			}
			
			try {
				scflitemBeans=iScflitemService.selectScflitemBeansbyse(startDate, endDate, keys, "0");
			} catch (Exception e) {
			}
			req.setAttribute("scflitemBeans", scflitemBeans);
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate",endDate);
			req.setAttribute("keys", keys);
			req.setAttribute("ljbMap", ljbMap);
			req.setAttribute("ljxxMap", ljxxMap);
			return "ckgl/scflgdxxmx";
		}
	
		//出库提交
		@RequestMapping("Scflgdxx.chukusave")
		public String  chukusave(String gdmxid,String kwname, HttpServletRequest req,HttpServletResponse response) {
           iScflitemService.updateScflitemBean(kwname, gdmxid);
			return "redirect:Scflgdxx.mxview";
		
		}
		
		
		
		//进入生产发料明细 已出库
		@RequestMapping("Scflgdxx.mxviewls")
		public String mxviewls(String startDate,String endDate,String keys, HttpServletRequest req) {


			List<ScflitemBean> scflitemBeans=new ArrayList<ScflitemBean>();
			List<LjbBean>ljbBeans=ljbService.selectall();
			Map<String,LjbBean>ljbMap=new HashMap<String, LjbBean>();
			for (int i = 0; i <ljbBeans.size(); i++) {
				ljbMap.put(ljbBeans.get(i).getLjbid()+"",ljbBeans.get(i));
			}
			List<LjxxglBean> ljBeans=iLjxxglService.selectLjxxglBeansall();
			Map<String, LjxxglBean>ljxxMap=new HashMap<String, LjxxglBean>();
			for (int i = 0; i < ljBeans.size(); i++) {
				ljxxMap.put(ljBeans.get(i).getLjid(), ljBeans.get(i));
			}
			
			try {
				scflitemBeans=iScflitemService.selectScflitemBeansbyse(startDate, endDate, keys, "1");
			} catch (Exception e) {
			}
			req.setAttribute("scflitemBeans", scflitemBeans);
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate",endDate);
			req.setAttribute("keys", keys);
			req.setAttribute("ljbMap", ljbMap);
			req.setAttribute("ljxxMap", ljxxMap);
			return "ckgl/scflgdxxmxls";
		}
		
		//获取工单信息
		@RequestMapping("Scflgdxx.getscflxx")
		public void  getscflxx(int gdid, HttpServletRequest req,HttpServletResponse response) {
			
			   try {
				req.setCharacterEncoding( "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           response.setCharacterEncoding( "UTF-8");
	           response.setContentType( "application/json;charset=utf-8" );
	           PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	           ScflgdxxBean scflgdxxBean=iScflgdxxService.selectbyid(gdid+"");

	           JSONArray json = JSONArray. fromObject(scflgdxxBean);
	           out.print(json.toString());

		
		}
	
		//退料
		@RequestMapping("Scflgdxx.tl")
		public String tl(String flmxid,String age, HttpServletRequest req,HttpSession session) {
			ScflitemBean scflitemBean=iScflitemService.selectbyid(flmxid);
			LjbBean ljbBean=ljbService.selectbyid(Integer.valueOf(scflitemBean.getLjbid()));
			
				SctldetailBean sctldetailBean=new SctldetailBean();
				try {
					sctldetailBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
				} catch (Exception e) {
					sctldetailBean.setInputman("111");
				}
				sctldetailBean.setRksj(ljbBean.getRksj());
				sctldetailBean.setTlsj(new Date());
				sctldetailBean.setTlsl(Integer.valueOf(age));
				sctldetailBean.setLjid(ljbBean.getLjid());
				sctldetailBean.setRksj(ljbBean.getRksj());
				sctldetailBean.setFlmxid(scflitemBean.getFlmxid());
				if (Integer.valueOf(age)==ljbBean.getKcl()) {
				sctldetailBean.setTmbh(ljbBean.getTmbh());
				}else {
					sctldetailBean.setTmbh(iQzbmglService.getbm(1));
				}
				iSctldetailService.addSctldetailBean(sctldetailBean);


			return "redirect:Scflgdxx.mxviewls";
		}
}
