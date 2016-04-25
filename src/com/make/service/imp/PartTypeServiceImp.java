/**  
 * @Title: PartTypeServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-17
 */
package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.PartTypeBean;
import com.make.mapper.IPartTypeMapper;
import com.make.service.IPartTypeService;

/**
 * ClassName: PartTypeServiceImp
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-17
 */
@Service
public class PartTypeServiceImp implements IPartTypeService {

	@Autowired
	IPartTypeMapper partTypeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.IPartTypeService#loadInfo(com.make.bean.PartTypeBean)
	 */
	public List<PartTypeBean> loadInfo(PartTypeBean item) {
		return partTypeDao.loadInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.IPartTypeService#insertInfo(com.make.bean.PartTypeBean)
	 */
	public int insertInfo(PartTypeBean item) {
		// TODO Auto-generated method stub
		return partTypeDao.insertInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IPartTypeService#linkPage(int)
	 */
	public PartTypeBean linkPage(int id) {
		PartTypeBean item = new PartTypeBean();
		item.setId(id);
		List<PartTypeBean> list = partTypeDao.loadInfo(item);
		if (id > 0) {
			return list.get(0);
		} else {
			return item;
		}
	}

}
