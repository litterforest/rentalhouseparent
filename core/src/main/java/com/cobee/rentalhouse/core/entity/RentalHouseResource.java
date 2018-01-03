package com.cobee.rentalhouse.core.entity;

import com.cobee.rentalhouse.core.entity.support.BaseEntity;

public class RentalHouseResource extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2557319209754268134L;

	private Integer userId;
	private Integer cityId;
	// 详细地址
	private String address;
	// 房型信息
	private Integer houseType;
	// 出租价格
	private Double rentPrice;
	// 出租状态
	private Integer status;
	// 装修情况
	private String decorationSituation;
	// 房屋名称
	private String name;
	// 父ID
	private Integer parentId;
	// 房屋编号
	private String houseCode;
	// 标准电费
	private Double standardElectAmount;
	// 标准水费
	private Double standardWaterAmount;

	// 所属地区关联对象
	private BaseArea baseArea;

	private RentalClient rentalClient;

	public RentalClient getRentalClient() {
		return rentalClient;
	}

	public void setRentalClient(RentalClient rentalClient) {
		this.rentalClient = rentalClient;
	}

	public BaseArea getBaseArea() {
		return baseArea;
	}

	public void setBaseArea(BaseArea baseArea) {
		this.baseArea = baseArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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
