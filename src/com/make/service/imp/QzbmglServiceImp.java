package com.make.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.QzbmglBean;
import com.make.mapper.IQzbmglMapper;
import com.make.service.IQzbmglService;
@Service
public class QzbmglServiceImp implements IQzbmglService {
	@Autowired
	private IQzbmglMapper iQzbmglMapper;

	public QzbmglBean selectbyid(int id) {
		// TODO Auto-generated method stub
		return iQzbmglMapper.selectQzbmglBeanbyid(id);
	}

	public int updateQzbmglBean(QzbmglBean qzbmglBean) {
		// TODO Auto-generated method stub
		return iQzbmglMapper.updateQzbmglBean(qzbmglBean);
	}

	public String getbm(int id) {
		 QzbmglBean qzbmglBean= selectbyid(id);
		
		 Long bmLong=qzbmglBean.getDqvalue()+1;
			qzbmglBean.setDqvalue(bmLong);
			updateQzbmglBean(qzbmglBean);
		 bmLong=1000000000000l+bmLong;
		 String bmString=qzbmglBean.getQianzhui()+bmLong;
		return bmString;
	}

}
