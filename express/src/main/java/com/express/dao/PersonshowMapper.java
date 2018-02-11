package com.express.dao;

import com.express.pojo.Personshow;

public interface PersonshowMapper {
    int deleteByPrimaryKey(Integer showid);

    int insert(Personshow record);

    int insertSelective(Personshow record);

    Personshow selectByPrimaryKey(Integer showid);

    int updateByPrimaryKeySelective(Personshow record);

    int updateByPrimaryKey(Personshow record);
}