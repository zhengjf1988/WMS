package com.make.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.CcqxglBean;
import com.make.bean.LjlxglBean;
import com.make.bean.UserBean;
import com.make.service.ICcqxglService;

//存储期限管理
@Controller
public class CcqxglController {
	
    @Autowired
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
			System.out.println(e);
		}
       
		req.setAttribute("ccqxglBeans", ccqxglBeans);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate",endDate);
		req.setAttribute("keys", keys);
		return "jcgl/ccqxgl";
	}
   //新增和修改存储期限管理
	@RequestMapping("Ccqxgl.add")
	public String add(String ccid,String ccname,String kwmeno,String sxqx, int issx,HttpServletRequest req,HttpSession session) {
		Date sxqxd=new Date();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if (sxqx!=null||!"".equals(sxqx)) {
			try {
			sxqxd=simpleDateFormat.parse(sxqx);
			} catch (ParseException e) {
				System.out.println(e);
			}
		}
		
		
		
		CcqxglBean ccqxglBean=new CcqxglBean();
		if (ccid==null||"".equals(ccid)) {
			
			try {
				ccqxglBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
			} catch (Exception e) {
				ccqxglBean.setInputman("111");
			}
		
			ccqxglBean.setCreDate(new Date());
			ccqxglBean.setCcname(ccname);
			ccqxglBean.setKwmeno(kwmeno);
			ccqxglBean.setIssx(issx);
			if(null!=sxqx)
			ccqxglBean.setSxqx(sxqxd);
			ccqxglBean.setUseTag(1);
			this.iCcqxglService.addCcqxglBean(ccqxglBean);
		}else {
			ccqxglBean=this.iCcqxglService.selectbyid(Integer.parseInt(ccid));
			ccqxglBean.setCcname(ccname);
			ccqxglBean.setKwmeno(kwmeno);
			ccqxglBean.setIssx(issx);
			if(null!=sxqx)
			ccqxglBean.setSxqx(sxqxd);
				
			this.iCcqxglService.updateCcqxglBean(ccqxglBean);
		}

		return "redirect:Ccqxgl.view";
	}
	
	@RequestMapping("Ccqxgl.dele")
	public String dele(int ccid, HttpServletRequest req,HttpSession session) {
		
			CcqxglBean ccqxglBean=new CcqxglBean();
			ccqxglBean=this.iCcqxglService.selectbyid(ccid);
			ccqxglBean.setUseTag(0);
			this.iCcqxglService.updateCcqxglBean(ccqxglBean);

		return "redirect:Ccqxgl.view";
	}
}

