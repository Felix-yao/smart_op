package com.kkgame.adx.base.bean;

import java.util.Date;

public class Charge {
	private int id; //test
	private int adverId;
	private Double fee;
	private Date createTime;
	private String description;

	
	@Override
	public String toString() {
		return "charge [id=" + id + ", adverId=" + adverId + ", fee=" + fee + ", createTime=" + createTime
				+ ", description=" + description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdverId() {
		return adverId;
	}
	public void setAdverId(int adverId) {
		this.adverId = adverId;
	}
	
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
