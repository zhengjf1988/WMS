/**  
 * @Title: TxmBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-25
 */
package com.make.bean;

/**
 * ClassName: TxmBean
 * 
 * @Description: 验货相关——条形码实体类
 * @author zhengjf
 * @date 2016-4-25
 */
public class TxmBean {
	/** 主键ID */
	private int id;
	/** 条形码 */
	private String txm;
	/** 实际数量 */
	private String realCount;
	/** 提货信息外键 */
	private int fk_receId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTxm() {
		return txm;
	}

	public void setTxm(String txm) {
		this.txm = txm;
	}

	public String getRealCount() {
		return realCount;
	}

	public void setRealCount(String realCount) {
		this.realCount = realCount;
	}

	public int getFk_receId() {
		return fk_receId;
	}

	public void setFk_receId(int fk_receId) {
		this.fk_receId = fk_receId;
	}

}
