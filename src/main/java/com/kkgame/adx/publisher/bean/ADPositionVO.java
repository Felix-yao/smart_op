package com.kkgame.adx.publisher.bean;

import com.kkgame.adx.base.bean.PageVO;

public class ADPositionVO {
	
	private int id;
	private int appId;
	private int adType;
	private int width;
	private int height;
	private int size;
	private int amId;
	private int publisherId;
	private int agentId;
	private int status;
	private String name;
	private String appName;
	private String adTypeName;
	private String iab1;
	private String iab2;
	private String token;
	private double bidPrice;
	private String bidPriceString;
	private PageVO pageVO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getAdType() {
		return adType;
	}
	public void setAdType(int adType) {
		this.adType = adType;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIab1() {
		return iab1;
	}
	public void setIab1(String iab1) {
		this.iab1 = iab1;
	}
	public String getIab2() {
		return iab2;
	}
	public void setIab2(String iab2) {
		this.iab2 = iab2;
	}
	public PageVO getPageVO() {
		return pageVO;
	}
	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAdTypeName() {
		return adTypeName;
	}
	public void setAdTypeName(String adTypeName) {
		this.adTypeName = adTypeName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getAmId() {
		return amId;
	}
	public void setAmId(int amId) {
		this.amId = amId;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getBidPriceString() {
		return bidPriceString;
	}
	public void setBidPriceString(String bidPriceString) {
		this.bidPriceString = bidPriceString;
	}
	
	

}
