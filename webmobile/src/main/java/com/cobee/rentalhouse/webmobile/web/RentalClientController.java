package com.cobee.rentalhouse.webmobile.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.cobee.rentalhouse.core.entity.logical.RentalClientLogic;
import com.cobee.rentalhouse.core.service.RentalClientService;
import com.cobee.rentalhouse.webmobile.web.support.AbstractController;

@Controller
@RequestMapping("/RentalClient")
public class RentalClientController extends AbstractController {

	@Autowired
	private RentalClientService rentalClientService;
	
	@GetMapping("/list")
	public String list(@ModelAttribute("rentalClientQuery") RentalClient rentalClientQuery, Model model)
	{
		PageRequest pageRequest = new PageRequest();
		pageRequest.setOrderByClause(" order by status desc ");
		rentalClientQuery.setPageRequest(pageRequest);
		List<RentalClient> rentalClientList = rentalClientService.list(rentalClientQuery);
		model.addAttribute("rentalClientList", rentalClientList);
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
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable Integer id, Model model)
	{
		RentalClient rentalClient = rentalClientService.get(id);
		model.addAttribute("rentalClient", rentalClient);
		return "rentalClientDetail";
	}
	
	/*@PostMapping(value = "/save", produces = { MediaType.APPLICATION_JSON_VALUE })
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
	}*/
	
	@PostMapping(value = "/save")
	public String save(RentalClient rentalClient)
	{
		rentalClientService.save(rentalClient);
		return "redirect:list";
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
