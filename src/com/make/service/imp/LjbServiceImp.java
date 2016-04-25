package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.LjbBean;
import com.make.mapper.IKwlxglMapper;
import com.make.mapper.ILjbMapper;
import com.make.service.ILjbService;
@Service
public class LjbServiceImp implements ILjbService{

	@Autowired
	private ILjbMapper iLjbMapper;
	public List<LjbBean> selectLjbBeansbyse(String creDate, String endDate,
			String keys) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addLjbBean(LjbBean ljbBean) {
		// TODO Auto-generated method stub
		return this.iLjbMapper.addLjbBean(ljbBean);
	}

	public int deleLjbBeanbyid(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public LjbBean selectbyid(int id) {
		// TODO Auto-generated method stub
		return this.iLjbMapper.selectLjbBeanbyid(id);
	}

	public int updateljbBean(LjbBean ljbBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<LjbBean> selectall() {
		// TODO Auto-generated method stub
		return this.iLjbMapper.selectLjbBeanall();
	}

	public List<LjbBean> selectalltotrue() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LjbBean> selectallbyljid(int ljid) {
		// TODO Auto-generated method stub
		return this.iLjbMapper.selectLjbBeanbyljid(ljid);
	}

}
