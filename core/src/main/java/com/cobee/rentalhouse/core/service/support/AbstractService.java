package com.cobee.rentalhouse.core.service.support;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cobee.rentalhouse.core.component.page.Page;
import com.cobee.rentalhouse.core.dao.support.BaseDao;
import com.cobee.rentalhouse.core.entity.SecureUser;
import com.cobee.rentalhouse.core.entity.support.BaseEntity;


@Transactional(readOnly = true)
public abstract class AbstractService<T extends BaseEntity, E extends BaseDao<T>> implements BaseService<T> {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected E dao;
	
	public List<T> list(T obj)
	{
		return dao.list(obj);
	}
	
	@Override
	public Page<T> findByPage(T obj) {
		return null;
	}

	@Override
	public Page<T> findByPage(T obj, String selectSqlID) {
		return null;
	}

	@Transactional(readOnly = false)
	@Override
	public void save(T obj) {
		SecureUser secureUser = null;
		if (!(obj instanceof SecureUser))
		{
			secureUser = (SecureUser) SecurityUtils.getSubject().getPrincipal();
		}
		if (obj.getId() != null)
		{
			obj.setUpdateBy(secureUser == null ? "" : secureUser.getId().toString());
			obj.setUpdateDate(new Date());
			dao.updateBySelective(obj);
		}
		else
		{
			obj.setCreateBy(secureUser == null ? "" : secureUser.getId().toString());
			obj.setCreateDate(new Date());
			obj.setUpdateBy(secureUser == null ? "" : secureUser.getId().toString());
			obj.setUpdateDate(new Date());
			dao.insertBySelective(obj);
		}
	}

	@Override
	public T get(Integer id) {
		return dao.get(id);
	}
	
	@Override
	public Integer queryByCount(T obj){
		return dao.queryByCount(obj);
	}

	@Override
	@Transactional(readOnly = false)
	public Integer delete(Integer id) {
		return dao.delete(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Integer deleteByLogic(Integer id) {
		return dao.deleteByLogic(id);
	}

	@Override
	@Transactional(readOnly = false)
	public Integer updateBySelective(T obj) {
		return dao.updateBySelective(obj);
	}
	
}
