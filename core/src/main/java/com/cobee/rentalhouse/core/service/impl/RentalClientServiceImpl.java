package com.cobee.rentalhouse.core.service.impl;

import java.util.List;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhouse.core.dao.impl.RentalClientMapper;
import com.cobee.rentalhouse.core.entity.RentalClient;
import com.cobee.rentalhouse.core.entity.RentalClientCheckinOrder;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.service.RentalClientCheckinOrderService;
import com.cobee.rentalhouse.core.service.RentalClientService;
import com.cobee.rentalhouse.core.service.RentalHouseResourceService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class RentalClientServiceImpl extends PagingAndSortingService<RentalClient, RentalClientMapper> implements RentalClientService {

	@Autowired
	private RentalHouseResourceService rentalHouseResourceService;
	@Autowired
	private RentalClientCheckinOrderService rentalClientCheckinOrderService;
	
	@Transactional(readOnly = false)
	@Override
	public void checkout(RentalClient rentalClient) {
		
		// 更新房客信息
		rentalClient.setStatus(1);
		updateBySelective(rentalClient);
		
		// 更新房源信息
		RentalHouseResource rentalHouseResource = new RentalHouseResource();
		rentalHouseResource.setId(rentalClient.getHouseId());
		rentalHouseResource.setStatus(0);
		rentalHouseResourceService.updateBySelective(rentalHouseResource);
		
		// 更新租客入住记录信息
		RentalClientCheckinOrder rentalClientCheckinOrder = new RentalClientCheckinOrder();
		rentalClientCheckinOrder.setHouseId(rentalClient.getHouseId());
		rentalClientCheckinOrder.setRentalClientId(rentalClient.getHouseId());
		rentalClientCheckinOrder.setStatus(0);
		List<RentalClientCheckinOrder> rentalClientCheckinOrderList = rentalClientCheckinOrderService.list(rentalClientCheckinOrder);
		if (!CollectionUtils.isEmpty(rentalClientCheckinOrderList))
		{
			RentalClientCheckinOrder dbRentalClientCheckinOrder = rentalClientCheckinOrderList.get(0);
			RentalClientCheckinOrder newRentalClientCheckinOrder = new RentalClientCheckinOrder();
			newRentalClientCheckinOrder.setId(dbRentalClientCheckinOrder.getId());
			newRentalClientCheckinOrder.setStatus(1);
			rentalClientCheckinOrderService.updateBySelective(newRentalClientCheckinOrder);
		}
	}

}
