package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.CcqxglBean;
import com.make.bean.LjlxglBean;
import com.make.mapper.ICcqxglMapper;
import com.make.service.ICcqxglService;
@Service
public class Ccqxglserviceimp implements ICcqxglService {
    @Autowired
	ICcqxglMapper iCcqxglMapper;
	public List<CcqxglBean> selectCcqxglBeanbyse(String creDate,
			String endDate, String keys) {
		String sql="select * from t_ccqxgl where useTag=1";
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and creDate>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and creDate<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql=sql+" and (ccname like '%"+keys+"%' or kwmeno like '%"+keys+"%')";
		}
		List<CcqxglBean> ccqxglBeans=this.iCcqxglMapper.selectccqxglBeanbysql(sql);
		return ccqxglBeans;
	}

	public int addCcqxglBean(CcqxglBean ccqxglBean) {
		// TODO Auto-generated method stub
		return this.iCcqxglMapper.addccqxglBean(ccqxglBean);
	}

	public int deleCcqxglBeanbyid(int ccid) {
		// TODO Auto-generated method stub
		return this.iCcqxglMapper.deleteone(ccid);
	}

	public CcqxglBean selectbyid(int id) {
		// TODO Auto-generated method stub
		return this.iCcqxglMapper.selectccqxglBeanbyid(id);
	}

	public int updateCcqxglBean(CcqxglBean ccqxglBean) {
		// TODO Auto-generated method stub
		
		return this.iCcqxglMapper.updateccqxglBean(ccqxglBean);
	}


}
