package com.cobee.rentalhouse.core.entity;

import com.cobee.rentalhouse.core.entity.support.BaseEntity;

public class RentalOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3827501685095969463L;

	private Integer year;
	private Integer month;
	// 电费
	private Double electricityAmount;
	// 用电度数
	private Double powerConsumption;
	// 总费用
	private Double totalAmount;
	// 扣减费用
	private Double deductionAmount;
	// 电费使用度数
	private Double diffPowerConsumption;
	// 用户外键ID
	private Integer userId;
	// 房客ID
	private Integer rentalClientId;
	// 水表度数
	private Double waterConsumption;
	// 用水度数
	private Double diffWaterConsumption;
	// 水费
	private Double waterAmount;

	private SecureUser secureUser;

	public RentalOrder() {
		super();
	}

	public Integer getRentalClientId() {
		return rentalClientId;
	}

	public void setRentalClientId(Integer rentalClientId) {
		this.rentalClientId = rentalClientId;
	}

	public Double getWaterConsumption() {
		return waterConsumption;
	}

	public void setWaterConsumption(Double waterConsumption) {
		this.waterConsumption = waterConsumption;
	}

	public Double getDiffWaterConsumption() {
		return diffWaterConsumption;
	}

	public void setDiffWaterConsumption(Double diffWaterConsumption) {
		this.diffWaterConsumption = diffWaterConsumption;
	}

	public Double getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(Double waterAmount) {
		this.waterAmount = waterAmount;
	}

	public SecureUser getSecureUser() {
		return secureUser;
	}

	public void setSecureUser(SecureUser secureUser) {
		this.secureUser = secureUser;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getDiffPowerConsumption() {
		return diffPowerConsumption;
	}

	public void setDiffPowerConsumption(Double diffPowerConsumption) {
		this.diffPowerConsumption = diffPowerConsumption;
	}

	public Double getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(Double deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Double getElectricityAmount() {
		return electricityAmount;
	}

	public void setElectricityAmount(Double electricityAmount) {
		this.electricityAmount = electricityAmount;
	}

	public Double getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(Double powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
