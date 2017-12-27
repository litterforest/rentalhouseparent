package com.cobee.rentalhouse.core.dao.support;

import java.util.List;

import com.cobee.rentalhouse.core.entity.support.BaseEntity;


public interface BaseDao<T extends BaseEntity > {
	
	List<T> list(T obj);
	
	T get(Integer id);
	
	void insertBySelective(T obj);
	
	Integer delete(Integer id);
	
	Integer deleteByLogic(Integer id);
	
	Integer updateBySelective(T obj);
	
	Integer queryByCount(T obj);
	
}
