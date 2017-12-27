package com.cobee.rentalhouse.core.dao;

import java.util.List;

import com.cobee.rentalhouse.core.dao.support.BaseDao;
import com.cobee.rentalhouse.core.entity.SecureRole;


public interface SecureRoleDao extends BaseDao<SecureRole> {

	List<SecureRole> findUserRoles(SecureRole secureRole);
	
}
