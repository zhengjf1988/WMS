package com.make.bean;

import java.util.Date;

public class KwlxglBean {
	//库位类型管理
	private int kwid;//零件类型id
	private String kwname;//类型名称
	private String kwmeno;//类型说明
	private Date creDate;//创建日期
	private String inputman;//创建人id
	private int iddelete;//0未删除 1删除
	public int getKwid() {
		return kwid;
	}
	public void setKwid(int kwid) {
		this.kwid = kwid;
	}
	public String getKwname() {
		return kwname;
	}
	public void setKwname(String kwname) {
		this.kwname = kwname;
	}
	public String getKwmeno() {
		return kwmeno;
	}
	public void setKwmeno(String kwmeno) {
		this.kwmeno = kwmeno;
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
	public int getIddelete() {
		return iddelete;
	}
	public void setIddelete(int iddelete) {
		this.iddelete = iddelete;
	}
}
