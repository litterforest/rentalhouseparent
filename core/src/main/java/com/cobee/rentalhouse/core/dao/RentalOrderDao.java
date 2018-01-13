package com.cobee.rentalhouse.core.dao;

import java.util.List;

import com.cobee.rentalhouse.core.dao.support.BaseDao;
import com.cobee.rentalhouse.core.entity.RentalOrder;

public interface RentalOrderDao extends BaseDao<RentalOrder> {
	
	List<Integer> findRentalOrderYear(RentalOrder rentalOrder);
	
}
