package com.cobee.rentalhouse.admin.web;

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
import com.cobee.rentalhouse.core.entity.logical.RentalClientLogic;
import com.cobee.rentalhouse.core.service.RentalClientService;

@Controller
@RequestMapping("/RentalClient")
public class RentalClientController extends AbstractController {

	@Autowired
	private RentalClientService rentalClientService;
	
	@GetMapping("/list")
	public String list()
	{
		return "rentalClientList";
	}
	
	@GetMapping(value = "/list/data", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> listData(RentalClient rentalClient)
	{
		Page<RentalClient> page = rentalClientService.findByPage(rentalClient);
		return RentalClientLogic.toDatagridData(page);
	}
	
	@GetMapping("/form")
	public String form(Integer id, Model model)
	{
		if (id != null)
		{
			RentalClient rentalClient = rentalClientService.get(id);
			model.addAttribute("rentalClient", rentalClient);
		}
		return "rentalClientForm";
	}
	
	@PostMapping(value = "/save", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> save(RentalClient rentalClient)
	{
		Map<String, Object> resultMap = new HashMap<>();
		try {
			rentalClientService.save(rentalClient);
			resultMap.put("status", "success");
		} catch (Exception e) {
			logger.error("", e);
			resultMap.put("status", "fail");
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}
	
	@GetMapping(value = "/checkout", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Map<String, Object> checkout(RentalClient rentalClient) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			rentalClientService.checkout(rentalClient);
			resultMap.put("status", "success");
		} catch (Exception e) {
			logger.error("", e);
			resultMap.put("status", "fail");
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}
	
}
