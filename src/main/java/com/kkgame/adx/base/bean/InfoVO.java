package com.kkgame.adx.base.bean;

/**
 * 
 * @author felix
 * 用来通知大数据更新相应的配置表信息
 *
 */
public class InfoVO {

	private String table;
	private Object where;
	
	public Object getWhere() {
		return where;
	}
	public void setWhere(Object where) {
		this.where = where;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
}
