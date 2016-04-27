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
	/** 库位类型外键 */
	private int fk_kwTypeId;
	/** 库位信息外键 */
	private int fk_kwID;
	/** 入库确认状态（0未完成 1已完成） */
	private int status;
	/** 库位类型 */
	public String kwType;
	/** 库位名称 */
	public String kwName;

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

	public int getFk_kwTypeId() {
		return fk_kwTypeId;
	}

	public void setFk_kwTypeId(int fk_kwTypeId) {
		this.fk_kwTypeId = fk_kwTypeId;
	}

	public int getFk_kwID() {
		return fk_kwID;
	}

	public void setFk_kwID(int fk_kwID) {
		this.fk_kwID = fk_kwID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getKwType() {
		return kwType;
	}

	public void setKwType(String kwType) {
		this.kwType = kwType;
	}

	public String getKwName() {
		return kwName;
	}

	public void setKwName(String kwName) {
		this.kwName = kwName;
	}

}
