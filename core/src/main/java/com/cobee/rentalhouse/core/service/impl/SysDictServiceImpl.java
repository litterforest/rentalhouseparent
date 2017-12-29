package com.cobee.rentalhouse.core.service.impl;

import org.springframework.stereotype.Service;

import com.cobee.rentalhouse.core.dao.impl.SysDictMapper;
import com.cobee.rentalhouse.core.entity.SysDict;
import com.cobee.rentalhouse.core.service.SysDictService;
import com.cobee.rentalhouse.core.service.support.PagingAndSortingService;

@Service
public class SysDictServiceImpl extends PagingAndSortingService<SysDict, SysDictMapper> implements SysDictService {

}
