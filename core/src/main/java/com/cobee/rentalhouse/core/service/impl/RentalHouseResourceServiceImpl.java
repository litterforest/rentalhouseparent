package com.cobee.rentalhouse.core.service.impl;

import org.springframework.stereotype.Service;

import com.cobee.rentalhouse.core.dao.impl.RentalHouseResourceMapper;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.service.RentalHouseResourceService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class RentalHouseResourceServiceImpl extends PagingAndSortingService<RentalHouseResource, RentalHouseResourceMapper>
		implements RentalHouseResourceService {

}
