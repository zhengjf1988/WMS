package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.KwxxglBean;
import com.make.mapper.IKwxxglMapper;
import com.make.service.IKwxxglService;
@Service
public class KwxxglServiceImp implements IKwxxglService{
	@Autowired
	private IKwxxglMapper iKwxxglMapper;
	public List<KwxxglBean> selectKwxxglBeanbyse(String creDate,
			String endDate, String keys) {
		String sql="select * from t_kwxxgl where useTag=1";
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and creDate>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and creDate<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql+=" and (kwname like '%"+keys+"%' or kwtype like '%"+keys+"%' or cctype like '%"+keys+"%')";
		}
		List<KwxxglBean> kwxxglBeans=this.iKwxxglMapper.selectkwxxglBeanbysql(sql);
		return kwxxglBeans;
	}

	public int addKwxxglBean(KwxxglBean kwxxglBean) {
		// TODO Auto-generated method stub
		return this.iKwxxglMapper.addkwxxglBean(kwxxglBean);
	}

	public int deleKwxxglBeanbyid(int ccid) {
		// TODO Auto-generated method stub
		return this.iKwxxglMapper.deleteone(ccid);
	}

	public KwxxglBean selectbyid(int id) {
		// TODO Auto-generated method stub
		return this.iKwxxglMapper.selectkwxxglBeanbyid(id);
	}

	public int updateKwxxglBean(KwxxglBean kwxxglBean) {
		// TODO Auto-generated method stub
		return this.iKwxxglMapper.updatekwxxglBean(kwxxglBean);
	}
	

}
