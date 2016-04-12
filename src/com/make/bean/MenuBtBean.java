/**  
 * @Title: MenuBtBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-12
 */
package com.make.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MenuBtBean
 * 
 * @Description: 菜单按钮实体类
 * @author zhengjf
 * @date 2016-4-12
 */
public class MenuBtBean {
	/** 主键ID */
	private int id;
	/** 名称 */
	private String name;
	/** 类型 1顶级菜单，2子菜单，3按钮 */
	private int type;
	/** 父节点ID */
	private int parentId;
	/** 状态 */
	private int status;
	/** 子节点集合 */
	private List<MenuBtBean> childList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public List<MenuBtBean> getChildList() {
		if (childList == null)
			childList = new ArrayList<MenuBtBean>();
		return childList;
	}

	public void setChildList(List<MenuBtBean> childList) {
		this.childList = childList;
	}

}
