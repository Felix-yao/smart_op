package com.kkgame.adx.tag.bean;

import java.util.Date;

import com.kkgame.adx.base.bean.PageVO;


public class Employee {
	
	private int id;
	private String name;
	private String phone;
	private String skype;
	private String qq;
	private String jobTitle;
	private String email;
	private String password;
	private int roleId;
	private int roleTypeInt;
	private String roleType;
	private int status;
	private String statu;
	private String type;//用来区分是list修改还是personal得修改
	private Date createTime;
	private int proxyId;
	private PageVO pageVO;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", skype=" + skype + ", qq=" + qq
				+ ", jobTitle=" + jobTitle + ", email=" + email + ", password=" + password + ", roleId=" + roleId
				+ ", roleType=" + roleType + ", status=" + status + ", statu=" + statu + ", type=" + type
				+ ", createTime=" + createTime + "]";
	}

	public String getStatu() {
		return statu;
	}



	public void setStatu(String statu) {
		this.statu = statu;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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

	public int getRoleTypeInt() {
		return roleTypeInt;
	}

	public void setRoleTypeInt(int roleTypeInt) {
		this.roleTypeInt = roleTypeInt;
	}

	public int getProxyId() {
		return proxyId;
	}

	public void setProxyId(int proxyId) {
		this.proxyId = proxyId;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}
}
