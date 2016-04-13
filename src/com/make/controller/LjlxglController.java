package com.make.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.LjlxglBean;
import com.make.bean.UserBean;
import com.make.mapper.ILjlxglMapper;
import com.make.service.ILjlxglService;
@Controller
public class LjlxglController {

	//零件类型管理
	
	
	private ILjlxglService iLjlxglService;
	/**
	 * 
	 * @Description: 进入零件类型管理
	 * @return String
	 * @throws
	 * @author 马龙奎
	 * @date 2016-4-9
	 */
	@RequestMapping("Ljlxgl.view")
	public String view(String startDate,String endDate,String keys, HttpServletRequest req) {
		
		List<LjlxglBean> ljlxglBeans=new ArrayList<LjlxglBean>();
		try {
			ljlxglBeans=this.iLjlxglService.selectLjlxglBeansbyse(startDate, endDate, keys);
		} catch (Exception e) {
		}
        
		req.setAttribute("ljlxglBeans", ljlxglBeans);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate",endDate);
		req.setAttribute("keys", keys);
		return "jcgljsp/ljlxgl";
	}

	//新增和修改零件类型管理
	@RequestMapping("Ljlxgl.add")
	public String add(String lxid,String lxname,String lxmeno, HttpServletRequest req,HttpSession session) {
		LjlxglBean ljlxglBean=new LjlxglBean();
		if (lxid==null||"".equals(lxid)) {
			
			ljlxglBean.setLxid(UUID.randomUUID().toString().replace("-", ""));
			try {
				ljlxglBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
			} catch (Exception e) {
				ljlxglBean.setInputman("111");
			}
		
			ljlxglBean.setCreDate(new Date());
			ljlxglBean.setLxmeno(lxmeno);
			ljlxglBean.setLxname(lxname);
			this.iLjlxglService.addLjlxglBean(ljlxglBean);
		}else {
			ljlxglBean=this.iLjlxglService.selectbyid(lxid);
			ljlxglBean.setLxmeno(lxmeno);
			ljlxglBean.setLxname(lxname);
			this.iLjlxglService.updatejlxglBean(ljlxglBean);
		}

		return "redirect:Ljlxgl.view";
	}
	//删除零件类型管理
	@RequestMapping("Ljlxgl.dele")
	public String dele(String lxid, HttpServletRequest req,HttpSession session) {

			try {
				this.iLjlxglService.deleLjlxglBeanbyid(lxid);
			} catch (Exception e) {
				
			}
		return "redirect:Ljlxgl.view";
	}
	
}
