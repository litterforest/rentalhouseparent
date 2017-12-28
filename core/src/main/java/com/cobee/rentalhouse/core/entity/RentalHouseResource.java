package com.cobee.rentalhouse.core.entity;

import com.cobee.rentalhouse.core.entity.support.BaseEntity;

public class RentalHouseResource extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2557319209754268134L;

	private Integer userId;
	private Integer cityId;
	private Integer houseType;
	private Double rentPrice;
	private Integer status;
	private String decorationSituation;
	private String name;
	private Integer parentId;
	private String houseCode;
	private Double standardElectAmount;
	private Double standardWaterAmount;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getHouseType() {
		return houseType;
	}

	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}

	public Double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDecorationSituation() {
		return decorationSituation;
	}

	public void setDecorationSituation(String decorationSituation) {
		this.decorationSituation = decorationSituation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public Double getStandardElectAmount() {
		return standardElectAmount;
	}

	public void setStandardElectAmount(Double standardElectAmount) {
		this.standardElectAmount = standardElectAmount;
	}

	public Double getStandardWaterAmount() {
		return standardWaterAmount;
	}

	public void setStandardWaterAmount(Double standardWaterAmount) {
		this.standardWaterAmount = standardWaterAmount;
	}

}
