/**  
 * @Title: NoticeBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.bean;

import java.util.Date;

import com.make.util.DateUtils;

/**
 * ClassName: NoticeBean
 * 
 * @Description: 系统公告实体Bean
 * @author zhengjf
 * @date 2016-4-11
 */
public class NoticeBean extends DBInfoBean {
	/** 主键ID */
	private int id;
	/** 标题 */
	private String title;
	/** 内容 */
	private String content;
	/** 创建时间 */
	private Date creatTime;
	/** 发布人 */
	private String owner;
	/** 状态 */
	private int status;

	/** 创建时间 */
	private String dateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDateTime() {
		dateTime = DateUtils.date2String(getCreatTime());
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
