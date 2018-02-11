package com.express.dao;

import com.express.pojo.Collections;

public interface CollectionsMapper {
    int deleteByPrimaryKey(Integer collectionid);

    int insert(Collections record);

    int insertSelective(Collections record);

    Collections selectByPrimaryKey(Integer collectionid);

    int updateByPrimaryKeySelective(Collections record);

    int updateByPrimaryKey(Collections record);
}