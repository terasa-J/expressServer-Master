package com.express.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.express.dao.PersonCustomMapper;
import com.express.pojo.Person;
import com.express.service.PersonService;
@Service("personService")
public class PersonServiceImpl implements PersonService  {
	@Resource
	PersonCustomMapper personCustomMapper;

	@Override
	public Person selectByPerson(Person person) throws Exception {
		return personCustomMapper.selectByPerson(person);
	}

	@Override
	public int insert(Person record) throws Exception {
		return personCustomMapper.insert(record);
	}

	@Override
	public int updateIconUrl(Person record) throws Exception {
		return personCustomMapper.updateIconUrl(record);
	}

	@Override
	public int updateInfo(Person person) throws Exception {
		return personCustomMapper.updateInfo(person);
	}

}
