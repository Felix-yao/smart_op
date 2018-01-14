package com.kkgame.adx.tag.bean;

import java.util.List;

public class Country_CarrierVO {
	private int carrierId;
	
	private int countryId;
	
	private String countryName;
	
	private String carrierName;
	
//	private List<CarrierVO> carrierList;

	
//	
//	public List<CarrierVO> getCarrierList() {
//		return carrierList;
//	}
//
//	public void setCarrierList(List<CarrierVO> carrierList) {
//		this.carrierList = carrierList;
//	}


	public int getCountryId() {
		return countryId;
	}

	public int getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
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

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	
	
	

}
