package com.cobee.rentalhouse.core.entity.logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;

import com.cobee.rentalhouse.core.component.page.Page;
import com.cobee.rentalhouse.core.entity.RentalClient;

public class RentalClientLogic extends RentalClient {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2909027860834578435L;
	
	
	
	
	@Override
	public String getStatusDesc() {
		
		if (getStatus() == null) {
			return "";
		} else if (getStatus() == 0) {
			return "已入住";
		} else if (getStatus() == 1) {
			return "已退房";
		} else {
			return "";
		}
		
	}




	public static Map<String, Object> toDatagridData(Page<RentalClient> page) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("total", page.getTotalCount());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!CollectionUtils.isEmpty(page.getContent())) {
			
			for (int i = 0; i < page.getContent().size(); i++)
			{
				
				RentalClientLogic po = (RentalClientLogic) page.getContent().get(i);
				Map<String, Object> voMap = new HashMap<>();
				voMap.put("id", po.getId());
				voMap.put("name", po.getName());
				voMap.put("mobile", po.getMobile());
				voMap.put("idCardNo", po.getIdCardNo());
//				voMap.put("checkinPower", po.getCheckinPower());
//				voMap.put("checkinWatermeter", po.getCheckinWatermeter());
//				voMap.put("rentalAmount", po.getRentalAmount());
//				voMap.put("checkinDate", po.getCheckinDate() == null ? "" : new DateTime(po.getCheckinDate()).toString("yyyy-MM-dd HH:mm:ss"));
//				voMap.put("checkoutDate", po.getCheckoutDate() == null ? "" : new DateTime(po.getCheckoutDate()).toString("yyyy-MM-dd HH:mm:ss"));
//				voMap.put("depositAmount", po.getDepositAmount());
				voMap.put("status", po.getStatus());
				voMap.put("statusDesc", po.getStatusDesc());
				voMap.put("houseId", po.getHouseId());
				voMap.put("rentalHouseResourceName", po.getRentalHouseResource() == null ? "" : po.getRentalHouseResource().getName());
				voMap.put("rentalHouseResourceAddress", (po.getRentalHouseResource() == null ? "" : po.getRentalHouseResource().getBaseArea() == null ? "" : po.getRentalHouseResource().getBaseArea().getFullname()) + (po.getRentalHouseResource() == null ? "" : po.getRentalHouseResource().getAddress()));
				voMap.put("currentRentalClientCheckinOrderId", po.getCurrentRentalClientCheckinOrder() == null ? "" : po.getCurrentRentalClientCheckinOrder().getId());
				list.add(voMap);
			}
			
		}
		dataMap.put("rows", list);
		return dataMap;
	}
	
}
