/**  
 * @Title: DepartmentBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.bean;

/**
 * ClassName: DepartmentBean
 * 
 * @Description: 部门实体类
 * @author zhengjf
 * @date 2016-4-11
 */
public class DepartmentBean {
	/** 主键ID */
	private int id;
	/** 部门名称 */
	private String departmentName;
	/** 备注信息 */
	private String comments;
	/** 父节点ID */
	private int parentId;
	/** 状态 */
	private int status;

	/** 创建时间 */
	private String creatDate;

	/** 所属上级名称 */
	private String parentName;

	/** 创建人 */
	private String owner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
