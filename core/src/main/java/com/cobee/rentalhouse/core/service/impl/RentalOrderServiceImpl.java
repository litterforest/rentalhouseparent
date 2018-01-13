package com.cobee.rentalhouse.core.service.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhouse.core.component.page.PageRequest;
import com.cobee.rentalhouse.core.dao.impl.RentalOrderMapper;
import com.cobee.rentalhouse.core.entity.RentalClientCheckinOrder;
import com.cobee.rentalhouse.core.entity.RentalOrder;
import com.cobee.rentalhouse.core.entity.SecureUser;
import com.cobee.rentalhouse.core.entity.SysVariables;
import com.cobee.rentalhouse.core.service.RentalClientCheckinOrderService;
import com.cobee.rentalhouse.core.service.RentalOrderService;
import com.cobee.rentalhouse.core.service.SysVariablesService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;


@Service
public class RentalOrderServiceImpl extends PagingAndSortingService<RentalOrder, RentalOrderMapper> implements RentalOrderService {
	
	@Autowired
	private SysVariablesService sysVariablesService;
	@Autowired
	private RentalClientCheckinOrderService rentalClientCheckinOrderService;

	@Override
	@Transactional(readOnly = false)
	public void createRentalOrder(RentalOrder rentalOrder) {
		
		// 1,查找是否是否已生成第一张收费单
		RentalClientCheckinOrder rentalClientCheckinOrderQuery = new RentalClientCheckinOrder();
		rentalClientCheckinOrderQuery.setIsFistOrder(0);
		rentalClientCheckinOrderQuery.setStatus(0);
		rentalClientCheckinOrderQuery.setId(rentalOrder.getRentalClientCheckinOrderId());
		List<RentalClientCheckinOrder> rentalClientCheckinOrderList = rentalClientCheckinOrderService.list(rentalClientCheckinOrderQuery);
		if (!CollectionUtils.isEmpty(rentalClientCheckinOrderList))
		{
			RentalClientCheckinOrder dbRentalClientCheckinOrder = rentalClientCheckinOrderList.get(0);
			// 入住时电表度数
			Double checkinPower = dbRentalClientCheckinOrder.getCheckinPower() == null ? 0.0D : dbRentalClientCheckinOrder.getCheckinPower();
			// 入住时水表数
			Double checkinWatermeter = dbRentalClientCheckinOrder.getCheckinWatermeter();
			// 租用费
			Double rentalAmount = dbRentalClientCheckinOrder.getRentalAmount();
			// 标准电费
			Double standardElectAmount = dbRentalClientCheckinOrder.getStandardElectAmount();
			// 标准水费
			Double standardWaterAmount = dbRentalClientCheckinOrder.getStandardWaterAmount();
			
			// 电表度数
			Double powerConsumption = rentalOrder.getPowerConsumption() == null ? 0.0D : rentalOrder.getPowerConsumption();
			// 用电度数
			Double diffPowerConsumption = powerConsumption - checkinPower;
			// 电费
			Double electricityAmount = diffPowerConsumption * standardElectAmount;
			// 水表度数
			Double waterConsumption = rentalOrder.getWaterConsumption() == null ? 0.0D : rentalOrder.getWaterConsumption();
			// 用水度数
			Double diffWaterConsumption = waterConsumption - checkinWatermeter;
			// 水费
			Double waterAmount = diffWaterConsumption * standardWaterAmount;
			// 扣减费用
			Double deductionAmount = rentalOrder.getDeductionAmount() == null ? 0.0D : rentalOrder.getDeductionAmount();
			// 总费用
			Double totalAmount = electricityAmount + waterAmount + rentalAmount - deductionAmount;
			rentalOrder.setLastPowerConsumption(checkinPower);
			rentalOrder.setLastWaterConsumption(checkinWatermeter);
			rentalOrder.setTotalAmount(totalAmount);
			rentalOrder.setElectricityAmount(electricityAmount);
			rentalOrder.setDiffPowerConsumption(diffPowerConsumption);
			rentalOrder.setDiffWaterConsumption(diffWaterConsumption);
			rentalOrder.setWaterAmount(waterAmount);
			rentalOrder.setStatus(100);
			save(rentalOrder);
			
			// 更新首次收租费用标志
			RentalClientCheckinOrder newRentalClientCheckinOrder = new RentalClientCheckinOrder();
			newRentalClientCheckinOrder.setId(dbRentalClientCheckinOrder.getId());
			newRentalClientCheckinOrder.setIsFistOrder(1);
			rentalClientCheckinOrderService.updateBySelective(newRentalClientCheckinOrder);
		}
		else
		{
			// 2,查找是否已存在最新的收费单
			RentalOrder rentalOrderQuery = new RentalOrder();
			rentalOrderQuery.setRentalClientCheckinOrderId(rentalOrder.getRentalClientCheckinOrderId());
			PageRequest pageRequest = new PageRequest();
			pageRequest.setOrderByClause(" order by a.id desc ");
			rentalOrderQuery.setPageRequest(pageRequest);
			List<RentalOrder> rentalOrderList = super.list(rentalOrderQuery);
			if (!CollectionUtils.isEmpty(rentalOrderList))
			{
				RentalOrder dbRentalOrder = rentalOrderList.get(0);
				// 电表度数
				Double lastPowerConsumption = dbRentalOrder.getPowerConsumption() == null ? 0.0D : dbRentalOrder.getPowerConsumption();
				// 水表度数
				Double lastWaterConsumption = dbRentalOrder.getWaterConsumption() == null ? 0.0D : dbRentalOrder.getWaterConsumption();
				// 租用费
				Double rentalAmount = dbRentalOrder.getRentalClientCheckinOrder().getRentalAmount();
				// 标准电费
				Double standardElectAmount = dbRentalOrder.getRentalClientCheckinOrder().getStandardElectAmount();
				// 标准水费
				Double standardWaterAmount = dbRentalOrder.getRentalClientCheckinOrder().getStandardWaterAmount();
				
				
				// 电表度数
				Double powerConsumption = rentalOrder.getPowerConsumption() == null ? 0.0D : rentalOrder.getPowerConsumption();
				// 用电度数
				Double diffPowerConsumption = powerConsumption - lastPowerConsumption;
				// 电费
				Double electricityAmount = diffPowerConsumption * standardElectAmount;
				// 水表度数
				Double waterConsumption = rentalOrder.getWaterConsumption() == null ? 0.0D : rentalOrder.getWaterConsumption();
				// 用水度数
				Double diffWaterConsumption = waterConsumption - lastWaterConsumption;
				// 水费
				Double waterAmount = diffWaterConsumption * standardWaterAmount;
				// 扣减费用
				Double deductionAmount = rentalOrder.getDeductionAmount() == null ? 0.0D : rentalOrder.getDeductionAmount();
				// 总费用
				Double totalAmount = electricityAmount + waterAmount + rentalAmount - deductionAmount;
				rentalOrder.setLastPowerConsumption(lastPowerConsumption);
				rentalOrder.setLastWaterConsumption(lastWaterConsumption);
				rentalOrder.setTotalAmount(totalAmount);
				rentalOrder.setElectricityAmount(electricityAmount);
				rentalOrder.setDiffPowerConsumption(diffPowerConsumption);
				rentalOrder.setDiffWaterConsumption(diffWaterConsumption);
				rentalOrder.setWaterAmount(waterAmount);
				rentalOrder.setStatus(100);
				save(rentalOrder);
			}
		}
		
	}

