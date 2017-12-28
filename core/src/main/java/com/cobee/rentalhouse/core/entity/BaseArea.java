package com.cobee.rentalhouse.core.entity;

import com.cobee.rentalhouse.core.entity.support.BaseEntity;

public class BaseArea extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4182910428422794494L;

	private Integer cityId;
	private Integer parentCityId;
	private String cityName;
	private String cityCode;
	private String fullname;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getParentCityId() {
		return parentCityId;
	}

	public void setParentCityId(Integer parentCityId) {
		this.parentCityId = parentCityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
