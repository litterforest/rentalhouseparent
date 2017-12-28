package com.cobee.rentalhouse.core.service.impl;

import org.springframework.stereotype.Service;

import com.cobee.rentalhouse.core.dao.RentalHouseResourceDao;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.service.RentalHouseResourceService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class RentalHouseResourceServiceImpl extends PagingAndSortingService<RentalHouseResource, RentalHouseResourceDao>
		implements RentalHouseResourceService {

}
