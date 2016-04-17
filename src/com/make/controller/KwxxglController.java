package com.make.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.make.bean.KwlxglBean;
import com.make.bean.KwxxglBean;
import com.make.bean.UserBean;
import com.make.service.IKwlxglService;
import com.make.service.IKwxxglService;
//库位信息管理
@Controller
public class KwxxglController {
	@Autowired
	private IKwxxglService iKwxxglService;
	@Autowired
	private IKwlxglService iKwlxglService;
	/**
	 * 
	 * @Description: 进入库位信息管理
	 * @return String
	 * @throws
	 * @author 马龙奎
	 * @date 2016-4-9
	 */
	@RequestMapping("Kwxxgl.view")
	public String view(String startDate,String endDate,String keys, HttpServletRequest req) {

		List<KwxxglBean> kwxxglBeans=new ArrayList<KwxxglBean>();
		try {
			kwxxglBeans=iKwxxglService.selectKwxxglBeanbyse(startDate, endDate, keys);
		} catch (Exception e) {
			System.out.println(e);
		}
        List<KwlxglBean>kwlxglBeans=new ArrayList<KwlxglBean>();
        		kwlxglBeans=iKwlxglService.selectall();
        Map<String, KwlxglBean>kwlxgkMap=new HashMap<String, KwlxglBean>();
        for (int i = 0; i < kwlxglBeans.size(); i++) {
			kwlxgkMap.put(kwlxglBeans.get(i).getKwid()+"", kwlxglBeans.get(i));
		}
        List<KwlxglBean>kwlxglBeanstotrue=iKwlxglService.selectalltotrue();
        req.setAttribute("kwlxglBeanstotrue", kwlxglBeanstotrue);
        req.setAttribute("kwlxgkMap", kwlxgkMap);
		req.setAttribute("kwxxglBeans", kwxxglBeans);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate",endDate);
		req.setAttribute("keys", keys);
		return "xxgl/kwxxgl";
	}
	//新增和修改库位信息管理
	@RequestMapping("Kwxxgl.add")
	public String add(String kwid,String kwname,String kwtype, String cctype, String kwaddress,Double kwrl,HttpServletRequest req,HttpSession session) {
		KwxxglBean kwxxglBean=new KwxxglBean();
		if (kwid==null||"".equals(kwid)) {

			try {
				kwxxglBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
			} catch (Exception e) {
				kwxxglBean.setInputman("111");
			}

			kwxxglBean.setCreDate(new Date());
			kwxxglBean.setKwname(kwname);
			kwxxglBean.setKwtype(kwtype);
			kwxxglBean.setCctype(cctype);
			kwxxglBean.setKwrl(kwrl);
			kwxxglBean.setKwaddress(kwaddress);
			kwxxglBean.setUseTag(1);
			this.iKwxxglService.addKwxxglBean(kwxxglBean);
		}else {
			kwxxglBean=this.iKwxxglService.selectbyid(Integer.parseInt(kwid));
			kwxxglBean.setKwname(kwname);
			kwxxglBean.setKwtype(kwtype);
			kwxxglBean.setCctype(cctype);
			kwxxglBean.setKwrl(kwrl);
			kwxxglBean.setKwaddress(kwaddress);
			this.iKwxxglService.updateKwxxglBean(kwxxglBean);
		}

		return "redirect:Kwxxgl.view";
	}

	@RequestMapping("Kwxxgl.dele")
	public String dele(String kwid, HttpServletRequest req,HttpSession session) {

		KwxxglBean kwxxglBean=new KwxxglBean();
		kwxxglBean=this.iKwxxglService.selectbyid(Integer.parseInt(kwid));
		kwxxglBean.setUseTag(0);
		this.iKwxxglService.updateKwxxglBean(kwxxglBean);

		return "redirect:Kwxxgl.view";
	}

}

