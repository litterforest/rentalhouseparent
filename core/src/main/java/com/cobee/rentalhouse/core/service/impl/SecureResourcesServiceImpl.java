package com.cobee.rentalhouse.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cobee.rentalhouse.core.dao.SecureResourcesDao;
import com.cobee.rentalhouse.core.entity.SecureResources;
import com.cobee.rentalhouse.core.service.SecureResourcesService;
import com.cobee.rentalhouse.core.service.support.AbstractService;


@Service
public class SecureResourcesServiceImpl extends AbstractService<SecureResources, SecureResourcesDao> implements SecureResourcesService {

	@Override
	public List<SecureResources> findRolePermissions(SecureResources secureResources) {
		return dao.findRolePermissions(secureResources);
	}

	@Override
	public List<SecureResources> findUserPermissions(SecureResources secureResources) {
		return dao.findUserPermissions(secureResources);
	}

	@Override
	public List<SecureResources> findMenusByUserId(Integer userID) {
		return dao.findMenusByUserId(userID);
	}

}
