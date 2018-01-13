package com.cobee.rentalhouse.core.service;

import java.util.List;

import com.cobee.rentalhouse.core.entity.RentalOrder;
import com.cobee.rentalhouse.core.service.support.BaseService;

public interface RentalOrderService extends BaseService<RentalOrder> {

	void createRentalOrder(RentalOrder rentalOrder);
	
	void audit(Integer id);

	boolean isCreatePermission(RentalOrder rentalOrder);
	
	List<Integer> findRentalOrderYear(RentalOrder rentalOrder);
	
}
