package com.express.dao;

import com.express.pojo.Person;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer personid);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer personid);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}