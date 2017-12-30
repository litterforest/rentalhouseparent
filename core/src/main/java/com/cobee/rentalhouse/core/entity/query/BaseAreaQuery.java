package com.cobee.rentalhouse.core.entity.query;

import com.cobee.rentalhouse.core.entity.BaseArea;

public class BaseAreaQuery extends BaseArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2061631760755356574L;

	private Boolean isAreaSearched;
	private Integer provinceCityId;
	private Integer cityCityId;
	private Integer areaCityId;

	public Boolean getIsAreaSearched() {
		return isAreaSearched;
	}

	public void setIsAreaSearched(Boolean isAreaSearched) {
		this.isAreaSearched = isAreaSearched;
	}

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

}
