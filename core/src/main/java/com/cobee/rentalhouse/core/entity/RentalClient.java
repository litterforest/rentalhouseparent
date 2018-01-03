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

	private RentalHouseResource rentalHouseResource;

	public RentalHouseResource getRentalHouseResource() {
		return rentalHouseResource;
	}

	public void setRentalHouseResource(RentalHouseResource rentalHouseResource) {
		this.rentalHouseResource = rentalHouseResource;
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

}
