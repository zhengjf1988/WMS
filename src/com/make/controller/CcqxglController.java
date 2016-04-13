package com.make.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.CcqxglBean;
import com.make.bean.LjlxglBean;
import com.make.bean.UserBean;
import com.make.service.ICcqxglService;

//存储期限管理
public class CcqxglController {
	

	private ICcqxglService iCcqxglService;
	/**
	 * 
	 * @Description: 进入存储期限管理管理
	 * @return String
	 * @throws
	 * @author 马龙奎
	 * @date 2016-4-9
	 */
	@RequestMapping("Ccqxgl.view")
	public String view(String startDate,String endDate,String keys, HttpServletRequest req) {
		
		List<CcqxglBean> ccqxglBeans=new ArrayList<CcqxglBean>();
		try {
			ccqxglBeans=iCcqxglService.selectCcqxglBeanbyse(startDate, endDate, keys);
		} catch (Exception e) {
		}
        
		req.setAttribute("ccqxglBeans", ccqxglBeans);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate",endDate);
		req.setAttribute("keys", keys);
		return "jcgljsp/ccqxgl";
	}
   //新增和修改存储期限管理
	@RequestMapping("Ccqxgl.add")
	public String add(String lxid,String lxname,String lxmeno, HttpServletRequest req,HttpSession session) {
		CcqxglBean ccqxglBean=new CcqxglBean();
		if (lxid==null||"".equals(lxid)) {
			
	/*		try {
				ccqxglBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
			} catch (Exception e) {
				ccqxglBean.setInputman("111");
			}
		
			ccqxglBean.setCreDate(new Date());
			ljlxglBean.setLxmeno(lxmeno);
			ljlxglBean.setLxname(lxname);
			this.iLjlxglService.addLjlxglBean(ljlxglBean);
		}else {
			ljlxglBean=this.iLjlxglService.selectbyid(lxid);
			ljlxglBean.setLxmeno(lxmeno);
			ljlxglBean.setLxname(lxname);
			this.iLjlxglService.updatejlxglBean(ljlxglBean);*/
		}

		return "redirect:Ccqxgl.view";
	}
	
	@RequestMapping("Ccqxgl.dele")
	public String dele(String lxid, HttpServletRequest req,HttpSession session) {
		if (lxid==null||"".equals(lxid)) {
			CcqxglBean ccqxglBean=new CcqxglBean();
			try {
				ccqxglBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
			} catch (Exception e) {
				ccqxglBean.setInputman("111");
			}

		}

		return "redirect:Ccqxgl.view";
	}
}

