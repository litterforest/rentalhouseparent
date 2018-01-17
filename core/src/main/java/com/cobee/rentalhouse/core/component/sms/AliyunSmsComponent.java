package com.cobee.rentalhouse.core.component.sms;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 阿里云，短信发送组件类
 * 
 * @author Administrator
 *
 */
@Service
public class AliyunSmsComponent implements SmsAware {

	private static final Logger logger = LoggerFactory.getLogger(AliyunSmsComponent.class);
	
	// 初始化ascClient需要的几个参数
	private static final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
	private static final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
	
	// 替换成你的AK
	private static final String accessKeyId = "LTAIjh3cVRBzwmPV"; // 你的accessKeyId,参考本文档步骤2
	private static final String accessKeySecret = "1Q3cN2DaB0hhg9JRgHiaBVogKK0Oa7";// 你的accessKeySecret，参考本文档步骤2
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public AliyunSmsComponent()
	{
		// 设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
	}

	/**
	 * 
	 * @param mobile
	 *            手机号码
	 * @param msg 短信模板号
	 * @param params 短信内容中使用到的参数，可为空
	 * @return
	 */
	public boolean sendSms(String mobile, String msg, Map<String, Object> params) {
		// 初始化ascClient,暂时不支持多region（请勿修改）
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e) {
			logger.error("", e);
			return false;
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		// 使用post提交
		request.setMethod(MethodType.POST);
		// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
		request.setPhoneNumbers(mobile);
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName("收租婆");
		// 必填:短信模板-可在短信控制台中找到
		request.setTemplateCode(msg);
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		// 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		if (!CollectionUtils.isEmpty(params))
		{
			try {
				request.setTemplateParam(mapper.writeValueAsString(params));
			} catch (JsonProcessingException e) {
				logger.error("", e);
				return false;
			}
		}
		//request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
		// 可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
		// request.setSmsUpExtendCode("90997");
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		// request.setOutId("yourOutId");
		// 请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
			if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
				return true;
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return false;
	}

	public static void main(String[] args)
	{
		SmsAware smsAware = new AliyunSmsComponent();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", "123456");
		System.out.println(smsAware.sendSms("17666260833", "SMS_122290087", null));
	}
	
}
