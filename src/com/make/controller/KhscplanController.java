package com.make.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.make.bean.CcqxglBean;
import com.make.bean.ConsumerInfoBean;
import com.make.bean.KhscplanBean;
import com.make.bean.LjxxglBean;
import com.make.bean.UserBean;
import com.make.service.IConsumerInfoService;
import com.make.service.IKhscplanService;
import com.make.service.ILjxxglService;

@Controller
@RequestMapping("Khscplan")
public class KhscplanController {
	@Autowired
	private IKhscplanService iKhscplanService;
	@Autowired
	private ILjxxglService iLjxxglService;
	@Autowired
	private IConsumerInfoService iConsumerInfoService;

	/**
	 * 
	 * @Description: 进入客户生产计划
	 * @return String
	 * @throws
	 * @author 马龙奎
	 * @date 2016-4-9
	 */
	@RequestMapping("Khscplan.view")
	public String view(String startDate,String endDate,String keys, HttpServletRequest req) {
		
		List<KhscplanBean> khscplanBeans=new ArrayList<KhscplanBean>();
		try {
			khscplanBeans=iKhscplanService.selectKhscplanBeanbyse(startDate, endDate, keys);
		} catch (Exception e) {
			System.out.println(e);
		}
		List<LjxxglBean> ljBeans=iLjxxglService.selectLjxxglBeansall();
		Map<String, LjxxglBean>ljxxMap=new HashMap<String, LjxxglBean>();
		for (int i = 0; i < ljBeans.size(); i++) {
			ljxxMap.put(ljBeans.get(i).getLjid(), ljBeans.get(i));
		}
		List<ConsumerInfoBean>consumerInfoBeans=iConsumerInfoService.loadInfo(new ConsumerInfoBean());
		Map<Integer,ConsumerInfoBean> conmap=new HashMap<Integer, ConsumerInfoBean>();
		for (int i = 0; i < consumerInfoBeans.size(); i++) {
			conmap.put(consumerInfoBeans.get(i).getId(),consumerInfoBeans.get(i));
		}
		
		req.setAttribute("khscplanBeans", khscplanBeans);
		req.setAttribute("startDate", startDate);
		req.setAttribute("endDate",endDate);
		req.setAttribute("keys", keys);
		req.setAttribute("ljxxMap", ljxxMap);
		req.setAttribute("conmap", conmap);
		req.setAttribute("ljBeans", ljBeans);
		req.setAttribute("consumerInfoBeans", consumerInfoBeans);
		return "scgl/khscplan";
	}
	
	
	   //新增和修改客户生产计划
		@RequestMapping("Khscplan.add")
		public String add(String khscid,String khid,String ljid,String xqsj, int ljsl,HttpServletRequest req,HttpSession session) {
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		KhscplanBean khscplanBean=new KhscplanBean();
		if (khscid==null||"".equals(khscid)) {
			khscplanBean.setKhid(Integer.valueOf(khid));
			khscplanBean.setLjid(Integer.valueOf(ljid));
			khscplanBean.setLjsl(ljsl);
			try {
				khscplanBean.setXqsj(simpleDateFormat.parse(xqsj));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			iKhscplanService.addKhscplanBean(khscplanBean);
		}else {
			khscplanBean=iKhscplanService.selectbyid(Integer.valueOf(khscid));
			khscplanBean.setKhid(Integer.valueOf(khid));
			khscplanBean.setLjid(Integer.valueOf(ljid));
			khscplanBean.setLjsl(ljsl);
			try {
				khscplanBean.setXqsj(simpleDateFormat.parse(xqsj));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			iKhscplanService.updateKhscplanBean(khscplanBean);
		}
			return "redirect:Khscplan.view";
		}
		
		@RequestMapping("Khscplan.dele")
		public String dele(int khid, HttpServletRequest req,HttpSession session) {
			
				iKhscplanService.deleKhscplanBeanbyid(khid);

			return "redirect:Khscplan.view";
		}
		@RequestMapping("Khscplan.pg")
		public String pg(int khid, HttpServletRequest req,HttpSession session) {
			KhscplanBean khscplanBean=iKhscplanService.selectbyid(khid);
				khscplanBean.setIspg(1);
              iKhscplanService.updateKhscplanBean(khscplanBean);
			return "redirect:Khscplan.view";
		}
}
