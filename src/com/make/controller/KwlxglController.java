package com.make.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.KwlxglBean;
import com.make.bean.UserBean;
import com.make.service.IKwlxglService;

@Controller
@RequestMapping("Kwlx")
public class KwlxglController {
	@Autowired
	private IKwlxglService iKwlxglService;
    //进入库位管理类型
	@RequestMapping("Kwlxgl.view")
	public String view(String startDate,String endDate,String keys, HttpServletRequest req) {
		
		List<KwlxglBean> kwlxglBeans=new ArrayList<KwlxglBean>();
		try {
			kwlxglBeans=iKwlxglService.selectKwlxglBeansbyse(startDate, endDate, keys);
		} catch (Exception e) {
		}
		req.setAttribute("kwlxglBeans", kwlxglBeans);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate",endDate);
		req.setAttribute("keys", keys);
		return "jcgl/kwlxgl";
	}
	
	//新增和修改库位类型管理
		@RequestMapping("Kwlxgl.add")
		public String add(String kwid,String kwname,String kwmeno, HttpServletRequest req,HttpSession session) {
			KwlxglBean kwlxglBean=new KwlxglBean();
			if (kwid==null||"".equals(kwid)) {
				
				try {
					kwlxglBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
				} catch (Exception e) {
					kwlxglBean.setInputman("111");
				}
			
				kwlxglBean.setCreDate(new Date());
				kwlxglBean.setKwmeno(kwmeno);
				kwlxglBean.setKwname(kwname);
				iKwlxglService.addKwlxglBean(kwlxglBean);
			}else {
				kwlxglBean=this.iKwlxglService.selectbyid(kwid);
				kwlxglBean.setKwmeno(kwmeno);
				kwlxglBean.setKwname(kwname);
				iKwlxglService.updatejlxglBean(kwlxglBean);
			}

			return "redirect:Kwlxgl.view";
		}
		//删除库位类型管理
		@RequestMapping("Kwlxgl.dele")
		public String dele(String kwid, HttpServletRequest req,HttpSession session) {

				try {
					iKwlxglService.deleKwlxglBeanbyid(kwid);
				} catch (Exception e) {
					
				}
			return "redirect:Kwlxgl.view";
		}
	
}
