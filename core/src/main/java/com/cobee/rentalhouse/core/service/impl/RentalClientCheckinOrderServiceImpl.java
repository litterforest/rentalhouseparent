package com.cobee.rentalhouse.core.service.impl;

import org.springframework.stereotype.Service;

import com.cobee.rentalhouse.core.dao.impl.RentalClientCheckinOrderMapper;
import com.cobee.rentalhouse.core.entity.RentalClientCheckinOrder;
import com.cobee.rentalhouse.core.service.RentalClientCheckinOrderService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class RentalClientCheckinOrderServiceImpl extends PagingAndSortingService<RentalClientCheckinOrder, RentalClientCheckinOrderMapper>
		implements RentalClientCheckinOrderService {
	
}
