package com.kkgame.adx.tag.bean;

import java.util.List;

public class CountryVO {

	private int id;
	
	private String name;
	
	private String code;
	
	private List<Country_CarrierVO> countryCarrierList;

	public List<Country_CarrierVO> getCountryCarrierList() {
		return countryCarrierList;
	}

	public void setCountryCarrierList(List<Country_CarrierVO> countryCarrierList) {
		this.countryCarrierList = countryCarrierList;
	}

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
