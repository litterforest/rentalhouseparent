package com.cobee.rentalhouse.core.service;

import com.cobee.rentalhouse.core.entity.RentalClientCheckinOrder;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.service.support.BaseService;

public interface RentalHouseResourceService extends BaseService<RentalHouseResource> {
	
	void checkin(RentalClientCheckinOrder rentalClientCheckinOrder);
	
	void saveRoom(RentalHouseResource rentalHouseResource, Integer parentHouseID);
	
}
