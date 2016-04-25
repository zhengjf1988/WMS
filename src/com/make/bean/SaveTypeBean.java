/**  
 * @Title: SaveTypeBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.bean;

/**
 * ClassName: SaveTypeBean
 * 
 * @Description: 存储类型实体类
 * @author zhengjf
 * @date 2016-4-16
 */
public class SaveTypeBean {
	/** 主键ID */
	private int id;
	/** 存储类型 */
	private String saveType;
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

	public String getSaveType() {
		return saveType;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
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
