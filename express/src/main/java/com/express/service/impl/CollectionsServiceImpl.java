package com.express.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.express.dao.CollectionsCustomMapper;
import com.express.dao.CollectionsMapper;
import com.express.pojo.Collections;
import com.express.service.CollectionsService;
@Service("collectionsService")
public class CollectionsServiceImpl implements CollectionsService {
	@Resource
	CollectionsCustomMapper collectionsCustomMapper;
	@Override
	public int insert(Collections record) throws Exception {
		return collectionsCustomMapper.insert(record);
	}
	@Override
	public int deleteByProductId(Integer productId) throws Exception {
		return collectionsCustomMapper.deleteByproductId(productId);
	}

}
