/**  
 * @Title: ConsumerInfoServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-17
 */
package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.ConsumerInfoBean;
import com.make.mapper.IConsumerInfoMapper;
import com.make.service.IConsumerInfoService;

/**
 * ClassName: ConsumerInfoServiceImp
 * 
 * @Description: 客户信息service
 * @author zhengjf
 * @date 2016-4-17
 */
@Service
public class ConsumerInfoServiceImp implements IConsumerInfoService {

	@Autowired
	IConsumerInfoMapper consumerDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.IConsumerInfoService#loadInfo(com.make.bean.ConsumerInfoBean
	 * )
	 */
	public List<ConsumerInfoBean> loadInfo(ConsumerInfoBean item) {
		return consumerDao.loadInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IConsumerInfoService#insertInfo(com.make.bean.
	 * ConsumerInfoBean)
	 */
	public int insertInfo(ConsumerInfoBean item) {
		// TODO Auto-generated method stub
		return consumerDao.insertInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IConsumerInfoService#linkPage(int)
	 */
	public ConsumerInfoBean linkPage(int id) {
		ConsumerInfoBean item = new ConsumerInfoBean();
		item.setId(id);
		List<ConsumerInfoBean> list = consumerDao.loadInfo(item);
		if (id > 0) {
			return list.get(0);
		} else {
			return item;
		}
	}

}
