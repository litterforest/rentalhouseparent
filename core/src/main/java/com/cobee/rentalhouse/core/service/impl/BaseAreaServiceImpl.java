package com.cobee.rentalhouse.core.service.impl;

import org.springframework.stereotype.Service;

import com.cobee.rentalhouse.core.dao.impl.BaseAreaMapper;
import com.cobee.rentalhouse.core.entity.BaseArea;
import com.cobee.rentalhouse.core.service.BaseAreaService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class BaseAreaServiceImpl extends PagingAndSortingService<BaseArea, BaseAreaMapper> implements BaseAreaService {

}
