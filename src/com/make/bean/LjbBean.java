package com.make.bean;

import java.util.Date;

public class LjbBean {//零件包
	private int ljbid;//零件包id
	private int kwid;//库位id
	private int ljid;//零件id
	private String tmbh;//条码编号
	private Date rksj;//入库时间
	private int kcl;//库存量
	public int getLjbid() {
		return ljbid;
	}
	public void setLjbid(int ljbid) {
		this.ljbid = ljbid;
	}
	public int getKwid() {
		return kwid;
	}
	public void setKwid(int kwid) {
		this.kwid = kwid;
	}
	public int getLjid() {
		return ljid;
	}
	public void setLjid(int ljid) {
		this.ljid = ljid;
	}
	public String getTmbh() {
		return tmbh;
	}
	public void setTmbh(String tmbh) {
		this.tmbh = tmbh;
	}
	public Date getRksj() {
		return rksj;
	}
	public void setRksj(Date rksj) {
		this.rksj = rksj;
	}
	public int getKcl() {
		return kcl;
	}
	public void setKcl(int kcl) {
		this.kcl = kcl;
	}
}
