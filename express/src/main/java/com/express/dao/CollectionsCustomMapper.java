package com.express.dao;

import java.util.List;

import com.express.pojo.Collections;

public interface CollectionsCustomMapper extends CollectionsMapper {
	//删除收藏
    int deleteByproductId(Integer productId);

   

  
}