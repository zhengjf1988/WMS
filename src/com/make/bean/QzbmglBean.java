package com.make.bean;

public class QzbmglBean {
//前缀编码管理
	private String id;//主建id
	private String qianzhui;//前缀
	private long dqvalue;//当前值
	private String beizhu;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQianzhui() {
		return qianzhui;
	}
	public void setQianzhui(String qianzhui) {
		this.qianzhui = qianzhui;
	}
	public long getDqvalue() {
		return dqvalue;
	}
	public void setDqvalue(long dqvalue) {
		this.dqvalue = dqvalue;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
}
