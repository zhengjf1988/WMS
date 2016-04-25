package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.YgxxglBean;
import com.make.mapper.IYgxxglMapper;
import com.make.service.IYgxxglService;

@Service
public class YgxxglServiceImp implements IYgxxglService{
	 @Autowired
	 IYgxxglMapper iYgxxglMapper;
		public List<YgxxglBean> selectYgxxglBeanbyse(String creDate,
				String endDate, String keys) {
			String sql="select * from t_ygxxgl where useTag=1";
			if (creDate!=null&&!"".equals(creDate)) {
				sql=sql+" and creDate>='"+creDate+" 00:00:00'";
			}
			if (endDate!=null&&!"".equals(endDate)) {
				sql=sql+" and creDate<='"+endDate+" 23:59:59'";
			}
			if (keys!=null&&!"".equals(keys)) {
				sql=sql+" and (ygxm like '%"+keys+"%' or zwmc like '%"+keys+"%'or bmmc like '%"+keys+"%')";
			}
			List<YgxxglBean> ygxxglBeans=this.iYgxxglMapper.selectYgxxglBeanbysql(sql);
			return ygxxglBeans;
		}

		public int addYgxxglBean(YgxxglBean ygxxglBean) {
			// TODO Auto-generated method stub
			return this.iYgxxglMapper.addYgxxglBean(ygxxglBean);
		}

		public int deleYgxxglBeanbyid(String ygid) {
			// TODO Auto-generated method stub
			return this.iYgxxglMapper.deleteone(ygid);
		}

		public YgxxglBean selectbyid(String id) {
			// TODO Auto-generated method stub
			return this.iYgxxglMapper.selectYgxxglBeanbyid(id);
		}

		public int updateYgxxglBean(YgxxglBean ygxxglBean) {
			// TODO Auto-generated method stub
			
			return this.iYgxxglMapper.updateYgxxglBean(ygxxglBean);
		}


	}
