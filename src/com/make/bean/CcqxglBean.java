package com.make.bean;

import java.util.Date;

public class CcqxglBean {//存储期限管理--------------
	private int ccid;//存储期限id
	private String ccname;//零件存储类型
	private String kwmeno;//库位存储类型
	private int issx;//是否受限
	private Date creDate;//创建日期
	private String inputman;//创建人id
	private Date sxqx;//存储期限
	private int useTag;//是否可用
	public int getCcid() {
		return ccid;
	}
	public void setCcid(int ccid) {
		this.ccid = ccid;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public String getKwmeno() {
		return kwmeno;
	}
	public void setKwmeno(String kwmeno) {
		this.kwmeno = kwmeno;
	}
	public int getIssx() {
		return issx;
	}
	public void setIssx(int issx) {
		this.issx = issx;
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
	public Date getSxqx() {
		return sxqx;
	}
	public void setSxqx(Date sxqx) {
		this.sxqx = sxqx;
	}
	public int getUseTag() {
		return useTag;
	}
	public void setUseTag(int useTag) {
		this.useTag = useTag;
	}
	
}
