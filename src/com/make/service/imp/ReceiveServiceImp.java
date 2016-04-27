/**  
 * @Title: ReceiveServiceImp.java
 * @Package com.make.service.imp
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-21
 */
package com.make.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.make.bean.KwlxglBean;
import com.make.bean.KwxxglBean;
import com.make.bean.LjxxglBean;
import com.make.bean.PackBean;
import com.make.bean.ReceiveBean;
import com.make.bean.TxmBean;
import com.make.mapper.ILjxxglMapper;
import com.make.mapper.IPackMapper;
import com.make.mapper.IReceiveMapper;
import com.make.service.IReceiveService;

/**
 * ClassName: ReceiveServiceImp
 * 
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-21
 */
@Service
public class ReceiveServiceImp implements IReceiveService {

	@Autowired
	IReceiveMapper receiveDao;

	@Autowired
	ILjxxglMapper ljxxDao;

	@Autowired
	IPackMapper packDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IReceiveService#loadInfo(com.make.bean.ReceiveBean)
	 */
	public List<ReceiveBean> loadInfo(ReceiveBean item) {
		List<ReceiveBean> tmpList = receiveDao.loadInfo(item);
		for (ReceiveBean receiveBean : tmpList) {
			ReceiveBean bdItem = new ReceiveBean();
			bdItem.setLink_id(receiveBean.getId());
			bdItem.setStatus(-1);
			List<ReceiveBean> tmplist = receiveDao.loadInfo(bdItem);
			if (tmplist.size() > 0) {
				receiveBean.setBd_flag(true);
			} else {
				receiveBean.setBd_flag(false);
			}
			// 分库后确认分箱的每一个是否已入库,按照超分行的确认
			if (receiveBean.getStatus() == 4) {
				List<TxmBean> txmList = receiveDao.loadTxmBy_ReceID(receiveBean.getId());
				for (TxmBean txmBean : txmList) {
					if (txmBean.getStatus() == 0) {
						receiveBean.setOver_flag(false);
						break;
					} else {
						receiveBean.setOver_flag(true);
					}
				}
			}
		}
		return tmpList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.IReceiveService#insertInfo(com.make.bean.ReceiveBean)
	 */
	public int insertInfo(ReceiveBean item) {
		return receiveDao.insertInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.make.service.IReceiveService#updateInfo(com.make.bean.ReceiveBean)
	 */
	public int updateInfo(ReceiveBean item) {
		String res = receiveDao.loadRealCount(item.getId());
		if (res != null && !"".equals(res)) {
			item.setRealCount(Integer.parseInt(res));
		}
		return receiveDao.updateInfo(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IReceiveService#linkPage(int)
	 */
	public Map<String, Object> linkPage(int id, int status) {
		Map<String, Object> map = new HashMap<String, Object>();
		ReceiveBean item = new ReceiveBean();
		item.setId(id);
		item.setStatus(status);
		if (id > 0) {
			item = receiveDao.loadInfo(item).get(0);
		}

		// 查询条形码
		List<TxmBean> txmList = new ArrayList<TxmBean>();
		if (status == 3) {
			txmList = receiveDao.loadTxmBy_ReceID(id);
			map.put("txmList", txmList);
		}
		if (status == 4) {
			txmList = receiveDao.loadTxmKwBy_ReceID(id);
			map.put("txmList", txmList);
		}
		// 补单信息
		ReceiveBean bdItem = new ReceiveBean();
		if (id > 0) {
			bdItem.setLink_id(id);
			bdItem.setStatus(-1);
			List<ReceiveBean> tmplist = receiveDao.loadInfo(bdItem);
			if (tmplist.size() > 0)
				bdItem = tmplist.get(0);
		}
		map.put("bdItem", bdItem);

		// 零件信息
		List<LjxxglBean> ljxxList = ljxxDao.selectljxxglBeanall();
		// 包装信息
		List<PackBean> packList = packDao.loadPackInfo(null);
		map.put("item", item);
		map.put("ljxxList", ljxxList);
		map.put("packList", packList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IReceiveService#loadTxmBy_ReceID(int)
	 */
	public List<TxmBean> loadTxmBy_ReceID(int recId) {
		return receiveDao.loadTxmBy_ReceID(recId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IReceiveService#upsertTxm(java.util.List)
	 */
	public void upsertTxm(List<TxmBean> list) {
		List<TxmBean> addList = new ArrayList<TxmBean>();
		for (TxmBean item : list) {
			if (item.getId() > 0) {
				receiveDao.updateTxm(item);// 修改
			} else {
				addList.add(item);// 需要添加数据的集合
			}
		}
		if (addList.size() > 0)
			receiveDao.insertTxm(addList);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IReceiveService#loadRealCount(int)
	 */
	public String loadRealCount(int fk_recId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.make.service.IReceiveService#fenkuLoad(int)
	 */
	public Map<String, Object> fenkuLoad(int recId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TxmBean> txmList = receiveDao.loadTxmBy_ReceID(recId);// 条形码集合
		List<KwlxglBean> kwTypeList = receiveDao.loadKWType();// 库位类型信息
		List<KwxxglBean> kwInfoList = receiveDao.loadKWInfo();// 库位信息
		map.put("txmList", txmList);
		map.put("kwTypeList", kwTypeList);
		map.put("kwInfoList", kwInfoList);
		return map;
	}

}
