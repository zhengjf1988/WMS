/**  
 * @Title: SelfPlanServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-28
 */
package com.make.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.ConsumerInfoBean;
import com.make.bean.LjxxglBean;
import com.make.bean.SelfPlanBean;
import com.make.mapper.IConsumerInfoMapper;
import com.make.mapper.ILjxxglMapper;
import com.make.mapper.ISelfPlanMapper;
import com.make.service.ISelfPlanService;

/**
 * ClassName: SelfPlanServiceImp
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-28
 */
@Service
public class SelfPlanServiceImp implements ISelfPlanService {

	@Autowired
	ISelfPlanMapper selfDao;

	@Autowired
	IConsumerInfoMapper conDao;// 客户

	@Autowired
	ILjxxglMapper ljDao;// 零件

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.ISelfPlanService#linkPage(int)
	 */
	public Map<String, Object> linkPage(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		SelfPlanBean item = new SelfPlanBean();

		item.setId(id);
		if (id > 0)
			item = selfDao.loadInfo(item).get(0);

		List<ConsumerInfoBean> khList = conDao.loadInfo(null);
		List<LjxxglBean> ljList = ljDao.selectljxxglBeanall();

		map.put("item", item);
		map.put("khList", khList);
		map.put("ljList", ljList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.ISelfPlanService#insertSelfInfo(com.make.bean.SelfPlanBean
	 * )
	 */
	public int insertSelfInfo(SelfPlanBean item) {
		return selfDao.insertSelfInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.ISelfPlanService#loadInfo(com.make.bean.SelfPlanBean)
	 */
	public List<SelfPlanBean> loadInfo(SelfPlanBean item) {
		return selfDao.loadInfo(item);
	}
}
