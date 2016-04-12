/**  
 * @Title: RelePermissionBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
 */
package com.make.bean;

/**
 * ClassName: RelePermissionBean
 * 
 * @Description: 角色权限实体类
 * @author zhengjf
 * @date 2016-4-12
 */
public class RolePermissionBean {
	/** 主键ID */
	private int id;
	/** 角色名称 */
	private String roleName;
	/** 权限信息 */
	private String permission;
	/** 备注 */
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
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
