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
	
	/**
	 * 获取页面上“出租”按钮的描述
	 * @return
	 */
	public String getLendBtnDesc()
	{
		if (super.getBuildStructureType() == null)
		{
			return "";
		}
		else if (NumericUtils.equal(getBuildStructureType(), 0))
		{
			return "整栋出租";
		}
		else if (NumericUtils.equal(getBuildStructureType(), 1))
		{
			return "出租";
		}
		return "";
	}

	/**
	 * 获取房源地址
	 * @return
	 */
	public String getHouseAddress()
	{
		StringBuilder sbuff = new StringBuilder(this.getBaseArea() == null ? "" : this.getBaseArea().getFullname());
		sbuff.append(this.getAddress());
		return sbuff.toString();
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
				voMap.put("rentalClientName", po.getRentalClient() == null ? "" : po.getRentalClient().getName());
				
				list.add(voMap);
			}
			
		}
		dataMap.put("rows", list);
		return dataMap;
	}

}