	@Override
	@Transactional(readOnly = false)
	public void audit(Integer id) {
		
		RentalOrder rentalOrder = new RentalOrder();
		rentalOrder.setId(id);
		rentalOrder.setStatus(100);
		this.updateBySelective(rentalOrder);
		
		RentalOrder dbRentalOrder = super.get(id);
		Double powerConsumption = dbRentalOrder.getPowerConsumption();
		
		SysVariables sysVariables = new SysVariables();
		sysVariables.setUserId(dbRentalOrder.getUserId());
		List<SysVariables> sysVariablesList = sysVariablesService.list(sysVariables);
		if (!CollectionUtils.isEmpty(sysVariablesList))
		{
			SysVariables newSysVariables = new SysVariables();
			newSysVariables.setId(sysVariablesList.get(0).getId());
//			if (dbRentalOrder.getRentalType() == 0)
//			{
//				newSysVariables.setCurrentRentingPowerConsumption(powerConsumption);
//			}
//			else if (dbRentalOrder.getRentalType() == 1)
//			{
//				newSysVariables.setCurrentBerthPowerConsumption(powerConsumption);
//			}
			sysVariablesService.updateBySelective(newSysVariables);
		}
		
	}

	@Override
	public boolean isCreatePermission(RentalOrder rentalOrder) {
		rentalOrder.setStatus(0);
		Integer count = super.queryByCount(rentalOrder);
		return count > 0 ? true : false;
	}

	@Override
	public List<Integer> findRentalOrderYear(RentalOrder rentalOrder) {
		return dao.findRentalOrderYear(rentalOrder);
	}
	
}
