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

	private Integer provinceCityId;
	private Integer cityCityId;
	private Integer areaCityId;

	public Integer getProvinceCityId() {
		return provinceCityId;
	}

	public void setProvinceCityId(Integer provinceCityId) {
		this.provinceCityId = provinceCityId;
	}

	public Integer getCityCityId() {
		return cityCityId;
	}

	public void setCityCityId(Integer cityCityId) {
		this.cityCityId = cityCityId;
	}

	public Integer getAreaCityId() {
		return areaCityId;
	}

	public void setAreaCityId(Integer areaCityId) {
		this.areaCityId = areaCityId;
	}

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

	public Integer getTrueCityId()
	{
		if (areaCityId != null)
		{
			return areaCityId;
		}
		else if (this.cityCityId != null)
		{
			return cityCityId;
		}
		else if (this.provinceCityId != null)
		{
			return provinceCityId;
		}
		return null;
	}
	
}
