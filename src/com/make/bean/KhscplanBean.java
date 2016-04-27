package com.make.bean;

import java.util.Date;

public class KhscplanBean {
	//客户生产计划
private   int khscid;//id
private   int khid;//客户id
private   int ljid;//零件id
private   int ljsl;//零件数量
private   Date xqsj;//需求时间
private   int useTag;//'是否可用 （1：可用；0:不可用）'
private   int ispg;//'是否派工（0：否；1：是）'
public int getKhscid() {
	return khscid;
}
public void setKhscid(int khscid) {
	this.khscid = khscid;
}
public int getKhid() {
	return khid;
}
public void setKhid(int khid) {
	this.khid = khid;
}
public int getLjid() {
	return ljid;
}
public void setLjid(int ljid) {
	this.ljid = ljid;
}
public int getLjsl() {
	return ljsl;
}
public void setLjsl(int ljsl) {
	this.ljsl = ljsl;
}
public Date getXqsj() {
	return xqsj;
}
public void setXqsj(Date xqsj) {
	this.xqsj = xqsj;
}
public int getUseTag() {
	return useTag;
}
public void setUseTag(int useTag) {
	this.useTag = useTag;
}
public int getIspg() {
	return ispg;
}
public void setIspg(int ispg) {
	this.ispg = ispg;
}
}
