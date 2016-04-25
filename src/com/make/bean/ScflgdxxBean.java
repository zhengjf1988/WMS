package com.make.bean;

import java.util.Date;

public class ScflgdxxBean {
	private int gdid;//工单id
	private String gdbh;//工单编号
	private String ljmcid;//零件名称
	private String scbzid;//生产班组id
	private Date jhsj;//计划时间
	private String fk_khid;//客户名称id
	private Date creDate;//创建日期
	private String inputman;//创建人id
	private int useTag;//是否可用
	private int ljsl;//零件数量
	private Date sxsj ;//筛选时间
	private int flstatus ;//发料状态（0：未发料；1：已发料)
	public int getGdid() {
		return gdid;
	}
	public void setGdid(int gdid) {
		this.gdid = gdid;
	}
	public String getGdbh() {
		return gdbh;
	}
	public void setGdbh(String gdbh) {
		this.gdbh = gdbh;
	}
	public String getLjmcid() {
		return ljmcid;
	}
	public void setLjmcid(String ljmcid) {
		this.ljmcid = ljmcid;
	}
	public String getScbzid() {
		return scbzid;
	}
	public void setScbzid(String scbzid) {
		this.scbzid = scbzid;
	}
	public Date getJhsj() {
		return jhsj;
	}
	public void setJhsj(Date jhsj) {
		this.jhsj = jhsj;
	}
	public String getFk_khid() {
		return fk_khid;
	}
	public void setFk_khid(String fk_khid) {
		this.fk_khid = fk_khid;
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
	public int getUseTag() {
		return useTag;
	}
	public void setUseTag(int useTag) {
		this.useTag = useTag;
	}
	public int getLjsl() {
		return ljsl;
	}
	public void setLjsl(int ljsl) {
		this.ljsl = ljsl;
	}
	public Date getSxsj() {
		return sxsj;
	}
	public void setSxsj(Date sxsj) {
		this.sxsj = sxsj;
	}
	public int getFlstatus() {
		return flstatus;
	}
	public void setFlstatus(int flstatus) {
		this.flstatus = flstatus;
	}
	
}
