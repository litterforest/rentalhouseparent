package com.cobee.rentalhouse.core.component.sms;

import java.util.Map;

public interface SmsAware {
	
	boolean sendSms(String mobile, String msg, Map<String, Object> params);
	
}
