package com.make.bean;

import java.util.Date;

public class LjdjglBean {
	//零件等级管理
	
	private int djid;//零件等级id
	private String djname;//等级名称
	private String djmeno;//等级说明
	private Date creDate;//创建日期
	private String inputman;//创建人id
	private int iddelete;//0未删除 1删除
	public int getDjid() {
		return djid;
	}
	public void setDjid(int djid) {
		this.djid = djid;
	}
	public String getDjname() {
		return djname;
	}
	public void setDjname(String djname) {
		this.djname = djname;
	}
	public String getDjmeno() {
		return djmeno;
	}
	public void setDjmeno(String djmeno) {
		this.djmeno = djmeno;
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
