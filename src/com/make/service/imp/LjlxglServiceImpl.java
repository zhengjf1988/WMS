package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.LjlxglBean;
import com.make.mapper.ILjlxglMapper;
import com.make.service.ILjlxglService;
@Service
public class LjlxglServiceImpl implements ILjlxglService{

@Autowired
private ILjlxglMapper iLjlxglMapper;
	public List<LjlxglBean> selectLjlxglBeansbyse(String creDate,
			String endDate, String keys) {
		String sql="select * from t_ljlxgl where iddelete=0";
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and creDate>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and creDate<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql=sql+" and (lxname like '%"+keys+"%' or lxmeno like '%"+keys+"%')";
		}
		List<LjlxglBean> ljlxglBeans=iLjlxglMapper.selectljlxglBeanbysql(sql);
		
		return ljlxglBeans;
	}
	public int addLjlxglBean(LjlxglBean ljlxglBean) {
		// TODO Auto-generated method stub
		return iLjlxglMapper.addljlxglBean(ljlxglBean);
	}
	public int deleLjlxglBeanbyid(String ljlxid) {
		// TODO Auto-generated method stub
		return iLjlxglMapper.deleteonebylo(ljlxid);
	}
	public LjlxglBean selectbyid(String id) {
		// TODO Auto-generated method stub
		return iLjlxglMapper.selectljlxglBeanbyid(id);
	}
	public int updatejlxglBean(LjlxglBean ljlxglBean) {
		// TODO Auto-generated method stub
		return iLjlxglMapper.updateljlxglBean(ljlxglBean);
	}
    
}