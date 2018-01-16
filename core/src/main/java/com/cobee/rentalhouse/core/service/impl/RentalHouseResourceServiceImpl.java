package com.cobee.rentalhouse.core.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhouse.core.dao.impl.RentalHouseResourceMapper;
import com.cobee.rentalhouse.core.entity.RentalClient;
import com.cobee.rentalhouse.core.entity.RentalClientCheckinOrder;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.service.RentalClientCheckinOrderService;
import com.cobee.rentalhouse.core.service.RentalClientService;
import com.cobee.rentalhouse.core.service.RentalHouseResourceService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class RentalHouseResourceServiceImpl extends PagingAndSortingService<RentalHouseResource, RentalHouseResourceMapper>
		implements RentalHouseResourceService {

	@Autowired
	private RentalClientService rentalClientService;
	@Autowired
	private RentalClientCheckinOrderService rentalClientCheckinOrderService;
	
	@Transactional(readOnly = false)
	@Override
	public void checkin(RentalClientCheckinOrder rentalClientCheckinOrder) {
		
		// 从房源信息获取租房费用
		RentalHouseResource dbRentalHouseResource = super.get(rentalClientCheckinOrder.getHouseId());
		rentalClientCheckinOrder.setCheckinDate(new Date());
		rentalClientCheckinOrder.setStatus(0);
		rentalClientCheckinOrder.setRentalAmount(dbRentalHouseResource.getRentPrice());
		rentalClientCheckinOrder.setStandardElectAmount(dbRentalHouseResource.getStandardElectAmount());
		rentalClientCheckinOrder.setStandardWaterAmount(dbRentalHouseResource.getStandardWaterAmount());
		rentalClientCheckinOrderService.save(rentalClientCheckinOrder);
		// 更新房客信息
		RentalClient rentalClient = new RentalClient();
		rentalClient.setStatus(0);
		rentalClient.setId(rentalClientCheckinOrder.getRentalClientId());
		rentalClient.setHouseId(rentalClientCheckinOrder.getHouseId());
		rentalClientService.updateBySelective(rentalClient);
		
		// 更新房源信息状态
		RentalHouseResource rentalHouseResource = new RentalHouseResource();
		rentalHouseResource.setId(rentalClientCheckinOrder.getHouseId());
		rentalHouseResource.setStatus(1);
		super.updateBySelective(rentalHouseResource);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void saveRoom(RentalHouseResource rentalHouseResource, Integer parentHouseID) {
		// 1,查找父类房源数据
		RentalHouseResource parentRentalHouseResource = get(parentHouseID);
		rentalHouseResource.setCityId(parentRentalHouseResource.getCityId());
		rentalHouseResource.setAddress(parentRentalHouseResource.getAddress());
		rentalHouseResource.setStandardElectAmount(parentRentalHouseResource.getStandardElectAmount());
		rentalHouseResource.setStandardWaterAmount(parentRentalHouseResource.getStandardWaterAmount());
		rentalHouseResource.setBuildStructureType(1);
		rentalHouseResource.setParentId(parentHouseID);
		rentalHouseResource.setFullName(parentRentalHouseResource.getName() + "-" + rentalHouseResource.getName());
		// 2，保存房间数据
		save(rentalHouseResource);
	}

}
