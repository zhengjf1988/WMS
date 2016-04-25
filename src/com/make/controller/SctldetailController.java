package com.make.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.LjbBean;
import com.make.bean.LjxxglBean;
import com.make.bean.ScflgdxxBean;
import com.make.bean.ScflitemBean;
import com.make.bean.SctldetailBean;
import com.make.service.ILjbService;
import com.make.service.ILjxxglService;
import com.make.service.IScflgdxxService;
import com.make.service.IScflitemService;
import com.make.service.ISctldetailService;

@Controller
@RequestMapping("Sctldetail")
public class SctldetailController {
	@Autowired
	private ISctldetailService iSctldetailService;
	@Autowired
	private ILjxxglService iLjxxglService;
	@Autowired
	private IScflgdxxService iScflgdxxService;
	@Autowired
	private IScflitemService iScflitemService;
	@Autowired
	private ILjbService iLjbService;
	//进入生产退料
	@RequestMapping("Sctldetail.view")
	public String view(String startDate,String endDate,String keys,String flag, HttpServletRequest req) {
		if (flag==null||"".equals(flag)) {
			flag="0";
		}

		List<SctldetailBean> sctldetailBeans=new ArrayList<SctldetailBean>();
		try {
			sctldetailBeans=iSctldetailService.selectSctldetailBeansbyse(startDate, endDate, keys, flag);
		} catch (Exception e) {
		}
		List<LjxxglBean> ljBeans=iLjxxglService.selectLjxxglBeansall();
		Map<String, LjxxglBean>ljxxMap=new HashMap<String, LjxxglBean>();
		for (int i = 0; i < ljBeans.size(); i++) {
			ljxxMap.put(ljBeans.get(i).getLjid(), ljBeans.get(i));
		}
		req.setAttribute("sctldetailBeans", sctldetailBeans);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate",endDate);
		req.setAttribute("keys", keys);
		req.setAttribute("flag", flag);
		req.setAttribute("ljxxMap", ljxxMap);
		return "rkgl/sctldtl";
	}

	//进入生产退料
	@RequestMapping("Sctldetail.update")
	public String update(String tlmxid, HttpServletRequest req) {
		iSctldetailService.updateSctldetailBean("1", tlmxid);
		return "rkgl/sctldtl";
	}

	//获取工单信息
	@RequestMapping("Sctldetail.getscflxx")
	public void  getscflxx(String tlmxid, HttpServletRequest req,HttpServletResponse response) {

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
		SctldetailBean sctldetailBean=iSctldetailService.selectbyid(tlmxid);
		ScflitemBean scflitemBean=iScflitemService.selectbyid(sctldetailBean.getFlmxid());
		ScflgdxxBean scflgdxxBean=iScflgdxxService.selectbyid(scflitemBean.getGdid());

		JSONArray json = JSONArray. fromObject(scflgdxxBean);
		out.print(json.toString());


	}


	//获取零件包
	@RequestMapping("Sctldetail.getljb")
	public void  getljb(String tlmxid, HttpServletRequest req,HttpServletResponse response) {

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
		SctldetailBean sctldetailBean=iSctldetailService.selectbyid(tlmxid);
		ScflitemBean scflitemBean=iScflitemService.selectbyid(sctldetailBean.getFlmxid());
		LjbBean ljbBean=iLjbService.selectbyid(Integer.valueOf(scflitemBean.getLjbid()));

		JSONArray json = JSONArray. fromObject(ljbBean);
		out.print(json.toString());


	}
	
	//进入生产退料
	@RequestMapping("Sctldetail.viewls")
	public String viewls(String startDate,String endDate,String keys,String flag, HttpServletRequest req) {
		if (flag==null||"".equals(flag)) {
			flag="1";
		}

		List<SctldetailBean> sctldetailBeans=new ArrayList<SctldetailBean>();
		try {
			sctldetailBeans=iSctldetailService.selectSctldetailBeansbyse(startDate, endDate, keys, flag);
		} catch (Exception e) {
		}
		List<LjxxglBean> ljBeans=iLjxxglService.selectLjxxglBeansall();
		Map<String, LjxxglBean>ljxxMap=new HashMap<String, LjxxglBean>();
		for (int i = 0; i < ljBeans.size(); i++) {
			ljxxMap.put(ljBeans.get(i).getLjid(), ljBeans.get(i));
		}
		req.setAttribute("sctldetailBeans", sctldetailBeans);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate",endDate);
		req.setAttribute("keys", keys);
		req.setAttribute("flag", flag);
		req.setAttribute("ljxxMap", ljxxMap);
		return "rkgl/sctlls";
	}

}
