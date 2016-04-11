/**  
 * @Title: DBInfoBean.java
 * @Package com.make.bean
 * @Description: TODO
 * @author zhengjf
 * @date 2016-4-11
 */
package com.make.bean;

/**
 * ClassName: DBInfoBean
 * 
 * @Description: 数据库实体Bean
 * @author zhengjf
 * @date 2016-4-11
 */
public class DBInfoBean {
	/** 数据库名 */
	private String dbName;

	/** 表名 */
	private String tableName;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
