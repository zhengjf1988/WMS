package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.LjdjglBean;
import com.make.mapper.ILjdjglMapper;
import com.make.service.ILjdjglService;

@Service
public class LjdjglServiceImp implements ILjdjglService{
	
	@Autowired
	private ILjdjglMapper iLjdjglMapper;

	public List<LjdjglBean> selectLjdjglBeansbyse(String creDate,
			String endDate, String keys) {
		String sql="select * from t_ljdjgl where iddelete=0";
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and creDate>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and creDate<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql=sql+" and ( djname like '%"+keys+"%' or djmeno like '%"+keys+"%')";
		}
		List<LjdjglBean> LjdjglBeans=iLjdjglMapper.selectLjdjglBeanbysql(sql);
		
		return LjdjglBeans;
	}

	public int addLjdjglBean(LjdjglBean ljdjglBean) {
		// TODO Auto-generated method stub
		return iLjdjglMapper.addLjdjglBean(ljdjglBean);
	}

	public int deleLjdjglBeanbyid(String ljdjid) {
		// TODO Auto-generated method stub
		return iLjdjglMapper.deleteonebylo(ljdjid);
	}

	public LjdjglBean selectbyid(String id) {
		// TODO Auto-generated method stub
		return iLjdjglMapper.selectLjdjglBeanbyid(id);
	}

	public int updateljdjglBean(LjdjglBean ljdjglBean) {
		// TODO Auto-generated method stub
		return iLjdjglMapper.updateLjdjglBean(ljdjglBean);
	}

}
