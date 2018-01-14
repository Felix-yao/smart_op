package com.kkgame.adx.publisher.bean;

import com.kkgame.adx.base.bean.PageVO;

public class AppVO {
	
	private int id;
	private int status;
	private int platform;
	private int publisherId;
	private int pricePercent;
	private int clickPercent;
	private int showPercent;
	private int dspOpType;
	private int amId;
	private int agentId;
	private String platformName;
	private String dsps;
	private String name;
	private String url;
	private String statusName;
	private String createTime;
	private String packageName;
	private String iab1;
	private String iab2;
	private String publisherName;
	private String storeUrl;
	private PageVO pageVO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public PageVO getPageVO() {
		return pageVO;
	}
	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPricePercent() {
		return pricePercent;
	}
	public void setPricePercent(int pricePercent) {
		this.pricePercent = pricePercent;
	}
	public int getClickPercent() {
		return clickPercent;
	}
	public void setClickPercent(int clickPercent) {
		this.clickPercent = clickPercent;
	}
	public int getShowPercent() {
		return showPercent;
	}
	public void setShowPercent(int showPercent) {
		this.showPercent = showPercent;
	}
	public int getDspOpType() {
		return dspOpType;
	}
	public void setDspOpType(int dspOpType) {
		this.dspOpType = dspOpType;
	}
	public String getDsps() {
		return dsps;
	}
	public void setDsps(String dsps) {
		this.dsps = dsps;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public int getPlatform() {
		return platform;
	}
	public void setPlatform(int platform) {
		this.platform = platform;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getStoreUrl() {
		return storeUrl;
	}
	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}
	public int getAmId() {
		return amId;
	}
	public void setAmId(int amId) {
		this.amId = amId;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

}
