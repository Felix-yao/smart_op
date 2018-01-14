package com.kkgame.adx.data.bean;

import com.kkgame.adx.base.bean.PageVO;

/**
 * 查询VO
 * @author rayi
 *
 */
public class SearchVO {
	
	private String startDate;
	
	private String endDate;
						
	private int rowFieldLen;//显示多少列
	
	private String[] rowFields;
	
	private String rowFieldString;
	
	private int publisherId;
	
	private String publisherName;
	
	private int appId;
	
	private String appName;
	
	private int countryId;
	
	private String countryName;
	
	private PageVO pageVO;
	
	private String table;
	
	private int amId;
	
	private int adType;
	
	private int dspId;
	
	private String dspName;
	
	private int proxyId;
	
	private int adPositionId;
	
	private String adPositionName;
	
	private int appAdId;
	
	public int getAppAdId() {
		return appAdId;
	}

	public void setAppAdId(int appAdId) {
		this.appAdId = appAdId;
	}

	public int getAmId() {
		return amId;
	}

	public void setAmId(int amId) {
		this.amId = amId;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	private RowFieldVO rowFieldVO = new RowFieldVO();

	public RowFieldVO getRowFieldVO() {
		return rowFieldVO;
	}

	public void setRowFieldVO(RowFieldVO rowFieldVO) {
		this.rowFieldVO = rowFieldVO;
	}


	public int getRowFieldLen() {
		return rowFields.length;
	}

	public void setRowFieldLen(int rowFieldLen) {
		this.rowFieldLen = rowFields.length;
	}

	public String[] getRowFields() {
		return rowFields;
	}

	public void setRowFields(String[] rowFields) {
		this.rowFields = rowFields;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRowFieldString() {
		return rowFieldString;
	}

	public void setRowFieldString(String rowFieldString) {
		this.rowFieldString = rowFieldString;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public int getAdType() {
		return adType;
	}

	public void setAdType(int adType) {
		this.adType = adType;
	}

	public int getDspId() {
		return dspId;
	}

	public void setDspId(int dspId) {
		this.dspId = dspId;
	}

	public String getDspName() {
		return dspName;
	}

	public void setDspName(String dspName) {
		this.dspName = dspName;
	}

	public int getProxyId() {
		return proxyId;
	}

	public void setProxyId(int proxyId) {
		this.proxyId = proxyId;
	}

	public int getAdPositionId() {
		return adPositionId;
	}

	public void setAdPositionId(int adPositionId) {
		this.adPositionId = adPositionId;
	}

	public String getAdPositionName() {
		return adPositionName;
	}

	public void setAdPositionName(String adPositionName) {
		this.adPositionName = adPositionName;
	}

}
