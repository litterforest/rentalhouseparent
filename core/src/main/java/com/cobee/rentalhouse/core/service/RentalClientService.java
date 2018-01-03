package com.cobee.rentalhouse.core.service;

import com.cobee.rentalhouse.core.entity.RentalClient;
import com.cobee.rentalhouse.core.service.support.BaseService;

public interface RentalClientService extends BaseService<RentalClient> {
	
	void checkout(RentalClient rentalClient);
	
}
