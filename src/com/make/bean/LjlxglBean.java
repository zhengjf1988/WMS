package com.make.bean;

import java.util.Date;


public class LjlxglBean {//零件类型管理

	private String lxid;//零件类型id
	private String lxname;//类型名称
	private String lxmeno;//类型说明
	private Date creDate;//创建日期
	private String inputman;//创建人id
	public String getLxid() {
		return lxid;
	}
	public void setLxid(String lxid) {
		this.lxid = lxid;
	}
	public String getLxname() {
		return lxname;
	}
	public void setLxname(String lxname) {
		this.lxname = lxname;
	}
	public String getLxmeno() {
		return lxmeno;
	}
	public void setLxmeno(String lxmeno) {
		this.lxmeno = lxmeno;
	}
	public Date getCreDate() {
		return creDate;
	}
	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}
	public String getInputman() {
		return inputman;
	}
	public void setInputman(String inputman) {
		this.inputman = inputman;
	}
	
	
}
