package com.cobee.rentalhouse.webmobile.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cobee.rentalhouse.webmobile.web.support.AbstractController;


@Controller
public class HomeController extends AbstractController {
	
	@GetMapping("/home")
	public String index(Model model)
	{
		return "home";
	}
	
}
