package com.express.dao;

import com.express.pojo.Person;

public interface PersonCustomMapper extends PersonMapper {
  
//登录
    Person selectByPerson(Person person)throws Exception;
//更换头像
    int updateIconUrl(Person record)throws Exception;
  //更新自己信息
    int updateInfo(Person person)throws Exception;

 
}