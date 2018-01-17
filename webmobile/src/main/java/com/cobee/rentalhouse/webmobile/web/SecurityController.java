package com.cobee.rentalhouse.webmobile.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cobee.rentalhouse.core.entity.SecureUser;
import com.cobee.rentalhouse.core.service.SecureUserService;
import com.cobee.rentalhouse.core.util.NumericUtils;
import com.cobee.rentalhouse.webmobile.web.support.AbstractController;


@Controller
public class SecurityController extends AbstractController {
	
	@Autowired
	private SecureUserService baseUserService;
	@Autowired
	private com.cobee.rentalhouse.core.component.sms.SmsAware smsAware;
	
	private Random random = new Random();
	
	@GetMapping(value="/login")
	public String login()
	{
		return "login";
	}
	
	@PostMapping(value="/doLogin")
	public String doLogin(SecureUser baseUser, RedirectAttributes redirectAttributes)
	{
		Subject currentUser = SecurityUtils.getSubject();
		String responsePage = "redirect:/home";
		if (!currentUser.isAuthenticated()) {
			
            UsernamePasswordToken token = new UsernamePasswordToken(baseUser.getUsername(), baseUser.getPassword());
            if (NumericUtils.equal(baseUser.getIsRememberMe(), 1))
            {
            	token.setRememberMe(true);
            }
            try
            {
            	// 登录时，创建一个新的会话。安全加固
                if (currentUser.getSession() != null)
                {
                	currentUser.getSession().stop();
                }
                currentUser.login(token);
                
                
                
            }
            catch (IncorrectCredentialsException e)
            {
            	logger.error("", e);
            	responsePage = "redirect:/login";
            	redirectAttributes.addFlashAttribute("errorMsg", "用户名或密码错误");
            }
            catch (Exception e)
            {
            	logger.error("", e);
            	responsePage = "redirect:/login";
            	redirectAttributes.addFlashAttribute("errorMsg", e.getMessage());
            }
            
        }
		return responsePage;
	}
	
	@GetMapping(value="/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping(value="/doRegister")
	public String doRegister(HttpSession session, SecureUser baseUser, String verificationCode, RedirectAttributes redirectAttributes)
	{
		
		String resultPage = "redirect:/login";
		try
		{
			String sessionVerificationCode = (String) session.getAttribute("Register_VerificationCode");
			session.removeAttribute("Register_VerificationCode");
			if (!StringUtils.equals(verificationCode, sessionVerificationCode))
			{
				redirectAttributes.addFlashAttribute("errorMsg", "验证码不正确，请重新操作");
				return "redirect:/register";
			}
			baseUserService.register(baseUser);
			redirectAttributes.addFlashAttribute("msg", "注册成功，请登录使用");
		}
		catch(Exception e)
		{
			logger.error("", e);
			redirectAttributes.addFlashAttribute("errorMsg", e.getMessage());
			resultPage = "redirect:/register";
		}
		
		return resultPage;
	}
	
	@RequestMapping(value="/sendVerificationCode")
	@ResponseBody
	public Map<String, Object> sendVerificationCode(String mobile, HttpSession session)
	{
		Map<String, Object> resultMap = new HashMap<>();
		try {
			// 创建一个6位的随机数
			StringBuilder sbuff = new StringBuilder();
			for (int i = 0; i < 6; i++)
			{
				sbuff.append(random.nextInt(10));
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("code", sbuff.toString());
			// 发送短信消息
			boolean flag = smsAware.sendSms(mobile, "SMS_122290087", params);
			if (flag)
			{
				session.setAttribute("Register_VerificationCode", sbuff.toString());
				resultMap.put("status", "success");
			}
			else
			{
				resultMap.put("status", "fail");
				resultMap.put("msg", "网络繁忙，短信发送失败");
			}
		} catch (Exception e) {
			logger.error("", e);
			resultMap.put("status", "fail");
			resultMap.put("msg", e.getMessage());
		}
		return resultMap;
	}
	
}
