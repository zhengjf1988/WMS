package com.make.bean;

import java.util.Date;


public class ScflitemBean {
//生产发料明细
	
	private String flmxid;//发料明细id
	private String gdid;//工单id
	private String ljbid;//零件包id
	private String kwid;//目标库 库位id;
	private int ckstatus;//出库状态 0 未出库 1 进行中 2已完成 3 以生成退料
	private Date fldate;//发料日期
	public String getFlmxid() {
		return flmxid;
	}
	public void setFlmxid(String flmxid) {
		this.flmxid = flmxid;
	}
	public String getLjbid() {
		return ljbid;
	}
	public void setLjbid(String ljbid) {
		this.ljbid = ljbid;
	}
	public String getKwid() {
		return kwid;
	}
	public void setKwid(String kwid) {
		this.kwid = kwid;
	}
	public int getCkstatus() {
		return ckstatus;
	}
	public void setCkstatus(int ckstatus) {
		this.ckstatus = ckstatus;
	}
	public String getGdid() {
		return gdid;
	}
	public void setGdid(String gdid) {
		this.gdid = gdid;
	}
	public Date getFldate() {
		return fldate;
	}
	public void setFldate(Date fldate) {
		this.fldate = fldate;
	}
	
	
	
}
