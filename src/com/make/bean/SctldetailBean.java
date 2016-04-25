package com.make.bean;

import java.util.Date;


public class SctldetailBean {
//生产退料明细
	private String tlmxid;//退料明细id
	private String flmxid;//发料明细id
	private String tmbh;//条码编号
	private int ljid;//零件id
	private int tlsl;//退料数量
	private Date tlsj;//退料时间
	private Date rksj;//重新入库的时间
	private String inputman;//录单人
	private int tlstatus;//退料状态   0  待入库  1进行中 2已完成
	private int useTag;//是否启用，1可用 0不可用
	public String getTlmxid() {
		return tlmxid;
	}
	public void setTlmxid(String tlmxid) {
		this.tlmxid = tlmxid;
	}
	public String getTmbh() {
		return tmbh;
	}
	public void setTmbh(String tmbh) {
		this.tmbh = tmbh;
	}
	public int getTlsl() {
		return tlsl;
	}
	public void setTlsl(int tlsl) {
		this.tlsl = tlsl;
	}
	public Date getTlsj() {
		return tlsj;
	}
	public void setTlsj(Date tlsj) {
		this.tlsj = tlsj;
	}
	public Date getRksj() {
		return rksj;
	}
	public void setRksj(Date rksj) {
		this.rksj = rksj;
	}
	public String getInputman() {
		return inputman;
	}
	public void setInputman(String inputman) {
		this.inputman = inputman;
	}
	public int getTlstatus() {
		return tlstatus;
	}
	public void setTlstatus(int tlstatus) {
		this.tlstatus = tlstatus;
	}
	public int getUseTag() {
		return useTag;
	}
	public void setUseTag(int useTag) {
		this.useTag = useTag;
	}
	public int getLjid() {
		return ljid;
	}
	public void setLjid(int ljid) {
		this.ljid = ljid;
	}
	public String getFlmxid() {
		return flmxid;
	}
	public void setFlmxid(String flmxid) {
		this.flmxid = flmxid;
	}
	
	
	
	
}
