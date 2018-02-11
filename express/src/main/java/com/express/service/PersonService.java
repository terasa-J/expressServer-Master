package com.express.service;

import com.express.pojo.Person;
//处理用户的   登录与注册
public interface PersonService {
	//登录
    Person selectByPerson(Person person) throws Exception;
    //注册
    int insert(Person record) throws Exception;
  //更换头像
    int updateIconUrl(Person record)throws Exception;
    //更新自己信息
    int updateInfo(Person person)throws Exception;

}
