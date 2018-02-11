package com.express.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.express.dao.CategoryMapper;
import com.express.pojo.Category;
import com.express.service.CategoryService;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Resource
	CategoryMapper categoryMapper;

	@Override
	public Category selectByPrimaryKey(Integer cid) throws Exception {
		
		return categoryMapper.selectByPrimaryKey(cid);
	}

}
