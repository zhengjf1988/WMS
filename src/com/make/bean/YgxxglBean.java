package com.make.bean;

import java.sql.Date;

public class YgxxglBean {
	//员工信息管理
	private String ygid;//员工信息id
	private String ygbh;//员工编号
	private String ygxm;//员工姓名
	private String zwmc;//职位名称
	private String bmmc;//部门名称
	private String lxfs;//联系方式
	private String sxnl;//筛选能力
	private Date creDate;//创建日期
	private String inputman;//创建id
	private int useTag;//是否可用
	private String photoAddr;//图片地址
	
	public String getYgbh() {
		return ygbh;
	}
	public void setYgbh(String ygbh) {
		this.ygbh = ygbh;
	}
	public String getYgxm() {
		return ygxm;
	}
	public void setYgxm(String ygxm) {
		this.ygxm = ygxm;
	}
	public String getZwmc() {
		return zwmc;
	}
	public void setZwmc(String zwmc) {
		this.zwmc = zwmc;
	}
	public String getBmmc() {
		return bmmc;
	}
	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public String getSxnl() {
		return sxnl;
	}
	public void setSxnl(String sxnl) {
		this.sxnl = sxnl;
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
	public String getYgid() {
		return ygid;
	}
	public void setYgid(String ygid) {
		this.ygid = ygid;
	}
	public String getPhotoAddr() {
		return photoAddr;
	}
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}
}
