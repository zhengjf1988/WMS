/**  
 * @Title: PackBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.bean;

/**
 * ClassName: PackBean
 * 
 * @Description: 包装信息实体类
 * @author zhengjf
 * @date 2016-4-16
 */
public class PackBean {
	/** 用户ID */
	private int id;
	/** 包装名称 */
	private String packName;
	/** 数量 */
	private String count;
	/** 体积 */
	private String bulk;
	/** 备注信息 */
	private String comments;
	/** 创建日期 */
	private String creatDate;
	/** 创建人 */
	private String owner;
	/** 状态 */
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getBulk() {
		return bulk;
	}

	public void setBulk(String bulk) {
		this.bulk = bulk;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
