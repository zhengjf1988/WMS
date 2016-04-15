package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.KwlxglBean;
import com.make.mapper.IKwlxglMapper;
import com.make.service.IKwlxglService;

@Service
public class KwlxglServiceImp implements IKwlxglService{

	@Autowired
	private IKwlxglMapper iKwlxglMapper;

	public List<KwlxglBean> selectKwlxglBeansbyse(String creDate,
			String endDate, String keys) {

		String sql="select * from t_kwlxgl where iddelete=0";
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and creDate>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and creDate<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql=sql+" and ( kwname like '%"+keys+"%' or kwmeno like '%"+keys+"%' )";
		}
		List<KwlxglBean> kwlxglBeans=iKwlxglMapper.selectKwlxglBeanbysql(sql);

		return kwlxglBeans;
	}

	public int addKwlxglBean(KwlxglBean kwlxglBean) {
		// TODO Auto-generated method stub
		return iKwlxglMapper.addKwlxglBean(kwlxglBean);
	}

	public int deleKwlxglBeanbyid(String kwlxid) {
		// TODO Auto-generated method stub
		return iKwlxglMapper.deleteonebylo(kwlxid);
	}

	public KwlxglBean selectbyid(String id) {
		// TODO Auto-generated method stub
		return iKwlxglMapper.selectKwlxglBeanbyid(id);
	}

	public int updatejlxglBean(KwlxglBean kwlxglBean) {
		// TODO Auto-generated method stub
		return iKwlxglMapper.updateKwlxglBean(kwlxglBean);
	}

	public List<KwlxglBean> selectall() {
		//System.out.println(1);		
		return iKwlxglMapper.selectKwlxglBeanall();
	}

	public List<KwlxglBean> selectalltotrue() {
		// TODO Auto-generated method stub
		return iKwlxglMapper.selectKwlxglBeanalltotrue();
	}

}
