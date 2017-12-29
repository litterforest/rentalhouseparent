package com.cobee.rentalhouse.core.service.impl;

import org.springframework.stereotype.Service;

import com.cobee.rentalhouse.core.dao.impl.RentalClientMapper;
import com.cobee.rentalhouse.core.entity.RentalClient;
import com.cobee.rentalhouse.core.service.RentalClientService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class RentalClientServiceImpl extends PagingAndSortingService<RentalClient, RentalClientMapper> implements RentalClientService {

}
