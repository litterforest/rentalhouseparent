package com.cobee.rentalhouse.webmobile.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cobee.rentalhouse.core.entity.SecureUser;
import com.cobee.rentalhouse.core.service.SecureUserService;
import com.cobee.rentalhouse.webmobile.web.support.AbstractController;


@Controller
@RequestMapping("/SecureUser")
public class SecureUserController extends AbstractController {
	
	@Autowired
	private SecureUserService baseUserService;
	
	@RequestMapping("/form/{id}")
	public String form(@PathVariable Integer id, Model model)
	{
		SecureUser user = baseUserService.get(id);
		model.addAttribute("user", user);
		return "secureUserForm";
	}
	
	@RequestMapping("/userInfo/{id}")
	public String userInfo(@PathVariable Integer id, Model model)
	{
		SecureUser user = baseUserService.get(id);
		model.addAttribute("user", user);
		return "userInfo";
	}
	
	@RequestMapping("/save")
	public String form(SecureUser baseUser, String oldPassword, RedirectAttributes redirectAttributes)
	{
		
		try {
			
			// 1，检查原密码是否正确
			if (StringUtils.isNotBlank(oldPassword))
			{
				SecureUser dbSecureUser = baseUserService.get(baseUser.getId());
				ByteSource salt = ByteSource.Util.bytes(baseUser.getUsername());
				SimpleHash simpleHash = new SimpleHash("MD5", oldPassword, salt, 128);
				if (!StringUtils.equals(simpleHash.toString(), dbSecureUser.getPassword()))
				{
					redirectAttributes.addAttribute("errorMsg", "原密码错误");
					return "redirect:userInfo/" + baseUser.getId();
				}
			}
			
			baseUserService.save(baseUser);
			redirectAttributes.addAttribute("msg", "用户修改成功");
			
		} catch (Exception e) {
			logger.error("", e);
			redirectAttributes.addAttribute("errorMsg", e.getMessage());
		}
		
		return "redirect:/home";
	}
	
}
