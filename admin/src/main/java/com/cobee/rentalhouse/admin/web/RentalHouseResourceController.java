package com.cobee.rentalhouse.admin.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cobee.rentalhouse.admin.web.support.AbstractController;
import com.cobee.rentalhouse.core.component.page.Page;
import com.cobee.rentalhouse.core.entity.RentalClient;
import com.cobee.rentalhouse.core.entity.RentalHouseResource;
import com.cobee.rentalhouse.core.entity.logical.RentalHouseResourceLogic;
import com.cobee.rentalhouse.core.service.RentalHouseResourceService;

@Controller
@RequestMapping("/RentalHouseResource")
public class RentalHouseResourceController extends AbstractController {

	@Autowired
	private RentalHouseResourceService rentalHouseResourceService;
	
	@GetMapping("/list")
	public String list()
	{
		return "rentalHouseResourceList";
	}
	
	@GetMapping(value = "/list/data", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> listData(RentalHouseResource rentalHouseResource)
	{
		Page<RentalHouseResource> page = rentalHouseResourceService.findByPage(rentalHouseResource);
		return RentalHouseResourceLogic.toDatagridData(page);
	}
	
	@PostMapping("/save")
	public String save(RentalHouseResource rentalHouseResource)
	{
		rentalHouseResourceService.save(rentalHouseResource);
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
	
	@PostMapping(value = "/checkin", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> checkin(RentalClient rentalClient) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			// 增加入住时间
			rentalClient.setCheckinDate(new Date());
			rentalHouseResourceService.checkin(rentalClient);
			resultMap.put("status", "success");
		} catch (Exception e) {
			logger.error("", e);
			resultMap.put("status", "fail");
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}
	
	@GetMapping("/form")
	public String form(Integer id, Model model)
	{
		if (id != null)
		{
			RentalHouseResource rentalHouseResource = rentalHouseResourceService.get(id);
			model.addAttribute("rentalHouseResource", rentalHouseResource);
		}
		return "rentalHouseResourceForm";
	}
	
	@GetMapping("/rentalHouseResourceClientCheckinForm")
	public String rentalHouseResourceClientCheckinForm()
	{
		return "rentalHouseResourceClientCheckinForm";
	}
	
}
