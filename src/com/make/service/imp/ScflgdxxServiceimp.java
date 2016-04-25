package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.ScflgdxxBean;
import com.make.mapper.IScflgdxxMapper;
import com.make.service.IScflgdxxService;

@Service
public class ScflgdxxServiceimp implements IScflgdxxService{

	@Autowired
	IScflgdxxMapper iScflgdxxMapper;

	public List<ScflgdxxBean> selectScflgdxxBeansbyse(String creDate,
			String endDate, String keys , String flag) {
		String sql="select * from t_scflgdxx where useTag=1";

		
		
		if ("2".equals(flag)) {
			sql=sql+" and  flstatus in (2,3 ) ";
		}else {
			sql=sql+" and flstatus = '"+flag+"'";
		}
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and creDate>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and creDate<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql=sql+" and (gdbh like '%"+keys+"%' )";
		}
		List<ScflgdxxBean> scflgdxxBeans=this.iScflgdxxMapper.selectScflgdxxBeanbysql(sql);
		return scflgdxxBeans;
	}

	public int addScflgdxxBean(ScflgdxxBean scflgdxxBean) {
		// TODO Auto-generated method stub
		return this.iScflgdxxMapper.addScflgdxxBean(scflgdxxBean);
	}

	public int deleScflgdxxBeanbyid(String id) {
		// TODO Auto-generated method stub
		return this.iScflgdxxMapper.deleteonebylo(id);
	}

	public ScflgdxxBean selectbyid(String id) {
		// TODO Auto-generated method stub
		return this.iScflgdxxMapper.selectScflgdxxBeanbyid(id);
	}

	public int updatescflgdxxBean(ScflgdxxBean scflgdxxBean) {
		// TODO Auto-generated method stub
		return this.iScflgdxxMapper.updateScflgdxxBean(scflgdxxBean);
	}

	public List<ScflgdxxBean> selectall() {
		// TODO Auto-generated method stub
		return this.iScflgdxxMapper.selectScflgdxxBeanall();
	}

	public List<ScflgdxxBean> selectalltotrue() {
		// TODO Auto-generated method stub
		return this.iScflgdxxMapper.selectScflgdxxBeantotrue();
	}

	public int updatestatus(String status, String id) {
		String sql="update t_scflgdxx set flstatus=1 where gdid="+id; 
		return this.iScflgdxxMapper.upflstatusonebylo(sql);
	}



}
