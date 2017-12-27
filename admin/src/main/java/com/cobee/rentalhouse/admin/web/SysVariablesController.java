package com.cobee.rentalhouse.admin.web;

import java.util.List;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cobee.rentalhouse.admin.web.support.AbstractController;
import com.cobee.rentalhouse.core.entity.SecureUser;
import com.cobee.rentalhouse.core.entity.SysVariables;
import com.cobee.rentalhouse.core.service.SysVariablesService;


@Controller
@RequestMapping("/sysVariables")
public class SysVariablesController extends AbstractController {
	
	@Autowired
	private SysVariablesService sysVariablesService;
	
	@GetMapping(value = "/form")
	public String form(Model model)
	{
		SecureUser user = super.getLoginUser();
		SysVariables sysVariables = new SysVariables();
		sysVariables.setUserId(user.getId());
		List<SysVariables> sysVariablesList = sysVariablesService.list(sysVariables);
		if (!CollectionUtils.isEmpty(sysVariablesList))
		{
			model.addAttribute("sysVariables", sysVariablesList.get(0));
		}
		return "sysVariablesForm";
	}
	
	@PostMapping(value = "/save")
	public String save(SysVariables sysVariables)
	{
		sysVariablesService.save(sysVariables);
		return "redirect:/home";
	}
	
}
