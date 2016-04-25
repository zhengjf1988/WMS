package com.make.bean;

import java.util.Date;

public class LjxxglBean {
	private String ljid;//零件信息id
	private String ljbm;//零件编码
	private String ljname;//零件名称
	private String fk_khid;//客户id
	private String cctype;//存储类型
	private String sjlj;//上级零件
	private String gjsl;//构件数量
	private Date creDate;//创建日期
	private String inputman;//创建人id
	private int useTag;//0删除 1未删除
	public String getLjid() {
		return ljid;
	}
	public void setLjid(String ljid) {
		this.ljid = ljid;
	}
	public String getLjname() {
		return ljname;
	}
	public void setLjname(String ljname) {
		this.ljname = ljname;
	}
	public String getCctype() {
		return cctype;
	}
	public void setCctype(String cctype) {
		this.cctype = cctype;
	}
	public String getSjlj() {
		return sjlj;
	}
	public void setSjlj(String sjlj) {
		this.sjlj = sjlj;
	}
	public String getGjsl() {
		return gjsl;
	}
	public void setGjsl(String gjsl) {
		this.gjsl = gjsl;
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
	public String getLjbm() {
		return ljbm;
	}
	public void setLjbm(String ljbm) {
		this.ljbm = ljbm;
	}
	public String getFk_khid() {
		return fk_khid;
	}
	public void setFk_khid(String fk_khid) {
		this.fk_khid = fk_khid;
	}
	
}
