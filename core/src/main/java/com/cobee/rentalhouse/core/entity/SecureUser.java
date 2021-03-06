package com.cobee.rentalhouse.core.entity;

import java.util.Set;

import com.cobee.rentalhouse.core.entity.support.BaseEntity;

public class SecureUser extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6143353763610343789L;
	private String username;
	private String password;
	private String mobile;
	private String realname;
	private Integer isRememberMe;
	// 是否为管理员 0不是 1是
	private Integer isAdmin;
	// 0二手房东 1房东 2二手房东和房东
	private Integer userType;

	private SysVariables sysVariables;
	private Set<SecureRole> roleSet;
	private Set<SecureResources> resourcesSet;

	public SecureUser() {
		super();
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set<SecureResources> getResourcesSet() {
		return resourcesSet;
	}

	public void setResourcesSet(Set<SecureResources> resourcesSet) {
		this.resourcesSet = resourcesSet;
	}

	public Set<SecureRole> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<SecureRole> roleSet) {
		this.roleSet = roleSet;
	}

	public Integer getIsRememberMe() {
		return isRememberMe;
	}

	public void setIsRememberMe(Integer isRememberMe) {
		this.isRememberMe = isRememberMe;
	}

	public SysVariables getSysVariables() {
		return sysVariables;
	}

	public void setSysVariables(SysVariables sysVariables) {
		this.sysVariables = sysVariables;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
