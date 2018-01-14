package com.kkgame.adx.login.bean;

import java.util.Date;

public class LoginUser {
	
	private int id;
	private String email;
	private String password;
	private String newPassword;
	private int roleId;
	private String roleType;
	private int status;
	private Date createTime;
	
	
	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", email=" + email + ", password=" + password + ", roleId=" + roleId
				+ ", roleType=" + roleType + ", status=" + status + ", createTime=" + createTime + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	

}
