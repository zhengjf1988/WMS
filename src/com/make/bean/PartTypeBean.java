/**  
 * @Title: PartTypeBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-16
 */
package com.make.bean;

/**
 * ClassName: PartTypeBean
 * 
 * @Description: 零件类型实体类
 * @author zhengjf
 * @date 2016-4-16
 */
public class PartTypeBean {
	/** 主键ID */
	private int id;
	/** 零件类型 */
	private String type;
	/** 备注说明 */
	private String comments;
	/** 创建时间 */
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
