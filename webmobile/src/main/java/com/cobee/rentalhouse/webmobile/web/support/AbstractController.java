package com.cobee.rentalhouse.webmobile.web.support;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.shiro.SecurityUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.cobee.rentalhouse.core.component.redis.JedisBean;
import com.cobee.rentalhouse.core.entity.SecureUser;


public abstract class AbstractController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected JedisBean jedisBean;

	/**
	 * <pre>
	 * 获取已登录的用户对象
	 * </pre>
	 * 
	 * @author 陈淦森
	 * @version 1.0.1
	 * @date 2017年12月15日
	 *
	 * @return
	 */
	protected SecureUser getLoginUser() {
		return (SecureUser) SecurityUtils.getSubject().getPrincipal();
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});

		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			
			@Override
			public void setAsText(String text) {
				setValue(DateTime.parse(text).toDate());
			}
		});
	}

}
