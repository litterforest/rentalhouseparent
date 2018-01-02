package com.cobee.rentalhouse.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhouse.core.dao.impl.RentalHouseResourceMapper;
import com.cobee.rentalhouse.core.entity.RentalClient;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.service.RentalClientService;
import com.cobee.rentalhouse.core.service.RentalHouseResourceService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class RentalHouseResourceServiceImpl extends PagingAndSortingService<RentalHouseResource, RentalHouseResourceMapper>
		implements RentalHouseResourceService {

	@Autowired
	private RentalClientService rentalClientService;
	
	@Transactional(readOnly = false)
	@Override
	public void checkin(RentalClient rentalClient) {
		
		rentalClientService.save(rentalClient);
		
		RentalHouseResource rentalHouseResource = new RentalHouseResource();
		rentalHouseResource.setId(rentalClient.getHouseId());
		rentalHouseResource.setStatus(1);
		super.updateBySelective(rentalHouseResource);
		
	}

}
