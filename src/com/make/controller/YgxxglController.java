package com.make.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.make.bean.YgxxglBean;
import com.make.bean.UserBean;
import com.make.service.IYgxxglService;
import com.sun.net.httpserver.HttpContext;
//员工信息管理
@Controller
public class YgxxglController {
	   @Autowired
		private IYgxxglService iYgxxglService;
		/**
		 * 
		 * @Description: 进入员工信息管理
		 * @return String
		 * @throws
		 * @author 马龙奎
		 * @date 2016-4-19
		 */
		@RequestMapping("Ygxxgl.view")
		public String view(String startDate,String endDate,String keys, HttpServletRequest req) {
			
			List<YgxxglBean> ygxxglBeans=new ArrayList<YgxxglBean>();
			try {
				ygxxglBeans=iYgxxglService.selectYgxxglBeanbyse(startDate, endDate, keys);
			} catch (Exception e) {
				System.out.println(e);
			}
	       
			req.setAttribute("YgxxglBeans", ygxxglBeans);
			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate",endDate);
			req.setAttribute("keys", keys);
			return "xxgl/ygxxgl";
		}
	   //新增和修改员工信息管理
		@RequestMapping("Ygxxgl.add")
		public String add(YgxxglBean ygxxglBean,HttpServletRequest req,HttpSession session,@RequestParam(value = "file", required = false) MultipartFile file) {
               
		 String rootPath = req.getSession().getServletContext().getRealPath("/" );//获得相对路径
			//String rootPath= getClass().getResource("/").getFile().toString();
              // 上传新的图像，删除原来的图像
             File df = new File(rootPath + ygxxglBean.getPhotoAddr());//获得item.getImgpath()字段记录的文件
              if (df.exists()) {
                    df.delete();
             }

             String fileName = file.getOriginalFilename();
             String[] strArr = fileName.split( "\\.");
             
             if(strArr.length!=0){
             fileName = new Date().getTime() + "." + strArr[strArr.length - 1];//获得后缀名
              
             File targetFile = new File(rootPath + "file/user" , fileName);//以filename为名存储到固定位置，不存在时创建对应文件夹
              if (!targetFile.exists()) {
                    targetFile.mkdirs();
             }
              // 保存
              try {
                    file.transferTo(targetFile);
             } catch (Exception e) {
                    e.printStackTrace();
             }
			
             }

			
			ygxxglBean.setPhotoAddr(fileName);
			
			
			
			if (ygxxglBean.getYgid()==null||"".equals(ygxxglBean.getYgid())) {
				
				try {
					ygxxglBean.setInputman(((UserBean)session.getAttribute("user")).getId()+"");
				} catch (Exception e) {
					ygxxglBean.setInputman("111");
				}
			
				
				this.iYgxxglService.addYgxxglBean(ygxxglBean);
			}else {
				YgxxglBean ygxxglBeans=new YgxxglBean();
				
				ygxxglBeans=this.iYgxxglService.selectbyid(ygxxglBean.getYgid());
				ygxxglBeans.setYgbh(ygxxglBean.getYgbh());
				ygxxglBeans.setZwmc(ygxxglBean.getZwmc());
				ygxxglBeans.setBmmc(ygxxglBean.getBmmc());
				ygxxglBeans.setLxfs(ygxxglBean.getLxfs());
				ygxxglBeans.setSxnl(ygxxglBean.getSxnl());
				ygxxglBeans.setYgxm(ygxxglBean.getYgxm());
				if(ygxxglBean.getPhotoAddr()!=null&&!"".equals(ygxxglBean.getPhotoAddr())){
				ygxxglBeans.setPhotoAddr(ygxxglBean.getPhotoAddr());
				}
				this.iYgxxglService.updateYgxxglBean(ygxxglBeans);
			}

			return "redirect:Ygxxgl.view";
		}
		
		@RequestMapping("Ygxxgl.dele")
		public String dele(String ygid, HttpServletRequest req,HttpSession session) {
			
				YgxxglBean ygxxglBean=new YgxxglBean();
				ygxxglBean=this.iYgxxglService.selectbyid(ygid);
				ygxxglBean.setUseTag(0);
				this.iYgxxglService.updateYgxxglBean(ygxxglBean);

			return "redirect:Ygxxgl.view";
		}

		@RequestMapping("Ygxxgl.upload")
		public String upload( HttpServletRequest req, @RequestParam(value = "file", required = false) MultipartFile file) {
			
			

			              String rootPath = req.getSession().getServletContext().getRealPath("/" );//获得相对路径
			              HttpSession session = req.getSession();

			               // 上传新的图像，删除原来的图像
			          /*    File df = new File(rootPath + item.getImgpath());//获得item.getImgpath()字段记录的文件
			               if (df.exists()) {
			                     df.delete();
			              }*/

			              String fileName = file.getOriginalFilename();
			              String[] strArr = fileName.split( "\\.");
			              fileName = new Date().getTime() + "." + strArr[strArr.length - 1];//获得后缀名

			              File targetFile = new File(rootPath + "file/user" , fileName);//以filename为名存储到固定位置，不存在时创建对应文件夹
			               if (!targetFile.exists()) {
			                     targetFile.mkdirs();
			              }
			               // 保存
			               try {
			                     file.transferTo(targetFile);
			              } catch (Exception e) {
			                     e.printStackTrace();
			              }
			


			return rootPath+"file/user/"+fileName;
		}
		
	}

