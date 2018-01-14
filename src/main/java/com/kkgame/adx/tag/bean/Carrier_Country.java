package com.kkgame.adx.tag.bean;

public class Carrier_Country {
	
	private String carrierIds;
	private String countryId;
	private String carrierName;
	private String countryName;
	

	

	@Override
	public String toString() {
		return "Carrier_Country [carrierIds=" + carrierIds + ", countryId=" + countryId + ", carrierName=" + carrierName
				+ ", countryName=" + countryName + "]";
	}
	public String getCarrierIds() {
		return carrierIds;
	}
	public void setCarrierIds(String carrierIds) {
		this.carrierIds = carrierIds;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	

}
