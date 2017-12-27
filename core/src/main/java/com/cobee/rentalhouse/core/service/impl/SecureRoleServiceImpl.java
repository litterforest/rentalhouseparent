package com.cobee.rentalhouse.core.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cobee.rentalhouse.core.dao.SecureRoleDao;
import com.cobee.rentalhouse.core.entity.SecureRole;
import com.cobee.rentalhouse.core.service.SecureRoleService;
import com.cobee.rentalhouse.core.service.support.AbstractService;


@Service
public class SecureRoleServiceImpl extends AbstractService<SecureRole, SecureRoleDao> implements SecureRoleService {

	@Override
	public List<SecureRole> findUserRoles(SecureRole secureRole) {
		return super.dao.findUserRoles(secureRole);
	}

}
