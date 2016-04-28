package com.make.service.imp;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.KhscplanBean;
import com.make.mapper.IKhscplanMapper;
import com.make.service.IKhscplanService;
@Service
public class KhscplanServiceimp implements IKhscplanService {
	@Autowired
	private IKhscplanMapper iKhscplanMapper;

	public List<KhscplanBean> selectKhscplanBeanbyse(String creDate,
			String endDate, String keys) {
		String sql="select * from t_khscplan kp ,t_consumer cs where kp.khid=cs.id and kp.useTag=1 ";
		if (creDate!=null&&!"".equals(creDate)) {
			sql=sql+" and kp.xqsj>='"+creDate+" 00:00:00'";
		}
		if (endDate!=null&&!"".equals(endDate)) {
			sql=sql+" and kp.xqsj<='"+endDate+" 23:59:59'";
		}
		if (keys!=null&&!"".equals(keys)) {
			sql=sql+" and cs.consumerName like '%"+keys+"%' ";
		}
		List<KhscplanBean>khscplanBeans=iKhscplanMapper.selectKhscplanBeanbysql(sql);
		return khscplanBeans;
	}

	public int addKhscplanBean(KhscplanBean khscplanBean) {
		// TODO Auto-generated method stub
		return iKhscplanMapper.addKhscplanBean(khscplanBean);
	}

	public int deleKhscplanBeanbyid(int id) {
		KhscplanBean khscplanBean=iKhscplanMapper.selectKhscplanBeanbyid(id);
		khscplanBean.setUseTag(0);
		return iKhscplanMapper.updateKhscplanBean(khscplanBean);
	}

	public KhscplanBean selectbyid(int id) {
		// TODO Auto-generated method stub
		return iKhscplanMapper.selectKhscplanBeanbyid(id);
	}

	public int updateKhscplanBean(KhscplanBean khscplanBean) {
		// TODO Auto-generated method stub
		return iKhscplanMapper.updateKhscplanBean(khscplanBean);
	}

}
