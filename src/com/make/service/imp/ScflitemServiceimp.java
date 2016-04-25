package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.ScflitemBean;
import com.make.mapper.IScflitemMapper;
import com.make.service.IScflitemService;

@Service
public class ScflitemServiceimp implements IScflitemService{
	@Autowired
	private IScflitemMapper iScflitemMapper;
	public int addScflitemBean(ScflitemBean scflitemBean) {
		// TODO Auto-generated method stub
		return iScflitemMapper.addScflitemBean(scflitemBean);
	}

	public int deleScflitemBeanbyid(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ScflitemBean selectbyid(String id) {
		// TODO Auto-generated method stub
		return iScflitemMapper.selectScflitemBeanbyid(id+"");
	}

	public int updateScflitemBean(String kwid, String id) {
		String sqlString="update t_scflitem set ckstatus=1, kwid="+kwid+" where flmxid="+id;
		return iScflitemMapper.upstu(sqlString);
	}

	public List<ScflitemBean> selectScflitemBeansbyse(String creDate,
			String endDate, String keys, String flag) {
		String sql="select sc.* from t_scflitem sc ,t_ljb ljb ,t_ljxxgl lj where sc.ljbid=ljb.ljbid and ljb.ljid=lj.ljid";
		if ("0".equals(flag)) {
			sql=sql+ " and sc.ckstatus=0 ";
		}else {
			sql=sql+ " and sc.ckstatus in (1,2) ";
		}


		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and sc.fldate>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and sc.fldate<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql+=" and (lj.ljname like '%"+keys+"%' or lj.ljname like '%"+keys+"%' )";
		}


		return iScflitemMapper.selectScflitemBeanbysql(sql);
	}

}
