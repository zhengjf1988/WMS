package com.make.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.LjxxglBean;
import com.make.bean.UserBean;
import com.make.service.ILjxxglService;
@Controller
public class LjxxglController {
	//零件信息管理
	
		@Autowired
		private ILjxxglService iLjxxglService;
		/**
		 * 
		 * @Description: 进入零件信息管理
		 * @return String
		 * @throws
		 * @author 马龙奎
		 * @date 2016-4-18
		 */
		@RequestMapping("Ljxxgl.view")
		public String view(String startDate,String endDate,String keys, HttpServletRequest req) {
			
			List<LjxxglBean> ljxxglBeans=new ArrayList<LjxxglBean>();
			try {
				ljxxglBeans=iLjxxglService.selectLjxxglBeansbyse(startDate, endDate, keys);
			} catch (Exception e) {
			}
			req.setAttribute("ljxxglBeans", ljxxglBeans);
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate",endDate);
			req.setAttribute("keys", keys);
			return "xxgl/ljxxgl";
		}

		//新增和修改零件信息管理
		@RequestMapping("Ljxxgl.add")
		public String add(String ljid,String ljbm,String ljname,String cctype, String sjlj,String gjsl,HttpServletRequest req,HttpSession session) {
			LjxxglBean ljxxglBean=new LjxxglBean();
			if (ljid==null||"".equals(ljid)) {
				
				try {
					ljxxglBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
				} catch (Exception e) {
					ljxxglBean.setInputman("111");
				}
			
				ljxxglBean.setCreDate(new Date());
				ljxxglBean.setLjbm(ljbm);
				ljxxglBean.setLjname(ljname);
				ljxxglBean.setCctype(cctype);
				ljxxglBean.setSjlj(sjlj);
				ljxxglBean.setGjsl(gjsl);
				iLjxxglService.addLjxxglBean(ljxxglBean);
			}else {
				ljxxglBean=this.iLjxxglService.selectbyid(ljid);
				ljxxglBean.setLjbm(ljbm);
				ljxxglBean.setLjname(ljname);
				ljxxglBean.setCctype(cctype);
				ljxxglBean.setSjlj(sjlj);
				ljxxglBean.setGjsl(gjsl);
				iLjxxglService.updateLjxxglBean(ljxxglBean);
			}

			return "redirect:Ljxxgl.view";
		}
		//删除零件信息管理
		@RequestMapping("Ljxxgl.dele")
		public String dele(String ljid, HttpServletRequest req,HttpSession session) {

				try {
					iLjxxglService.deleLjxxglBeanbyid(ljid);
				} catch (Exception e) {
					
				}
			return "redirect:Ljxxgl.view";
		}
		
	}
