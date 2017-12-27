package com.cobee.rentalhouse.core.dao;

import java.util.List;

import com.cobee.rentalhouse.core.dao.support.BaseDao;
import com.cobee.rentalhouse.core.entity.SecureResources;


public interface SecureResourcesDao extends BaseDao<SecureResources> {
	
	List<SecureResources> findRolePermissions(SecureResources secureResources);
	
	List<SecureResources> findUserPermissions(SecureResources secureResources);
	
	List<SecureResources> findMenusByUserId(Integer userID);
	
}
