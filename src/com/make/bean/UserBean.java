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
	/** 真实姓名 */
	private String realName;
	/** 创建时间 */
	private String creatDate;
	/** 创建人 */
	private String owner;
	/** 用户状态 */
	private int status;
	/** 用户备注 */
	private String comments;
	/** 用户部门外键 */
	private int fk_departmentId;
	/** 用户所属角色外键 */
	private int fk_roleId;
	/** 用户所属部门名称 */
	private String departmentName;
	/** 用户所属角色名称 */
	private String roleName;
	/** 用户所属角色权限 */
	private String permission;

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

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

}
