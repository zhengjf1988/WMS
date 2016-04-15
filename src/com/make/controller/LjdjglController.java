package com.make.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.LjdjglBean;
import com.make.bean.UserBean;
import com.make.service.ILjdjglService;

@Controller
@RequestMapping("Ljdj")
public class LjdjglController {
	
	@Autowired
	private ILjdjglService iLjdjglService;
	
	//进入库位管理类型
		@RequestMapping("Ljdjgl.view")
		public String view(String startDate,String endDate,String keys, HttpServletRequest req) {
			
			List<LjdjglBean> ljdjglBeans=new ArrayList<LjdjglBean>();
			try {
				ljdjglBeans=iLjdjglService.selectLjdjglBeansbyse(startDate, endDate, keys);
			} catch (Exception e) {
			}
			req.setAttribute("ljdjglBeans", ljdjglBeans);
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate",endDate);
			req.setAttribute("keys", keys);
			return "jcgl/ljdjgl";
		}
		
		//新增和修改库位类型管理
			@RequestMapping("Ljdjgl.add")
			public String add(String djid,String djname,String djmeno, HttpServletRequest req,HttpSession session) {
				LjdjglBean ljdjglBean=new LjdjglBean();
				if (djid==null||"".equals(djid)) {
					
					try {
						ljdjglBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
					} catch (Exception e) {
						ljdjglBean.setInputman("111");
					}
				
					ljdjglBean.setCreDate(new Date());
					ljdjglBean.setDjmeno(djmeno);
					ljdjglBean.setDjname(djname);
					iLjdjglService.addLjdjglBean(ljdjglBean);
				}else {
					ljdjglBean=this.iLjdjglService.selectbyid(djid);
					ljdjglBean.setDjmeno(djmeno);
					ljdjglBean.setDjname(djname);
					iLjdjglService.updateljdjglBean(ljdjglBean);
				}

				return "redirect:Ljdjgl.view";
			}
			//删除库位类型管理
			@RequestMapping("Ljdjgl.dele")
			public String dele(String djid, HttpServletRequest req,HttpSession session) {

					try {
						iLjdjglService.deleLjdjglBeanbyid(djid);
					} catch (Exception e) {
						
					}
				return "redirect:Ljdjgl.view";
			}

}
