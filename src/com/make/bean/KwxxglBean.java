package com.make.bean;

import java.util.Date;
//库位信息管理
public class KwxxglBean {
	private int kwid;//库位信息id
	private String kwname;//库位名称
	private String kwtype;//库位类型
	private String cctype;//存储类型
	private double kwrl;//库位容量
	private long kwbm;//库位编码
	private String kwaddress;//库位地址
	private Date creDate;//创建日期
	private String inputman;//创建人id
	private int useTag;//是否可用
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
	public String getKwtype() {
		return kwtype;
	}
	public void setKwtype(String kwtype) {
		this.kwtype = kwtype;
	}
	public String getCctype() {
		return cctype;
	}
	public void setCctype(String cctype) {
		this.cctype = cctype;
	}
	public double getKwrl() {
		return kwrl;
	}
	public void setKwrl(double kwrl) {
		this.kwrl = kwrl;
	}
	public long getKwbm() {
		return kwbm;
	}
	public void setKwbm(long kwbm) {
		this.kwbm = kwbm;
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
	public String getKwaddress() {
		return kwaddress;
	}
	public void setKwaddress(String kwaddress) {
		this.kwaddress = kwaddress;
	}
	
}
