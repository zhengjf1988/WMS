/**  
 * @Title: PackServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-17
 */
package com.make.service.imp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.PackBean;
import com.make.mapper.IPackMapper;
import com.make.service.IPackService;

/**
 * ClassName: PackServiceImp
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-17
 */
@Service
public class PackServiceImp implements IPackService {

	@Autowired
	IPackMapper packDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IPackService#loadPackInfo(com.make.bean.PackBean)
	 */
	public List<PackBean> loadPackInfo(PackBean item) {
		return packDao.loadPackInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IPackService#insertPack(com.make.bean.PackBean)
	 */
	public int insertPack(PackBean item) {
		return packDao.insertPack(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IPackService#linkPage(int)
	 */
	public PackBean linkPage(int id) {
		PackBean item = new PackBean();
		item.setId(id);
		List<PackBean> list = packDao.loadPackInfo(item);
		if (id > 0) {
			return list.get(0);
		} else {
			return item;
		}

	}

}
