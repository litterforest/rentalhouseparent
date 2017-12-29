package com.cobee.rentalhouse.admin.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cobee.rentalhouse.admin.web.support.AbstractController;
import com.cobee.rentalhouse.core.component.page.Page;
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
		return RentalHouseResourceLogic.toJqGridData(page);
	}
	
	@PostMapping("/save")
	public String save(RentalHouseResource rentalHouseResource)
	{
		rentalHouseResourceService.save(rentalHouseResource);
		return "redirect:list";
	}
	
	@GetMapping("/form")
	public String form()
	{
		return "rentalHouseResourceForm";
	}
	
}
