/**  
 * @Title: UserBean.java
 * @Package com.make.bean
 * @Description: 用户实体类
 * @author zhengjf
 * @date 2016-4-7
 */
package com.make.bean;

/**
 * ClassName: UserBean
 * 
 * @Description: 用户实体类
 * @author zhengjf
 * @date 2016-4-7
 */
public class UserBean {

	/** 主键ID */
	private int id;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String psw;
	/** 用户状态 */
	private int status;
	/** 用户备注 */
	private String comments;
	/** 用户部门外键 */
	private int fk_departmentId;
	/** 用户所属角色外键 */
	private int fk_roleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getFk_departmentId() {
		return fk_departmentId;
	}

	public void setFk_departmentId(int fk_departmentId) {
		this.fk_departmentId = fk_departmentId;
	}

	public int getFk_roleId() {
		return fk_roleId;
	}

	public void setFk_roleId(int fk_roleId) {
		this.fk_roleId = fk_roleId;
	}

}
