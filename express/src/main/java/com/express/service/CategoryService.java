package com.express.service;

import com.express.pojo.Category;

public interface CategoryService {
	Category selectByPrimaryKey(Integer cid) throws Exception;

}
