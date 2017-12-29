package com.cobee.rentalhouse.core.entity;

import java.util.Date;

import com.cobee.rentalhouse.core.entity.support.BaseEntity;

/**
 * <pre>
 * 房屋租客
 * </pre>
 * 
 * @author 陈淦森
 * @version 1.0.1
 * @date 2017年12月28日
 *
 */
public class RentalClient extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1458242623617219362L;

	// 名称
	private String name;
	// 手机号码
	private String mobile;
	// 身份证号码
	private String idCardNo;
	// 房源ID
	private Integer houseId;
	// 入住时电表度数
	private Double checkinPower;
	// 入住时水表数
	private Double checkinWatermeter;
	// 租用费
	private Double rentalAmount;
	// 入住时间
	private Date checkinDate;
	// 退房时间
	private Date checkoutDate;
	// 押金
	private Double depositAmount;

	public Double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
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

}
