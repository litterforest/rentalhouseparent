package com.cobee.rentalhouse.core.service.support;

import java.util.List;

import com.cobee.rentalhouse.core.component.page.Page;
import com.cobee.rentalhouse.core.entity.support.BaseEntity;


public interface BaseService<T extends BaseEntity> {

	List<T> list(T obj);
	
	Page<T> findByPage(T obj);
	
	Page<T> findByPage(T obj, String selectSqlID);

	T get(Integer id);

	void save(T obj);

	Integer delete(Integer id);

	Integer deleteByLogic(Integer id);

	Integer updateBySelective(T obj);
	
	Integer queryByCount(T obj);

}
