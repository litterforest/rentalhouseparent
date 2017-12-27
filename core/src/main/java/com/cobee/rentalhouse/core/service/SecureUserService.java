package com.cobee.rentalhouse.core.service;

import com.cobee.rentalhouse.core.entity.SecureResources;
import com.cobee.rentalhouse.core.entity.SecureUser;
import com.cobee.rentalhouse.core.service.support.BaseService;

public interface SecureUserService extends BaseService<SecureUser> {

	void register(SecureUser baseUser);
	
	/**
	 * <pre>获取登录用户菜单</pre>
	 * @author 陈淦森
	 * @version 1.0.1
	 * @date 2017年12月22日
	 *
	 * @return
	 */
	SecureResources getUserMenus();
	
}
