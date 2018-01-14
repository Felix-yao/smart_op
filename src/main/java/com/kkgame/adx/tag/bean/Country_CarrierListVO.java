package com.kkgame.adx.tag.bean;

import java.util.List;

public class Country_CarrierListVO {
	
	private int countryId;
	
	private String countryName;
	
	private List<Country_CarrierVO> carrierList;

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

	public List<Country_CarrierVO> getCarrierList() {
		return carrierList;
	}

	public void setCarrierList(List<Country_CarrierVO> carrierList) {
		this.carrierList = carrierList;
	}


	
}
