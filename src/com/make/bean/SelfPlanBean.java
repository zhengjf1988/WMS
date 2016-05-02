/**  
 * @Title: SelfPlanBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-28
 */
package com.make.bean;

/**
 * ClassName: SelfPlanBean
 * 
 * @Description: 内部生产计划实体类
 * @author zhengjf
 * @date 2016-4-28
 */
public class SelfPlanBean {
	/** 主键ID */
	private int id;
	/** 客户关联外键ID */
	private int fk_khId;
	/** 零件信息外键ID */
	private int fk_ljId;
	/** 零件数量 */
	private int count;
	/** 需求时间 */
	private String xqDate;
	/** 状态 (0 正常，1 删除) */
	private int status;
	/** 客户名称 */
	private String khName;
	/** 零件名称 */
	private String ljname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_khId() {
		return fk_khId;
	}

	public void setFk_khId(int fk_khId) {
		this.fk_khId = fk_khId;
	}

	public int getFk_ljId() {
		return fk_ljId;
	}

	public void setFk_ljId(int fk_ljId) {
		this.fk_ljId = fk_ljId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getXqDate() {
		return xqDate;
	}

	public void setXqDate(String xqDate) {
		this.xqDate = xqDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getKhName() {
		return khName;
	}

	public void setKhName(String khName) {
		this.khName = khName;
	}

	public String getLjname() {
		return ljname;
	}

	public void setLjname(String ljname) {
		this.ljname = ljname;
	}

}
