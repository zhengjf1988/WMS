package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.LjxxglBean;
import com.make.mapper.ILjxxglMapper;
import com.make.service.ILjlxglService;
import com.make.service.ILjxxglService;
@Service
public class LjxxglServiceImp implements ILjxxglService{

@Autowired
private ILjxxglMapper iLjxxglMapper;
	public List<LjxxglBean> selectLjxxglBeansbyse(String creDate,
			String endDate, String keys) {
		String sql="select * from t_ljxxgl where useTag=1";
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and creDate>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and creDate<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql=sql+" and (ljname like '%"+keys+"%' or cctype like '%"+keys+"%')";
		}
		List<LjxxglBean> LjxxglBeans=iLjxxglMapper.selectLjxxglBeanbysql(sql);
		
		return LjxxglBeans;
	}
	public int addLjxxglBean(LjxxglBean ljxxglBean) {
		// TODO Auto-generated method stub
		return iLjxxglMapper.addLjxxglBean(ljxxglBean);
	}
	public int deleLjxxglBeanbyid(String ljlxid) {
		// TODO Auto-generated method stub
		return iLjxxglMapper.deleteonebylo(ljlxid);
	}
	public LjxxglBean selectbyid(String id) {
		// TODO Auto-generated method stub
		return iLjxxglMapper.selectLjxxglBeanbyid(id);
	}
	public int updatejlxglBean(LjxxglBean LjxxglBean) {
		// TODO Auto-generated method stub
		return iLjxxglMapper.updateLjxxglBean(LjxxglBean);
	}
	public int updateLjxxglBean(LjxxglBean LjxxglBean) {
		// TODO Auto-generated method stub
		return iLjxxglMapper.updateLjxxglBean(LjxxglBean);
	}
	public List<LjxxglBean> selectLjxxglBeansall() {
		// TODO Auto-generated method stub
		return iLjxxglMapper.selectljxxglBeanall();
	}
    
}