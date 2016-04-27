/**  
 * @Title: IReceiveService.java
 * @Package com.make.mapper
 * @Description: 收货信息service
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.service;

import java.util.List;
import java.util.Map;

import com.make.bean.ReceiveBean;
import com.make.bean.TxmBean;

/**
 * ClassName: IReceiveService
 * 
 * @Description: 收货信息Service
 * @author zhengjf
 * @date 2016-4-21
 */
public interface IReceiveService {

	/**
	 * @Description: 查询收货信息
	 * @param @param item
	 * @param @return
	 * @return List<ReceiveBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	List<ReceiveBean> loadInfo(ReceiveBean item);

	/**
	 * @Description: 添加 提货信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	int insertInfo(ReceiveBean item);

	/**
	 * @Description: 修改收货信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-19
	 */
	int updateInfo(ReceiveBean item);

	/**
	 * @Description: 跳转页面的数据查询
	 * @param @param id
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	Map<String, Object> linkPage(int id, int status);

	/**
	 * @Description: 根据提货ID查询条形码信息
	 * @param @param recId
	 * @param @return
	 * @return List<TxmBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-25
	 */
	List<TxmBean> loadTxmBy_ReceID(int recId);

	/**
	 * @Description: 添加或者修改条形码信息
	 * @param @param list
	 * @return void
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-26
	 */
	void upsertTxm(List<TxmBean> list);

	/**
	 * @Description: 查询提货的实际数量
	 * @param @param fk_recId
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-26
	 */
	String loadRealCount(int fk_recId);

	/**
	 * @Description: 分库信息查询
	 * @param @param recId
	 * @param @return
	 * @return Map<String,Object>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-27
	 */
	Map<String, Object> fenkuLoad(int recId);
}
