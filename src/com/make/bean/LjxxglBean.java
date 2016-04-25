package com.make.bean;

import java.util.Date;

public class LjxxglBean {
	private String ljid;// 零件信息id
	private String ljbm;// 零件编码
	private String ljname;// 零件名称
	private String cctype;// 存储类型
	private String sjlj;// 上级零件
	private String gjsl;// 构件数量
	private Date creDate;// 创建日期
	private String inputman;// 创建人id
	private int useTag;// 0删除 1未删除
	/** 客户信息外键ID */
	private int fk_khId;

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

	public int getFk_khId() {
		return fk_khId;
	}

	public void setFk_khId(int fk_khId) {
		this.fk_khId = fk_khId;
	}

}
