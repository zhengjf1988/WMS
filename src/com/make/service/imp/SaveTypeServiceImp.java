/**  
 * @Title: SaveTypeServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-17
 */
package com.make.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.SaveTypeBean;
import com.make.mapper.ISaveTypeMapper;
import com.make.service.ISaveTypeService;

/**
 * ClassName: SaveTypeServiceImp
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-17
 */
@Service
public class SaveTypeServiceImp implements ISaveTypeService {

	@Autowired
	ISaveTypeMapper saveTypeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.ISaveTypeService#loadInfo(com.make.bean.SaveTypeBean)
	 */
	public List<SaveTypeBean> loadInfo(SaveTypeBean item) {
		return saveTypeDao.loadInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.ISaveTypeService#insertInfo(com.make.bean.SaveTypeBean)
	 */
	public int insertInfo(SaveTypeBean item) {
		// TODO Auto-generated method stub
		return saveTypeDao.insertInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.ISaveTypeService#linkPage(int)
	 */
	public SaveTypeBean linkPage(int id) {
		SaveTypeBean item = new SaveTypeBean();
		item.setId(id);
		List<SaveTypeBean> list = saveTypeDao.loadInfo(item);
		if (id > 0) {
			return list.get(0);
		} else {
			return item;
		}
	}

}
