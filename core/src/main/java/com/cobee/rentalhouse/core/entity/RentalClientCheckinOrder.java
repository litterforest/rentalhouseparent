package com.cobee.rentalhouse.core.entity;

import java.util.Date;

import com.cobee.rentalhouse.core.entity.support.BaseEntity;

public class RentalClientCheckinOrder extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8156435246471972848L;

	private Integer houseId;
	private Integer rentalClientId;
	private Double checkinPower;
	private Double checkinWatermeter;
	private Double rentalAmount;
	private Date checkinDate;
	private Date checkoutDate;
	private Double depositAmount;
	private Double checkoutPower;
	private Double checkoutWatermeter;
	private Integer status;

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getRentalClientId() {
		return rentalClientId;
	}

	public void setRentalClientId(Integer rentalClientId) {
		this.rentalClientId = rentalClientId;
	}

	public Double getCheckinPower() {
		return checkinPower;
	}

	public void setCheckinPower(Double checkinPower) {
		this.checkinPower = checkinPower;
	}

	public Double getCheckinWatermeter() {
		return checkinWatermeter;
	}

	public void setCheckinWatermeter(Double checkinWatermeter) {
		this.checkinWatermeter = checkinWatermeter;
	}

	public Double getRentalAmount() {
		return rentalAmount;
	}

	public void setRentalAmount(Double rentalAmount) {
		this.rentalAmount = rentalAmount;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Double getCheckoutPower() {
		return checkoutPower;
	}

	public void setCheckoutPower(Double checkoutPower) {
		this.checkoutPower = checkoutPower;
	}

	public Double getCheckoutWatermeter() {
		return checkoutWatermeter;
	}

	public void setCheckoutWatermeter(Double checkoutWatermeter) {
		this.checkoutWatermeter = checkoutWatermeter;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
