package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.make.bean.CcqxglBean;
import com.make.bean.LjlxglBean;
import com.make.mapper.ICcqxglMapper;
import com.make.service.ICcqxglService;

public class Ccqxglserviceimp implements ICcqxglService {
    @Autowired
	ICcqxglMapper iCcqxglMapper;
	public List<CcqxglBean> selectCcqxglBeanbyse(String creDate,
			String endDate, String keys) {
		String sql="select * from t_ccqxgl where 1=1";
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and creDate>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and creDate<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
		//	sql=sql+" and lxname like '%"+keys+"%' or lxmeno like '%"+keys+"%'";
		}
		List<CcqxglBean> ljlxglBeans=this.iCcqxglMapper.selectccqxglBeanbysql(sql);
		return ljlxglBeans;
	}

	public int addCcqxglBean(CcqxglBean ccqxglBean) {
		// TODO Auto-generated method stub
		return this.iCcqxglMapper.addccqxglBeanBean(ccqxglBean);
	}

	public int deleCcqxglBeanbyid(String ccid) {
		// TODO Auto-generated method stub
		return this.iCcqxglMapper.deleteone(ccid);
	}

	public CcqxglBean selectbyid(String id) {
		// TODO Auto-generated method stub
		return this.iCcqxglMapper.selectccqxglBeanbyid(id);
	}

	public int updateCcqxglBean(CcqxglBean ccqxglBean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
