package com.cobee.rentalhouse.core.service;

import java.util.List;

import com.cobee.rentalhouse.core.entity.SecureRole;
import com.cobee.rentalhouse.core.service.support.BaseService;


public interface SecureRoleService extends BaseService<SecureRole> {
	
	List<SecureRole> findUserRoles(SecureRole secureRole);
	
}
