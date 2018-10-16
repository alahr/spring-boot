package com.alahr.springboot.module.person.service;

import com.alahr.springboot.module.person.dto.Person;
import com.alahr.springboot.module.person.mapper.PersonMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonMapper personMapper;

    public PageInfo<Person> findAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Person> list = personMapper.findAll();
        PageInfo<Person> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public Person getById(BigInteger id){
        return personMapper.getById(id);
    }

    public int add(Person p){
        return personMapper.add(p);
    }

    public int update(Person p){
        return personMapper.update(p);
    }

    public int removeById(BigInteger id){
        return personMapper.removeById(id);
    }
}
