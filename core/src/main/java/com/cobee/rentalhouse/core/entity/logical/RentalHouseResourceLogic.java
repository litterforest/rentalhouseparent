package com.cobee.rentalhouse.core.entity.logical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;

import com.cobee.rentalhouse.core.component.page.Page;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.util.DictUtils;
import com.cobee.rentalhouse.core.util.NumericUtils;

public class RentalHouseResourceLogic extends RentalHouseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6748005233756308822L;
	
	
	
	@Override
	public String getStatusDesc() {
		if (getStatus() == null)
		{
			return "";
		}
		
		if (NumericUtils.equal(getStatus(), 0))
		{
			return "待出租";
		}
		else if (NumericUtils.equal(getStatus(), 1))
		{
			return "已出租";
		}
		
		return "";
	}

	
	public String getHouseTypeDesc() {
		
		if (super.getHouseType() == null)
		{
			return "";
		}
		else
		{
			return DictUtils.getDictLabel(super.getHouseType().toString(), "rental_house_resource_house_type", "");
		}
		
	}




	public static Map<String, Object> toJqGridData(Page<RentalHouseResource> page) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("page", page.getPageNo());
		dataMap.put("total", page.getTotalPage());
		dataMap.put("records", page.getTotalCount());
		
		List<Map<String, Object>> list = new ArrayList<>();
		if (!CollectionUtils.isEmpty(page.getContent())) {
			
			for (int i = 0; i < page.getContent().size(); i++)
			{
				
				RentalHouseResourceLogic po = (RentalHouseResourceLogic) page.getContent().get(i);
				Map<String, Object> voMap = new HashMap<>();
				voMap.put("id", po.getId());
				voMap.put("name", po.getName());
				voMap.put("rentPrice", po.getRentPrice());
				voMap.put("decorationSituation", po.getDecorationSituation());
				voMap.put("standardElectAmount", po.getStandardElectAmount());
				voMap.put("standardWaterAmount", po.getStandardWaterAmount());
				voMap.put("houseCode", po.getHouseCode());
				voMap.put("statusDesc", po.getStatusDesc());
				voMap.put("houseTypeDesc", po.getHouseTypeDesc());
				voMap.put("createDate", po.getCreateDate() == null ? "" : new DateTime(po.getCreateDate()).toString("yyyy-MM-dd HH:mm:ss"));
				voMap.put("areaAddress", (po.getBaseArea() == null ? "" : po.getBaseArea().getFullname()) + po.getAddress());
				
				list.add(voMap);
			}
		
		}
		dataMap.put("rows", list);
		return dataMap;
	}
	
	public static Map<String, Object> toDatagridData(Page<RentalHouseResource> page) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("total", page.getTotalCount());
		List<Map<String, Object>> list = new ArrayList<>();
		if (!CollectionUtils.isEmpty(page.getContent())) {
			
			for (int i = 0; i < page.getContent().size(); i++)
			{
				
				RentalHouseResourceLogic po = (RentalHouseResourceLogic) page.getContent().get(i);
				Map<String, Object> voMap = new HashMap<>();
				voMap.put("id", po.getId());
				voMap.put("name", po.getName());
				voMap.put("status", po.getStatus() == null ? 0 : po.getStatus());
				voMap.put("rentPrice", po.getRentPrice());
				voMap.put("decorationSituation", po.getDecorationSituation());
				voMap.put("standardElectAmount", po.getStandardElectAmount());
				voMap.put("standardWaterAmount", po.getStandardWaterAmount());
				voMap.put("houseCode", po.getHouseCode());
				voMap.put("statusDesc", po.getStatusDesc());
				voMap.put("houseTypeDesc", po.getHouseTypeDesc());
				voMap.put("createDate", po.getCreateDate() == null ? "" : new DateTime(po.getCreateDate()).toString("yyyy-MM-dd HH:mm:ss"));
				voMap.put("areaAddress", (po.getBaseArea() == null ? "" : po.getBaseArea().getFullname()) + po.getAddress());
				
				list.add(voMap);
			}
			
		}
		dataMap.put("rows", list);
		return dataMap;
	}

}
