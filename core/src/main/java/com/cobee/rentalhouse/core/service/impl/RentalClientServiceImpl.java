package com.cobee.rentalhouse.core.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhouse.core.dao.impl.RentalClientMapper;
import com.cobee.rentalhouse.core.entity.RentalClient;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.service.RentalClientService;
import com.cobee.rentalhouse.core.service.RentalHouseResourceService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class RentalClientServiceImpl extends PagingAndSortingService<RentalClient, RentalClientMapper> implements RentalClientService {

	@Autowired
	private RentalHouseResourceService rentalHouseResourceService;
	
	@Transactional(readOnly = false)
	@Override
	public void checkout(RentalClient rentalClient) {
		
		rentalClient.setCheckoutDate(new Date());
		rentalClient.setStatus(1);
		
		updateBySelective(rentalClient);
		
		// 更新房源信息
		RentalHouseResource rentalHouseResource = new RentalHouseResource();
		rentalHouseResource.setId(rentalClient.getHouseId());
		rentalHouseResource.setStatus(0);
		rentalHouseResourceService.updateBySelective(rentalHouseResource);
		
	}

}
