package com.cobee.rentalhouse.core.service;

import java.util.List;

import com.cobee.rentalhouse.core.entity.SecureResources;
import com.cobee.rentalhouse.core.service.support.BaseService;


public interface SecureResourcesService extends BaseService<SecureResources> {
	
	List<SecureResources> findRolePermissions(SecureResources secureResources);
	
	List<SecureResources> findUserPermissions(SecureResources secureResources);
	
	List<SecureResources> findMenusByUserId(Integer userID);
	
}
