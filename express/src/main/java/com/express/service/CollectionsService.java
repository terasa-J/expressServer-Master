package com.express.service;

import java.util.List;

import com.express.pojo.Collections;

public interface CollectionsService {
	//添加收藏
	 int insert(Collections record) throws Exception;
	 //删除收藏
	  int deleteByProductId(Integer productId) throws Exception;
	 

}
