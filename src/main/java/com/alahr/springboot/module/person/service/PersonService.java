package com.alahr.springboot.module.person.service;

import com.alahr.springboot.module.person.dto.Person;
import com.github.pagehelper.PageInfo;

import java.math.BigInteger;

public interface PersonService {
    PageInfo<Person> findAll(int pageNum, int pageSize);

    Person getById(BigInteger id);

    int add(Person p);

    int update(Person p);

    int removeById(BigInteger id);
}
