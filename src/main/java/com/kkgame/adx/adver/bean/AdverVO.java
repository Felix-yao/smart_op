package com.kkgame.adx.adver.bean;

import java.util.Date;
import java.util.List;

import com.kkgame.adx.base.bean.PageVO;


public class AdverVO {
	
	private int id;
	private String name;
	private int countryId;
	private String country;
	private String phone;
	private String company;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String skype;
	private String qq;
	private String desc;
	private String email;
	private String password;
	private int roleId;
	private String roleType;
	private int status;
	private String statu;
	private Date createTime;
	private String type;
	private Double balance;
	private Double todayCost;
	private Double monthCost;
	private Double totalCost;
	private String balance1;
	private String todayCost1;
	private String monthCost1;
	private String totalCost1;
	private List<Object> daily_Date;
	private List<Object> daily_ClickCount;
	private List<Object> daily_Cost;
	private int isInner;
	private int amId;
	private String amName;
	private int adid;
	private PageVO pageVO;
	private int liststatus;
	private int isCpa;
	private int isAM;//用来判断是否是SP,AM,AMA用户
	private String token;

	@Override
	public String toString() {
		return "Advertiser [id=" + id + ", name=" + name + ", countryId=" + countryId + ", country=" + country
				+ ", phone=" + phone + ", company=" + company + ", street=" + street + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", skype=" + skype + ", qq=" + qq + ", desc=" + desc + ", email=" + email
				+ ", password=" + password + ", roleId=" + roleId + ", roleType=" + roleType + ", status=" + status
				+ ", statu=" + statu + ", createTime=" + createTime + ", type=" + type + ", balance=" + balance
				+ ", todayCost=" + todayCost + ", monthCost=" + monthCost + ", totalCost=" + totalCost + ", balance1="
				+ balance1 + ", todayCost1=" + todayCost1 + ", monthCost1=" + monthCost1 + ", totalCost1=" + totalCost1
				+ ", daily_Date=" + daily_Date + ", daily_ClickCount=" + daily_ClickCount + ", daily_Cost=" + daily_Cost
				+ ", isInner=" + isInner + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getSkype() {
		return skype;
	}
	public void setSkype(String skype) {
		this.skype = skype;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getTodayCost() {
		return todayCost;
	}

	public void setTodayCost(Double todayCost) {
		this.todayCost = todayCost;
	}

	public Double getMonthCost() {
		return monthCost;
	}

	public void setMonthCost(Double monthCost) {
		this.monthCost = monthCost;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public String getBalance1() {
		return balance1;
	}

	public void setBalance1(String balance1) {
		this.balance1 = balance1;
	}

	public String getTodayCost1() {
		return todayCost1;
	}

	public void setTodayCost1(String todayCost1) {
		this.todayCost1 = todayCost1;
	}

	public String getMonthCost1() {
		return monthCost1;
	}

	public void setMonthCost1(String monthCost1) {
		this.monthCost1 = monthCost1;
	}

	public String getTotalCost1() {
		return totalCost1;
	}

	public void setTotalCost1(String totalCost1) {
		this.totalCost1 = totalCost1;
	}

	public List<Object> getDaily_Date() {
		return daily_Date;
	}

	public void setDaily_Date(List<Object> daily_Date) {
		this.daily_Date = daily_Date;
	}

	public List<Object> getDaily_ClickCount() {
		return daily_ClickCount;
	}

	public void setDaily_ClickCount(List<Object> daily_ClickCount) {
		this.daily_ClickCount = daily_ClickCount;
	}

	public List<Object> getDaily_Cost() {
		return daily_Cost;
	}

	public void setDaily_Cost(List<Object> daily_Cost) {
		this.daily_Cost = daily_Cost;
	}

	public int getIsInner() {
		return isInner;
	}

	public void setIsInner(int isInner) {
		this.isInner = isInner;
	}

	public int getAmId() {
		return amId;
	}

	public void setAmId(int amId) {
		this.amId = amId;
	}

	public String getAmName() {
		return amName;
	}

	public void setAmName(String amName) {
		this.amName = amName;
	}

	public int getAdid() {
		return adid;
	}

	public void setAdid(int adid) {
		this.adid = adid;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public int getListstatus() {
		return liststatus;
	}

	public void setListstatus(int liststatus) {
		this.liststatus = liststatus;
	}

	public int getIsCpa() {
		return isCpa;
	}

	public void setIsCpa(int isCpa) {
		this.isCpa = isCpa;
	}

	public int getIsAM() {
		return isAM;
	}

	public void setIsAM(int isAM) {
		this.isAM = isAM;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
