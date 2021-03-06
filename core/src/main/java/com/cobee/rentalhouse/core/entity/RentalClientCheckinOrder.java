package com.cobee.rentalhouse.core.entity;

import java.util.Date;

import com.cobee.rentalhouse.core.entity.logical.RentalHouseResourceLogic;
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
	// 是否已生成第一张收费单,0--未生成 1--已生成
	private Integer isFistOrder;
	// 标准电费
	private Double standardElectAmount;
	// 标准水费
	private Double standardWaterAmount;
	// 租约开始时间
	private Date leaseStartTime;
	// 租约结束时间
	private Date leaseEndTime;

	private RentalHouseResourceLogic rentalHouseResource;
	
	private RentalClient rentalClient;
	
	public Date getLeaseStartTime() {
		return leaseStartTime;
	}

	public void setLeaseStartTime(Date leaseStartTime) {
		this.leaseStartTime = leaseStartTime;
	}

	public Date getLeaseEndTime() {
		return leaseEndTime;
	}

	public void setLeaseEndTime(Date leaseEndTime) {
		this.leaseEndTime = leaseEndTime;
	}

	public RentalClient getRentalClient() {
		return rentalClient;
	}

	public void setRentalClient(RentalClient rentalClient) {
		this.rentalClient = rentalClient;
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

	public RentalHouseResourceLogic getRentalHouseResource() {
		return rentalHouseResource;
	}

	public void setRentalHouseResource(RentalHouseResourceLogic rentalHouseResource) {
		this.rentalHouseResource = rentalHouseResource;
	}

	public Integer getIsFistOrder() {
		return isFistOrder;
	}

	public void setIsFistOrder(Integer isFistOrder) {
		this.isFistOrder = isFistOrder;
	}

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
