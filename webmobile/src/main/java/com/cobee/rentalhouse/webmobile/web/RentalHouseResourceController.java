package com.cobee.rentalhouse.webmobile.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cobee.rentalhouse.core.component.page.Page;
import com.cobee.rentalhouse.core.component.page.PageRequest;
import com.cobee.rentalhouse.core.entity.RentalClient;
import com.cobee.rentalhouse.core.entity.RentalClientCheckinOrder;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.entity.logical.RentalHouseResourceLogic;
import com.cobee.rentalhouse.core.service.RentalClientService;
import com.cobee.rentalhouse.core.service.RentalHouseResourceService;
import com.cobee.rentalhouse.core.util.NumericUtils;
import com.cobee.rentalhouse.webmobile.web.support.AbstractController;

@Controller
@RequestMapping("/RentalHouseResource")
public class RentalHouseResourceController extends AbstractController {

	@Autowired
	private RentalHouseResourceService rentalHouseResourceService;
	@Autowired
	private RentalClientService rentalClientService;
	
	@GetMapping("/list")
	public String list(@ModelAttribute("rentalHouseResourceQuery") RentalHouseResource rentalHouseResourceQuery, Model model)
	{
		PageRequest pageRequest = new PageRequest();
		pageRequest.setOrderByClause(" order by a.status, a.full_name ");
		rentalHouseResourceQuery.setPageRequest(pageRequest);
		List<RentalHouseResource> rentalHouseResourceList = rentalHouseResourceService.list(rentalHouseResourceQuery);
		model.addAttribute("rentalHouseResourceList", rentalHouseResourceList);
		return "rentalHouseResourceList";
	}
	
	@GetMapping(value = "/list/data", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> listData(RentalHouseResource rentalHouseResource)
	{
		Page<RentalHouseResource> page = rentalHouseResourceService.findByPage(rentalHouseResource);
		return RentalHouseResourceLogic.toDatagridData(page);
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable Integer id, Model model)
	{
		RentalHouseResource rentalHouseResource = rentalHouseResourceService.get(id);
		// 设置是否可以整栋出租的标志
		RentalHouseResourceLogic rentalHouseResourceLogic = (RentalHouseResourceLogic) rentalHouseResource;
		
		// 整栋房类型
		if (NumericUtils.equal(rentalHouseResourceLogic.getBuildStructureType(), 0))
		{
			// 查询是否有房间已经出租了
			RentalHouseResource rentalHouseResourceQuery = new RentalHouseResource();
			rentalHouseResourceQuery.setParentId(rentalHouseResourceLogic.getId());
			rentalHouseResourceQuery.setStatus(1);
			Integer count = rentalHouseResourceService.queryByCount(rentalHouseResourceQuery);
			if (count == null || count == 0)
			{
				rentalHouseResourceLogic.setWholeRentalFlag(1);
			}
		}
		
		model.addAttribute("rentalHouseResource", rentalHouseResourceLogic);
		return "rentalHouseResourceDetail";
	}
	
	@PostMapping("/save")
	public String save(RentalHouseResource rentalHouseResource, String operator, Integer parentHouseID)
	{
		if (StringUtils.equals(operator, "addroom"))
		{
			rentalHouseResourceService.saveRoom(rentalHouseResource, parentHouseID);
		}
		else
		{
			rentalHouseResource.setCityId(rentalHouseResource.getBaseArea().getTrueCityId());
			rentalHouseResource.setFullName(rentalHouseResource.getName());
			rentalHouseResourceService.save(rentalHouseResource);
		}
		
		return "redirect:list";
	}
	
	@PostMapping(value = "/saveByAjax", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> saveByAjax(RentalHouseResource rentalHouseResource)
	{
		Map<String, Object> resultMap = new HashMap<>();
		try {
			rentalHouseResourceService.save(rentalHouseResource);
			resultMap.put("status", "success");
		} catch (Exception e) {
			logger.error("", e);
			resultMap.put("status", "fail");
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}
	
	@PostMapping(value = "/checkin")
	public String checkin(RentalClientCheckinOrder rentalClientCheckinOrder) {
		rentalHouseResourceService.checkin(rentalClientCheckinOrder);
		return "redirect:list";
	}
	
	@GetMapping("/form")
	public String form(Integer id, String operator, Integer parentHouseID, Model model)
	{
		
		// 添加房间时，要展示的添加表单
		if (StringUtils.equals(operator, "addroom"))
		{
			// 1,查找父类房子的数据
			//RentalHouseResource parentRentalHouseResource = rentalHouseResourceService.get(parentHouseID);
			model.addAttribute("operator", operator);
			model.addAttribute("parentHouseID", parentHouseID);
		}
		// 展示房源数据修改表单
		else if (id != null)
		{
			RentalHouseResource rentalHouseResource = rentalHouseResourceService.get(id);
			model.addAttribute("rentalHouseResource", rentalHouseResource);
		}
		
		return "rentalHouseResourceForm";
	}
	
	@GetMapping("/rentalHouseResourceClientCheckinForm")
	public String rentalHouseResourceClientCheckinForm(Model model)
	{
		// 加载未入住房客
		RentalClient rentalClient = new RentalClient();
		rentalClient.setStatus(1);
		List<RentalClient> rentalClientList = rentalClientService.list(rentalClient);
		model.addAttribute("rentalClientList", rentalClientList);
		return "rentalHouseResourceClientCheckinForm";
	}
	
}
