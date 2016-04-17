/**  
 * @Title: ConsumerInfoBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-17
 */
package com.make.bean;

/**
 * ClassName: ConsumerInfoBean
 * 
 * @Description: 客户信息实体类
 * @author zhengjf
 * @date 2016-4-17
 */
public class ConsumerInfoBean {
	/** 主键ID */
	private int id;
	/** 客户名称 */
	private String consumerName;
	/** 联系人 */
	private String linkman;
	/** 联系电话 */
	private String telephone;
	/** 联系地址 */
	private String address;
	/** 创建时间 */
	private String creatDate;
	/** 创建人 */
	private String owner;
	/** 备注信息 */
	private String comments;
	/** 状态 */
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
