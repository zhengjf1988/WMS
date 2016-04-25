package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.ScflgdxxBean;
import com.make.bean.SctldetailBean;
import com.make.mapper.ISctldetailMapper;
import com.make.service.ISctldetailService;
@Service
public class SctldetailServiceImp implements ISctldetailService {
@Autowired
private ISctldetailMapper iSctldetailMapper;
	public List<SctldetailBean> selectSctldetailBeansbyse(String creDate,
			String endDate, String keys, String flag) {
      String sql="select * from t_sctldetail sc,t_ljxxgl lj where sc.useTag=1 and lj.ljid=sc.ljid ";

		if ("1".equals(flag)) {
			sql=sql+" and  sc.tlstatus in (1,2 ) ";
		}else {
			sql=sql+" and sc.tlstatus = '"+flag+"'";
		}
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and sc.tlsj>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and sc.tlsj <='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql=sql+" and lj.ljname like '%"+keys+"%'";
		}
		List<SctldetailBean> sctldetailBeans=this.iSctldetailMapper.selectSctldetailBeanbysql(sql);
		return sctldetailBeans;
	}

	public int addSctldetailBean(SctldetailBean sctldetailBean) {
		// TODO Auto-generated method stub
		return iSctldetailMapper.addSctldetailBean(sctldetailBean);
	}

	public int deleSctldetailBeanbyid(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public SctldetailBean selectbyid(String id) {
		// TODO Auto-generated method stub
		return iSctldetailMapper.selectSctldetailBeanbyid(id);
	}

	public int updateSctldetailBean(String st, String id) {
		 String sql="update t_sctldetail set tlstatus="+st+" where tlmxid="+id;
		return iSctldetailMapper.upstu(sql);
	}

}
