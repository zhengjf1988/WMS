/**  
 * @Title: IReceivevMapper.java
 * @Package com.make.mapper
 * @Description: 收货信息Dao
 * @author zhengjf
 * @date 2016-4-21
 */
package com.make.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.make.bean.KwlxglBean;
import com.make.bean.KwxxglBean;
import com.make.bean.ReceiveBean;
import com.make.bean.TxmBean;

/**
 * ClassName: IReceivevMapper
 * 
 * @Description: 收货信息Dao
 * @author zhengjf
 * @date 2016-4-21
 */
@Repository
public interface IReceiveMapper {
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
	 * @Description: 查询零件与客户的关联数据
	 * @param @return
	 * @return List<ReceiveBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-23
	 */
	@Select("SELECT t_ljxxgl.ljname as ljName,t_consumer.consumerName as khName FROM t_ljxxgl INNER JOIN t_consumer ON t_consumer.id = t_ljxxgl.fk_khId")
	List<ReceiveBean> load_LJ_KH_Info();

	/**
	 * @Description: 添加 提货信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-21
	 */
	@Insert("INSERT INTO `t_receive` (`fk_ljID`, `count`, `fk_bzID`, `thDate`, `thMan`, `thCar`, `realCount`, `status`,link_id,bd_date) VALUES (#{fk_ljID},#{count}, #{fk_bzID}, #{thDate}, #{thMan}, #{thCar}, #{realCount}, #{status},#{link_id},#{bd_date})")
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
	 * @Description: 根据提货ID查询条形码信息
	 * @param @param recId
	 * @param @return
	 * @return List<TxmBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-25
	 */
	List<TxmBean> loadTxmBy_ReceID(@Param("fk_receId") int recId);

	/**
	 * @Description: 根据提货ID查询条形码与库位信息
	 * @param @param recId
	 * @param @return
	 * @return List<TxmBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-25
	 */
	List<TxmBean> loadTxmKwBy_ReceID(@Param("fk_receId") int recId);

	/**
	 * @Description: 添加条形码信息
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-25
	 */
	int insertTxm(List<TxmBean> list);

	/**
	 * @Description: 修改条形码
	 * @param @param item
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-25
	 */
	int updateTxm(TxmBean item);

	/**
	 * @Description: 查询提货的实际数量
	 * @param @param fk_recId
	 * @param @return
	 * @return int
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-26
	 */
	String loadRealCount(@Param("fk_recId") int fk_recId);

	/**
	 * @Description: 查询库位类型信息
	 * @param @param item
	 * @param @return
	 * @return List<KwlxglBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-27
	 */
	List<KwlxglBean> loadKWType();

	/**
	 * @Description: 查询库位信息
	 * @param @param item
	 * @param @return
	 * @return List<KwxxglBean>
	 * @throws
	 * @author zhengjf
	 * @date 2016-4-27
	 */
	List<KwxxglBean> loadKWInfo();
}
